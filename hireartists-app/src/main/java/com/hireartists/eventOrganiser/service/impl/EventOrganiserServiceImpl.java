package com.hireartists.eventOrganiser.service.impl;

import com.hireartists.client.model.EventOrganiserModel;
import com.hireartists.client.model.Session;
import com.hireartists.domain.EventOrganiser;
import com.hireartists.domain.User;
import com.hireartists.eventOrganiser.repositories.EventOrganiserRepository;
import com.hireartists.eventOrganiser.service.EventOrganiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Binod on 7/14/2015.
 */

@Service
public class EventOrganiserServiceImpl implements EventOrganiserService {
    @Autowired
    EventOrganiserRepository eventOrganiserRepository;

    public void EventOrganiserServiceImpl () {}

    @Override
    public EventOrganiser save(EventOrganiserModel eventOrganiserModel) {
        EventOrganiser eo = new EventOrganiser();
        eo.setName(eventOrganiserModel.getName());
        eo.setEmail(eventOrganiserModel.getEmail());
        eo.setAddress(eventOrganiserModel.getAddress());
        eo.setContactNumber(eventOrganiserModel.getContactNumber());

        User user = new User();
        user.setUserName(eventOrganiserModel.getUsername());
        user.setPassword(eventOrganiserModel.getPassword());
        user.setAuthority("ROLE_EVENT_ORGANISER");

        eo.setUser(user);

        Session.userName = user.getUserName();
        Session.user = user;

        return eventOrganiserRepository.save(eo);

    }

    @Override
    public EventOrganiser findByUsername(String username) {
        EventOrganiser eventOrganiser = eventOrganiserRepository.findByUsername(username);
        return eventOrganiser;
    }
}
