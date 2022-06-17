<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="Estyles/General.css" rel="stylesheet" >
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<%@ include file="Snippets/BooststrapEstyles.jsp" %>
</head>
<body>
	<%@ include file="Snippets/Encabezado.jsp" %>
	
	<div class="dashboard_content">
			<%@ include file="Snippets/MenuLateral.jsp" %>
		<section>
			<center> <h1>Proveedores</h1></center>
		<header class="cabezera d-block">
			<!-- Button trigger modal -->
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${requestScope.MENSAJE}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
		  	<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
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
		        <form id="idRegistrar" method="post" action="ServletProveedor?tipo=REGISTRAR" data-toggle="validator" role="form">
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
					   	  <option value="">Seleccione un Distrito</option>
						</select>
					  </div>
					  <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" id="btn-cerrar" data-bs-dismiss="modal">Cerrar</button>
				        <button type="submit" class="btn btn-success">Grabar</button>
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
		</section>
	</div>
	<%@ include file="Snippets/BooststrapJS.jsp" %>
	<script>
		$(document).ready(function() {
		    $('#example').DataTable();
		    leercondicion();
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
			$.get("ServletProveedorJSON?codigo="+codigo, function(response){
				$("#idCodigo").val(response.codProv)
				$("#idRUC").val(response.nroRuc);
				$("#idRazonSocial").val(response.rzSoc);
				$("#idEstado").val(response.estado);
				$("#idCondicion").val(response.condic);
				$("#idDireccion").val(response.direc);
				$("#idTelefono").val(response.telf);
				$("#idDistrito").val(response.codDis);
			})
		})
		//asignar evento click al botón con id "btn-cerrar"
		$(document).on("click","#btn-cerrar",function(){
			//limpiar controles del formularios
			$("#idRegistrar").trigger("reset");
			$("#idRegistrar").data("bootstrapValidator").resetForm(true);
			$("#idCodigo").val("0");
		})
		function leercondicion(){
			$.get("ServletCondicionJSON?comboBox=DISTRITOS",function(response){
				$.each(response, function(index, item){
					$("#idDistrito").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
				});
			});
		}
	</script>
	<script>
	$(document).ready(function(){
		$("#idRegistrar").bootstrapValidator({      
		   	 fields:{
		   			nroRuc:{
		   		 		validators:{
		   		 			notEmpty:{
		   		 				message:'Campo RUC es obligatorio'
		   		 			},
		   		 			regexp:{
		   		 				regexp:/^[0-9]{11}$/,
		   		 				message:'Campo RUC solo números | Maximo 11 digitos'
		   		 			}
		   		 		}
		   		 	},
		   		 	razonSocial:{
		   		 		validators:{
		   		 			notEmpty:{
		   		 				message:'Campo Razon Social es obligatorio'
		   		 			},
		   		 			regexp:{
		   		 				regexp:/^[A-Za-z\ñ\Á\É\Í\Ó\Ú\á\é\í\ó\ú\Ñ\s]{5,40}$/,
		   		 				message:'Campo RazonSocial solo letras | Maximo: 40 letras'
		   		 			}
		   		 		}
		   		 	},
		   		 	estado:{
		   		 		validators:{
		   		 			notEmpty:{
		   		 				message:'Campo Estado es obligatorio'
		   		 			}
		   		 		}
		   		 	},
		   		 	condicion:{
		   		 		validators:{
		   		 			notEmpty:{
		   		 				message:'Campo Condicion es obligatorio'
		   		 			}
		   		 		}
		   		 	},
		   		 	direccion:{
		   		 		validators:{
		   		 			notEmpty:{
		   		 				message:'Campo Direccion es obligatorio'
		   		 			},
		   		 			regexp:{
		   		 				regexp:/^[A-Za-z\ñ\Á\É\Í\Ó\Ú\á\é\í\ó\ú\Ñ\s\-\.]{5,50}$/,
		   		 				message:'Campo Direccion solo letras | Maximo: 50 letras'
		   		 			}
		   		 		}
		   		 	},
		   		 	telefono:{
		   		 		validators:{
		   		 			notEmpty:{
		   		 				message:'Campo Telefono es obligatorio'
		   		 			},
		   		 			regexp:{
		   		 				regexp:/^[9][0-9]{8}$/,
		   		 				message:'Campo Telefono solo números | Maximo: 9 digitos'
		   		 			}
		   		 		},
		   		 	distrito:{
		       		 	validators:{
		       		 		notEmpty:{
		       		 			message:'Campo sexo es obligatorio'
		       		 		}
		       		 	}
		   		 	} 		 
		   	 	}
		   	 }
		});
	});
    
</script>
</body>
</html>


