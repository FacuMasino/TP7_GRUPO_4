<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entidad.TipoSeguro"%>
<%@ page import="daoImpl.TipoSeguroDaoImpl"%>
<%@ page import="daoImpl.SeguroDaoImpl"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Agregar Seguro - SegurosGroup</title>
		<style><%@include file="style.css"%></style>
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
		<form class="form-agregar-seguro d-flex flex-column" action="ServletSeguro" method="get">
			<div class="form-group">
				<p>Id Seguro</p>
				<span>
					<%
						SeguroDaoImpl seguroDao = new SeguroDaoImpl();
						int nextId = seguroDao.obtenerUltimoId()+1;
					%>
						<%=nextId%>
				</span>
			</div>
			<div class="form-group">
				<p>Descripción</p>
				<input type="text" name="txtDescripcion" required/>
			</div>
			<div class="form-group">
				<p>Tipo de Seguro</p>
				<select name="ddlTipoSeguro">
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
			<div class="form-group">
				<p>Costo contratación</p>
				<input type="text" name="txtCosto" required/>
			</div>
			<div class="form-group">
				<p>Costo máximo asegurado</p>
				<input type="text" name="txtMaximo" required/>
			</div>
			<button type="submit" name="btnAceptar" >Aceptar</button>
			
			<%
				if(request.getAttribute("message") != null)
				{
					String message = request.getAttribute("message").toString();
			%>
					<%=message %>
			<%	
				}
			%>
			
		</form>
	</body>
</html>