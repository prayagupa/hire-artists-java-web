package com.hireartists.normalUser.services;

import com.hireartists.domain.*;
import com.hireartists.eventOrganiser.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by prayagupd
 * on 7/13/15.
 */

@Service
public class NormalUserServiceImpl implements NormalUserService {

    @Autowired
    EventRepository eventRepository;

    public NormalUserServiceImpl(){}

    @Override
    public java.util.List<Event> events() {
        return eventRepository.getEvents();
    }
}
