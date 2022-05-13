<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp" %>
		<section>
		<h1>CONSULTAR CUADRO DE REQUERIMIENTOS</h1>
		<h5>Esto es una pagina de prueba</h5>
		</section>
		
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#nav01').removeClass("active");
		$('#nav02').addClass("active");
		
		$('#nav03').removeClass("active");
		$('#nav04').removeClass("active");
	});
</script>
</html>