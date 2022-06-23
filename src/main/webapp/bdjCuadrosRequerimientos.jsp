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
									<th>REMITENTE</th>
									<th>DESTINATARIO</th>
									<th>ESTADO</th>
									<th>FECHA</th>
									<th width="12%"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.requerimientos}" var="requerimiento">
									<tr>
										<td>${requerimiento.numreq}</td>
										<td>${requerimiento.dniSoli}</td>
										<td>${requerimiento.apenomSoli}</td>
										<td>${requerimiento.apenomEntre}</td>
										<td>${requerimiento.estado}</td>
										<td>${requerimiento.fechaEmi}</td>
										<td><button type="button" class="btn btn-danger" data-bs-toggle="modal" id="idVerDetalle"
										data-bs-target="#idDetalleCuadroReq">Ver Detalle</button></td>
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
	
	
	<script type="text/javascript">
	//asignar evento click a los botones con clase "btn btn-danger"
	$(document).on("click","#idVerDetalle",function(){
		//variables
		let num,nomDest,responsable,estado;
		//leer las columnas de la fila según el botón Ver Detalle que se pulso
		num=$(this).parents("tr").find("td")[0].innerHTML;
		nomDest = $(this).parents("tr").find("td")[2].innerHTML;
		responsable = $(this).parents("tr").find("td")[3].innerHTML;
		//estado = $(this).parents("tr").find("td")[4].innerHTML;
		//Colocamos los valores a los inputs
		$("#idNumeroReq").val(num);
		$("#idDestinatario").val(nomDest);
		$("#idResponsable").val(responsable);
		
	})
	
	
	</script>	
	
		
		
</body>
</html>