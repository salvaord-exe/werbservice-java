package ws.webservice;

import java.util.ArrayList;

import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.entidades.Consulta;
import com.cmc.eval.entidades.Restriccion;
import com.cmc.eval.servicios.ServicioRestriccionesArchivo;



@Path("/picoplaca")
public class RestriccionRest {
	private Logger logger = LogManager.getLogger(RestriccionRest.class);
	
	@Path("/restricciones")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPersonas() throws Exception{
		try {
			ServicioRestriccionesArchivo ma = new ServicioRestriccionesArchivo();
			ArrayList<Restriccion> lstRestricciones = ma.leerRestricciones();
			String retorno = "";
			for (Restriccion restriccion : lstRestricciones){
				retorno += restriccion.toString();
			}
			return Response.status(200).entity(retorno).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error al consultar"+e);
			return Response.status(200).entity(e.getMessage()).build();
		}
		
	}
	
	
	@Path("/validar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarCirculacion(Consulta consulta) throws Exception{
		
		try {
			logger.info(consulta.toString());;
			
			ServicioRestriccionesArchivo ma = new ServicioRestriccionesArchivo();
			
			Restriccion restriccion = ma.buscarRestriccion(consulta.getFecha(), Integer.parseInt(consulta.getPlaca()) , consulta.getHora());
			
			String retorno = (restriccion==null)?"PUEDE CIRCULAR":"SI SALES TE MULTAN";
			
			return Response.status(200).entity(retorno).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error al validar"+e);
			return Response.status(200).entity(e.getMessage()).build();
		}
		
	}
}
