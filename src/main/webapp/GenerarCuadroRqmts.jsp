<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cuadro de Requerimiento</title>
<%@ include file="Snippets/BooststrapEstyles.jsp"%>
<link href="Estyles/ModalGenerarCuadroRqmts.css" rel="stylesheet">
</head>
<style>
	.tbodyDiv{
		max-height: clamp(30vh,10vh,250px);
		overflow: auto;
    }
    .tbodyDetalle{
    	max-height: clamp(60vh,10vh,250px);
		overflow: auto;
    }
</style>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp" %>
		<section class="generarRequ">
			<h3 class="text-center">Cuadros de Requerimientos</h3>
			<div class="mt-4">
				<div class="card">
				  <div class="card-header bg-warning">
				    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop" id="btnGenerar">GENERAR</button>
				  </div>
				  <div class="card-body">
				    	<table id="tableRequerimientos" class="table table-striped table-bordered">
						     <thead>
						        <tr>
								<th width="5%">NRO</th>
								<th width="10%">DNI</th>
								<th width="50%">REMITENTE</th>
								<th width="15%">ESTADO</th>
								<th width="15%">FECHA</th>
								</tr>
							</thead>
							<tbody>
								<tr>
				                <td>000014</td>
				                <td>Lorem Ipsum</td>
				                <td>Lorem Ipsum</td>
				                <td>Lorem Ipsum</td>
				                <td>10/12/2022</td>
				                </tr>
							</tbody>
						</table>
				  </div>
				</div>
			</div>
			<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-xl modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-white" id="staticBackdropLabel">Nuevo Cuadro de Requerimiento</h5>
						<button type="button" class="btn-close" aria-label="Close" data-bs-dismiss="modal">×</button>
					</div>
					<div class="modal-body">
						<div class="form-group input-group-sm">
								<label for="exampleInputEmail1" class="form-label">Número</label>
								<input type="text" class="form-control" name="numero"
									id="idNumero" readonly>
						</div>
						<div class="form-group input-group-sm">
								<label for="exampleInputEmail1" class="form-label">Fecha de Emisión</label>
								<input type="date" class="form-control" name="fecha"
									id="idFecha" readonly>
						</div>
						<div class="modal-body__block-responsable">
							<img class="modal-body__perfil grid-perfil-responsable" src="img/perfil.png">
							<div class="form-group input-group-sm">
								<label for="exampleInputEmail1" class="form-label">DNI</label>
								<input type="text" class="form-control" name="dni"
									id="idDni" readonly>
							</div>
							<div class="form-group grid-responsable input-group-sm">
								<label for="exampleInputEmail1" class="form-label"> Nombres </label>
								<input type="text" class="form-control" name="responsable"
									id="idResponsable" readonly>
							</div>
							<div class="input-group input-group-sm mb-3  grid-unidadOrganica">
								<span class="input-group-text" id="inputGroup-sizing-sm">De:</span>
								<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="responsable"
									id="idResponsable" readonly>
							</div>
						</div>
						<div class="modal-body__block-destinatario">
							<div class="input-group input-group-sm mb-3  grid-destinario">
								<span class="input-group-text" id="inputGroup-sizing-sm">Destinatario:</span>
								<button type="button" class="btn btn-primary" data-bs-toggle="" data-bs-target="#staticBackdrop" id="">+</button>
								<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="destinatario"
									id="idDestinatario" readonly>
							</div>
							<div class="input-group input-group-sm mb-3  grid-destinario">
								<span class="input-group-text" id="inputGroup-sizing-sm">Nombre:</span>
								<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name=""
									id="" readonly>
							</div>
							<div class="input-group input-group-sm mb-3  grid-destinario">
								<span class="input-group-text" id="inputGroup-sizing-sm">De:</span>
								<input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name=""
									id="" readonly>
							</div>
							<img class="modal-body__perfil grid-perfil-destinatario" src="img/trabajador.png">
						</div>
						<div class="modal-body__block-table-bienes tbodyDiv">
							<table id="example" class="table table-bordered text-center table-sm table-hover" style="width: 100%">
								<thead class="table-light sticky-top">
									<tr>
										<th width="5%">CÓDIGO</th>
										<th>DESCRIPCION</th>
										<th width="5%"></th>
									</tr>
								</thead>
								<tbody>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td><button type="button" class="btn btn-success"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">+</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td><button type="button" class="btn btn-success"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">+</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td><button type="button" class="btn btn-success"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">+</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td><button type="button" class="btn btn-success"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">+</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td><button type="button" class="btn btn-success"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">+</button></td>
										</tr>
								</tbody>
							</table>
		                </div>
		                <div class="form-group input-group-sm mt-5">
								<label for="exampleInputEmail1" class="form-label">Cantidad a solicitar</label>
								<input type="text" class="form-control" name="cantidad"
									id="idCantidad">
						</div>
						<div class="modal-body__block-table-detalle tbodyDetalle">
							<table id="example" class="table table-bordered text-center table-sm" style="width: 100%">
								<thead class="table-danger sticky-top">
									<tr>
										<th width="5%">CÓDIGO</th>
										<th>DESCRIPCION</th>
										<th>UNIDAD DE MEDIDA</th>
										<th>CANTIDAD</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td>UNIDAD</td>
											<td>15</td>
											<td><button type="button" class="btn btn-primary"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">X</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td>UNIDAD</td>
											<td>15</td>
											<td><button type="button" class="btn btn-primary"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">X</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td>UNIDAD</td>
											<td>15</td>
											<td><button type="button" class="btn btn-primary"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">X</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td>UNIDAD</td>
											<td>15</td>
											<td><button type="button" class="btn btn-primary"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">X</button></td>
										</tr>
										<tr>
											<td>1</td>
											<td>Pantalones Jeans</td>
											<td>UNIDAD</td>
											<td>15</td>
											<td><button type="button" class="btn btn-primary"
													data-bs-toggle="modal" data-bs-target="#staticBackdrop">X</button></td>
										</tr>
								</tbody>
							</table>
		                </div>
						<div class="modal-footer d-flex justify-content-center">
								<button type="button" class="btn btn-success">Generar</button>
								<button type="submit" class="btn btn-danger">Limpiar</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
	</div>
<%@ include file="Snippets/BooststrapJS.jsp" %>
<!-- JS de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

</body>
</html>