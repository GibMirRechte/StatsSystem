package de.juniorinjects.statssystem.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Handler {
	
	private static Connection connection;
	
	private String host = "localhost";
	private String datenbank = "Minecraft";
	private String admin = "root";
	private String password = "";
	
	public void connect() {
		if(isConnected()) {
			return;
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + datenbank + "?autoReconnect=true", admin, password);
			System.out.println("MySQl connected.");
		}catch (SQLException exe) {
			exe.printStackTrace();
			System.out.println("fail connecting MySQL.");
		}
		
	}
	
	public boolean isConnected() {
		return connection != null;
	}
	
	public void disconnect() {
		try {
			connection.close();
			System.out.println("MySQl disconnected.");
		}catch (SQLException exe) {
			exe.printStackTrace();
			System.out.println("fail disconnecting MySQL.");
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}
