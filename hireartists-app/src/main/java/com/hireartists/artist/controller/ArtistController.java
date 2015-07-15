/**
 * 
 */
package com.hireartists.artist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hireartists.artist.service.ArtistService;
import com.hireartists.artist.service.UserService;
import com.hireartists.client.model.ArtistModel;
import com.hireartists.client.model.Profile;
import com.hireartists.client.model.Session;
import com.hireartists.client.model.SignupModel;
import com.hireartists.client.model.mapper.ProfileMapper;
import com.hireartists.domain.Artist;
import com.hireartists.domain.Event;
import com.hireartists.domain.User;

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

	public ArtistController() {
	}

	public ArtistController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = "application/json")
	public @ResponseBody String login_(@RequestBody List<Map<String, String>> keyValuePair) {
		Map<String, String> map = getRequestParamaters(keyValuePair);
		User user = userService.login(map.get("userName") + "", map.get("password"));
		if (user == null) {
			return "KO";
		}
		Session.userName = user.getUserName();
		Session.user = user;
		return "OK";

	}

	// request return for sign up page
	@RequestMapping(value = "/artist-sign-up", method = RequestMethod.GET)
	public String signUp(Model m) {
		m.addAttribute("artist", new Artist());
		return "artist/signUp";
	}

	// request for sign off return home page
	@RequestMapping(value = "/artist/signOut", method = RequestMethod.GET)
	public String signOff(Model m) {
		Session.user = null;
		Session.userName = "";
		return "redirect:/";
	}

	// request for sign off return home page
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String showHome(Model m) {
		return "redirect:/";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = "application/json")
	public @ResponseBody Map<String, String> signup_(@RequestBody List<Map<String, String>> keyValuePair) {

		Map<String, String> kv = getRequestParamaters(keyValuePair);

		final SignupModel signupModel = new SignupModel();
		signupModel.setDisplayName(kv.get("displayName"));
		signupModel.setAddress(kv.get("address"));
		signupModel.setUsername(kv.get("username"));
		signupModel.setPassword(kv.get("password"));
		signupModel.setEmail(kv.get("email"));

		logger.info("{} : {}", kv.size(), kv.get("displayName"));

		artistService.save(signupModel);
		Map<String, String> result = new HashMap<String, String>();
		result.put("status", "success");
		return result;
	}

	// if request comes for LoginView, return the loginView page
	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String getLoginView(Model m) {
		return "artist/signIn";
	}

	// if request comes for profileView, return the profileView jsp page
	@RequestMapping(value = "/artist/profile", method = RequestMethod.GET)
	public String artistProfile(Model m) {
		return "artist/profile";
	}

	// request return for viewing the list of artists page
	@RequestMapping(value = "/artistList", method = RequestMethod.GET)
	public String showArtistList(Model m) {
		List<Artist> artistList = artistService.findAll();
		m.addAttribute("artistList", artistList);
		return "artist/list";
	}

	// request return for viewing the list of artists page
	@RequestMapping(value = "artist/viewEvents", method = RequestMethod.GET)
	public String showEventList(Model m) {
//		List<Event> eventList = eventService.findAll();
//		m.addAttribute("artistList", artistList);
		return "artist/eventList";
	}
	
	// request return for viewing the profile after viewing the list of events
		@RequestMapping(value = "artist/backToProfile", method = RequestMethod.GET)
		public String showProfile(Model m) {
//			List<Event> eventList = eventService.findAll();
//			m.addAttribute("artistList", artistList);
			return "artist/profile";
		}

	@RequestMapping(value = "/artist/update", method = RequestMethod.POST, headers = "Accept=*/*")
	public ModelAndView update(@ModelAttribute("artist") ArtistModel artistModel) {
		return null;
	}

	@RequestMapping(value = "/artist/{userName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Profile profile(@PathVariable(value = "userName") String userName) {
		Artist a = artistService.getProfile(userName);
		logger.info("Artist {}", a.getDisplayName());
		Profile p = ProfileMapper.mapToModel(a);
		return p;
	}

	private Map<String, String> getRequestParamaters(List<Map<String, String>> keyValuePair) {
		Map<String, String> kv = new HashMap<String, String>();
		for (Map<String, String> kvp : keyValuePair) {
			logger.info("{}, {}", kvp.get("name"), kvp.get("value"));
			kv.put(kvp.get("name"), kvp.get("value"));
		}
		return kv;
	}

}
