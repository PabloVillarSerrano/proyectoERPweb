package edu.fpdual.proyectoERP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Employees {
	
	int id;
	String Company;
//	String country;
	String FirstName;
	String Email;
	String City;
	
	/**
	 * para obtener los datos de los empleados 
	 * @param result
	 */
	public Employees() {
		
	}
	public Employees(ResultSet result) {
		try {
			this.id = result.getInt("ID");
			this.Company = result.getString("Company");
			this.City = result.getString("City");
			this.FirstName = result.getString("FirstName");
			this.Email = result.getString("Email");

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "\nid=" + id + ", Company=" + Company + ", City=" + City + "\n";
	}


}
