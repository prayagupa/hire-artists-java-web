package com.hireartists.eventOrganiser.repositories;

import com.hireartists.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by prayagupd
 * on 7/13/15.r
 */

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    @Query("select e from Event e JOIN FETCH e.artists a")
    public List<Event> getEvents();
}
