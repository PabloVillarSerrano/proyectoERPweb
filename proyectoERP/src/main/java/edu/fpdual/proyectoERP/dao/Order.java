package edu.fpdual.proyectoERP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class Order {
	
	int OrderID;
	int EmployeeID;
	int CustomerID; 
	String OrderDate;
	
	public Order() {

	}

	public Order(ResultSet result) {
		try {
			this.OrderID = result.getInt("OrderID");
			this.EmployeeID = result.getInt("EmployeeID");
			this.CustomerID = result.getInt("CustomerID");
			this.OrderDate = result.getString("OrderDate");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}



