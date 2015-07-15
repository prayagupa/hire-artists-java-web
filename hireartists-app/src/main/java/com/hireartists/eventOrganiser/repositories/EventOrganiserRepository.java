package com.hireartists.eventOrganiser.repositories;

import com.hireartists.domain.EventOrganiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by prayagupd
 * on 7/13/15.
 */

@Repository
public interface EventOrganiserRepository extends JpaRepository<EventOrganiser, Long>{
    @Query("SELECT eo FROM EventOrganiser eo INNER JOIN eo.user u WHERE u.userName = :userName")
    public EventOrganiser findByUsername(@Param("username") String userName);
}
