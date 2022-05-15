<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="Estyles/General.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Proveedores</title>
 <!-- Bootstrap CSS -->
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css" rel="stylesheet"> 
    <link href="Estyles/boostrapValidator.css" rel="stylesheet">
    <link href="Estyles/Proveedores.css" rel="stylesheet">
</head>
<style>
</style>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	
	<div class="dashboard_content">
			<%@ include file="Snippets/MenuLateral.jsp" %>
		
			<!-- Button trigger modal -->
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${requestScope.MENSAJE}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
		<section>
		<header class="cabezera d-block">
			<center> <h1>Proveedores</h1></center>
		  	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  	Registrar Proveedor
			</button>
		</header>	
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">PROVEEDOR</h5>
		      </div>
		      <div class="modal-body">
		        <form id="idRegistrar" method="post" action="ServletProveedor?tipo=REGISTRAR">
		        <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Codigo</label>
				    <input type="text" class="form-control" name="codigo" id="idCodigo" readonly value="0">
				  </div>
		           <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Nro RUC</label>
				    <input type="text" class="form-control" name="nroRuc" id="idRUC">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Razon Social</label>
				    <input type="text" class="form-control" name="razonSocial" id="idRazonSocial">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Estado</label>
				   <select class="form-select"  name="estado" id="idEstado">
				   	  <option value="">Seleccione Estado</option>
					  <option value="ACTIVO">ACTIVO</option>
					  <option value="NO ACTIVO">NO ACTIVO</option>
					</select>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Condicion</label>
				   <select class="form-select"  name="condicion" id="idCondicion">
				   	  <option value="">Seleccione Condicion</option>
					  <option value="HABIDO">HABIDO</option>
					  <option value="NO HABIDO">NO HABIDO</option>
					</select>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Direccion</label>
				    <input type="text" class="form-control"  name="direccion" id="idDireccion">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Telefono</label>
				    <input type="text" class="form-control"  name="telefono" id="idTelefono">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Distrito</label>
				   <select class="form-select"  name="distrito" id="idDistrito">
				   	  <option value="">Seleccione Codigo Distrito</option>
					  <option value="DS-01">DS-01</option>
					  <option value="DS-02">DS-02</option>
					  <option value="DS-03">DS-03</option>
					  <option value="DS-04">DS-04</option>
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
		<!-- modal para eliminar -->
		<div class="modal fade" id="modalEliminar" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">ELIMINAR</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form method="post" action="ServletProveedor?tipo=ELIMINAR">
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
		<!-- FILAS Y COLUMNAS -->
		<div class="container-sm">
			<table id="example" class="table table-striped" style="width:100%">
		        <thead>
		            <tr>
		            	<th>CODIGO</th>
		                <th>NRO RUC</th>
		                <th>RAZON SOCIAL</th>
		                <th>ESTADO</th>
		                <th>CONDICION</th>
		                <th>DIRECCION</th>
		                <th>TELEFONO</th>
		                <th>DISTRITO</th>
		                <th></th>
		                <th></th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${requestScope.proveedores}" var="row">
			            <tr>
			            	<td>${row.codProv}</td>
			                <td>${row.nroRuc}</td>
			                <td>${row.rzSoc}</td>
			                <td>${row.estado}</td>
			                <td>${row.condic}</td>
			                <td>${row.direc}</td>
			                <td>${row.telf}</td>
			                <td>${row.codDis}</td>
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
			//variable para almacenar el código del proveedor según el botón eliminar que se pulso
			let cod;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			$("#idCodigoEliminar").val(cod);
		})
		
		//asignar evento click a los botones con clase "btn-success"
		$(document).on("click",".btn-success",function(){
			//variables
			let codigo,ruc,razons,estado,condi,direc,telf,distri;
			//leer las columnas de según el botón editar que se pulso
			codigo=$(this).parents("tr").find("td")[0].innerHTML;
			ruc=$(this).parents("tr").find("td")[1].innerHTML;
			razons=$(this).parents("tr").find("td")[2].innerHTML;
			estado=$(this).parents("tr").find("td")[3].innerHTML;
			condi=$(this).parents("tr").find("td")[4].innerHTML;
			direc=$(this).parents("tr").find("td")[5].innerHTML;
			telf=$(this).parents("tr").find("td")[6].innerHTML;
			distri=$(this).parents("tr").find("td")[7].innerHTML;
			//mostrar en las cajas del modal con id "staticBackdrop" los valores de las variables
			$("#idCodigo").val(codigo)
			$("#idRUC").val(ruc);
			$("#idRazonSocial").val(razons);
			$("#idEstado").val(estado);
			$("#idCondicion").val(condi);
			$("#idDireccion").val(direc);
			$("#idTelefono").val(telf);
			$("#idDistrito").val(distri);
			
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


