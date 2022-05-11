<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Estyles/Generalcss">
<title>Insert title here</title>
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
			<h1>Te damos la bienvenida <%= nombre%></h1>
		</section>
	</div>
	
</body>
</html>