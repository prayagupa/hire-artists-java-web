package com.hireartists.event.repository;

import com.hireartists.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Binod
 * on 7/13/15.r
 */

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e JOIN FETCH e.artists a")
    public List<Event> getEvents();

    @Query("select e from Event e join fetch e.eventOrganiser eo where eo.user.userName = :username")
    public List<Event> getEventsByEventOrganiserUsername(@RequestParam("username") String username);

}