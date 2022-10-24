package com.cs3306.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WebController {
	
	@Autowired
	private MessageRepository messageRepo;

	@GetMapping("/")
	public String index() {
		System.out.println("MY_LOG" + "INDEX ACCESS");
		return "index";
	}

	@GetMapping("/info")
	public String info(Model model) {
		System.out.println("MY_LOG" + "INFO ACCESS");
		
		List<Message> messages = messageRepo.findAll();
		System.out.println("MY_LOG" + messages);
		
		model.addAttribute("messages", messages);
		
		return "info";
	}

}
