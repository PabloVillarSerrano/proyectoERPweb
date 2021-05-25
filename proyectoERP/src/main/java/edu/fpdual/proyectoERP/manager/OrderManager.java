package edu.fpdual.proyectoERP.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.fpdual.proyectoERP.dao.Employees;
import edu.fpdual.proyectoERP.dao.Order;

public class OrderManager {
	public List<Order> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM Orders ORDER BY Order_ID");
			result.beforeFirst();

			List<Order> order = new ArrayList<>();

			while (result.next()) {
				order.add(new Order(result));
			}
			return order;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	public List<Order> findAll2(Connection con) {
		
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT OrderID,EmployeeID,CustomerID,OrderDate FROM Orders;");
			result.beforeFirst();

			List<Order> order = new ArrayList<>();

			while (result.next()) {
				order.add(new Order(result));
			}

			return order;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addOrder(Connection con, int orderId, int employeeId, int customerId, String orderDate) {
		try (PreparedStatement prepStmt = con.prepareStatement(
				"INSERT INTO Orders (Order_ID, Employee_ID, Customer_ID, Order_Date) VALUES ( ?, ?, ?,?)")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, orderId);
			prepStmt.setInt(2, employeeId);
			prepStmt.setInt(3, customerId);
			prepStmt.setString(4, orderDate);
			prepStmt.executeUpdate();
			System.out.println("Se ha guardado un nuevo pedido: ");

			con.commit();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void deleteOrder(Connection con, int orderId) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM Orders WHERE Order_ID = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, orderId);
			prepStmt.executeUpdate();
			System.out.println("Se ha borrado el pedido");
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
}
