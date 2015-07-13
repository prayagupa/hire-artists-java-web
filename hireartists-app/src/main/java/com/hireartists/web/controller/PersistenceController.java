/**
 * 
 */
package com.hireartists.web.controller;

import java.util.Map;

import com.hireartists.domain.User;
import com.hireartists.web.repository.UserRepository;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hireartists.web.service.UserService;

/**
 * @author prayag
 * 
 */
@Controller
public class PersistenceController {
	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	public PersistenceController(){}

	public PersistenceController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/persistence", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	Map<String, Object> setup() {
		User user = new User();
		user.setAuthority("ROLE_ADMIN");
		user.setUserName("RodJohnson");
		user.setPassword("123456");
		User addedUser = userRepository.save(user);

		Map<String, Object> map = new HashedMap();
		map.put("id", addedUser.getId());
		map.put("fullName", addedUser.getUserName());
		return map;
		// return addedUser;
	}
}
