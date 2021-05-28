package edu.fpdual.proyectoERP.main;

import java.sql.Connection;
import java.sql.SQLException;

import edu.fpdual.proyectoERP.conector.Conector;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	 

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException the SQL exception
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Connects to the DB
        Connection con = new Conector().getMySQLConnection();
        try {
            // Looks for all the cities in the DB and prints them.
            // new CityManager().findAll(con).forEach(city ->System.out.println(city));
            System.out.println(con.getCatalog());

 

//            ADD CUSTOMERS
//            new CustomerManagerC().addCustomer(con,30,"Accenture", "Bravo", "Victoria");
            
//            DELETE CUSTOMERS
//            new CustomerManagerC().deleteCustomer(con, 30);
//            
            // UPDATE CUSTOMER
//            Customer customer1 = new Customer();
//            customer1.setCustomerId(1);
//            customer1.setCompany("update");
//            customer1.setFirstName("funciona");
//            customer1.setLastName("hoy");
//            new CustomerManagerC().updateCustomer(con, customer1);
            
//            CUSTOMERS COMPLETE LIST
//            new CustomerManagerC().findAll(con).forEach(customer -> System.out.println(customer));
            
//            ADD ORDER
//            new OrderManager().addOrder(con,29,30,27,"2006-01-15 00:00:00");
            
//            DELETE ORDER
//            new OrderManager().deleteOrder(con, 29);
            
            
//            ORDERS COMPLETE LIST
//            new OrderManager().findAll(con).forEach(order -> System.out.println(order));
            // FIND ORDER BY ID EMPLEADO
//            new OrderManager().findByEmployeeId(con, 3).forEach(order -> System.out.println(order));
//            System.out.println("Lista por ID de empleado(3): " + "\n");

 

            // FIND ORDER BY ID CLIENTE
//            System.out.println("Lista por ID de cliente (4): " + "\n");
//            new OrderManager().findByCustomerId(con, 4).forEach(order -> System.out.println(order));

 

            
//            //UPDATE EMPLOYEE
//            Employee employee1 = new Employee();
//            employee1.setIdEmpleado(1);
//            employee1.setCompany("update");
//            employee1.setCity("Sevilla");
//            employee1.setFirstName("Vic");
//            employee1.setEmail("bravomacayov@gmail.com");
//            new EmployeeManager().updateEmployee(con, employee1);
//            EMPLOYEE COMPLETE LIST
//            new EmployeeManager().findAll(con).forEach(employee -> System.out.println(employee));

 

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

 

    }
}