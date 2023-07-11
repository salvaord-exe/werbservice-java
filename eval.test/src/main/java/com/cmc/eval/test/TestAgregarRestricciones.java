package com.cmc.eval.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import com.cmc.eval.commons.DateUtil;
import com.cmc.eval.entidades.Horario;
import com.cmc.eval.entidades.Restriccion;
import com.cmc.eval.servicios.ServicioRestricciones;

public class TestAgregarRestricciones {
	public static void main(String args[]){
		ServicioRestricciones sr = new ServicioRestricciones();
		
		ArrayList<Horario> horarios = sr.obtenerHorariosPorDefecto();
		
		int[] placas12 = {1,2};
		int[] placas34 = {3,4};
		int[] placas56 = {5,6};
		int[] placas78 = {7,8};
		int[] placas90 = {9,0};
		
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-15"),placas12));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-16"),placas34));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-17"),placas56));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-18"),placas78));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-19"),placas90));
		sr.agregarRestriccion(new Restriccion(LocalDate.parse("2022-08-19"),placas90));
		
		
		System.out.println(sr.getRestricciones());
		
		
		
		
		
	}
}
