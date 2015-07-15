package com.hireartists.event.services;

import com.hireartists.client.model.EventModel;
import com.hireartists.domain.Event;
import com.hireartists.domain.EventOrganiser;

import java.util.List;

/**
 * Created by Binod on 7/15/2015.
 */
public interface EventServices {
    public Event save(EventModel eventModel);
    public Event findOne(Long id);
    public List<Event> getEventsByEventOrganiserUsername(String username);
    public List<Event> findAll();
}
