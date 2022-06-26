<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bandeja de Entrada - PECOSA</title>
<%@ include file="Snippets/BooststrapEstyles.jsp"%>
</head>
<body>
<%@ include file="Snippets/Encabezado.jsp"%>
<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp"%>
		<section class="generarRequ">
			<h3 class="text-center">Bandeja de Entrada - PECOSAs</h3>
			<div class="mt-4">
				<div class="card">
					<div class="card-header bg-warning"></div>
					<div class="card-body">
						<table id="tablePecosa"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th width="10%">NUMERO</th>
									<th width="10%">REQUERIMIENTO</th>
									<th>DESTINATARIO</th>
									<th>UNIDAD ORGANICA</th>
									<th>ESTADO</th>
									<th>FECHA</th>
									<th>IMPORTE TOTAL</th>
									<th width="12%"></th>
								</tr>
							</thead>
								<tbody>
									<tr>
										<td>lorem ipsum</td>
										<td>lorem ipsum</td>
										<td>lorem ipsum</td>
										<td>lorem ipsum</td>
										<td>lorem ipsum</td>
										<td>lorem ipsum</td>
										<td>lorem ipsum</td>
										<td><button type="button" class="btn btn-danger" data-bs-toggle="modal" id="idVerDetalle"
										data-bs-target="#idDetalleCuadroReq">Ver Detalle</button></td>
									</tr>
								<!-- <c:forEach items="${requestScope.requerimientos}" var="requerimiento">
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
								</c:forEach>  -->
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
	
	</script>
</body>
</html>