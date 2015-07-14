/**
 * 
 */
package com.hireartists.artist.controller;

import com.hireartists.client.model.ArtistModel;
import com.hireartists.client.model.SignupModel;
import com.hireartists.domain.Artist;
import com.hireartists.artist.service.ArtistService;
import com.hireartists.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hireartists.artist.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author prayag
 * 
 */

@Controller
public class ArtistController {

	Logger logger = LoggerFactory.getLogger(ArtistController.class);

	@Autowired
	UserService userService;

	@Autowired
	ArtistService artistService;

	public ArtistController(){}
	public ArtistController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model m) {
		return "artist/signIn";
	}

	@RequestMapping(value = "/artist", method = RequestMethod.GET)
	public String signUp(Model m) {
		m.addAttribute("artist", new Artist());
		return "artist/signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST, headers = {"Content-type=application/json"}, produces = "application/json")
	public @ResponseBody String signup_(@RequestBody List<Map<String, String>> signupModel){
		logger.info("" + signupModel);
//		artistService.save(signupModel);
		return new String("OK");
	}

	@RequestMapping(value = "/artist/update", method = RequestMethod.POST, headers = "Accept=*/*")
	public ModelAndView update(@ModelAttribute("artist") ArtistModel artistModel){
		return null;
	}

//	@RequestMapping(value = "/artist/add/json", method = RequestMethod.GET, headers = {"Content-type=application/json"})
//	public @ResponseBody addJson(@RequestBody Artist artist){
//		artistService.save(artist);
//		return JsonResponse("OK");
//	}

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
