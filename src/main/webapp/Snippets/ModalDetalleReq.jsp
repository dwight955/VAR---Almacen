<link href="Estyles/ModalDetalleCuadroRqmts.css" rel="stylesheet">
<style>
.tbodyDetalle {
	max-height: clamp(30vh, 10vh, 250px);
	overflow: auto;
}
</style>
		<div class="modal fade" id="idDetalleCuadroReq" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticBackdropLabel"> DETALLE CUADRO DE REQUERIMIENTO </h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="cuadroReq__info">
								<label for="exampleInputEmail1" class="form-label">Estado actual: </label>
								<h5 class = "CuadroReq__estado-detalleReq">APROBADO</h5>
								<div class="form-group input-group-sm">
									<label for="exampleInputEmail1" class="form-label"> Número </label> 
									<input type="text" class="form-control" name="numeroReq" id="idNumeroReq" readonly>
								</div>
								<div class="form-group input-group-sm">
									<label for="exampleInputEmail1" class="form-label">Destinatario</label>
									<input type="text" class="form-control" name="destinatario" id="idDestinatario" readonly>
								</div>
								<div class="form-group input-group-sm">
									<label for="exampleInputEmail1" class="form-label">Responsable</label>
									<input type="text" class="form-control" name="responsable" id="idResponsable" readonly>
								</div>
								<div class="table-DetalleCuadroReq tbodyDetalle">
									<table id="tblDetalleCuadroReq"
										class="table table-bordered text-center table-sm table-hover"
										style="width: 100%">
										<thead class="table-danger sticky-top">
											<tr>
												<th width="10%">CODIGO</th>
												<th>DESCRIPCION</th>
												<th>UNIDAD MED.</th>
												<th>CATEGORIA</th>
												<th>PRECIO</th>
												<th>CANTIDAD</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>25</td>
												<td>Lorem Ipsum</td>
												<td>Lorem Ipsum</td>
												<td>Lorem Ipsum</td>
												<td>25.50</td>
												<td>10</td>
											</tr>
										</tbody>
									</table>
								</div>
								<%
									String cargoAux = (String) session.getAttribute("cargo");
									if(cargoAux.equals("DIRECTOR EJECUTIVO")){
										%>
										<div class="modal-footer">
									        <button type="button" class="btn btn-danger">Rechazar</button>
									        <button type="button" class="btn btn-success">Enviar</button>
				      					</div>
				      					<%
									}
				      					%>
						</div>
					</div>
			    </div>
		</div>