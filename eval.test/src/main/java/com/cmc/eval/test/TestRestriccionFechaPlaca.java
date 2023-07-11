package com.cmc.eval.test;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cmc.eval.entidades.Horario;
import com.cmc.eval.entidades.Restriccion;
import com.cmc.eval.servicios.ServicioRestricciones;

public class TestRestriccionFechaPlaca {

	public static ServicioRestricciones sr = new ServicioRestricciones();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarRestricciones();
		
		Restriccion restriccion1 = sr.buscarRestriccion("22-08-2022",1);
		Restriccion restriccion2 = sr.buscarRestriccion("18-07-2022",9);
		Restriccion restriccion3 = sr.buscarRestriccion("23-07-2022",10);
		
		System.out.println((restriccion1!=null)?restriccion1.toString():"No existe restriccion en esta fecha");
		System.out.println((restriccion2!=null)?restriccion2.toString():"No existe restriccion en esta fecha");
		System.out.println((restriccion3!=null)?restriccion2.toString():"No existe restriccion en esta fecha");
		
	}

	public static void cargarRestricciones(){
		sr = new ServicioRestricciones();
		
		ArrayList<Horario> horarios = sr.obtenerHorariosPorDefecto();
		
		int[] placas12 = {1,2};
		int[] placas34 = {3,4};
		int[] placas56 = {5,6};
		int[] placas78 = {7,8};
		int[] placas90 = {9,0};
		
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-22"),placas12));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-23"),placas34));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-24"),placas56));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-25"),placas78));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-26"),placas90));
		
	}
	
}
