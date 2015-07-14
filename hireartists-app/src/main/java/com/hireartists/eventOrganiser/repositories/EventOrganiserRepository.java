package com.hireartists.eventOrganiser.repositories;

import com.hireartists.domain.EventOrganiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prayagupd
 * on 7/13/15.
 */

@Repository
public interface EventOrganiserRepository extends JpaRepository<EventOrganiser, Long>{
}
