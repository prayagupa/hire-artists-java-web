package com.hireartists.signin.controller;

import com.hireartists.artist.service.UserService;
import com.hireartists.client.model.Session;
import com.hireartists.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by prayagupd
 * on 7/15/15.
 */

@Controller
public class SigninController {

    Logger logger = LoggerFactory.getLogger(SigninController.class);

    @Autowired
    UserService userService;

    // if request comes for LoginView, return the loginView page
    @RequestMapping(value = "/loginView", method = RequestMethod.GET)
    public String getLoginView(Model m) {
        return "artist/signIn";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = {
            "Content-type=application/json" }, produces = "application/json")
    public @ResponseBody
    Map<String, String> login(@RequestBody List<Map<String, String>> keyValuePair) {
        Map<String, String> map = getRequestParamaters(keyValuePair);
        Map<String, String> response = new HashMap<String, String>();
        User user = userService.login(map.get("userName") + "", map.get("password"));
        if (user == null) {
            response.put("status", "KO");
            return response;
        }
        Session.userName = user.getUserName();
        Session.user = user;

        response.put("status", "OK");
        if (user.getAuthority().equals("ROLE_EVENT_ORGANISATION")) {
            response.put("url", "eventOrganiser/p");
        } else {
            response.put("url", "artist/profile");
        }
        return response;

    }

    // request for sign off return home page
    @RequestMapping(value = "/artist/signOut", method = RequestMethod.GET)
    public String signOut(Model m) {
        Session.user = null;
        Session.userName = null;
        return "redirect:/";
    }

    // request for sign off return home page
    @RequestMapping(value = "/eventOrganiser/signOut", method = RequestMethod.GET)
    public String eSignOut(Model m) {
        Session.user = null;
        Session.userName = null;
        return "redirect:/";
    }

    private Map<String, String> getRequestParamaters(List<Map<String, String>> keyValuePair) {
        Map<String, String> kv = new HashMap<String, String>();
        for (Map<String, String> kvp : keyValuePair) {
            logger.info("{}, {}", kvp.get("name"), kvp.get("value"));
            kv.put(kvp.get("name"), kvp.get("value"));
        }
        return kv;
    }
}
