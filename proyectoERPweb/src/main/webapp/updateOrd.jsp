<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="edu.fpdual.proyectoERP.conector.Conector"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.fpdual.proyectoERP.dao.Order"%>
<%@page import= "edu.fpdual.proyectoERP.manager.OrderManager" %>


<% 
String t1 = request.getParameter("OrderID");
int id1 = Integer.parseInt(t1);
String t2 = request.getParameter("EmployeeID");
int id2 = Integer.parseInt(t2);
String t3 = request.getParameter("CustomerID");
int id3 = Integer.parseInt(t3);
String t4 = request.getParameter("OrderDate");

Connection con = new Conector().getMySQLConnection();

try (PreparedStatement prepStmt = con.prepareStatement("UPDATE Orders SET EmployeeID = ?, CustomerID = ? , OrderDate= ? WHERE OrderID = ?")) 

{
	con.setAutoCommit(false);
	prepStmt.setInt(1, id2);
	prepStmt.setInt(2, id3);
	prepStmt.setString(3, t4);
	prepStmt.setInt(4, id1);
	
	prepStmt.executeUpdate();
	con.commit();
} catch (SQLException e) {

e.printStackTrace();
}
%>	

		
<html>
<head>
	<!-- Fuentes -->
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Pattaya&display=swap" rel="stylesheet">
	<!-- Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
	<!-- MDBootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
</head>
<style>
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

		<section class="mt-5 section text-center py-5" >
			<div class="pt-5 " style="text-align: center; font-family: 'Pattaya', sans-serif;">
				<span style="font-size: 4em; color: #ed8323">�Pedido modificado!</span>
			</div>	
			
			
			<p><b>Id Pedido:</b>
			   <%= request.getParameter("OrderID")%>
			</p>
			<p><b>Id Empleado:</b>
			   <%= request.getParameter("EmployeeID")%>
			</p>
				<p><b>Id Cliente:</b>
			   <%= request.getParameter("CustomerID")%>
			</p>
				<p><b>Fecha:</b>
			   <%= request.getParameter("OrderDate")%>
			</p>
			
			
		</section>	
	    <section class="section py-5" >
			<div class="text-center" style="text-align: center; font-family: 'Pattaya', sans-serif;">
				<a href="filterPedidos.jsp" style="color:#fff">
		          <button type="button" class="btn botoncta2 btn-rounded" > 
		            Volver al listado
		          </button>
		        </a>			
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
	

</body>
</html>
