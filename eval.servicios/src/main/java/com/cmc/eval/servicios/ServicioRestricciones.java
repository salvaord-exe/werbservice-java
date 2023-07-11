package com.cmc.eval.servicios;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.eval.commons.DateUtil;
import com.cmc.eval.entidades.Horario;
import com.cmc.eval.entidades.Restriccion;

public class ServicioRestricciones {
	private ArrayList<Restriccion> restricciones;
	private Logger logger = LogManager.getLogger(ServicioRestricciones.class);
	
	public ServicioRestricciones(){
		restricciones = new ArrayList<Restriccion>();
	}
	
	
	public ArrayList<Horario> obtenerHorariosPorDefecto(){
		
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		
		LocalTime fechaInicio1 = LocalTime.parse("06:00");
		LocalTime fechaFin1 = LocalTime.parse("09:30");
		LocalTime fechaInicio2 = LocalTime.parse("16:00:00");
		LocalTime fechaFin2 = LocalTime.parse("21:00:00");
		
		Horario horario1 = new Horario(fechaInicio1,fechaFin1);
		Horario horario2 = new Horario(fechaInicio2,fechaFin2);
		
		
		horarios.add(horario1);
		horarios.add(horario2);
		
		return horarios;
		
	}
	
	public boolean agregarRestriccion(Restriccion restriccion){
		String fechaBusqueda = DateUtil.stringFechaRestriccion(restriccion.getFecha());
		if(this.buscarRestriccion(fechaBusqueda)==null){
			if(restriccion.getHorarios()==null){
				restriccion.setHorarios(this.obtenerHorariosPorDefecto());
			}
			
			this.restricciones.add(restriccion);
			return true;
		}else{
			return false;
		}
	}
	
	public Restriccion buscarRestriccion(String fecha){
		for(Restriccion restriccion : this.restricciones){
			try {
				if(restriccion.getFecha().equals(DateUtil.convertirLocalDate(fecha))){
					return restriccion;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				logger.error("Error al parsear la fecha" + e);
			}
		}
		return null;
	}

	public Restriccion buscarRestriccion(String fecha,int ultimoDigito){
		Restriccion restriccion = this.buscarRestriccion(fecha);
		if (restriccion!=null){
			int[] placas = restriccion.getPlacas();
			
			for(int i=0;i<placas.length;i++){
				if(placas[i]==ultimoDigito){
					return restriccion;
				}
			}
			return null;
		}
		return null;
	}
	
	public Restriccion buscarRestriccion(String fecha,int ultimoDigito, String hora){
		Restriccion restriccion = this.buscarRestriccion(fecha,ultimoDigito);
		try{
			if(restriccion!=null){
				LocalTime horaBusqueda = DateUtil.obtenerHoraRestriccion(hora);
				boolean boolRetorno = false;
				
				for (Horario horario : restriccion.getHorarios()){
					LocalTime horaInicio = horario.getFechaInicio();
					LocalTime horaFin = horario.getFechaFin();
					
					boolRetorno = (horaBusqueda.isAfter(horaInicio) && horaBusqueda.isBefore(horaFin)) || ((horaBusqueda.compareTo(horaFin)==0 || horaBusqueda.compareTo(horaInicio)==0));
					
					if(boolRetorno){
						return restriccion;
					}
				}
				
			}
		}catch(ParseException e){
			logger.error("Error al pasear la hora"+e);
		}
		
		
		return null;
	}
	
	public Restriccion buscarRestriccion(int ultimoDigito){
		
		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		
		String strHoy = DateUtil.stringFechaRestriccion(hoy);
		String strAhora = DateUtil.stringHoraRestriccion(ahora);
		
		return this.buscarRestriccion(strHoy, ultimoDigito, strAhora);
		
	}
	
	public boolean actualizarRestriccion(String fecha, Restriccion restriccion){
		Restriccion resViejo = this.buscarRestriccion(fecha);
		if(resViejo!=null){
			int index = this.restricciones.indexOf(resViejo);
			
			this.restricciones.set(index, restriccion);
			return true;
		}
		return false;
	}
	
	public boolean eliminarRestriccion(String fecha){
		Restriccion resEliminar = this.buscarRestriccion(fecha);
		if (resEliminar!=null){
			this.restricciones.remove(resEliminar);
			return true;
		}
		return false;
	}
	
	public ArrayList<Restriccion> getRestricciones() {
		return restricciones;
	}
	

	
	
	
}
