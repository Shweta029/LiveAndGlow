
package com.live_glow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	  private static final String URl = "jdbc:oracle:thin:@localhost:1521:xe";
		private static final String UserName = "liveandglow29";
		private static final String Password = "111";
		private  static Connection connection;

		public static Connection getConnection() throws SQLException {
			return  DriverManager.getConnection(URl, UserName, Password);
		}

}
