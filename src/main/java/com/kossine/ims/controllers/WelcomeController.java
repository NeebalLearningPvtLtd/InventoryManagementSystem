package com.kossine.ims.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
   
	@RequestMapping("/hello")
	public String sayHello(@RequestParam String naam) {
		return "hello "+ naam;
	}
}
