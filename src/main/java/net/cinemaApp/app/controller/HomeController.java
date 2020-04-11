package net.cinemaApp.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.cinemaApp.app.model.Pelicula;
import net.cinemaApp.app.service.IPelicula;
import net.cinemaApp.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPelicula servicePelicula;  
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = servicePelicula.obtenerTodas();
		
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			final Date searchFecha = formatter.parse(fecha);
			
			List<Pelicula> peliculas = servicePelicula.obtenerTodas().stream()
					   .filter(p -> p.getFechaEstreno().compareTo(searchFecha) == 0)
					   .collect(Collectors.toList());

			List<String> listaFechas = Utileria.getNextDays(4);
			model.addAttribute("peliculas", peliculas);
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", fecha);
									
								   
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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

}
