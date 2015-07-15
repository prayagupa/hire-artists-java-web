package com.hireartists.eventOrganiser.service;

import com.hireartists.client.model.EventOrganiserModel;
import com.hireartists.domain.EventOrganiser;

/**
 * Created by user on 7/14/2015.
 */
public interface EventOrganiserService {
    public EventOrganiser save(EventOrganiserModel eventOrganiserModel);
    public EventOrganiser findByUsername(String username);
}
