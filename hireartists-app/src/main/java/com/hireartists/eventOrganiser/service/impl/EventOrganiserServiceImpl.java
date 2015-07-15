package com.hireartists.eventOrganiser.service.impl;

import com.hireartists.client.model.SignupModel;
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
    public EventOrganiser save(SignupModel signupModel) {
        EventOrganiser eo = new EventOrganiser();
        eo.setName(signupModel.getDisplayName());

        User user = new User();
        user.setUserName(signupModel.getUsername());
        user.setPassword(signupModel.getPassword());
        user.setAuthority("ROLE_EVENT_ORGANISER");

        eo.setUser(user);
        return eventOrganiserRepository.save(eo);

    }
}
