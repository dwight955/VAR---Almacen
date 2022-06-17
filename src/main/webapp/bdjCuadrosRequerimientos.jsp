<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bandeja de Entrada - Cuadros de Requerimientos</title>
<%@ include file="Snippets/BooststrapEstyles.jsp"%>
</head>
<body>
<%@ include file="Snippets/Encabezado.jsp"%>
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp"%>
		<section class="generarRequ">
			<h3 class="text-center">Bandeja de Entrada - Cuadros de Requerimientos</h3>
			<div class="mt-4">
				<div class="card">
					<div class="card-header bg-warning"></div>
					<div class="card-body">
						<table id="tableRequerimientos"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th width="10%">NRO</th>
									<th width="10%">DNI</th>
									<th width="30%">REMITENTE</th>
									<th width="15%">ESTADO</th>
									<th>FECHA</th>
									<th width="12%"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.requerimientos}" var="requerimiento">
									<tr>
										<td>${requerimiento.numero}</td>
										<td>${requerimiento.dni}</td>
										<td>${requerimiento.remitente}</td>
										<td>${requerimiento.estado}</td>
										<td>${requerimiento.fecha}</td>
										<td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#idDetalleCuadroReq">Ver Detalle</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		<%@ include file="Snippets/ModalDetalleReq.jsp" %>
	</div>
		<%@ include file="Snippets/BooststrapJS.jsp"%>
</body>
</html>