<!-- MENU LATERAL -->
		<div class="menu">
			<div class="menu__img-user">
				 <img src="img/user_login.png" alt="">
			</div>
			<!-- DATOS DEL USUARIO-->
				<% String dni = (String)session.getAttribute("dniUsuario"); %>
				<% String nombre = (String)session.getAttribute("nomUsuario"); %>
				<% String apellido = (String)session.getAttribute("apeUsuario"); %>
				<% String unidaOrg = (String)session.getAttribute("unidadOrganica"); %>
            	<% String cargo = (String) session.getAttribute("cargo");%>
			
			<div class="menu__datos-user">
				<h4><strong class="menu__titulo fs-5">Nombre de usuario</strong> </h4>
				<h5><%= nombre%></h5>
				<h4><strong class="menu__titulo fs-5">Cargo</strong> </h4>
				<h5><%= cargo%></h5>
			</div>
			
			<nav class="menu__contenedor-modulos">
				<a href="dashboard.jsp" class="active" id="nav01"> Principal</a>
				<%
					if(unidaOrg !=null){
						if(unidaOrg.equals("LOGISTICA")){
	               			if(cargo.equals("DIRECTOR EJECUTIVO")){
	               				%>
	                			<a href="ServletRequerimiento?accion=LISTARbyESTADO" id="nav02"><i class="far fa-calendar-check"></i>Bandeja de entrada</a>
	                			<a href="ServletTrabajador?tipo=LISTAR" id="nav03"><i class="far fa-calendar-check"></i>Mantenimiento de Trabajadores</a>
	                			<a href="" id="nav04"><i class="far fa-calendar-check"></i></a>
	                			<%
	               			}
	               			else if(cargo.equals("SUB-ALMACENERO")){
	               				%>
	                    		<a href="#" id="nav05"><i class="far fa-calendar-check"></i> Generar PECOSA</a>
			               		<a href="#" id="nav06"><i class="far fa-calendar-check"></i> Consultar PECOSAs</a>
			               		<a href="ServletBien?tipo=LISTAR" id="nav07"><i class="far fa-calendar-check"></i> Listado de Bienes</a>
			               		<a href="#" id="nav08"><i class="far fa-calendar-check"></i> Generar Reporte</a>
	                    		<%
	               			}
	               			else if(cargo.equals("JEFE DE ALMACEN")){
	               				%>
	                    		<a href="#" id="nav09"><i class="far fa-calendar-check"></i> Bandeja de entrada PECOSAs</a>
	                    		<a href="ConsultarCuadroRqmts.jsp" id="nav10"><i class="far fa-calendar-check"></i>Consultar Cuadro de Requerimientos</a>
	                    		<a href="#" id="nav11"><i class="far fa-calendar-check"></i> Consultar PECOSA</a>
	                    		<a href="ServletProveedor?tipo=LISTAR" id="nav12"><i class="far fa-calendar-check"></i> Listado de Proveedores</a>
	                    		<a href="#" id="nav13"><i class="far fa-calendar-check"></i> Generar Reporte</a>
	                    		<%
	               			}
	               			//MENU PARA LOS DIRECTIVOS
	               		}else{
	               				%>
		               			<a href="ServletRequerimiento?accion=LISTAR" id="nav14"><i class="far fa-calendar-check"></i> Generar Cuadro de Requerimientos</a>
		               			<a href="UnidadOrg-ConsultarCuadroRqmts.jsp" id="nav15"><i class="far fa-calendar-check"></i> Consultar Cuadro de Requerimientos</a>
		               			<a href="#" id="nav16"><i class="far fa-calendar-check"></i> Generar Reporte</a>
	               				<%
	               		}
					}else{
						response.sendRedirect("Login.jsp");
					}
               		%>	
			</nav>
		</div>