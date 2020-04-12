package net.cinemaApp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.cinemaApp.app.model.Pelicula;

@Controller
@RequestMapping(value="/peliculas")
public class PeliculasController {
	
	@GetMapping(value="/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping(value="/save")
	public String guardar(Pelicula pelicula, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "peliculas/formPelicula";
		}
		
		System.out.println(pelicula);
		return "peliculas/formPelicula";
	}
}
