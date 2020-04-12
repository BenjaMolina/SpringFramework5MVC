package net.cinemaApp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.cinemaApp.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {
	
	@GetMapping(value="/create")
	public String crear() {
		return "noticias/formNoticias";
	}
	
	@PostMapping(value="/save")
	public String guardar(Noticia noticia) {
		
		//TODO: Falta guardar a la BD
		
		System.out.println(noticia);
		
		return "noticias/formNoticias";
	}
}
