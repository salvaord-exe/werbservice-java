package com.cmc.eval.entidades;

public class Consulta {
	private String fecha;
	private String hora;
	private String placa;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "Consulta [fecha=" + fecha + ", hora=" + hora + ", placa=" + placa + "]";
	}
	
	
}
