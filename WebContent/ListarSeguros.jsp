<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entidad.TipoSeguro"%>
<%@ page import="daoImpl.TipoSeguroDaoImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Seguros</title>
		<style><%@include file="style.css"%></style>
	</head>
	<body>
		<%@include file="Header.jsp"%>
		<%
			TipoSeguroDaoImpl tipoDao = new TipoSeguroDaoImpl();
			ArrayList<TipoSeguro> listaTipos = new ArrayList<TipoSeguro>();
			listaTipos = tipoDao.readAll();
		%>
		<h1>Tipos de seguros de la base de datos</h1>
		<form action="ServletSeguro" method="get">
			<div class="form-group" style="width: 35%">
				<p>Búsqueda por tipo de seguro: </p>
				<select name="ddlTipo">
					<option value="1">Seleccionar Tipo</option>
					<%
						for(TipoSeguro tipo : listaTipos)
						{
					%>
						<option value=<%=tipo.getId() %>><%= tipo.getDescripcion() %></option>
					<%
						}
					%>
				</select>
				<button type="submit" name="btnFiltrar" style="margin-left: 5px">Filtrar</button>
			</div>
		</form>
		<br>
		<table border="1">
			<tr>
				<th>ID Seguro</th>
				<th>Descripción del seguro</th>
				<th>Descripción tipo seguro</th>
				<th>Costo contratación</th>
				<th>Costo máximo asegurado</th>
			</tr>
			<tr>
				<td>1</td>
				<td>Descripción de ejemplo del seguro para prueba</td>
				<td>Descripción de ejemplo del tipo de seguro para prueba</td>
				<td>15000.00</td>
				<td>999000.00</td>
			</tr>
		</table>
	</body>
</html>