package net.cinemaApp.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	
	/*
	 * Regresa una lista de strings con las fechas siguientes al dia actual,
	 * segun el parametro count
	 * */
	public static List<String> getNextDays(int count){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count); //Proximos N dias a partir de hoy
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();
		while(!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		
		return nextDays;
		
	}
	
	public static String guardarImagen(MultipartFile multipart, HttpServletRequest request) {
		//Obtenemos el nombre original del archivo
		String nombreOriginal = multipart.getOriginalFilename();		
		//Quitamos espacios
		nombreOriginal = nombreOriginal.replace(" ", "-"); 
		//Nombre aleatorio
		String nombreFinal = randomAlphanumeric(8) + nombreOriginal;
		
		//Obtenemos la ruta absoluta del directorio images
		//apache-tomcat/webapps/cineapp/resources/images/
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");
		
		try {
			//Formamos el nombre del archivo para guardarlo
			File imageFile = new File(rutaFinal + nombreFinal);
			//Ver la ruta donde se guardan las imagenes (deploy)
			System.out.println(imageFile.getAbsolutePath());
			
			//Guardamos fisicamente el archivo en disco duro
			multipart.transferTo(imageFile);
			
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}

	}
	
	public static String randomAlphanumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0 ) {
			int caracter = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(caracter));
		}
		
		return builder.toString();
	}
}
