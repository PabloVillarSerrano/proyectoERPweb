package edu.fpdual.proyectoERP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Customer {

	int customerId;
	String Company;
	String firstName;
	String lastName;

	public Customer() {

	}

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
