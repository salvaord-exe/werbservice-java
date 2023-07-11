package com.cmc.eval.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	private static final String PATRON_FECHA = "dd/MM/yyyy hh:mm:ss";
	private static final String NUEVO_PATRON_FECHA = "dd-MM-yyyy";
	private static final String PATRON_HORA = "HH:mm";

	public static String convertir(Date fechaCreacion) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATRON_FECHA);
		String retorno = sdf.format(fechaCreacion);
		return retorno;
	}

	public static LocalDate convertirLocalDate(String fecha) throws ParseException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(NUEVO_PATRON_FECHA);
		return LocalDate.parse(fecha,formatter);
	}

	public static String stringFechaRestriccion(LocalDate fechaRestriccion) {
		
		String formattedDate = fechaRestriccion.format(DateTimeFormatter.ofPattern(NUEVO_PATRON_FECHA));
	
		return formattedDate;
	}
	
	public static String stringHoraRestriccion(LocalTime horaRestriccion){
		String formattedTime = horaRestriccion.format(DateTimeFormatter.ofPattern(PATRON_HORA));
		
		return formattedTime;
	}
	
	public static LocalTime obtenerHoraRestriccion(String hora) throws ParseException{
		LocalTime horaRetorno = LocalTime.parse(hora);
		return horaRetorno;
	}

	public static String obtenerDiaSemana(LocalDate fecha){
		Calendar c = Calendar.getInstance();
		c.set(fecha.getYear(), fecha.getMonth().getValue()-1, fecha.getDayOfMonth());
		
		int DiaSemana = c.get(Calendar.DAY_OF_WEEK);
		
		String strDiaSemana = "";
		
		switch (DiaSemana){
        case 1: strDiaSemana = "DOMINGO";
            break;
        case 2: strDiaSemana = "LUNES";
            break;
        case 3: strDiaSemana = "MARTES";
            break;
        case 4: strDiaSemana = "MIERCOLES";
            break;
        case 5: strDiaSemana = "JUEVES";
            break;
        case 6: strDiaSemana = "VIERNES";
            break;
        case 7: strDiaSemana = "SABADO";
            break;
        default:
            break;
		}
        
		return strDiaSemana;
		
    }

}
