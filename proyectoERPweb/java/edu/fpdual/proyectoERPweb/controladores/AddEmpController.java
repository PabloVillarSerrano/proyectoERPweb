package edu.fpdual.proyectoERPweb.controladores;

import java.sql.Connection;
import java.sql.SQLException;

import edu.fpdual.proyectoERP.conector.Conector;
import edu.fpdual.proyectoERP.dao.Employees;
import edu.fpdual.proyectoERP.manager.EmployeesManager;



public class AddEmpController {
	
	
	public Employees findEmployee(String id) {
		
		try (Connection con = new Conector().getMySQLConnection()){
			
			return new EmployeesManager().findID(con, Integer.parseInt(id));
			

		} catch (SQLException e) {

		e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;
		
		
	}
	

}
