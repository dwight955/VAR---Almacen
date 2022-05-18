<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienes</title>
	<%@ include file="Snippets/BooststrapEstyles.jsp" %>
</head>
<body>
	<div class="container">
		<h1 class="text-center mt-5">BIENES</h1>
			<c:if test="${requestScope.MENSAJE!=null}">
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
				  <strong>MENSAJE : </strong> ${requestScope.MENSAJE}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
		  Registrar un BIEN
		</button>
		
		<!-- Modal -->
		<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="staticBackdropLabel">BIEN</h5>
		      </div>
		      <div class="modal-body">
		        <form id="idRegistrar" method="post" action="ServletTrabajador?tipo=REGISTRAR">
		           <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Codigo</label>
				    <input type="text" class="form-control" name="codigo" id="idCodigo" readonly value="0">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1" class="form-label">Descripcion</label>
				    <input type="text" class="form-control" name="descripcion" id="idDescripcion">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Unidad Medida</label>
				    <input type="text" class="form-control"  name="unidadmedida" id="idUnidadmedida">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Precio Unit.</label>
				   	<input type="text" class="form-control"  name="precio" id="idPrecio">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Categoria</label>
				   <select class="form-select"  name="categoria" id="idCategoria">
				   	  <option value="">Seleccione Categoria</option>
					</select>
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1" class="form-label">Stock Disponible</label>
				   <input type="text" class="form-control"  name="stock" id="idStock">
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
		                <th>DESCRIPCION</th>
		                <th>UNIDAD MEDIDA</th>
		                <th>PRECIO</th>
		                <th>CATEGORIA</th>
		                <th>STOCK</th>
		                <th>FECHA INGRESO</th>
		                <th></th>
		                <th></th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${requestScope.bienes}" var="row">
			            <tr>
			                <td>${row.codBien}</td>
			                <td>${row.descBien}</td>
			                <td>${row.uniMed}</td>
			                <td>${row.precUni}</td>
			                <td>${row.categoria}</td>
			                <td>${row.stockDisponible}</td>
			                <td>${row.fecIngreso}</td>
			                <td><button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Editar</button></td>
			                <td><button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#modalEliminar">Eliminar</button></td>
			            </tr>
			        </c:forEach>
		        </tbody>
	    	</table>		
		</div>
	</div>
	<%@ include file="Snippets/BooststrapJS.jsp" %>
	<script>
		$(document).ready(function() {
		    $('#example').DataTable();
		} );
	</script>
</body>
</html>