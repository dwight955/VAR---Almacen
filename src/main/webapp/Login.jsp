<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Login - VAR</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="Estyles/Login.css">
  <link href="Estyles/boostrapValidator.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">
<!-- ESTILOS DEL MODAL DEL LOGIN -->
<style type="text/css">
		.modal-dialog{
			max-width: 630px;
		}
		.modal-login__img{
			width:280px;
		}
		.modal-login__user-img{
			width:100px;
			margin:.5em;
		}
		.form-signin .form-signin-heading, .form-signin .checkbox {
		  margin-bottom: 10px;
		}
		.form-signin input[type="text"], .form-signin input[type="password"] {
		  margin-bottom: 15px;
		}
		.form-signin .form-control {
		  padding: 10px;
		}
	.modal-login {
		color: #636363;
		display:flex;
		box-shadow: 0px 0px 7px 3px rgba(0, 0, 0, 0.2);
	}
	.modal-login .modal-content {
		padding: 0px;
		border-radius: 10px;
		border: none;
	}
	.modal-login h4 {
		text-align: center;
		font-size: 26px;
	}
	.modal-login  .form-group {
		position: relative;
	}
	.modal-login i {
		position: absolute;
		left: 13px;
		top: 43px;
		font-size: 18px;
	}
	.modal-login .form-control {
		padding-left: 40px;
	}
	.modal-cabezera{
		display:flex;
		flex-direction:column;
		align-items: center;
	}
	.modal-cabezera > h2{
		font-size:16pt;
	}
	.btn-sesion{
		color: white;
		background: #D40912;
		border: 1px solid black;
		padding: .3em;
		width:180px;
		font-family: 'Arial';
		font-weight: bold;
		margin-top: 1rem;
	}
	.form-group > p{
		font-weight: bold;
		color: #7D7D7F;
		margin-bottom: .5rem;
	}
	.form-control{
		margin-bottom: .5rem;
	}
</style>
</head>
<body>
<header class="encabezado">
	<div class="encabezado_logo">
		<object data="img/logo.svg" width="150" height="230"> </object>
	</div>
</header>
				<c:if test="${requestScope.MENSAJE!=null}">
					<div class="alert alert-warning alert-dismissible fade show" role="alert">
					  <strong>MENSAJE : </strong> ${requestScope.MENSAJE}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
					</div>
				</c:if>
				
<div class="wrapper">
<div id="myModal">
	<div class="modal-dialog modal-login">
	<img class="modal-login__img" alt="" src="img/img_login.jpg">
		<div class="modal-content">
			<div class="modal-body">
			<header class="modal-cabezera">
				<h2>Iniciar Sesion</h2>
				<img class="modal-login__user-img" alt="" src="img/user_login.png">
			</header>
				<form id="idLogin" action="ServletUsuario?tipo=INICIAR" method="post">
					<div class="form-group">
						<p>Usuario</p>
						<i class="fa fa-user"></i>
						<input type="text" class="form-control" placeholder="Username"  name="username">
					</div>
					<div class="form-group">
						<p>Contraseña</p>
						<i class="fa fa-lock"></i>
						<input type="password" class="form-control" placeholder="Password" name="clave">					
					</div>
					<div class="pie">
						<!--<input type="submit" class="btn btn-primary btn-block btn-lg" value="Login">-->
						<center><input type="submit" class="btn-sesion" aria-pressed="true" value="Entrar"></center>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>     

</div>
</body>

  <!-- LIBRERIAS -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>
  <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<script>
$(document).ready(function(){     
    $("#idLogin").bootstrapValidator({      
    	 fields:{
    		 	username:{
    		 		validators:{
    		 			notEmpty:{
    		 				message:'Campo username es obligatorio'
    		 			}
    		 		}
    		 	},
    		 	clave:{
    		 		validators:{
    		 			notEmpty:{
    		 				message:'Campo clave es obligatorio'	
    		 			}
    		 		}
    		 		
    		 	}
    		 }
    });
});
</script>


</html>
