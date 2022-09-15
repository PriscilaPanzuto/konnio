package net.sobiecki.konnio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sobieck.sobieckmaven.dto.CategoriaDto;
import net.sobieck.sobieckmaven.dto.VideoDto;
import net.sobiecki.konnio.model.Categoria;
import net.sobiecki.konnio.model.Video;
import net.sobiecki.konnio.service.CrudCategoriaService;
import net.sobiecki.konnio.service.CrudVideoService;


@Controller
@RequestMapping("video")
public class VideoController {
	
	private final CrudVideoService videoService;
	private final CrudCategoriaService categoriaService;
	
	public VideoController(CrudVideoService videoService, CrudCategoriaService categoriaService) {
		this.videoService = videoService;
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("novovideo")
	public String novovideo(Model model, VideoDto novoVideo) {
		List<Categoria> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		return "video/novovideo";
	}
	
	@PostMapping("/novo")
	public String novo(@Valid VideoDto videoDto, BindingResult result, Model model) {
		List<Categoria> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "video/novovideo";
		}
				
		Video novoVideo = videoDto.toVideo(categoriaService, videoService);
		videoService.salvar(novoVideo);
		return "redirect:/home";
	}
	
	@GetMapping("/atualizar/{id}")
	public String atualizarVideo(Model model, @PathVariable(name = "id") Integer id, VideoDto videoDto) {
		Video video = videoService.buscarVideoPorId(id);
		Categoria categoria = categoriaService.buscarCategoriaPorId(video.getCategoria().getId());
		videoDto.toVideoDto(video);
		List<Categoria> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute(videoDto);
		model.addAttribute("selecionado", categoria);
		return "video/atualizar";
	}
	
	@PostMapping("/atualizar/update/{id}")
	public String atualizar(@PathVariable(name = "id") Integer id, @Valid VideoDto videoDto, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "video/novovideo";
		}
			
		videoService.alterar(id, videoDto);
		
		return "redirect:/home";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable(name = "id") Integer id) {
			
		videoService.deletarVideo(id);
		
		return "redirect:/home";
	}
	
	@GetMapping("categoria")
	public String listar(CategoriaDto categoriaDto, Model model) {
		List<Categoria> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		return "video/categoria";
	}
	
	@PostMapping("novaCategoria")
	public String novacategoria(@Valid CategoriaDto novaCategoria, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "video/categoria";
		}
		
		Categoria categoria = novaCategoria.toCategoria();
		categoriaService.salvar(categoria);
		return "redirect:/video/categoria";
	}
	
	@GetMapping("/editarcategoria/{id}")
	public String editarcategoria(Model model, @PathVariable(name = "id") Integer id, CategoriaDto categoriaDto) {
		Categoria categoria = categoriaService.buscarCategoriaPorId(categoriaDto.getId());
		categoriaDto.toCategoriadto(categoria);
		List<Categoria> categorias = categoriaService.listarCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute(categoriaDto);
		return "video/editarcategoria";
	}
	
	@PostMapping("/editarcategoria/update/{id}")
	public String atualizarCategoria(@PathVariable(name = "id") Integer id, @Valid CategoriaDto categoriaDto, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.toString());
			return "redirect:/video/categoria";
		}
			
		categoriaService.alterar(id, categoriaDto);
		
		return "redirect:/video/categoria";
	}
	
	@GetMapping("/deletarcategoria/{id}")
	public String deletarcategoria(@PathVariable(name = "id") Integer id) {
			
		categoriaService.deletarCategoria(id);
		
		return "redirect:/video/categoria";
	}
}