/**
 * 
 */
package com.hireartists.web.controller;

import java.util.Date;
import java.util.Map;

import com.hireartists.domain.Event;
import com.hireartists.domain.EventOrganiser;
import com.hireartists.domain.User;
import com.hireartists.eventOrganiser.repositories.EventOrganiserRepository;
import com.hireartists.eventOrganiser.repositories.EventRepository;
import com.hireartists.web.repository.ArtistRepository;
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
	ArtistRepository artistRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	EventOrganiserRepository eventOrganiserRepository;

	public PersistenceController(){}

	@RequestMapping(value = "/persistence", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody
	Map<String, Object> setupEvent() {
		User user = new User();
		user.setAuthority("ROLE_EVENT_ORGANISER");
		user.setUserName("morrision.bar");
		user.setPassword("123456");
		User addedUser = userRepository.save(user);

		EventOrganiser organiser = new EventOrganiser();
		organiser.setName("Morrison Bar");
		organiser.setEmail("morrision.bar@gmail.com");
		organiser.setUser(addedUser);
		EventOrganiser e = eventOrganiserRepository.save(organiser);

		Event event = new Event();
		event.setEventOrganiser(e);
		event.setName("California Festival");
//		event.setFrom(new Date());
//		event.setTo(new Date());
		event.addArtist(artistRepository.findOne(1l));
		eventRepository.save(event);

		Map<String, Object> map = new HashedMap();
		map.put("id", addedUser.getId());
		map.put("username", addedUser.getUserName());
		return map;
		// return addedUser;
	}
}
