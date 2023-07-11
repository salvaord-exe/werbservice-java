package com.cmc.eval.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import com.cmc.eval.commons.DateUtil;

public class Restriccion {
	private LocalDate fecha;
	private int[] placas;
	private ArrayList<Horario> horarios;
	
	
	
	public Restriccion(LocalDate fecha, int[] placas) {
		this.fecha = fecha;
		this.placas = placas;
	}



	public Restriccion(LocalDate fecha, int[] placas, ArrayList<Horario> horarios) {
		this.fecha = fecha;
		this.placas = placas;
		this.horarios = horarios;
	}



	@Override
	public String toString() {
		String retorno = "";
		
		retorno += DateUtil.stringFechaRestriccion(this.fecha) + " (" + DateUtil.obtenerDiaSemana(this.fecha) + "): ";
		retorno += "No circulan las placas "+this.placas[0]+" y "+this.placas[1]
				+" en el horario de "+horarios.get(0).toString()+" y "
				+		horarios.get(1).toString()
				+ "\n";
		
		return retorno;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public int[] getPlacas() {
		return placas;
	}



	public void setPlacas(int[] placas) {
		this.placas = placas;
	}



	public ArrayList<Horario> getHorarios() {
		return horarios;
	}



	public void setHorarios(ArrayList<Horario> horarios) {
		this.horarios = horarios;
	}
	
	
	
}
