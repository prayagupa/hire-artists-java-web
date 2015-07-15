package com.hireartists.eventOrganiser.controller;

import com.hireartists.client.model.SignupModel;
import com.hireartists.domain.EventOrganiser;
import com.hireartists.eventOrganiser.service.EventOrganiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Binod on 7/14/2015.
 */
@Controller
public class EventOrganiserController {
    Logger logger = LoggerFactory.getLogger(EventOrganiserController.class);

    @Autowired
    EventOrganiserService eventOrganiserService;

    @RequestMapping(value="/eventOrganiser/signup", method = RequestMethod.GET)
    public String getSignupForm(Model m) {
        m.addAttribute("eventOrganiser", new EventOrganiser());
        return "eventOrganiser/signup";
    }

    @RequestMapping(value="/eventOrganiser/add", method = RequestMethod.POST, headers = {"Content-type=application/json"}, produces = "application/json")
    public @ResponseBody Map<String, String> add (@RequestBody List<Map<String, String>> keyValuePair) {
        Map<String, String> kv = new HashMap<String, String>();
        for (Map<String, String> kvp : keyValuePair) {
            logger.info("{}, {}", kvp.get("name"), kvp.get("value"));
            kv.put(kvp.get("name"), kvp.get("value"));
        }
        final SignupModel signupModel = new SignupModel();
        signupModel.setDisplayName(kv.get("displayName"));
        logger.info("{} : {}", kv.size(), kv.get("displayName"));
        eventOrganiserService.save(signupModel);

        Map<String, String> response = new HashMap<String, String>();
        response.put("status", "success");
        return response;
    }

    @RequestMapping(value="/eventOrganiser/profile",method = RequestMethod.GET)
    public String eventOrganiserProfile (Model m) {
        return "eventOrganiser/profile";
    }
}
