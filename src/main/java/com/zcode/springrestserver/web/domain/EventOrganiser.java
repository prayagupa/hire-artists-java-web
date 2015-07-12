package com.zcode.springrestserver.web.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.criteria.Fetch;

/**
 * Created by prayagupd
 * on 7/12/15.
 */


@Entity
@Table(name="EventOrganiser")
public class EventOrganiser extends AbstractEntity<Long>{

    private String name;

    @OneToMany(mappedBy = "organiser", fetch = FetchType.LAZY)
    private List<Event> events;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
