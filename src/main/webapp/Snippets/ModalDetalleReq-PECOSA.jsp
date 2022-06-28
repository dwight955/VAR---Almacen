<link href="Estyles/ModalDetalleCuadroRqmts-Pecosa.css" rel="stylesheet">
<style>
.tbodyDetalle {
	max-height: clamp(30vh, 10vh, 250px);
	overflow: auto;
}
</style><!-- Este Modal es un hibrido que se adapta segun el cargo del usuario -->
		<div class="modal fade" id="idDetalleCuadroReq" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticBackdropLabel"> DETALLE DE LA PECOSA </h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<form class="cuadroReq__info" id="formDetallePecosa" method="post" action="ServletPecosa?accion=ACTUALIZAR_ESTADO&page=bdjPecosa" data-toggle="validator"
							role="form">
								<label for="exampleInputEmail1"  class="form-label">Estado actual: </label>
								<h5 class = "CuadroReq__estado-detalleReq" id="idEstadoByNumero"></h5>
								<div class="form-group input-group-sm">
									<label for="exampleInputEmail1" class="form-label"> Número </label> 
									<input type="text" class="form-control" name="numeroPec" id="idNumeroPec" readonly>
								</div>
								<div class="form-group input-group-sm">
									<label for="exampleInputEmail1" class="form-label"> Requerimiento </label> 
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
								<div class="form-group input-group-sm">
									<label for="exampleInputEmail1" class="form-label">Referencia</label>
									<input type="text" class="form-control" name="referencia" id="idReferencia" readonly>
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
												<th>CANTIDAD</th>
												<th>PRECIO</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
										<div class="modal-footer justify-content-between">
									         	<div class="form-group input-group-sm d-flex">
													<span class="input-group-text" id="inputGroup-sizing-sm">Importe Total:</span>
													<input type="text" id="idImporteTotal" class="form-control"readonly>
												</div>
											<div>
											<button type="submit" id="idBtnRechazado" name="btnEstado" value="RECHAZADO" class="btn btn-danger">Rechazar</button>
									        <button type="submit" id="idBtnAprobado" name="btnEstado" value="APROBADO" class="btn btn-success">Aprobar</button>
									        </div>
				      					</div>
						</form>
					</div>
			    </div>
		</div>