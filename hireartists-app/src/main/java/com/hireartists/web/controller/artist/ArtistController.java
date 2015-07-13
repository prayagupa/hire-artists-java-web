/**
 * 
 */
package com.hireartists.web.controller.artist;

import com.hireartists.client.model.ArtistModel;
import com.hireartists.domain.Artist;
import com.hireartists.web.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hireartists.client.model.UserModel;
import com.hireartists.web.service.UserService;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/login", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	UserModel login() {
		return userService.login("Prayag", "123456");
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login_() {
	// return "home";
	// }

	@RequestMapping(value = "/artist/add", method = RequestMethod.POST, headers = "Accept=*/*")
	public ModelAndView add(@ModelAttribute("artist") ArtistModel artistModel){

		Artist artist = new Artist();
		artist.setDisplayName(artistModel.displayName);
		artistService.save(artist);
		ModelAndView modelAndView = new ModelAndView("artist/list");
		modelAndView.addObject("artists", artist.getDisplayName());
		return modelAndView;
	}

	@RequestMapping(value = "/artist/update", method = RequestMethod.POST, headers = "Accept=*/*")
	public ModelAndView update(@ModelAttribute("artist") ArtistModel artistModel){

		Artist artist = new Artist();
		artist.setDisplayName(artistModel.displayName);
		artistService.save(artist);
		ModelAndView modelAndView = new ModelAndView("artist/list");
		modelAndView.addObject("artists", artist.getDisplayName());
		return modelAndView;
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
