package com.hireartists.artist.repository;

import com.hireartists.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by prayagupd
 * on 7/12/15.
 */

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>{

    @Query("select a from Artist a where a.user.userName=?1")
    Artist getProfile(String username);
}
