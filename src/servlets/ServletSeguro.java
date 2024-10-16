package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SeguroDaoImpl;
import entidad.Seguro;


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
		SeguroDaoImpl seguroDao = new SeguroDaoImpl();
		int nextId = seguroDao.obtenerUltimoId() + 1;
		
		request.setAttribute("nextId", nextId);
		
		if(request.getParameter("btnAceptar") != null) /*veo de preguntar por campos llenos...es necesario?*/
		{
			/*
			String descripcion = request.getParameter("txtDescripcion");
			int idTipo = Integer.parseInt(request.getParameter("ddlTipoSeguro").toString());
			float costoContratacion = Float.parseFloat(request.getParameter("txtCosto").toString());
			float costoAsegurado = Float.parseFloat(request.getParameter("txtMaximo").toString());
			
			Seguro seg = new Seguro();
			
			seg.setDescripcion(descripcion);
			seg.setIdTipo(idTipo);
			seg.setCostoContratacion(costoContratacion);
			seg.setCostoAsegurado(costoAsegurado);
			
			seguroDao.agregar(seg);
			*/
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
