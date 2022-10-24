package com.cs3306.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WebController {
	
	@Autowired
	private PostRepository postRepo;

	@GetMapping("/")
	public String index(Model model) {
		
		System.out.println("MY_LOG" + "GET request");
		
		List<Post> posts = postRepo.findAll(Sort.by(Sort.Direction.DESC, "time"));		
		System.out.println("MY_LOG" + posts);
		
		Post newPost = new Post();
		
		model.addAttribute("posts", posts);
		model.addAttribute("newPost",newPost);
		
		return "index";
	}
	
	@PostMapping("/")
	public String postMessage(@ModelAttribute Post newPost, Model model) {
		System.out.println("MY_LOG" + "POST request");
		System.out.println("MY_LOG" + newPost + " " + newPost.getName() + " " + newPost.getMessage());
		
		postRepo.save(newPost);
		
		return "redirect:/";
	}
}
