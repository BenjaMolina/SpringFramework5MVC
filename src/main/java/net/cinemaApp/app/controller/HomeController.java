package net.cinemaApp.app.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.cinemaApp.app.model.Pelicula;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		
		List<Pelicula> peliculas = getLista();
		
//		peliculas.add("Rapidos y furiosos 5");
//		peliculas.add("Avengers - End Game");
//		peliculas.add("El aro 2");
//		peliculas.add("Aliens vs Depredador");
		
		
		model.addAttribute("peliculas", peliculas);
		
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value = "/detail")
	public String mostrarDetalle(Model model) {
		
		String tituloPelicula = "Avengers - End Game";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		
		return "detalle";
	}
	
	private List<Pelicula> getLista(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		
		try {
			lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Avengers - End Game");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Accion");
			pelicula1.setFechaEstreno(formatter.parse("05-05-2019"));
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("El Ilusionista");
			pelicula2.setDuracion(120);
			pelicula2.setClasificacion("B");
			pelicula2.setGenero("Accion");
			pelicula2.setFechaEstreno(formatter.parse("05-05-2009"));
			pelicula2.setImagen("bella.png");
			pelicula2.setEstatus("Inactivo");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Juego de Tronos");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Accion");
			pelicula3.setFechaEstreno(formatter.parse("05-05-2006"));
			pelicula3.setImagen("kong.png");
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		return lista;
	}

}
