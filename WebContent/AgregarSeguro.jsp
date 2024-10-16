<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h1>Agregar Seguros</h1>
		<form class="form-agregar-seguro d-flex flex-column" action="ServletSeguro">
			<div class="form-group">
				<p>Id Seguro</p>
				<span>
					<%
						//int nextId=0;
						if(request.getAttribute("nextId") != null)
						{
							int nextId=(int)request.getAttribute("nextId");
					%>
						<%=nextId %>
					<%
						}					
					%>
					
				</span>
			</div>
			<div class="form-group">
				<p>Descripción</p>
				<input type="text" name="txtDescripcion" required/>
			</div>
			<div class="form-group">
				<p>Tipo de Seguro</p>
				<select name="ddlTipoSeguro">
					<option value="1">usar for</option>
					<option value="2">usar for</option>
					<option value="3">usar for</option>
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