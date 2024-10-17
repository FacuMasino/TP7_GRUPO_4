package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SeguroDaoImpl;
import entidad.Seguro;
import entidad.TipoSeguro;


@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    public ServletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String message;
		
		try
		{
			// Procesar solicitudes dentro del Try Catch
			
			if(request.getParameter("btnAceptar") != null)
			{
				boolean exito = procesarRequestAgregar(request);
				message = exito ? "Seguro agregado con éxito!" : "Ocurrió un error al guardar seguro.";
				
				request.setAttribute("message", message);
			}
		}
		// Excepcion producida si faltan parámetros
		catch (IllegalArgumentException ex)
		{
			message = ex.getMessage();
			request.setAttribute("message", message);
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
		rd.forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean validarParametrosAgregar(Map<String, String[]> parametros)
	{
		for(Map.Entry<String, String[]> entry: parametros.entrySet())
		{
			// Excluye al parametro btnAceptar
			if(entry.getKey().equals("btnAceptar")) continue;
			// Si algún parámetro del request está vacio, entonces no es válido
			if(entry.getValue()[0].isEmpty()) return false;
		}
		// Si todos los parámetros tienen info, validar
		return true;
	}
	
	private boolean procesarRequestAgregar(HttpServletRequest request) throws IllegalArgumentException 
	{
		SeguroDaoImpl seguroDao = new SeguroDaoImpl();
		
		Map<String, String[]> parametros = request.getParameterMap();
		
		if(!validarParametrosAgregar(parametros))
		{
			throw new IllegalArgumentException("Debe completar todos los campos");
		}
		
		try 
		{
			String descripcion = request.getParameter("txtDescripcion");
			int idTipo = Integer.parseInt(request.getParameter("ddlTipoSeguro").toString());
			float costoContratacion = Float.parseFloat(request.getParameter("txtCosto").toString());
			float costoAsegurado = Float.parseFloat(request.getParameter("txtMaximo").toString());
			
			Seguro seg = new Seguro();
			TipoSeguro tipoSeg = new TipoSeguro();
			tipoSeg.setId(idTipo);

			seg.setDescripcion(descripcion);
			seg.setTipoSeguro(tipoSeg);
			seg.setCostoContratacion(costoContratacion);
			seg.setCostoAsegurado(costoAsegurado);
			
			boolean exito = seguroDao.agregar(seg);
			
			return exito;
		}
		catch (NumberFormatException ex)
		{
			throw new NumberFormatException("Verifique los campos, tienen un formato incorrecto");
		}
		
	}
}
