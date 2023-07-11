package com.cmc.eval.test;

import java.text.ParseException;
import java.time.LocalDate;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.commons.ValidationException;
import com.cmc.eval.entidades.Restriccion;
import com.cmc.eval.servicios.ServicioRestriccionesArchivo;

public class TestRestriccionesArchivo {
	public static void main(String args[]){
		
		try {
			ServicioRestriccionesArchivo sra = new ServicioRestriccionesArchivo();
			System.out.println(sra.getRestricciones());
			
			Restriccion restriccion1 = sra.buscarRestriccion("22-08-2022");
			Restriccion restriccion2 = sra.buscarRestriccion("17-08-2022");
			
			System.out.println((restriccion1!=null)?restriccion1.toString():"No existe restriccion en esta fecha");
			System.out.println((restriccion2!=null)?restriccion2.toString():"No existe restriccion en esta fecha");
			
			Restriccion restriccion3 = sra.buscarRestriccion("22-08-2022",3);
			Restriccion restriccion4 = sra.buscarRestriccion("18-08-2022",5);
			
			System.out.println((restriccion3!=null)?restriccion1.toString():"No existe restriccion en esta fecha");
			System.out.println((restriccion4!=null)?restriccion2.toString():"No existe restriccion en esta fecha");
			
			int[] placas12 = {1,2};
			Restriccion resNuevo = new Restriccion(LocalDate.parse("2022-08-15"),placas12);
			
			System.out.println(sra.actualizarRestriccion("15-08-2022", resNuevo));
			
			
			
			
		} catch (ArchivoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
