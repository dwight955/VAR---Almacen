<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generar PECOSA</title>
<%@ include file="Snippets/BooststrapEstyles.jsp"%>
<link href="Estyles/ModalGenerarPECOSA.css" rel=stylesheet>
</head>
<style>
.tbodyDiv {
	max-height: clamp(25vh, 10vh, 250px);
	overflow: auto;
}
</style>
<body>
<%@ include file="Snippets/Encabezado.jsp"%>
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp"%>
		<section class="generarPECOSA">
			<h3 class="text-center">GENERAR PECOSA</h3>
			<div class="mt-4">
				<div class="card">
					<div class="card-header bg-warning">
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#staticBackdrop"
							id="btnGenerar">GENERAR</button>
					</div>
					<div class="card-body">
						<table id="tablePECOSA"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th width="10%">NRO</th>
									<th width="15%">NRO REQUERIMIENTO</th>
									<th width="35%">DESTINATARIO</th>
									<th width="15%">ESTADO</th>
									<th width="15%">FECHA</th>
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
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- MODAL PRINCIPAL - GENERAR PECOSA -->
			<div class="modal" id="staticBackdrop" data-bs-backdrop="static"
				data-bs-keyboard="false" tabindex="-1"
				aria-labelledby="staticBackdropLabel" aria-hidden="false">
				<div class="modal-dialog modal-xl modal-dialog-centered">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title text-white" id="staticBackdropLabel">GENERAR UNA PECOSA</h5>
							<button type="button" class="btn-close" aria-label="Close"
								data-bs-dismiss="modal">×</button>
						</div>
						<div class="modal-body">
							<form id="form-generarPECOSA" method="post" class="grid-formPECOSA">
								<div class="form-group modal-body__block-cabeceraPecosa">
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">Número</label>
										<input type="text" class="form-control" name="numero"
											id="idNumero" readonly>
									</div>
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">Estado</label>
										<input type=text class="form-control" name="estado"
											id="idEstado" readonly value="PENDIENTE">
									</div>
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">Fecha de Emisión</label> 
										<input type=date class="form-control" name="fecha" id="idFecha" readonly>
									</div>
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">Referencia</label> 
										<input type="text" class="form-control" name="referencia" id="idReferencia">
									</div>
								</div>
								
								<div class="form-group modal-body__block-responsable">
									<img class="modal-body__perfil grid-perfil-responsable"
										src="img/perfil.png">
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">DNI</label>
										<input type="text" class="form-control" name="CodUsuario"
											id="idCodUsuario" readonly value="${sessionScope.CODIGO}">
									</div>
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">APELLIDOS Y NOMBRES</label> 
										<input type="text" class="form-control" name="responsable" 
											id="idResponsable" readonly value="${sessionScope.DATOS}">
									</div>
									<div class="form-group input-group-sm">
										<label for="exampleInputEmail1" class="form-label">CARGO</label>
										<input type="text" class="form-control" name="Cargo"
											id="idCargo" readonly value="${sessionScope.CARGO}">
									</div>
								</div>
								<div class="modal-body__block-Requerimiento">
									<button type="button" class="btn btn-danger">BUSCAR</button>
									<div class="form-group input-group-sm">
											<input type="text" class="form-control" name="numeroReq" id="idNumeroReq" readonly>
									</div>
									<div class="form-group input-group-sm">
											<input type="text" class="form-control" name="dniDestinatario" id="idDniDestinatario" readonly>
									</div>
									<div class="form-group input-group-sm">
											<input type="text" class="form-control" name="nombreDestinatario" id="idNombreDestinatario" readonly>
									</div>
									<div class="tblDetalleReq__Pecosa tbodyDiv">
										<table id="tableBienes" class="table table-bordered text-center table-sm" style="width: 100%">
											<thead class="table-light sticky-top">
												<tr>
													<th width="5%">CÓDIGO</th>
													<th>DESCRIPCION</th>
													<th>UNI. MEDI.</th>
													<th width="5%"> CANT.</th>
													<th width="8%"> PRECIO</th>
													<th width="8%"> SUBTOTAL</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>SILLA DE MADERA</td>
													<td>UNIDAD</td>
													<td>12</td>
													<td>15.50</td>
													<td>788.30</td>
												</tr>
												<tr>
													<td>1</td>
													<td>SILLA DE MADERA</td>
													<td>UNIDAD</td>
													<td>12</td>
													<td>15.50</td>
													<td>788.30</td>
												</tr>
												<tr>
													<td>1</td>
													<td>SILLA DE MADERA</td>
													<td>UNIDAD</td>
													<td>12</td>
													<td>15.50</td>
													<td>788.30</td>
												</tr>
												<tr>
													<td>1</td>
													<td>SILLA DE MADERA</td>
													<td>UNIDAD</td>
													<td>12</td>
													<td>15.50</td>
													<td>788.30</td>
												</tr>
												<tr>
													<td>1</td>
													<td>SILLA DE MADERA</td>
													<td>UNIDAD</td>
													<td>12</td>
													<td>15.50</td>
													<td>788.30</td>
												</tr>
											</tbody>
										</table>
									</div>
									<div class="input-group input-group-sm">
										<span class="input-group-text" id="inputGroup-sizing-sm">Total:</span>
										<input type="text" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-sm"
											name="unidadOrgDestinatario" id="idUnidadOrgDestinatario"
											readonly>
									</div>
								</div>
								<div class="modal-footer d-flex justify-content-center">
									<button type="submit" class="btn btn-success">Generar</button>
									<button type="button" class="btn btn-danger" id="btnLimpiar">Limpiar</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<%@ include file="Snippets/BooststrapJS.jsp"%>	
	<script type="text/javascript"> 
	$(document).ready(function(){
		asignarFecha();
	});
	function asignarFecha(){
		let fecha= new Date();
		document.getElementById("idFecha").value = fecha.toJSON().slice(0,10);
	}
	
	
	
	</script>
</body>
</html>