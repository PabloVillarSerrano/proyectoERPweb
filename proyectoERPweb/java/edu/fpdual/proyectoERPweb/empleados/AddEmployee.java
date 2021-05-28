package edu.fpdual.proyectoERPweb.empleados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import edu.fpdual.proyectoERP.conector.Conector;

import edu.fpdual.proyectoERP.manager.EmployeesManager;



/**
 * Servlet implementation class addEmployee
 */
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String t1=request.getParameter("EmployeeId");
		int id = Integer.parseInt(t1);
		String t2=request.getParameter("Company");
		String t3=request.getParameter("City");
		String t4=request.getParameter("FirstName");
		String t5=request.getParameter("Email");

		try (Connection con = new Conector().getMySQLConnection()){
			
			//new EmployeesManager().insert(con, id, t2, t3, t4, t5);
			

		} catch (SQLException e) {

		e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		request.setAttribute("EmployeeId", t1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addEmp.jsp");
		dispatcher.forward(request, response);

	}

}
