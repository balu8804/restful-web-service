package resthelloworld;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class StudentDB {
	private static Connection connection = null;

	public static Connection getConnection() throws SQLException, IOException {
		if (connection != null)
			return connection;
		else {
			try {
				Properties properties = new Properties();
				InputStream input = StudentDB.class.getClassLoader()
						.getResourceAsStream("/db.properties");
				properties.load(input);
				String driver = properties.getProperty("driver");
				String url = properties.getProperty("url");
				String userName = properties.getProperty("username");
				String password = properties.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, userName, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
			return connection;

		}
	}

}
