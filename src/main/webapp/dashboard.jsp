<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Estyles/General.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
			<h3>Te damos la bienvenida <%= nombre%> <%= apellido%></h3>
			<h4>De: <%= unidaOrg%> </h4>
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