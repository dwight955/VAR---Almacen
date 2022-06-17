<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultar Cuadro de Requerimientos</title>
<%@ include file="Snippets/BooststrapEstyles.jsp"%>
<link href="Estyles/ConsultarCuadroNec.css" rel="stylesheet">
</head>
<style>
	.tbodyDiv{
max-height: clamp(35vh,10vh,250px);
overflow: auto;
}
</style>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	<div class="dashboard_content">
		<%@ include file="Snippets/MenuLateral.jsp" %>
		<section class="consultaRequ" id="staticBackdrop" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1" >
			<center><h3>CONSULTAR CUADRO DE REQUERIMIENTOS</h3></center>
			<div class="consultaRequ__block_query">
				<form id="idConsultar" method="post" action="" class="consultaRequ__criterios" role="form">
					<div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Destinatario</label>
					    <input type="text" class="form-control" name="destinatario" id="idDestinatario">
					</div>
					<div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Responsable</label>
					    <input type="text" class="form-control" name="responsable" id="idResponsable">
					</div>
					<div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Fecha</label>
					    <input type="date" class="form-control" name="fecha" id="idDescripcion">
					</div>
					<div class="form-group">
					    <label for="exampleInputPassword1" class="form-label">Estado</label>
					   <select class="form-select"  name="estado" id="idEstado">
					   	  <option value="">Seleccione un Estado</option>
					   	  <option value="UNIDAD">APROBADO</option>
					   	  <option value="KILO">RECHAZADO</option>
					   	  <option value="KILO">FORMULADO</option>				   	
						</select>
					 </div>
					 <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Cantidad</label>
					    <input type="text" class="form-control" name="cantidad" id="idCantidad">
					 </div>
					 <div class="form-group">
					    <label for="exampleInputPassword1" class="form-label">Unidad Organica</label>
					   <select class="form-select"  name="unidadorganica" id="idUnidadorganica">
					   	  <option value="">Seleccione Unidad Organica</option>				   	
						</select>
					 </div>
					 <div class="form-group">
					    <label for="exampleInputEmail1" class="form-label">Codigo de Bien</label>
					    <input type="text" class="form-control" name="codigobien" id="idCodigobien">
					 </div>
					 <button type="submit" class="btn btn-danger btn__fontSize">Consultar</button>
				 </form>
			</div>
			<div class="consultaRequ__block_table">
				<div class="mt-3 tbodyDiv">
				<table id="example" class="table table-bordered table-striped text-center" style="width:100%">
			        <thead class="table-danger sticky-top bg-white">
			            <tr>
			                <th>NRO</th>
			                <th>RESPONSABLE</th>
			                <th>DESTINATARIO</th>
			                <th>UNIDAD ORGANICA</th>
			                <th>CANTIDAD</th>
			                <th>FECHA</th>
			                <th></th>
			            </tr>
			        </thead>
			        <tbody>
				            <tr>
				                <td>000014</td>
				                <td>Lorem Ipsum</td>
				                <td>Lorem Ipsum</td>
				                <td>Lorem Ipsum</td>
				                <td>10</td>
				                <td>30/05/2022</td>
				                <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#idDetalleCuadroReq">Ver Detalle</button></td>
				            </tr>
			        </tbody>
		    	</table>		
			</div>
			<div class="consultaRequ__block_info mt-2"><p>XXX Cuadro de Requerimiento encontradas</p></div>
		</div>
		<%@ include file="Snippets/ModalDetalleReq.jsp" %>	
		</section>
	</div>
<%@ include file="Snippets/BooststrapJS.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		$('#nav01').removeClass("active");
		$('#nav02').removeClass("active");
		$('#nav03').removeClass("active");
		$('#nav04').addClass("active");
		leerCondicionJSON();
		//$('#example').DataTable();
		$('#idConsultar').bootstrapValidator({
			fields:{
				destinatario:{
					validators:{
						regexp:{
    			 			regexp:/^[A-Za-z\ñ\Á\É\Í\Ó\Ú\á\é\í\ó\ú\Ñ\s]{3,30}$/,
    			 			message:'Solo letras | Campo de 30 caracteres'
    			 		}
					}
				},
				responsable:{
					validators:{
						regexp:{
    			 			regexp:/^[A-Za-z\ñ\Á\É\Í\Ó\Ú\á\é\í\ó\ú\Ñ\s]{3,30}$/,
    			 			message:'Solo letras | Campo de 30 caracteres'
    			 		}
					}
				},
				cantidad:{
					validators:{
						between:{
							min:1,
    		 				max:9999,
    		 				message:'Solo números | Maximo 9999'
    			 		}
					}
				},
				codigobien:{
					validators:{
						regexp:{
    			 			regexp:/^[\d]{1,4}$/,
    			 			message:'Solo números | Max:9999'
    			 		}
					}
				}
			}
		})
	});
	
	function leerCondicionJSON(){
		$.get("ServletCondicionJSON?comboBox=UO",function(response){
			console.log(response);
			$.each(response,function(index,item){ 
				$("#idUnidadorganica").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
			})
		})
	}
</script>
</body>
</html>