<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entidad.TipoSeguro"%>
<%@ page import="entidad.Seguro"%>
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
			ArrayList<Seguro> seguros = null;
			
			if (request.getAttribute("seguros") != null)
			{
				seguros = (ArrayList<Seguro>)request.getAttribute("seguros");
			}
		%>
		<h1>Tipos de seguros de la base de datos</h1>
		<form action="ServletSeguro" method="get">
			<div class="form-group" style="width: 35%">
				<p>B�squeda por tipo de seguro: </p>
				<select name="ddlTipo">
					<option value="1">Seleccionar Tipo</option>
					<%
						for(TipoSeguro tipo : listaTipos)
						{
					%>
						<option value=<%=tipo.getId() %>>
							<%= tipo.getDescripcion() %>
						</option>
					<%
						}
					%>
				</select>
				<button
					type="submit"
					name="btnFiltrar"
					style="margin-left: 5px">
					Filtrar
				</button>
			</div>
		</form>
		<br>
		<table border="1">
			<tr>
				<th>ID Seguro</th>
				<th>Descripci�n del seguro</th>
				<th>Descripci�n tipo seguro</th>
				<th>Costo contrataci�n</th>
				<th>Costo m�ximo asegurado</th>
			</tr>
			<%
				if (seguros != null)
				{
					for (Seguro seguro : seguros)
					{
			%>
						<tr>
							<td><%=seguro.getId()%></td>
							<td><%=seguro.getDescripcion()%></td>
							<td><%=seguro.getTipoSeguro().getDescripcion()%></td>
							<td><%=seguro.getCostoContratacion()%></td>
							<td><%=seguro.getCostoAsegurado()%></td>
						</tr>
			<%		
					}
				}
				else
				{
			%>
					<tr>
						<td>0</td>
						<td>N/A</td>
						<td>N/A</td>
						<td>0.00</td>
						<td>0.00</td>
					</tr>
			<%
				}
			%>
		</table>
	</body>
</html>