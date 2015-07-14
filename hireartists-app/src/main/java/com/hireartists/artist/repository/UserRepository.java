/**
 * 
 */
package com.hireartists.artist.repository;

import com.hireartists.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

/**
 * @author prayag
 * 
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	@Query("select u from User u where u.userName=?1 and password=?2")
	User findByUserNameAndPassword(String username, String password);
}
