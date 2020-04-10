package net.cinemaApp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticias";
	}
	
	@PostMapping(value="/save")
	public String guardar(
				@RequestParam("titulo") String titulo, 
				@RequestParam("estatus") String estatus, 
				@RequestParam("detalle") String detalle) {
		
		System.out.println(titulo + " " + estatus + " " + detalle);
		return "noticias/formNoticias";
	}
}