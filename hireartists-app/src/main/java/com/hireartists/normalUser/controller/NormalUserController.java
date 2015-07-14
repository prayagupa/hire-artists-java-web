package com.hireartists.normalUser.controller;

import com.hireartists.client.model.ArtistModel;
import com.hireartists.client.model.EventModel;
import com.hireartists.client.model.mapper.EventOrganiserMapper;
import com.hireartists.domain.Artist;
import com.hireartists.domain.Event;
import com.hireartists.normalUser.services.NormalUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prayagupd
 * on 7/13/15.
 */

@Controller
public class NormalUserController {
    Logger logger = LoggerFactory.getLogger(NormalUserController.class);
    @Autowired
    NormalUserService normalUserService;

    ObjectMapper objectMapper = new ObjectMapper();

    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    NormalUserController(){}

    @RequestMapping(value = "/main/events", method = RequestMethod.GET)
    @ResponseBody
    public List<EventModel> events() {
        List<Event> events = normalUserService.events();
        List<EventModel> eventJson = new ArrayList<EventModel>();
        //EventModel eventModel_ = new EventModel();
        for (Event e : events) {
            EventModel eventModel = new EventModel();
            eventModel.id = e.getId();
            eventModel.name = e.getName();
            eventJson.add(eventModel);

            eventModel.organiser = EventOrganiserMapper.map(e.getEventOrganiser());
            for (Artist a : e.getArtists()) {
                ArtistModel aM = new ArtistModel();
                aM.id = a.getId();
                aM.displayName = a.getDisplayName();
                eventModel.artists.add(aM);
            }
            //eventModel_ = eventModel;
        }
        try {
            String json = objectMapper.writeValueAsString(eventJson);
            logger.info("================= json ================");
            logger.info("" + json);
            logger.info("================= json ================");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return eventJson;
    }
}
