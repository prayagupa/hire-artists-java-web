package com.hireartists.event.controller;

import com.hireartists.client.model.EventModel;
import com.hireartists.domain.Event;
import com.hireartists.event.services.EventServices;
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
 * Created by Binod on 7/15/2015.
 */
@Controller
public class EventController {
    Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventServices eventServices;

    @RequestMapping(value="/events/lists",method= RequestMethod.GET)
    public String showEventList (Model m) {
        List<Event> eventList = eventServices.findAll();
        m.addAttribute("eventList",eventList);
        return "event/eventLists";
    }

    @RequestMapping(value="/events/create",method= RequestMethod.GET)
    public String createEvent (Model m) {
        return "event/create";
    }

    @RequestMapping(value="/events/add", method = RequestMethod.POST, headers = {"Content-type=application/json"}, produces = "application/json")
    public @ResponseBody
    Map<String, String> add (@RequestBody List<Map<String, String>> keyValuePair) {
        Map<String, String> kv = getRequestParamaters(keyValuePair);

        final EventModel eventModel = new EventModel();
        eventModel.setName(kv.get("eventName"));


        logger.info("{} : {}", kv.size(), kv.get("name"));
        eventServices.save(eventModel);
        Map<String, String> response = new HashMap<String, String>();

        response.put("status", "success");
        return response;
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
