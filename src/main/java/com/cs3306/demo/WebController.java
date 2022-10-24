package com.cs3306.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;

@RestController
public class WebController {

	@GetMapping("/")
	public String index() {
		return "This is the main page";
	}

	@GetMapping("/info")
	public String info() {
		return "this is the second page";
	}

}
