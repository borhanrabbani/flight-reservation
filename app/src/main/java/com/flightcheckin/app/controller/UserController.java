package com.flightcheckin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightcheckin.app.entities.User;
import com.flightcheckin.app.repos.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		return "login"; // Assuming "login" is the name of your login page
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, ModelMap modelMap) {
//		User user = userRepository.findByEmail(email);
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid email or password, please try again");
			return "login";
		}
	}

}
