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

import java.util.HashMap;
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

	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String login() {
		return "artist/signIn";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = {"Content-type=application/json"}, produces = "application/json")
	public @ResponseBody String login(@RequestBody List<Map<String, String>> keyValuePair) {
		Map<String, String> map = getRequestParamaters(keyValuePair);
		User user = userService.login(map.get("userName")+"", map.get("password"));
		if (user == null)
			return "KO";
		return "OK";
	}

	private Map<String, String> getRequestParamaters(List<Map<String, String>> keyValuePair) {
		Map<String, String> kv = new HashMap<String, String>();
		for (Map<String, String> kvp : keyValuePair) {
			logger.info("{}, {}", kvp.get("name"), kvp.get("value"));
			kv.put(kvp.get("name"), kvp.get("value"));
		}
		return kv;
	}

	@RequestMapping(value = "/artist", method = RequestMethod.GET)
	public String signUp(Model m) {
		m.addAttribute("artist", new Artist());
		return "artist/signUp";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST, headers = {"Content-type=application/json"}, produces = "application/json")
	public @ResponseBody String signup_(@RequestBody List<Map<String, String>> keyValuePair){

		Map<String, String> kv = getRequestParamaters(keyValuePair);

		final SignupModel signupModel = new SignupModel();
		signupModel.setDisplayName(kv.get("displayName"));
		signupModel.setEmail(kv.get("email"));

		logger.info("{} : {}" , kv.size(), kv.get("displayName"));
		artistService.save(signupModel);
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
