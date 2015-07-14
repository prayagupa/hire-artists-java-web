/**
 * 
 */
package com.hireartists.artist.service;

import com.hireartists.client.model.UserModel;

/**
 * @author prayag
 * 
 */
public interface UserService {
	UserModel login(String userName, String password);
}
