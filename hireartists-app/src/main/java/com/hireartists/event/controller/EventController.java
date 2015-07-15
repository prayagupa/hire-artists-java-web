package com.hireartists.event.controller;

import com.hireartists.domain.Event;
import com.hireartists.event.services.EventServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
        return "events/eventLists";
    }
}
