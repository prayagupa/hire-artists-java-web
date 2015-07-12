/**
 * 
 */
package com.zcode.springrestserver.web.service.impl;

import com.zcode.springrestserver.client.model.UserModel;
import com.zcode.springrestserver.client.model.mapper.UserMapper;
import com.zcode.springrestserver.web.api.IUserAPI;
import com.zcode.springrestserver.web.domain.User;
import com.zcode.springrestserver.web.repository.UserRepository;
import com.zcode.springrestserver.web.service.IUserService;
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
