package net.cinemaApp.app.service;

import java.util.List;

import net.cinemaApp.app.model.Pelicula;

public interface IPelicula {
	void insertar(Pelicula pelicula);
	List<Pelicula> obtenerTodas();
	Pelicula getPelicula(int id);
}
