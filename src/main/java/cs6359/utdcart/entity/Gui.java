package cs6359.utdcart.entity;

import cs6359.utdcart.controller.CustomerController;


import cs6359.utdcart.controller.DriverController;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;



public class Gui extends HttpServlet{

	// private User user;
	private DriverController driverController;
	private CustomerController customerController;
	
	private final String url = "jdbc:mysql://localhost:3306/utdcart";
	private final String username = "root";
	private final String password = "root";
	
	private String userType;
	private int id;
	Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

	public Gui() {
		// TODO Auto-generated constructor stub

	}

	public int register(String username, String password, String firstName, String lastName, String email,
			String userType) throws Exception {

		this.userType = userType;
		if (this.userType.equals("customer")) {
			this.customerController = new CustomerController();
			this.customerController.register(username, password, firstName, lastName, email, userType);
		} else if (this.userType.equals("driver")) {
			this.driverController = new DriverController();
			this.driverController.register(username, password, firstName, lastName, email, userType);
		}
		return -1;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String userName = request.getParameter("username");
		String userPass = request.getParameter("password");
		
		String queryString = "SELECT userType FROM utdcart WHERE username=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			ps = connection.prepareStatement(queryString);
			ps.setString(1,userName);
			resultSet = ps.executeQuery();
			resultSet.next();
			
			
			if ("customer".equalsIgnoreCase(resultSet
                                    .getString("userType"))) {
				this.customerController = new CustomerController();
				this.customerController.login(userName, userPass);
				
			} else if("driver".equalsIgnoreCase(resultSet
                    .getString("userType"))){
				this.driverController = new DriverController();
				this.driverController.login(userName, userPass, this.userType);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
			doGet(request, response);
    }


	public int login(String username, String password) {

		
		return -1;
	}

	public int logout() {

		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		Gui gui = new Gui();
		gui.register("ram2", "ram", "ram", "ram", "ram", "customer");
		gui.register("ram1", "ram", "ram", "ram", "ram", "driverr");
		
		
	}

}