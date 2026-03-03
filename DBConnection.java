package com.company.payroll.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements DBConfig{
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		return con;
	}
}
