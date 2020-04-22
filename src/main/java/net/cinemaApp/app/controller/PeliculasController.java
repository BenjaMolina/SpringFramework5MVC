package net.cinemaApp.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cinemaApp.app.model.Pelicula;
import net.cinemaApp.app.service.IPelicula;

@Controller
@RequestMapping(value="/peliculas")
public class PeliculasController {
	
	@Autowired
	private IPelicula servicePelicula;
	
	@GetMapping(value="/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePelicula.obtenerTodas();
		
		model.addAttribute("peliculas", lista);
		
		return "peliculas/listPeliculas";
	}
	
	@GetMapping(value="/create")
	public String crear() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping(value="/save")
	public String guardar(Pelicula pelicula, BindingResult result, Model model, RedirectAttributes attributes,
				@RequestParam("archivoImagen") MultipartFile multipart, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			System.out.println("Existieron errores");
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "peliculas/formPelicula";
		}
		
		if(!multipart.isEmpty()) {
			String nombreImagen = guardarImagen(multipart,request);
			pelicula.setImagen(nombreImagen);
		}
		
		System.out.println(pelicula);
		servicePelicula.insertar(pelicula);
		
		attributes.addFlashAttribute("mensaje", "Pelicula agregado con exito");
		
		return "redirect:/peliculas/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	private String guardarImagen(MultipartFile multipart, HttpServletRequest request) {
		//Obtenemos el nombre original del archivo
		String nombreOriginal = multipart.getOriginalFilename();
		
		//Obtenemos la ruta absoluta del directorio images
		//apache-tomcat/webapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		
		try {
			//Formamos el nombre del archivo para guardarlo
			File imageFile = new File(rutaFinal + nombreOriginal);
			
			//Guardamos fisicamente el archivo en disco duro
			multipart.transferTo(imageFile);
			
			return nombreOriginal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}

	}
}
