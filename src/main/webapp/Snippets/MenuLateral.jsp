<!-- MENU LATERAL -->
		<div class="menu">
			<div class="menu__img-user">
				 <img src="img/user_login.png" alt="">
			</div>
			<!-- DATOS DEL USUARIO - EJEMPLO-->
			
				<% String dni = (String)session.getAttribute("dniUsuario"); %>
				<% String nombre = (String)session.getAttribute("nomUsuario"); %>
				<% String apellido = (String)session.getAttribute("apeUsuario"); %>
				<% String unidaOrg = (String)session.getAttribute("unidadOrganica"); %>
            	<% String cargo = (String) session.getAttribute("cargo");%>
			
			<div class="menu__datos-user">
				<h4><strong class="menu__titulo">NOMBRE DEL USUARIO</strong> </h4>
				<p><%= nombre%></p>
				<h4><strong class="menu__titulo">CARGO</strong> </h4>
				<p><%= cargo%></p>
			</div>
			
			<nav class="menu__contenedor-modulos">
				<a href="#" class="active" id="01"> Principal</a>
				<%
               		if(unidaOrg.equals("LOGISTICA")){
               			if(cargo.equals("DIRECTOR EJECUTIVO")){
               				%>
                			<a href="#" id="nav02"><i class="far fa-calendar-check"></i> Modulo01</a>
                			<a href="#" id="nav03"><i class="far fa-calendar-check"></i>Modulo02</a>
                			<a href="#" id="nav06"><i class="far fa-calendar-check"></i>Modulo03</a>
                			<%
               			}
               			else if(cargo.equals("SUB-ALMACENERO")){
               				%>
                    		<a href="#" id="nav04"><i class="far fa-calendar-check"></i>Modulo04</a>
               		<a href="#" id="nav07"><i class="far fa-calendar-check"></i> Modulo05</a>
               		<a href="#" id="nav05"><i class="far fa-calendar-check"></i> Asistencia Laboral</a>         
                 	<a href="#" id="nav08"><i class="far fa-calendar-check"></i> Generar Boletas</a>
                 	<a href="#" id="nav09"><i class="far fa-calendar-check"></i> Listado de Boletas</a>
                    		
                    	<%
               			}
               			else if(cargo.equals("JEFE DE ALMACEN")){
               				%>
                    		<a href="#" id="nav02"><i class="far fa-calendar-check"></i> Gestionar Actividades</a>
                    <a href="#" id="nav03"><i class="far fa-calendar-check"></i>Actividades Pendientes</a>
                    <a href="#" id="nav06"><i class="far fa-calendar-check"></i> Reportes Actividades</a>
                    	<a href="#" id="nav04"><i class="far fa-calendar-check"></i> Mantener Trabajadores</a>
               		<a href="#" id="nav07"><i class="far fa-calendar-check"></i> Gestionar Cargos</a>
               		<a href="#" id="nav05"><i class="far fa-calendar-check"></i> Asistencia Laboral</a>         
                 	<a href="#" id="nav08"><i class="far fa-calendar-check"></i> Generar Boletas</a>
                 	<a href="#" id="nav09"><i class="far fa-calendar-check"></i> Listado de Boletas</a>
                    	<%
               			}
               		}
               	%>
			</nav>
		</div>