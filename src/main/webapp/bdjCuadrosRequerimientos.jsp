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
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>MENSAJE : </strong> ${requestScope.MENSAJE}
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>
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
	$(document).on("click","#idVerDetalle",function(){
		let num,nomDest,responsable,estado;
		
		num=$(this).parents("tr").find("td")[0].innerHTML;
		nomDest = $(this).parents("tr").find("td")[2].innerHTML;
		responsable = $(this).parents("tr").find("td")[3].innerHTML;
		estado = $(this).parents("tr").find("td")[4].innerHTML;
		
		$("#tblDetalleCuadroReq tbody").empty();//limpiar despues de cada listado
		$("#idNumeroReq").val(num);
		$("#idDestinatario").val(nomDest);
		$("#idResponsable").val(responsable);
		$.get("ServletRequerimientoJSON?accion=BUSCARbyNUMDetalle&numreq="+num,function(response){
			$.each(response, function(index, item){
				$("#tblDetalleCuadroReq tbody").append("<tr><td>"+ item.codBien+ "</td><td>"+ item.descripcion+ "</td><td>"
						   + item.uniMed+ "</td><td>"+item.cant+"</td><td>"
						   + item.preUni+"</td></tr>");
			})
		})
		$("#idEstadoByNumero").text(estado);
	})
	
	</script>	
	
		
		
</body>
</html>