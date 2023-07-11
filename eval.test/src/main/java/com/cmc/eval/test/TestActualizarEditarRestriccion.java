package com.cmc.eval.test;

import java.text.ParseException;
import java.time.LocalDate;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.commons.ValidationException;
import com.cmc.eval.entidades.Restriccion;
import com.cmc.eval.servicios.ServicioRestriccionesArchivo;

public class TestActualizarEditarRestriccion {
	public static void main(String args[]){
		try {
			ServicioRestriccionesArchivo sra = new ServicioRestriccionesArchivo();
			System.out.println(sra.getRestricciones());
			
			
			
			int[] placas12 = {9,9};
			Restriccion resNuevo = new Restriccion(LocalDate.parse("2022-08-15"),placas12);
			resNuevo.setHorarios(sra.obtenerHorariosPorDefecto());
			
			System.out.println(sra.actualizarRestriccion("15-08-2022", resNuevo));
			System.out.println(sra.eliminarRestriccion("19-08-2022"));
			
			System.out.println(sra.getRestricciones());
			
			
		} catch (ArchivoException e) {
			// TODO Auto-generated catch block
			
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			
		}
	}
}
