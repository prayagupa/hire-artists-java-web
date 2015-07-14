package com.hireartists.normalUser.controller;

import com.hireartists.domain.Event;
import com.hireartists.normalUser.services.NormalUserService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
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

    NormalUserController(){}

    @RequestMapping("/events")
    public void events() {
        List<Event> events = normalUserService.events();
        try {
            String json = objectMapper.writeValueAsString(events);
            logger.info("================= json ================");
            logger.info("" + json);
            logger.info("================= json ================");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
