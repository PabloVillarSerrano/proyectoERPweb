/*
 * 
 */
package edu.fpdual.proyectoERP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// TODO: Auto-generated Javadoc
/**
 * Gets the last name.
 *
 * @return the last name
 */
@Getter

/**
 * Sets the last name.
 *
 * @param lastName the new last name
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString



public class Customer {

	/** The customer id. */
	int customerId;
	
	/** The Company. */
	String Company;
	
	/** The first name. */
	String firstName;
	
	/** The last name. */
	String lastName;

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {

	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param result the result
	 */
	public Customer(ResultSet result) {
		try {
			this.customerId = result.getInt("ID");
			this.Company = result.getString("Company");
			this.firstName = result.getString("firstName");
			this.lastName = result.getString("lastName");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
