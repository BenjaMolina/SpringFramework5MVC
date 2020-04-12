package net.cinemaApp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/peliculas")
public class PeliculasController {
	
	@GetMapping(value="/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
}
