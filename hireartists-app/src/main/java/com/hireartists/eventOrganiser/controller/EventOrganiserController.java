package com.hireartists.eventOrganiser.controller;

import com.hireartists.client.model.EventOrganiserModel;
import com.hireartists.client.model.Session;
import com.hireartists.domain.EventOrganiser;
import com.hireartists.eventOrganiser.service.EventOrganiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

//    /*@Autowired
//    */EventServices eventServices;

    @RequestMapping(value="/eventOrganiser/signup", method = RequestMethod.GET)
    public String getSignupForm(Model m) {
        m.addAttribute("eventOrganiser", new EventOrganiser());
        return "eventOrganiser/signup";
    }

    @RequestMapping(value="/eventOrganiser/add", method = RequestMethod.POST, headers = {"Content-type=application/json"}, produces = "application/json")
    public @ResponseBody Map<String, String> add (@RequestBody List<Map<String, String>> keyValuePair) {
        Map<String, String> kv = getRequestParamaters(keyValuePair);

        final EventOrganiserModel eventOrganiserModel = new EventOrganiserModel();
        eventOrganiserModel.setName(kv.get("name"));
        eventOrganiserModel.setUsername(kv.get("username"));
        eventOrganiserModel.setEmail(kv.get("email"));
        eventOrganiserModel.setPassword(kv.get("password"));
        eventOrganiserModel.setAddress(kv.get("address"));
        eventOrganiserModel.setContactNumber(kv.get("contactNumber"));

        logger.info("{} : {}", kv.size(), kv.get("name"));
        eventOrganiserService.save(eventOrganiserModel);

        Session.userName = kv.get("username");


        Map<String, String> response = new HashMap<String, String>();

        response.put("status", "success");
        return response;
    }

    @RequestMapping(value="/eventOrganiser/p",method = RequestMethod.GET)
    public String eventOrganiserProfile (Model m) {
        return "eventOrganiser/profile";
    }


    @RequestMapping(value="/eventOrganiser/profileDetail",method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Map<String, Object> eventOrganiserProfile (Model m, @RequestBody List<Map<String, String>> keyValuePair) {
        Map<String, String> kv = getRequestParamaters(keyValuePair);
        String username = kv.get("username");
        Map<String,Object> eventOrganiser = new HashMap<String, Object>();
        eventOrganiser.put("eventOrganiser",eventOrganiserService.findByUsername(username));
        return eventOrganiser;
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
