/**
 * 
 */
package com.hireartists.web.service.impl;

import com.hireartists.client.model.UserModel;
import com.hireartists.client.model.mapper.UserMapper;
import com.hireartists.domain.User;
import com.hireartists.web.repository.UserRepository;
import com.hireartists.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author prayag
 * 
 */

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	public UserService(){}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@Override
	public UserModel login(String userName, String password) {
		User user = new User();
		user.setFullName("Prayag");
		return UserMapper.mapUser(user);
	}
}
