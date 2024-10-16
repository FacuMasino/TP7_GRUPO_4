<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Seguros</title>
		<style><%@include file="style.css"%></style>
	</head>
	<body>
		<%@include file="Header.jsp"%>
		<h1>Tipos de seguros de la base de datos</h1>
		<div class="form-group" style="width: 35%">
		<p>B�squeda por tipo de seguro: </p>
		<select name="ddlTipo">
			<option value="1">Seguro 1</option>
			<option value="2">Seguro 2</option>
			<option value="3">Seguro 3</option>
		</select>	
		<button type="submit" name="btnFiltrar" style="margin-left: 5px">Filtrar</button>
		</div>
		<br>
		<table border="1">
			<tr>
				<th>ID Seguro</th>
				<th>Descripci�n del seguro</th>
				<th>Descripci�n tipo seguro</th>
				<th>Costo contrataci�n</th>
				<th>Costo m�ximo asegurado</th>
			</tr>
			<tr>
				<td>1</td>
				<td>Descripci�n de ejemplo del seguro para prueba</td>
				<td>Descripci�n de ejemplo del tipo de seguro para prueba</td>
				<td>15000.00</td>
				<td>999000.00</td>
			</tr>
		</table>
	</body>
</html>