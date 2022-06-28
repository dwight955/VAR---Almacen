<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
									<th width="10%">NRO</th>
									<th >NRO REQUERIMIENTO</th>
									<th>DESTINATARIO</th>
									<th>RESPONSABLE</th>
									<th>ESTADO</th>
									<th>FECHA</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.PECOSA}" var="pecosa">
									<tr>
										<td>${pecosa.nroPec}</td>
										<td>${pecosa.nroReq}</td>
										<td>${pecosa.destinatario}</td>
										<td>${pecosa.responsable}</td>
										<td>${pecosa.estado}</td>
										<td>${pecosa.fecha}</td>
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
		<%@ include file="Snippets/ModalDetalleReq-PECOSA.jsp" %>
	</div>
		<%@ include file="Snippets/BooststrapJS.jsp"%>
	
	<script type="text/javascript">
		$(document).on("click","#idVerDetalle",function(){
			let numpec, numreq, responsable, destinatario;
			numpec = $(this).parents("tr").find("td")[0].innerHTML;
			numreq = $(this).parents("tr").find("td")[1].innerHTML
			responsable = $(this).parents("tr").find("td")[3].innerHTML;
			destinatario = $(this).parents("tr").find("td")[2].innerHTML;
			estado = $(this).parents("tr").find("td")[4].innerHTML;
			$.get("ServletPecosaJSON?accion=BUSCARbyNum&numpec="+numpec,function(response){
				$("#idNumeroPec").val(response.numPec);
				$("#idNumeroReq").val(response.numReq);
				$("#idDestinatario").val(destinatario);
				$("#idResponsable").val(responsable);
				$("#idReferencia").val(response.referencia);
				$("#idImporteTotal").val(response.total);
			})
			$("#tblDetalleCuadroReq tbody").empty();
			$.get("ServletRequerimientoJSON?accion=BUSCARbyNUMDetalle&numreq="+numreq,function(response){
				$.each(response, function(index, item){
					$("#tblDetalleCuadroReq tbody").append("<tr><td>"+ item.codBien+ "</td><td>"+ item.descripcion+ "</td><td>"
							   + item.uniMed+ "</td><td>"+item.cant+"</td><td>"
							   + item.preUni+"</td></tr>");
				})
				$("#idEstadoByNumero").text(estado)
			})
			isStatePendiente(estado);
		});
		function isStatePendiente(estado){
			if(estado != "PENDIENTE"){
				$("#idBtnRechazado").addClass("disabled");
				$("#idBtnAprobado").addClass("disabled");
			}else{
				$("#idBtnRechazado").removeClass("disabled");
				$("#idBtnAprobado").removeClass("disabled");
			}
		}
	</script>
</body>
</html>