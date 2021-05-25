package edu.fpdual.proyectoERP.main;

import java.sql.Connection;
import java.sql.SQLException;

import edu.fpdual.proyectoERP.conector.Conector;
import edu.fpdual.proyectoERP.manager.EmployeesManager;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Connects to the DB
		Connection con = new Conector().getMySQLConnection();
		
		try {
			
			//IMPRIME: erp2 
			//System.out.println(con.getCatalog());
			 		
			//BUSCAR TODOS LOS EMPLEADOS MOSTRAR TODOS SUS DATOS 
			//System.out.println(new EmployeesManager().findAll(con));
			
			//BUSCAR LOS EMPLEADOS DE LAS CIUDADES QUE EMPIECEN POR...
			//new EmployeesManager().findAllByNameStartingWith(con, "B").forEach(employees ->System.out.println(employees));
			 
			
			//PARA BUSCAR POR NOMBRE
			//System.out.println(new CityManager().FindName(con, "Bolton"));	
			//System.out.println(new EmployeesManager().FindName(con, "Bolton"));	
			
			//PARA BUSCAR POR ID
			//System.out.println(new CityManager().findID(con, 500));
			//System.out.println(new EmployeesManager().findIDEmp(con, 1));

			
			//PARA MODIFICAR LA POBLACION DE UNA CIUDAD TENIENDO SU ID
			//System.out.println(new CityManager().findID(con, 500));
			//new CityManager().update(con, 500, new BigDecimal("100000"));
			//System.out.println(new CityManager().findID(con, 500));
			
			
			//PARA INSERTAR UNA CIUDAD ( NO FUNCIONA )		
			
//			new CityManager().insert(con, "ciudadInvent", "distritoInvent" , new BigDecimal("100000"));
//			new CityManager().findAllByNameStartingWith(con, "ciudadIn").forEach(city ->System.out.println(city));
			
//			new CityManager().insert(con);
//			System.out.println(new CityManager().findID(con, 70000));
			
			
			//PARA BORRAR CIUDADES POR ID
			//new CityManager().delete(con, 500);
	 
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
