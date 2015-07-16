package com.hireartists.client.controller;

import com.hireartists.domain.Artist;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by prayagupd
 * on 7/15/15.
 */

public class ViewController {
    // request return for sign up page
    @RequestMapping(value = "/artist-sign-up", method = RequestMethod.GET)
    public String signUp(Model m) {
        m.addAttribute("artist", new Artist());
        return "artist/signUp";
    }

    // if request comes for profileView, return the profileView jsp page
    @RequestMapping(value = "/artist/profile", method = RequestMethod.GET)
    public String artistProfile(Model m) {
        return "artist/profile";
    }

    // request return for viewing the list of artists page
    @RequestMapping(value = "artist/viewEvents", method = RequestMethod.GET)
    public String showEventList(Model m) {
        // List<Event> eventList = eventService.findAll();
        // m.addAttribute("artistList", artistList);
        return "artist/eventList";
    }

    // request return for viewing the profile after viewing the list of events
    @RequestMapping(value = "/normalUser", method = RequestMethod.GET)
    public String normalUserView(Model m) {
        // List<Event> eventList = eventService.findAll();
        // m.addAttribute("artistList", artistList);
        return "artist/normalView";
    }

    // request for sign off return home page
    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String showHome(Model m) {
        return "redirect:/";
    }
}
