<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entidad.TipoSeguro"%>
<%@ page import="daoImpl.TipoSeguroDaoImpl"%>
<%@ page import="daoImpl.SeguroDaoImpl"%>

<!DOCTYPE html>

<html data-theme="light">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agregar Seguro - SegurosGroup</title>
		<link href="./css/tw-styles.css" rel="stylesheet" type="text/css">
		<link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.13/dist/full.min.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<!-- menú -->
		<%@include file="Header.jsp"%>
		<%
			TipoSeguroDaoImpl tipoDao = new TipoSeguroDaoImpl();
			ArrayList<TipoSeguro> listaTipos = new ArrayList<TipoSeguro>();
			listaTipos = tipoDao.readAll();
		%>
		<h1>Agregar Seguros</h1>
		<form class="w-[400px]" action="ServletSeguro" method="get">
		  <div class="flex justify-between items-center mb-4">
		    <p>Id Seguro</p>
		    <span>
		      <%
		        SeguroDaoImpl seguroDao = new SeguroDaoImpl();
		        int nextId = seguroDao.obtenerUltimoId()+1;
		      %>
		      <%=nextId%>
		    </span>
		  </div>
		  <div class="flex justify-between items-center mb-4">
		    <p class="flex-1">Descripción</p>
		    <input class="flex-1 input input-bordered w-full max-w-xs" type="text" name="txtDescripcion" required/>
		  </div>
		  <div class="flex justify-between items-center mb-4">
		    <p class="flex-1">Tipo de Seguro</p>
		    <select class="flex-1 select select-bordered" name="ddlTipoSeguro">
		      <option value=null>Seleccionar Tipo</option>
		      <%
		        for(TipoSeguro tipo : listaTipos)
		        {
		      %>
		        <option value=<%=tipo.getId() %>><%= tipo.getDescripcion() %></option>
		      <%
		        }
		      %>
		    </select>
		  </div>
		  <div class="flex justify-between items-center mb-4">
		    <p>Costo contratación</p>
		    <input class="h-10 px-3 text-base placeholder-gray-600 border rounded-lg focus:shadow-outline" type="text" name="txtCosto" required/>
		  </div>
		  <div class="flex justify-between items-center mb-4">
		    <p>Costo máximo asegurado</p>
		    <input class="h-10 px-3 text-base placeholder-gray-600 border rounded-lg focus:shadow-outline" type="text" name="txtMaximo" required/>
		  </div>
		  <div class="flex justify-end mt-4">
		    <button type="submit" name="btnAceptar" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
		      Aceptar
		    </button>
		  </div>
		  <%
		    if(request.getAttribute("message") != null)
		    {
		      String message = request.getAttribute("message").toString();
		  %>
		  <p class="text-red-500 mt-2"><%=message %></p>
		  <%
		    }
		  %>
		</form>
	</body>
</html>