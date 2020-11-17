package cs6359.utdcart.controller;


import cs6359.utdcart.dao.DBMgr;

import cs6359.utdcart.entity.Customer;
import cs6359.utdcart.entity.User;
import cs6359.utdcart.entity.Gui;

public class CustomerController {

	// private User user;
	private Customer user;
	private DBMgr db = null;

	public CustomerController() {

	}

	public int register(String username, String password, String firstName, String lastName, String email,
			String userType) throws Exception {
        System.out.print("CC:Register");
		this.user = new Customer();
		this.user.setEmail(email);
		this.user.setFirstName(firstName);
		this.user.setLastName(lastName);
		this.user.setPassword(password);
		this.user.setUsername(username);
		this.user.setUserType(userType);
		//this.user.register();


		db = new DBMgr();
		db.insertUser(this.user);
		return -1;
	}

	public int login(String username, String password) {
		

		return -1;
	}

	public int logout(int id) {

		return -1;
	}
	
	
	
	

}
