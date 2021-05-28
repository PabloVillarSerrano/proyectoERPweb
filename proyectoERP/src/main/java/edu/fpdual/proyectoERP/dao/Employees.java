package edu.fpdual.proyectoERP.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * Gets the city.
 *
 * @return the city
 */
@Getter

/**
 * Sets the city.
 *
 * @param City the new city
 */
@Setter
@ToString



public class Employees {
	
	/** The id. */
	int id;
	
	/** The Company. */
	String Company;

/** The First name. */
//	String country;
	String FirstName;
	
	/** The Email. */
	String Email;
	
	/** The City. */
	String City;
	
	/**
	 * para obtener los datos de los empleados .
	 */
	public Employees() {
		
	}
	
	/**
	 * Instantiates a new employees.
	 *
	 * @param result the result
	 */
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
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "\nid=" + id + ", Company=" + Company + ", City=" + City + "\n";
	}


}
