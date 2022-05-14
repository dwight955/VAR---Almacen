<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajador</title>
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">
    <style type="text/css">	
		.modal-header{
			color:#fff;
			background: #428bca;
			display: flex;
	  		justify-content: center;
	  		
		}
		.help-block {
		  		color: red;
		}
		.form-group.has-error .form-control-label {
		  color: red;
		}
		.form-group.has-error .form-control {
		  border: 1px solid red;
		  box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
		}
    </style>
</head>
<body>
	<div class="container">
		<h1 class="text-center mt-5">TRABAJADORES</h1>
			
			
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${requestScope.MENSAJE}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
		
		
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  Registrar Trabajador
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">TRABAJADOR</h5>
		      </div>
		      <div class="modal-body">
		        <form id="idRegistrar" method="post" action="ServletTrabajador?tipo=REGISTRAR">
		           <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Codigo</label>
				    <input type="text" class="form-control" name="codigo" id="idCodigo" readonly value="0">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">DNI</label>
				    <input type="text" class="form-control" name="dni" id="idDNI">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Nombre Completo</label>
				    <input type="text" class="form-control"  name="nombrecom" id="idNombreCom">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Cargo</label>
				    <input type="text" class="form-control"  name="cargo" id="idCargo">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Sexo</label>
				   <select class="form-select"  name="sexo" id="idSexo">
				   	  <option value="">Seleccione Sexo</option>
					  <option value="FEMENINO">FEMENINO</option>
					  <option value="MASCULINO">MASCULINO</option>
					</select>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Codigo UO</label>
				   <select class="form-select"  name="coduo" id="idCodUO">
				   	  <option value="">Seleccione Codigo de UO</option>
					  <option value="UO0001">UO0001</option>
					  <option value="UO0002">UO0002</option>
					  <option value="UO0003">UO0003</option>
					  <option value="UO0004">UO0004</option>
					  <option value="UO0005">UO0005</option>
					  <option value="UO0006">UO0006</option>
					  <option value="UO0007">UO0007</option>
					</select>
				  </div>
				   <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" id="btn-cerrar" data-bs-dismiss="modal">Cerrar</button>
			        <button type="submit" class="btn btn-primary">Grabar</button>
			      </div>				  
				  
				</form>
		      </div>		     
		    </div>
		  </div>
		</div>
		
		
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalBuscar">Buscar</button>
				
				  <!-- Modal Buscar -->
		<div class="modal fade" id="modalBuscar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" style="display: none;" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">TRABAJADOR</h5>
		      </div>
		      <div class="modal-body">
		        <form id="idBuscar method="post" action="ServletTrabajador?tipo=BUSCAR">
		           <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Codigo</label>
				    <input type="text" class="form-control" name="codigo" id="idCodigo" >
				  </div>
			      	<div class="modal-footer">
			        <button type="button" class="btn btn-secondary" id="btn-cerrar" data-bs-dismiss="modal">Cerrar</button>
			        <button type="submit" class="btn btn-primary">Buscar</button>
			        
			        </div>
			        </form>
			        
			      </div>	
			      </div>	
			      </div>		
			      </div>	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<!-- modal para eliminar -->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">ELIMINAR</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form method="post" action="ServletTrabajador?tipo=ELIMINAR">
				    <input type="hidden" class="form-control" id="idCodigoEliminar" name="codigoEliminar">
				   <h4>Seguro de eliminar registro?</h4>
				   <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">NO</button>
			        <button type="submit" class="btn btn-primary">SI</button>
			      </div>				  
				  
				</form>
		      </div>		     
		    </div>
		  </div>
		</div>
		
		
		
		<div class="mt-3">
			<table id="example" class="table table-striped" style="width:100%">
		        <thead>
		            <tr>
		                <th>CÓDIGO</th>
		                <th>DNI</th>
		                <th>NOMBRE COMPLETO</th>
		                <th>CARGO</th>
		                <th>SEXO</th>
		                <th>CODIGO UO</th>
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
			                <td>${row.cargo}</td>
			                <td>${row.sexo}</td>
			                <td>${row.codUnidadOrga}</td>
			                <td><button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button></td>
			                <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalEliminar">Eliminar</button></td>
			            </tr>
			        </c:forEach>
		        </tbody>
	    	</table>
		
		
		
		</div>
		






	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
	<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	
	<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
	
	<!-- Bootstrap validator -->
	<script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
	
	<script>
		$(document).ready(function() {
		    $('#example').DataTable();
		} );
		
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
			dni=$(this).parents("tr").find("td")[1].innerHTML;
			nomcom=$(this).parents("tr").find("td")[2].innerHTML;
			cargo=$(this).parents("tr").find("td")[3].innerHTML;
			sexo=$(this).parents("tr").find("td")[4].innerHTML;
			coduo=$(this).parents("tr").find("td")[5].innerHTML;
			//mostrar en las cajas del modal con id "staticBackdrop" los valores de las variables
			$("#idCodigo").val(cod);
			$("#idDNI").val(dni);
			$("#idNombreCom").val(nomcom);
			$("#idCargo").val(cargo);
			$("#idSexo").val(sexo);
			$("#idCodUO").val(coduo);
			
		})
		//asignar evento click al botón con id "btn-cerrar"
		$(document).on("click","#btn-cerrar",function(){
			//limpiar controles del formularios
			$("#idRegistrar").trigger("reset");
			$("#idRegistrar").data("bootstrapValidator").resetForm(true);
			$("#idCodigo").val("0");
		})
		
		
	</script>
	<script>    
    $(document).ready(function(){     
        $("#idRegistrar").bootstrapValidator({      
        	// fields:{
        	//	 	RUC:{
        	//	 		validators:{
        	//	 			notEmpty:{
        	//	 				message:'Campo RUC es obligatorio'
        	//	 			},
        	//	 			regexp:{
        	//	 				//regexp:/^ $/,
        	//	 				message:'Campo RUC solo...'
        	//	 			}
        	//	 		}
        	//	 	},
        	//	 	RazonSocial:{
        	//	 		validators:{
        	//	 			notEmpty:{
        	//	 				message:'Campo RazonSocial es obligatorio'
        	//	 			},
        	//	 			regexp:{
        	//	 				//regexp:/^ $/,
        	//	 				message:'Campo RazonSocial solo...'
        	//	 			}
        	//	 		}
        	//	 	},
        	//	 	Estado:{
        	//	 		validators:{
        	//	 			notEmpty:{
        	//	 				message:'Campo Estado es obligatorio'
        	//	 			}
        	//	 		}
        	//	 	},
        	//	 	Condicion:{
        	//	 		validators:{
        	//	 			notEmpty:{
        	//	 				message:'Campo Condicion es obligatorio'
        	//	 			}
        	//	 		}
        	//	 	},
        	//	 	Direccion:{
        	//	 		validators:{
        	//	 			notEmpty:{
        	//	 				message:'Campo Direccion es obligatorio'
        	//	 			},
        	//	 			regexp:{
        	//	 				//regexp:/^ $/,
        	//	 				message:'Campo Direccion solo...'
        	//	 			}
        	//	 		}
        	//	 	},
        	//	 	Telefono:{
        	//	 		validators:{
        	//	 			notEmpty:{
        	//	 				message:'Campo Telefono es obligatorio'
        	//	 			},
        	//	 			regexp:{
        	//	 				//regexp:/^ $/,
        	//	 				message:'Campo Telefono solo...'
        	//	 			}
        	//	 		},
            //		 	Distrito:{
            //		 		validators:{
            //		 			notEmpty:{
            //		 				message:'Campo sexo es obligatorio'
            //		 			}
            //		 		}
        	//	 	}
        	//	 	
        		 
        	 }
        });   
			
    });    
</script>
</body>
</html>


