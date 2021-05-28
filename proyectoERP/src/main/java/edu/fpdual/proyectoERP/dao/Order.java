package edu.fpdual.proyectoERP.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// TODO: Auto-generated Javadoc

/**
 * Gets the order date.
 *
 * @return the order date
 */
@Getter

/**
 * Sets the order date.
 *
 * @param orderDate the new order date
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString

public class Order {
	
	/** The order id. */
	int orderId;
	
	/** The employee id. */
	int employeeId;
	
	/** The customer id. */
	int customerId; 
	
	/** The order date. */
	String orderDate;
	
	/**
	 * Instantiates a new order.
	 */
	public Order() {

	}

	/**
	 * Instantiates a new order.
	 *
	 * @param result the result
	 */
	public Order(ResultSet result) {
		try {
			this.orderId = result.getInt("OrderID");
			this.employeeId = result.getInt("EmployeeID");
			this.customerId = result.getInt("CustomerID");
			this.orderDate = result.getString("OrderDate");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}



