package net.cinemaApp.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.cinemaApp.app.model.Pelicula;
import net.cinemaApp.app.util.Utileria;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = getLista();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		
		return "home";
	}

//	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, 
			@RequestParam(name = "idMovie", required = false) int idPelicula, 
			@RequestParam("fecha") String fecha) {
		
		System.out.println("Id Pelicula: " + idPelicula);
		System.out.println("Fecha de Busqueda: " + fecha);
		
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
