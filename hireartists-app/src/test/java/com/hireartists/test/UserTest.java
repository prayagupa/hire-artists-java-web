/**
 * 
 */
package com.hireartists.test;

import com.hireartists.client.model.UserModel;
import com.hireartists.artist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author prayag
 * 
 */
public class UserTest {

	@Autowired
	UserRepository userRepository;

	public void createUser() {
		UserModel userModel = new UserModel();
		userModel.setUsername("Prayag");
	}
}
