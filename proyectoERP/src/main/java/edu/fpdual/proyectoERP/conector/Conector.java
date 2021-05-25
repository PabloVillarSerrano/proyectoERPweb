package edu.fpdual.proyectoERP.conector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lombok.Getter;
import lombok.Setter;

/**
 * Class responsible for creation DDBB connections.
 * @author pablo.villar.serrano
 *
 */

public class Conector {
	
	@Setter
	@Getter
	Properties prop = new Properties();
	
	public Conector() {
		try {
			//Loads all the properties of file "config.properties".
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates the connection object for a MySQL DDBB
	 * @return a {@link Connection}
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		try {

			//Indicates which driver is going to be used.
			Class.forName(prop.getProperty(MySQLConstants.DRIVER));

			try {
				//Creates the connection based on the obtained URL.
				return  DriverManager.getConnection(getURL());
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * Obtains the URL to connect to MySQL DDBB
	 * @return an URL
	 * 
	 * TODO &serverTimezone=CET como parametro 
	 * 
	 */
	private String getURL() {
		return new StringBuilder().append(prop.getProperty(MySQLConstants.URL_PREFIX))
		.append(prop.getProperty(MySQLConstants.URL_HOST)).append(":")
		.append(prop.getProperty(MySQLConstants.URL_PORT)).append("/")
		.append(prop.getProperty(MySQLConstants.URL_SCHEMA)).append("?user=")
		.append(prop.getProperty(MySQLConstants.USER)).append("&password=")
		.append(prop.getProperty(MySQLConstants.PASSWD)).append("&useSSL=")
		.append(prop.getProperty(MySQLConstants.URL_SSL)).append("&serverTimezone=CET").toString();
		}
	
	// ME DEVUELVE LO SIGUIENTE: jdbc:mysql://localhost:3306/world?user=sa&password=pableras88&SSL=false

}
