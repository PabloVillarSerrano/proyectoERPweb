<%@page import="java.util.List"%>
<%@page import="edu.fpdual.proyectoERP.conector.Conector"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.fpdual.proyectoERP.dao.Employees"%>
<%@page import= "edu.fpdual.proyectoERP.manager.EmployeesManager" %>

<html>
<head>
	<!-- Fuentes -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Pattaya&display=swap" rel="stylesheet">
	<!-- Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- MDBootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
	<style>
		.botoncta{
		  background-image: linear-gradient(#f6b83f,#f6b83f);
		  font-family: 'roboto', sans-serif;
		  line-height: 1;
		  letter-spacing: 0.05em;
		  color: #fff8e1 ;
		  font-weight: bold;
		  font-size: 16px;
		  border-radius: 25px;
		}
		.botoncta:hover{
		  background-image: linear-gradient(#e28b3a,#e28b3a);
		  font-family: 'roboto', sans-serif;
		  line-height: 1;
		  letter-spacing: 0.05em;
		  color: #fff8e1 ;
		  font-weight: bold;
		  font-size: 16px;
		  border-radius: 25px;
		}
		.botoncta2{
		  background-image: linear-gradient(#3299ba,#3299ba);
		  font-family: 'roboto', sans-serif;
		  line-height: 1;
		  letter-spacing: 0.05em;
		  color: #fff8e1 ;
		  font-weight: bold;
		  font-size: 16px;
		  border-radius: 25px;
		}
		.botoncta2:hover{
		  background-image: linear-gradient(#1c7796,#1c7796);
		  font-family: 'roboto', sans-serif;
		  line-height: 1;
		  letter-spacing: 0.05em;
		  color: #fff8e1 ;
		  font-weight: bold;
		  font-size: 16px;
		  border-radius: 25px;
		}
</style>
</head>

	<body style="background-color: #fff8e1;">


	<!-- NAV PC -->
	 <nav class="navbar py-2 fixed-top ocultarpc" style="background-image: linear-gradient(to right,#ed8323,#ed8323); box-shadow: 0px 0px 0px 0px grey; padding: 0rem 0rem 0rem 0rem; ">
	    
	  <div class="col-md-3 pl-3" >
	    <ul class="nav justify-content-left  lighten-4">
	      <li class="nav-item">
	        <a href="http://localhost:8080/proyectoERPweb/index.jsp" style="color:#fff">
	          <button type="button" class="btn botoncta2 btn-rounded" > 
	            INICIO
	          </button>
	        </a>
	      </li>
	    </ul>
	  </div>
	   <div class="col-md-9" >
	    <ul class="nav justify-content-end  lighten-4 py-2 pr-2">
	      <li class="nav-item mx-3">
	        <a href="http://localhost:8080/proyectoERPweb/filterEmpleados.jsp" style="color:#fff">
	            EMPLEADOS
	        </a>
	      </li>
   	     <li class="nav-item mx-3">
	        <a href="http://localhost:8080/proyectoERPweb/filterClientes.jsp" style="color:#fff">
	            CLIENTES
	        </a>
	      </li>
	      <li class="nav-item mx-3">
	        <a href="http://localhost:8080/proyectoERPweb/filterPedidos.jsp" style="color:#fff">
	            PEDIDOS
	        </a>
	      </li>
	    </ul>
	   </div>
	  </nav>
	
	<main>
		<section class="section py-5" >
		
			<div class="pt-5 text-center" style="text-align: center; font-family: 'Pattaya', sans-serif;">
				<span style="font-size: 4em; color: #ed8323">¿Qué quieres consultar?</span>
			</div>
		
			<div class="p-5 row row-cols-1 row-cols-md-3 g-4 m-0">
			  <div class="col">
			    <div class="card h-100">
			      <img
			        src="https://pvillarserrano.com/recursos/empleados.png"
			        class="card-img-top"
			        alt="..."
			      />
			      <div class="card-body">
			        <h5 class="card-title">EMPLEADOS</h5>
			        <p class="card-text">
			          Esta tabla contiene id, compañía, ciudad, nombre e email de los empleados.
			        </p>
			      </div>
			      <div class="card-footer">
			        <a href="http://localhost:8080/proyectoERPweb/filterEmpleados.jsp" style="color:#fff">
			          <button type="button" class="btn botoncta btn-rounded" > 
			            VER MÁS
			          </button>
			        </a>
   			      </div>
			    </div>
			  </div>
			  <div class="col">
			    <div class="card h-100">
			      <img
			        src="https://pvillarserrano.com/recursos/empleados.png"
			        class="card-img-top"
			        alt="..."
			      />
			      <div class="card-body">
			        <h5 class="card-title">CLIENTES</h5>
			        <p class="card-text">
			          Esta tabla contiene id, compañía, nombre y apellido de los clientes.
			        </p>
			      </div>
			      <div class="card-footer">
			        <a href="http://localhost:8080/proyectoERPweb/filterClientes.jsp" style="color:#fff">
			          <button type="button" class="btn botoncta btn-rounded" > 
			            VER MÁS
			          </button>
			        </a>
			        </div>
			    </div>
			  </div>
			  <div class="col">
			    <div class="card h-100">
			      <img
			        src="https://pvillarserrano.com/recursos/empleados.png"
			        class="card-img-top"
			        alt="..."
			      />
			      <div class="card-body">
			        <h5 class="card-title">PEDIDOS</h5>
			        <p class="card-text">
			          Esta tabla contiene id de pedido, id de empleado, id de cliente y fecha.
			        </p>
			      </div>
			      <div class="card-footer">
			        <a href="http://localhost:8080/proyectoERPweb/filterPedidos.jsp" style="color:#fff">
			          <button type="button" class="btn botoncta btn-rounded" > 
			            VER MÁS
			          </button>
			        </a>
			        </div>
			    </div>
			  </div>
			</div>
		
		</section>
		

		
	</main>

	<!--  SCRIPTS  -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
	
	<!--HAMBURGUESA-->
	<script>$(document).ready(function () {
	
	    $('.second-button').on('click', function () {
	    
	        $('.animated-icon2').toggleClass('open');
	    });
	});
	</script>
	
	  <!-- Scroll animation script -->
	  <script>
	    $( document ).ready(function() {
	      new WOW().init();
	    });
	  </script>
	   <!-- <script>
	  new WOW().init();</script>-->
  
</body>
</html>
