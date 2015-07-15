package com.hireartists.client.model.mapper;

import com.hireartists.client.model.EventOrganiserModel;
import com.hireartists.domain.EventOrganiser;

/**
 * Created by prayagupd on 7/14/15.
 */
public class EventOrganiserMapper {
    public static EventOrganiserModel map(EventOrganiser eventOrganiser){
        EventOrganiserModel eventOrganiserModel = new EventOrganiserModel();
        eventOrganiserModel.setId(eventOrganiser.getId());
        eventOrganiserModel.setName(eventOrganiser.getName());
        return eventOrganiserModel;
    }
}
