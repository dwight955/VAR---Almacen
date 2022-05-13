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
</style>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp" %>
		<section>
			<div class="msg_bienvenida">
			<h2>Te damos la bienvenida <%= nombre%> <%= apellido%></h2>
			<h3>Unidad Organica: <%= unidaOrg%> </h3>
			</div>
		</section>
	</div>
	
</body>
<script>
	$(document).ready(function() {
		$('#nav02').click(function() {
			$('#nav01').removeClass("active");
			$('#nav02').addClass("active");
		})
	});
</script>
</html>