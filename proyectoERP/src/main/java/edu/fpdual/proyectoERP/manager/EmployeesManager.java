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

public class EmployeesManager {
	
	
	/**
	 * Finds all the employees in the DB
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
	 * Fills all the countries for each city.
	 * @param con the Db connection
	 * @param countries the map of cities and countries.
	 * @param cities the list of cities to update.
	 */
//	private void fillCountries(Connection con, Map<Integer, String> countries, List<Employees> cities) {
//		//Obtains all the country codes to search
//		Set<String> countryCodes = new HashSet<>(countries.values());
//
//		//Looks for all countries and groups them by id.
//		Map<String, Country> countriesMap = new CountryManager().findAllById(con, countryCodes).stream()
//				.collect(Collectors.toMap(Country::getId, data -> data));
//
//		//Associates the corresponding Country to each City
//		cities.forEach(city -> {
//			String countryCode = countries.get(city.getId());
//			Country foundCountry = countriesMap.get(countryCode);
//			city.setCountry(foundCountry);
//		});
//
//	}
	
	/**
	 * prueba de clase para sacar las ciudades
	 * @param con
	 * @param prefix
	 * @return
	 */
	public List<Employees> findAllByCityStartingWith(Connection con, String prefix){
		
		try(PreparedStatement prepStmt = con.prepareStatement("SELECT ID,Company,City,FirstName,Email FROM Employees WHERE City LIKE ?")){
			
			//Sustituye la ? por el valor de cada uno
			prepStmt.setString(1, prefix+"%");
			
			ResultSet result = prepStmt.executeQuery();
			//para que el cursor recorra desde el principio, por si acaso el cursor no lo hace
			result.beforeFirst();
			
			List<Employees> employees = new ArrayList<>();
			
			while (result.next()) {
				employees.add(new Employees(result));
			}
			return employees;
		}catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		
	}
	
	/**
	 * Me busca un empleado indicándole un nombre
	 * @param con
	 * @param name
	 * @return
	 */
	public Employees FindName(Connection con, String name) {
		
		String consulta = ("SELECT * FROM city WHERE name=?");

		try(PreparedStatement prepStmt = con.prepareStatement(consulta)){
			
			prepStmt.setString(1, name);
			ResultSet result = prepStmt.executeQuery();
			
			Employees ciudad = null;
			if (result.next()) {
				ciudad = new Employees(result);
			}
			return ciudad;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * para buscar por el ID de ciudad
	 * @param con
	 * @param id
	 * @return
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
	public Employees findIDEmp(Connection con, int id) {
		

		String consulta = ("SELECT ID,Company,City FROM Employees WHERE id=?");
		
		try(PreparedStatement prepStmt = con.prepareStatement(consulta)){
			
			//Le establecemos los parametros de consulta
			prepStmt.setInt(1, id);
			
			//Ejecutamos la sentencia mediante result para contruir los datos
			ResultSet result = prepStmt.executeQuery();
			
			//Cojemos el resultado y lo metemos un objeto ciudad
			Employees emp = null;
			if (result.next()) {
				emp = new Employees(result);
			}
			return emp;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Para actualizar la poblacion de un pais teniendo su id 
	 * @param con
	 * @param id
	 * @param population
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
	 * para introducir ciudades en la DB
	 * @param con
	 * @param name
	 * @param district
	 * @param population
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
	 * para borrar ciudades por su id 
	 * @param con
	 * @param id
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
	

}
