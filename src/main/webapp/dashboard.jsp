<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Estyles/Generalcss">
<title>Mi Dashboard</title>
</head>
<style>
	.msg_bienvenida{
		padding:1em;
	}
	.dashboard_content{
		display: flex;
		align-items: flex-start;
	}
	section{
		width:100%;
	}
</style>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp" %>
		<section>
			<div class="msg_bienvenida">
			<h2>Te damos la bienvenida <%= nombre%> <%= apellido%></h2>
			<h3>Unidad Organica: <%= unidaOrg%> </h3>
		</section>
	</div>
	
</body>
</html>