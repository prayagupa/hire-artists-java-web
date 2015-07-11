/**
 * 
 */
package com.zcode.springrestserver.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcode.springrestserver.client.model.UserModel;
import com.zcode.springrestserver.web.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author prayag
 * 
 */
@Controller
public class ArtistController {

	@Autowired
	IUserService userService;

	public ArtistController(){}
	public ArtistController(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	UserModel login() {
		return userService.login("Prayag", "123456");
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login_() {
	// return "home";
	// }


	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView add(){
		ModelAndView modelAndView = new ModelAndView("artist/list");
		modelAndView.addObject("artists", "Porcupine Tree");
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("artist", "Porcupine Tree");
		return modelAndView;
	}

}
