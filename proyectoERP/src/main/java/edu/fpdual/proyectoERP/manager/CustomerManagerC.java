package edu.fpdual.proyectoERP.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.fpdual.proyectoERP.dao.Customer;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerManagerC.
 */
public class CustomerManagerC {
	
	/**
	 * Find all.
	 *
	 * @param con the con
	 * @return the list
	 */
	// List customers
	public List<Customer> findAll(Connection con) {
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT * FROM Customers");
			result.beforeFirst();

			List<Customer> customer = new ArrayList<>();

			while (result.next()) {
				customer.add(new Customer(result));
			}
			return customer;
		} catch (SQLException e) {

			e.printStackTrace();
			return Collections.emptyList(); 
		}
	}

	/**
	 * Adds the customer.
	 *
	 * @param con the con
	 * @param customerId the customer id
	 * @param company the company
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public void addCustomer(Connection con, int customerId, String company, String firstName, String lastName) {
		try (PreparedStatement prepStmt = con
				.prepareStatement("INSERT INTO Customers (ID,Company, Last_Name, First_Name) VALUES ( ?, ?, ?,?)")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, customerId);
			prepStmt.setString(2, company);
			prepStmt.setString(4, firstName);
			prepStmt.setString(3, lastName);
			prepStmt.executeUpdate();
			System.out.println("Se ha guardado un nuevo cliente");
			con.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Delete customer.
	 *
	 * @param con the con
	 * @param customerId the customer id
	 */
	public void deleteCustomer(Connection con, int customerId) {
		try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM Customers WHERE ID = ?")) {
			con.setAutoCommit(false);
			prepStmt.setInt(1, customerId);
			prepStmt.executeUpdate();
			System.out.println("Se ha borrado el cliente");
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	
	/**
	 * Find by ID.
	 *
	 * @param con the con
	 * @param customerId the customer id
	 * @return the customer
	 */
	public Customer findByID(Connection con, int customerId) {
        String consulta = ("SELECT * FROM Customers WHERE ID=?");

 

        try (PreparedStatement prepStmt = con.prepareStatement(consulta)) {

 

            // Le establecemos los parametros de consulta
            prepStmt.setInt(1, customerId);

 

            // Ejecutamos la sentencia mediante result para contruir los datos
            ResultSet result = prepStmt.executeQuery();

 

            // Cojemos el resultado y lo metemos un objeto customer
            Customer customer = null;
            if (result.next()) {
                customer = new Customer(result);
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	/**
	 * Update customer.
	 *
	 * @param con the con
	 * @param customer the customer
	 * @throws SQLException the SQL exception
	 */
	public void updateCustomer(Connection con, Customer customer) throws SQLException {

		 

        PreparedStatement prepStmt = con
                .prepareStatement("UPDATE Customers SET Company = ?, Last_Name = ? , First_Name= ? WHERE ID = ?");
        prepStmt.setString(1, customer.getCompany());
        prepStmt.setString(2, customer.getFirstName());
        prepStmt.setString(3, customer.getLastName());
        prepStmt.setInt(4, customer.getCustomerId());

 

        prepStmt.executeUpdate();

 

        prepStmt.close();
    }

}
