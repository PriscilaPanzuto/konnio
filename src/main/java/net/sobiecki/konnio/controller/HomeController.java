package net.sobiecki.konnio.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.sobiecki.konnio.model.Busca;
import net.sobiecki.konnio.model.Video;
import net.sobiecki.konnio.service.CrudVideoService;

@Controller
public class HomeController {
	
	private final CrudVideoService videoService;
	
	public HomeController(CrudVideoService videoService) {
		this.videoService = videoService;
	}
	
	@GetMapping("/home")
	public String home(Model model, Busca busca) {
		List<Video> videos = videoService.listarVideos();
		model.addAttribute("videos", videos);
		model.addAttribute(busca);
		return "home";
	}
	
	@PostMapping("/busca")
	public String busca(Model model, Busca busca, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "home";
		}
		
		List<Video> videos = videoService.buscarPor(busca);
		model.addAttribute("videos", videos);
		return "home";
	}
	
}
