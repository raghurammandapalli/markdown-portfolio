package cs6359.utdcart.controller;

import cs6359.utdcart.dao.DBMgr;
import cs6359.utdcart.entity.Driver;
import cs6359.utdcart.entity.User;

public class DriverController {

	private Driver user;
	private DBMgr db = null;

	public DriverController() {
	}

	public int register(String username, String password, String firstName, String lastName, String email,
			String userType) throws Exception {

		this.user = new Driver();
		this.user.setEmail(email);
		this.user.setFirstName(firstName);
		this.user.setLastName(lastName);
		this.user.setPassword(password);
		this.user.setUsername(username);
		this.user.setUserType(userType);
		// this.user.register();

		//db = new DBMgr();
		//db.insertUser(this.user);

		return -1;
	}

	public int login(String username, String password, String userType) {
		return -1;
	}

	public int logout(int id) {
		return -1;
	}

}
