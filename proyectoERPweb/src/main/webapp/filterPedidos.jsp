<%@page import="java.util.List"%>
<%@page import="edu.fpdual.proyectoERP.conector.Conector"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.fpdual.proyectoERP.dao.Order"%>
<%@page import="edu.fpdual.proyectoERP.manager.OrderManager" %>

<html>
<head>
<!-- Fuentes -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Pattaya&display=swap"
	rel="stylesheet">
<!-- Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- MDBootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css"
	rel="stylesheet">
</head>
<style>
.botoncta2 {
	background-image: linear-gradient(#3299ba, #3299ba);
	font-family: 'roboto', sans-serif;
	line-height: 1;
	letter-spacing: 0.05em;
	color: #fff8e1;
	font-weight: bold;
	font-size: 16px;
	border-radius: 25px;
}

.botoncta2:hover {
	background-image: linear-gradient(#1c7796, #1c7796);
	font-family: 'roboto', sans-serif;
	line-height: 1;
	letter-spacing: 0.05em;
	color: #fff8e1;
	font-weight: bold;
	font-size: 16px;
	border-radius: 25px;
}
</style>

<body style="background-color: #fff8e1;">




	<!-- MODAL UPDATE -->
	<div class="modal fade" id="carouselIMG" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content">
				<div class="modal-body" style="text-align: center;">

					<div>
						<h2>
							Update del pedido con Id:
							<%=request.getParameter("OrderID")%></h2>
					</div>

					<div class="pt-4">
						<form name="updateOrd" action="updateOrd.jsp" method="GET">
							<label class="px-2"> Id Pedido </label><input type="text"
							name=OrderID value="<%=request.getParameter("OrderID")%>" /> <br>
							<label class="px-2"> Id Empleado </label><input type="text" name="EmployeeID" value="" /> <br>
							<label class="px-2"> Id Cliente </label><input type="text"
							name="CustomerID" value="" /> <br> 
							<label class="px-2">Fecha </label><input type="text" name="OrderDate" value="" /> <br>
							<input type="submit" value="Update" />
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>



	<!-- NAV PC -->
	<nav class="navbar py-2 fixed-top ocultarpc"
		style="background-image: linear-gradient(to right, #ed8323, #ed8323); box-shadow: 0px 0px 0px 0px grey; padding: 0rem 0rem 0rem 0rem;">

		<div class="col-md-3 pl-3">
			<ul class="nav justify-content-left  lighten-4">
				<li class="nav-item"><a
					href="http://localhost:8080/proyectoERPweb/index.jsp"
					style="color: #fff">
						<button type="button" class="btn botoncta2 btn-rounded">
							INICIO</button>
				</a></li>
			</ul>
		</div>
		<div class="col-md-9">
			<ul class="nav justify-content-end  lighten-4 py-2 pr-2">
				<li class="nav-item mx-3"><a
					href="http://localhost:8080/proyectoERPweb/filterEmpleados.jsp"
					style="color: #fff"> EMPLEADOS </a></li>
				<li class="nav-item mx-3"><a
					href="http://localhost:8080/proyectoERPweb/filterClientes.jsp"
					style="color: #fff"> CLIENTES </a></li>
				<li class="nav-item mx-3"><a
					href="http://localhost:8080/proyectoERPweb/filterPedidos.jsp"
					style="color: #fff"> PEDIDOS </a></li>
			</ul>
		</div>
	</nav>

	<main>


		<section class="section py-5">

			<div class="pt-5 text-center"
				style="text-align: center; font-family: 'Pattaya', sans-serif;">
				<span style="font-size: 4em; color: #ed8323">Pedidos</span>
			</div>

			<div class="p-4 text-center" style="text-align: center;">
				<input type="text" id="myInputOrdID" onkeyup="myFunctionOrdID()"
					placeholder="Buscar por Id Pedido" title="Escribe un Id Pedido">
				<input type="text" id="myInputEmpID" onkeyup="myFunctionEmpID()"
					placeholder="Buscar por Id Empleado" title="Escribe un Id Empleado">
				<input type="text" id="myInputCustID" onkeyup="myFunctionCustID()"
					placeholder="Buscar por Id Cliente" title="Escribe un Id Cliente">
				<input type="text" id="myInputDATE" onkeyup="myFunctionDATE()"
					placeholder="Buscar por Fecha" title="Escribe una fecha">
			</div>

			<div class="" style="text-align: center">

				<table border="1" style="margin: auto" id="myTable">
					<thead style="font-family: 'Pattaya', sans-serif; color: #ed8323">
						<tr class="header">
							<th class="px-4 py-2" style="font-size: 1.5em;">Id Pedido</th>
							<th class="px-4 py-2" style="font-size: 1.5em;">Id Empleado</th>
							<th class="px-4 py-2" style="font-size: 1.5em;">Id Cliente</th>
							<th class="px-4 py-2" style="font-size: 1.5em;">Fecha</th>
							<th class="px-4 py-2" style="font-size: 1.5em;">Opciones</th>

						</tr>
					</thead>
					<%
					Connection con = new Conector().getMySQLConnection();
					//List<Employees>list=new EmployeesManager().findAllByCityStartingWith(con,"Sea");
					List<Order> list = new OrderManager().findAll2(con);

					//Employees emp = new EmployeesManager().findIDEmp(con, id);
					//List<Employees>list=new EmployeesManager().findIDEmp(con,1);
					%>
					<tbody>

						<%
						for (Order ord : list) {
						%>

						<tr>
							<td><%=ord.getOrderId()%></td>
							<td><%=ord.getEmployeeId()%></td>
							<td><%=ord.getCustomerId()%></td>
							<td><%=ord.getOrderDate()%></td>
							<td><span> 
									<button type="button" class="update" data-toggle="modal"
										data-target="#carouselIMG">Update</button>
							</span>
							<a href="deleteOrd.jsp?id= <%=ord.getOrderId()%>">
									<button type="button" class="delete"
										style="background-color: #ff000094">Delete</button>
							</a></td>

						</tr>
						<%}%>
					</tbody>
				</table>


				 <div class="pt-4">
                  <form  name="addEmp" action="addOrd.jsp" method="GET">
                   <label class="px-2"> Id Pedido </label><input type="text" name=OrderID value=""/>
                   <label class="px-2"> Id Empleado </label><input type="text" name="EmployeeID" value=""/>
                   <label class="px-2"> Id Cliente </label><input type="text" name="CustomerID" value=""/>
                      <label class="px-2"> Fecha </label><input type="text" name="OrderDate" value=""/>
                    <input type="submit" value="Añadir pedido"/>
                  </form>
              </div>  
				</div>


		</section>



		<div>
			<%!private int contador = 0;%>
			<p>
				Número de veces que se ha visitado esta página desde que se arrancó
				el servidor:
				<%=++contador%>
			</p>
		</div>

	</main>

	<!--  SCRIPTS  -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>

	<!-- PARA LAS ID -->
	<script>
		function myFunctionOrdID() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInputOrdID");
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
	<!-- PARA LAS CIUDADES -->
	<script>
		function myFunctionEmpID() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInputEmpID");
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
		function myFunctionCustID() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInputCustID");
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
	<script>
		function myFunctionDATE() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInputDATE");
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
	<script>
		$('#myModal').modal({
			keyboard : false
		})
	</script>

</body>
</html>
