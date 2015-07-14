/**
 * 
 */
package com.hireartists.artist.service;

import com.hireartists.client.model.UserModel;
import com.hireartists.domain.User;

/**
 * @author prayag
 * 
 */
public interface UserService {
	User login(String userName, String password);
}
