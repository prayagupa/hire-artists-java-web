/**
 * 
 */
package com.hireartists.web.controller.artist;

import com.hireartists.domain.Artist;
import com.hireartists.web.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hireartists.client.model.UserModel;
import com.hireartists.web.service.IUserService;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author prayag
 * 
 */

@Controller
public class ArtistController {

	Logger logger = LoggerFactory.getLogger(ArtistController.class);

	@Autowired
	IUserService userService;

	@Autowired
	ArtistService artistService;

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

	@RequestMapping(value = "/artist/add", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView add(/*@RequestBody Artist artist*/){

		Artist artist = new Artist();
		artist.setDisplayName("Pink Floyd");
		artistService.save(artist);
		ModelAndView modelAndView = new ModelAndView("artist/list");
		modelAndView.addObject("artists", artist.getDisplayName());
		return modelAndView;
	}

	@RequestMapping(value = "/artist/list", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("artist/list");
		modelAndView.addObject("artists", "Porcupine Tree");
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=*/*")
	public ModelAndView index(){
		logger.info("index");
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("artist", "Porcupine Tree");
		return modelAndView;
	}

}
