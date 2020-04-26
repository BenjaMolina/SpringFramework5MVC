package net.cinemaApp.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.cinemaApp.app.model.Pelicula;

@Service
public class PeliculaServiceImpl implements IPelicula {
	
	private List<Pelicula> lista;
	
	public PeliculaServiceImpl() {
		System.out.println("Se ha creado una instanacia del Servicio Peliculas");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		this.lista = null;
		
		try {
			this.lista = new LinkedList<>();
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Avengers - End Game");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Accion");
			pelicula1.setFechaEstreno(formatter.parse("7-04-2020"));
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("El Ilusionista");
			pelicula2.setDuracion(120);
			pelicula2.setClasificacion("B");
			pelicula2.setGenero("Accion");
			pelicula2.setFechaEstreno(formatter.parse("7-04-2020"));
			pelicula2.setImagen("bella.png");
			pelicula2.setEstatus("Inactivo");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Juego de Tronos");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Accion");
			pelicula3.setFechaEstreno(formatter.parse("19-09-2019"));
			pelicula3.setImagen("kong.png");
			
			this.lista.add(pelicula1);
			this.lista.add(pelicula2);
			this.lista.add(pelicula3);
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	@Override
	public List<Pelicula> obtenerTodas() {		
		return this.lista;
	}

	@Override
	public Pelicula getPelicula(int id) {
		for (Pelicula pelicula : this.lista) {
			if(pelicula.getId() == id) return pelicula;
		}
		
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		this.obtenerTodas().add(pelicula);
	}

	@Override
	public List<String> buscarGeneros() {
		
		List<String> generos =  new LinkedList<String>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciencia Ficcion");
		
		return generos;
		
	}
	
}
