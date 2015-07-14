/**
 * 
 */
package com.hireartists.artist.service.impl;

import com.hireartists.client.model.UserModel;
import com.hireartists.client.model.mapper.UserMapper;
import com.hireartists.domain.User;
import com.hireartists.artist.repository.UserRepository;
import com.hireartists.artist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author prayag
 * 
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl(){}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@Override
	public UserModel login(String userName, String password) {
		User user = new User();
		user.setUserName("Prayag");
		return UserMapper.mapUser(user);
	}
}
