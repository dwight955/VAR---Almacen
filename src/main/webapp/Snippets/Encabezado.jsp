<link rel="stylesheet" href="Estyles/General.css">
<body>
<header class="encabezado">
	<div class="encabezado_logo">
		<object data="img/logo.svg" width="120" height="230"> </object>
	</div>
	
	<h3 class="lema fs-5 fw-bolder mt-2" id="lema">ALMACENES PARA TODO EL PERÚ</h3>
	<div class="d-flex">
		<div class="hora">
			<div class="hora__text" id="reloj"></div> 		
		</div>
	<a href="ServletUsuario?tipo=CERRAR" class="btn btn-default cerrarSesion">Cerrar Sesión</a>
	</div>
	</header>
				
<script type="text/javascript">
	function startTime(){
	today=new Date();
	h=today.getHours();
	m=today.getMinutes();
	s=today.getSeconds();
	m=checkTime(m);
	s=checkTime(s);
	document.getElementById('reloj').innerHTML=h+":"+m+":"+s;
	t=setTimeout('startTime()',500);}
	function checkTime(i)
	{if (i<10) {i="0" + i;}return i;}
	window.onload=function(){startTime();}
</script>
</body>	