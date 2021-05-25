<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="edu.fpdual.proyectoERP.conector.Conector"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.fpdual.proyectoERP.dao.Customer"%>
<%@page import= "edu.fpdual.proyectoERP.manager.CustomerManagerC" %>


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
	
	
		<section class="section py-5" >
		
			<div class="pt-5 text-center" style="text-align: center; font-family: 'Pattaya', sans-serif;">
				<span style="font-size: 4em; color: #ed8323">Clientes</span>
			</div>		
			
			<div class="p-4 text-center" style="text-align: center; ">
				<input type="text" id="myInputID" onkeyup="myFunctionID()" placeholder="Buscar por Id" title="Escribe un id">
				<input type="text" id="myInputCOMPANY" onkeyup="myFunctionCOMPANY()" placeholder="Buscar por Compañía" title="Escribe una compañía">	
				<input type="text" id="myInputNAME" onkeyup="myFunctionNAME()" placeholder="Buscar por Nombre" title="Escribe un nombre">	
				<input type="text" id="myInputLASTNAME" onkeyup="myFunctionLASTNAME()" placeholder="Buscar por Apellido" title="Escribe un apellido">	
				
			</div>	   
			
			<div class="" style="text-align: center">
	
			   <table border = "1" style="margin: auto" id="myTable">
			       <thead style="font-family: 'Pattaya', sans-serif; color: #ed8323" >
			           <tr class="header">
			               <th class="px-4 py-2" style="font-size: 1.5em;">Id</th>
			               <th class="px-4 py-2" style="font-size: 1.5em;">Compañía</th>
			               <th class="px-4 py-2" style="font-size: 1.5em;">Nombre</th>
   			               <th class="px-4 py-2" style="font-size: 1.5em;">Apellido</th>
			               
			           </tr>
			       </thead>
			        <%
			          Connection con = new Conector().getMySQLConnection();
			          //List<Employees>list=new EmployeesManager().findAllByCityStartingWith(con,"Sea");
			           List<Customer>list=new CustomerManagerC().findAll(con);
			           


			           //Employees emp = new EmployeesManager().findIDEmp(con, id);
			          //List<Employees>list=new EmployeesManager().findIDEmp(con,1);
			        %> 
			      <tbody> 
			       <% for(Customer cust:list){ %>
			       
			           <tr>
			           	   <td><%= cust.getCustomerId()%></td>			               
			               <td><%= cust.getCompany()%></td>
   			               <td><%= cust.getFirstName()%></td>
			               <td><%= cust.getLastName()%></td>		
						   <td>
						   	<a href="deleteCust.jsp?id= <%=cust.getCustomerId() %>">
						   		<button type="button" class="delete">Delete</button>
						   	</a>
						   </td>               

			           </tr>
			           <%}%>
			       </tbody>
			   </table> 
			   
			   <div class="pt-4">
				  <form  name="addCust" action="addCust.jsp" method="GET">
				   <label class="px-2"> Id </label><input type="text" name=CustomerId value=""/> 
				   <label class="px-2"> Compañia </label><input type="text" name="Company" value=""/>
	   			   <label class="px-2"> Nombre </label><input type="text" name="FirstName" value=""/>
	   			   <label class="px-2"> Apellido </label><input type="text" name="LastName" value=""/>
				    <input type="submit" value="Enter Values"/>
				  </form>
			  </div>	   
			   
			   
		   </div>
		</section>
		
		

		<div style="padding-left: 2%;">			
		<%! private int contador = 0; %>
			<p>Número de veces que se ha visitado esta página desde que se
			arrancó el servidor:
			<%= ++contador %>
			</p>
		</div>
		
	</main>

	<!--  SCRIPTS  -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
	
	<!-- PARA LAS ID -->
	<script>
	function myFunctionID() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInputID");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	</script>
	<!-- PARA LAS COMPAÑÍAS -->
	<script>
	function myFunctionCOMPANY() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInputCOMPANY");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	</script>
	<!-- PARA LOS NOMBRES -->
	<script>
	function myFunctionNAME() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInputNAME");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[2];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	</script>
	<!-- PARA LOS APELLIDOS -->
	<script>
	function myFunctionLASTNAME() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInputLASTNAME");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[3];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
	</script>

	<!-- PARA BORRAR -->
	<script>
	function removeRow()
		{
		  var table = document.getElementById('myTable');
		  var lastElement = ptable.rows.length;
		  if (lastElement > 2) ptable.deleteRow(lastElement - 1);
		  if(document.getElementById("psize").value>1)
			{
			   document.getElementById("psize").value = document.getElementById("psize").value-1;
			}
		}
	</script>
	

  
</body>
</html>
