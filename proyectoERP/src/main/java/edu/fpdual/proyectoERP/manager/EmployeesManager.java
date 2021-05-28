package edu.fpdual.proyectoERP.manager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import edu.fpdual.proyectoERP.dao.Employees;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeesManager.
 */
public class EmployeesManager {
	
	
	/**
	 * Finds all the employees in the DB.
	 *
	 * @param con DB connection
	 * @return a {@link List} of {@link Employees}
	 */
	public List<Employees> findAll(Connection con) {
		
		try (Statement stmt = con.createStatement()) {
			ResultSet result = stmt.executeQuery("SELECT ID,Company,City,FirstName,Email FROM Employees;");
			result.beforeFirst();

			List<Employees> employees = new ArrayList<>();

			while (result.next()) {
				employees.add(new Employees(result));
			}

			return employees;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * prueba de clase para sacar las ciudades
	 * @param con
	 * @param prefix
	 * @return
	 */
	public List<Employees> findAllByCityStartingWith(Connection con, String prefix) {

        try (PreparedStatement prepStmt = con
                .prepareStatement("SELECT ID,Company,City,FirstName,Email FROM Employees WHERE City LIKE ?")) {

            prepStmt.setString(1, prefix + "%");

            ResultSet result = prepStmt.executeQuery();
        
            result.beforeFirst();

            List<Employees> employee = new ArrayList<>();

            while (result.next()) {
                employee.add(new Employees(result));
            }
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }


    }
	
	/**
	 * Me busca un empleado indicándole un nombre.
	 *
	 * @param con the con
	 * @param firstName the first name
	 * @return the employees
	 */
	public Employees FindName(Connection con, String firstName) {

        String consulta = ("SELECT * FROM Employees WHERE FirstName=?");

        try (PreparedStatement prepStmt = con.prepareStatement(consulta)) {

 

            prepStmt.setString(1, firstName);
            ResultSet result = prepStmt.executeQuery();

 

            Employees empl = null;
            if (result.next()) {
                empl = new Employees(result);
            }
            return empl;

 

        } catch (SQLException e) {

 

            e.printStackTrace();
        }
        return null;
    }

	/**
	 * para buscar por el ID de ciudad.
	 *
	 * @param con the con
	 * @param id the id
	 * @return the employees
	 */
	public Employees findID(Connection con, int id) {
		
		//String con la secuncia SQL
		//Podriamos haberlo indicado todo en el prepStmt
		String consulta = ("SELECT * FROM city WHERE id=?");
		
		try(PreparedStatement prepStmt = con.prepareStatement(consulta)){
			
			//Le establecemos los parametros de consulta
			prepStmt.setInt(1, id);
			
			//Ejecutamos la sentencia mediante result para contruir los datos
			ResultSet result = prepStmt.executeQuery();
			
			//Cojemos el resultado y lo metemos un objeto ciudad
			Employees ciudad = null;
			if (result.next()) {
				ciudad = new Employees(result);
			}
			return ciudad;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Find ID emp.
	 *
	 * @param con the con
	 * @param idEmpleado the id empleado
	 * @return the employees
	 */
	public Employees findIDEmp(Connection con, int idEmpleado) {

        String consulta = ("SELECT ID,Company,City, FirstName FROM Employees WHERE ID=?");

        try (PreparedStatement prepStmt = con.prepareStatement(consulta)) {

            // Le establecemos los parametros de consulta
            prepStmt.setInt(1, idEmpleado);

            // Ejecutamos la sentencia mediante result para contruir los datos
            ResultSet result = prepStmt.executeQuery();

            // Cojemos el resultado y lo metemos un objeto empleado
            Employees emp = null;
            if (result.next()) {
                emp = new Employees(result);
            }
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	/**
	 * Find by ID.
	 *
	 * @param con the con
	 * @param idEmpleado the id empleado
	 * @return the employees
	 */
	public Employees findByID(Connection con, int idEmpleado) {
 

        // String con la secuncia SQL
        // Podriamos haberlo indicado todo en el prepStmt
        String consulta = ("SELECT * FROM Employees WHERE ID=?");

        try (PreparedStatement prepStmt = con.prepareStatement(consulta)) {

            // Le establecemos los parametros de consulta
            prepStmt.setInt(1, idEmpleado);

            // Ejecutamos la sentencia mediante result para contruir los datos
            ResultSet result = prepStmt.executeQuery();

            // Cojemos el resultado y lo metemos un objeto empleado
            Employees empl = null;
            if (result.next()) {
                empl = new Employees(result);
            }
            return empl;
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
	

	
	
	/**
	 * Para actualizar la poblacion de un pais teniendo su id .
	 *
	 * @param con the con
	 * @param id the id
	 * @param population the population
	 */
	public void update(Connection con, int id, BigDecimal population) {
	
		//Actualizare la poblacion de una ciudad en base a su id 
		String consulta = ("UPDATE city SET population = ? WHERE id = ?");

		try(PreparedStatement prepStmt = con.prepareStatement(consulta)){
			
			prepStmt.setBigDecimal(1, population);
			prepStmt.setInt(2, id);
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * para introducir ciudades en la DB.
	 *
	 * @param con the con
	 * @param name the name
	 * @param district the district
	 * @param population the population
	 */
	public void insert(Connection con, String name, String district, BigDecimal population) {
		
		String consulta = ("INSERT INTO City (ID, Name, District, Population) VALUES((SELECT MAX(City.id)+1 FROM City),?,?,?");	
//		String consulta2 = ("INSERT INTO City (ID, Name, District, Population) VALUES('70000','ciudadInvent','distritoInvent', '100000')");
		
		try(PreparedStatement prepStmt = con.prepareStatement(consulta)){
			
			prepStmt.setString(1, name);
			prepStmt.setString(2, district);
			prepStmt.setBigDecimal(3, population);
			prepStmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * para borrar ciudades por su id .
	 *
	 * @param con the con
	 * @param id the id
	 */
	public void delete(Connection con, int id) {
		
		String consulta = ("DELETE FROM city WHERE id=?");	

		try(PreparedStatement prepStmt = con.prepareStatement(consulta)){
			
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	

	/**
	 * Adds the employee.
	 *
	 * @param con the con
	 * @param idEmpleado the id empleado
	 * @param company the company
	 * @param city the city
	 * @param firstName the first name
	 * @param email the email
	 */
	// ADD EMPLOYEE
	    public void addEmployee(Connection con, int idEmpleado, String company, String city, String firstName,
	            String email) {
	        try (PreparedStatement prepStmt = con
	                .prepareStatement("INSERT INTO Employees (ID,Company, City, FirstName, Email) VALUES ( ?, ?, ?,?,?)")) {
	            con.setAutoCommit(false);
	            prepStmt.setInt(1, idEmpleado);
	            prepStmt.setString(2, company);
	            prepStmt.setString(3, city);
	            prepStmt.setString(4, firstName);
	            prepStmt.setString(4, email);

	            prepStmt.executeUpdate();
	            System.out.println("Se ha guardado un nuevo empleado");
	            con.commit();
	        } catch (SQLException e) {

	            e.printStackTrace();
	        }
	    }

	 

	/**
	 * Delete employee.
	 *
	 * @param con the con
	 * @param idEmpleado the id empleado
	 */
	//DELETE EMPLOYEE
	    public void deleteEmployee(Connection con, int idEmpleado) {
	        try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM Employees WHERE ID = ?")) {
	            con.setAutoCommit(false);
	            prepStmt.setInt(1, idEmpleado);
	            prepStmt.executeUpdate();
	            System.out.println("Se ha borrado el empleado");
	            con.commit();

	        } catch (SQLException e) {
	            e.printStackTrace();

	        }


	    }





	

}
