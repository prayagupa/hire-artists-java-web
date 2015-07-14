package com.hireartists.eventOrganiser.repositories;

import com.hireartists.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prayagupd
 * on 7/13/15.r
 */

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
