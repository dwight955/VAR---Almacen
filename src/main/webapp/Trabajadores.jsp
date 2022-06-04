<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajador</title>
<link href="Estyles/General.css" rel="stylesheet">
<%@ include file="Snippets/BooststrapEstyles.jsp"%>
</head>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	
	<div class="dashboard_content">
			<%@ include file="Snippets/MenuLateral.jsp" %>
		<section>
				<center><h1>Trabajadores</h1></center>
		<header class="cabezera d-block">
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show"
					role="alert">
					<strong>MENSAJE : </strong> ${requestScope.MENSAJE}
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
			</c:if>
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
			Registrar Trabajador
			</button>
		</header>
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">TRABAJADOR</h5>
					</div>
					<div class="modal-body">
						<form id="idRegistrar" method="post"
							action="ServletTrabajador?tipo=REGISTRAR" data-toggle="validator"
							role="form">
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Codigo</label>
								<input type="text" class="form-control" name="codigo"
									id="idCodigo" readonly value="0">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">DNI</label> <input
									type="text" class="form-control" name="dni" id="idDNI">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Nombre
									Completo</label> <input type="text" class="form-control"
									name="nombrecom" id="idNombreCom">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Cargo</label>
								<select class="form-select" name="cargo" id="idCargo">
									<option value="">Seleccione un Cargo</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Sexo</label>
								<select class="form-select" name="sexo" id="idSexo">
									<option value="">Seleccione Sexo</option>
									<option value="FEMENINO">FEMENINO</option>
									<option value="MASCULINO">MASCULINO</option>
								</select>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Unidad
									Organica</label> <select class="form-select" name="coduo"
									id="idUnidadOrganica">
									<option value="">Seleccione la UO</option>
								</select>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" id="btn-cerrar"
									data-bs-dismiss="modal">Cerrar</button>
								<button type="submit" class="btn btn-success">Grabar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- modal para eliminar -->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static"
			data-bs-keyboard="false" tabindex="-1"
			aria-labelledby="staticBackdropLabel" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="staticBackdropLabel">ELIMINAR</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form method="post" action="ServletTrabajador?tipo=ELIMINAR">
							<input type="hidden" class="form-control" id="idCodigoEliminar"
								name="codigoEliminar">
							<h4>Seguro de eliminar registro?</h4>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">NO</button>
								<button type="submit" class="btn btn-primary">SI</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="mt-3">
			<table id="example" class="table table-striped" style="width: 100%">
				<thead>
					<tr>
						<th>CÓDIGO</th>
						<th>DNI</th>
						<th>NOMBRE COMPLETO</th>
						<th>SEXO</th>
						<th>UNIDAD ORGANICA</th>
						<th>CARGO</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.trabajadores}" var="row">
						<tr>
							<td>${row.codTrab}</td>
							<td>${row.dni}</td>
							<td>${row.nomApe}</td>
							<td>${row.sexo}</td>
							<td>${row.codUnidadOrga}</td>
							<td>${row.cargo}</td>
							<td><button type="button" class="btn btn-success"
									data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button></td>
							<td><button type="button" class="btn btn-danger"
									data-bs-toggle="modal" data-bs-target="#modalEliminar">Eliminar</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</section>
	</div>
	<%@ include file="Snippets/BooststrapJS.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#example').DataTable();
		    leerCondicionJSON();
		    $('#idRegistrar').bootstrapValidator({      
	        	 fields:{
	        		 dni:{
	        			 	validators:{
	        			 		notEmpty:{
	        			 			message:'Campo DNI es obligatorio'	
	        			 		},
	         			 		regexp:{
	        			 			regexp:/^[0-9]{8}$/,
	        			 			message:'Campo de 8 digitos numericos'
	        			 		}
	        			 	}
	        		 },    
	     		 	nombrecom:{
	     			 	validators:{
	     			 		notEmpty:{
	     			 			message:'Campo Nombre es obligatorio'	
	     			 		},
	     			 		regexp:{
	    			 			regexp:/^[a-zA-ZÀ-ÿ\u00f1\u00d1 ]{3,30}$/,
	    			 			message:'Campo Nombre hasta 30 digitos alfabeticos'
	    			 		}
	     			 	}
	     		 	 }
	        	 }
	        });   
		});
		
		//asignar evento click a los botones con clase "btn-danger"
		$(document).on("click",".btn-danger",function(){
			//variable para almacenar el código del docente según el botón eliminar que se pulso
			let cod;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			$("#idCodigoEliminar").val(cod);
		})
		
		//asignar evento click a los botones con clase "btn-success"
		$(document).on("click",".btn-success",function(){
			//variables
			let cod,dni,nomcom,cargo,sexo,coduo;
			//leer las columnas de según el botón editar que se pulso
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			console.log(cod);
			//mostrar en las cajas del modal con id "staticBackdrop" los valores de las variables
			$.get("ServletTrabajadorJSON?codigo=" + cod,function(response){
				//Las variables dentro de val() son de la clase trabajador
				$("#idCodigo").val(cod);
				$("#idDNI").val(response.dni);
				$("#idNombreCom").val(response.nomApe);
				$("#idSexo").val(response.sexo);
				$("#idUnidadOrganica").val(response.codUnidadOrga);
				$("#idCargo").val(response.cargo);
			})
		})
		//asignar evento click al botón con id "btn-cerrar"
		$(document).on("click","#btn-cerrar",function(){
			//limpiar controles del formularios
			$("#idRegistrar").trigger("reset");
			$("#idRegistrar").data("bootstrapValidator").resetForm(true);
			$("#idCodigo").val("0");
		})
		
		//Rellenar ComboBox del modal registrar
		function leerCondicionJSON(){
			$.get("ServletCondicionJSON?comboBox=CARGO",function(response){
				console.log(response);
				$.each(response,function(index,item){ 
					$("#idCargo").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
				})
			})
			$.get("ServletCondicionJSON?comboBox=UO",function(response){
				console.log(response);
				$.each(response,function(index,item){ 
					$("#idUnidadOrganica").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
				})
			})
		}
	</script>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#nav01").removeClass("active");
		$("#nav02").removeClass("active");
		$("#nav03").addClass("active");
	})
	</script>
</body>
</html>


