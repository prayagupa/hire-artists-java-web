/**
 * 
 */
package com.hireartists.client.model.mapper;

import com.hireartists.client.model.UserModel;
import com.hireartists.domain.User;

/**
 * @author prayag
 * 
 */
public class UserMapper {
	public static UserModel mapUser(User user) {
		UserModel userModel = new UserModel();
		userModel.setFullName(user.getFullName());
		return userModel;
	}
}
