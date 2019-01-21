package exoJDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MaConnection {
	private static MaConnection instance;
	private Connection connection;

	private static final String JDBC_DRIVER = "mysqlDriver";
	private static final String JDBC_URL = "mysqlUrl";
	private static final String JDBC_USER = "mysqlUser";
	private static final String JDBC_PASSWORD = "mysqlPassword";

	private MaConnection() throws IOException, ClassNotFoundException, SQLException {

		// accede en lecture des fichiers de configs

		Properties props = new Properties();
		FileInputStream fils = new FileInputStream("src/main/ressources/jdbcCo,gig.properties");
		props.load(fils);

		final String DRIVER = props.getProperty(JDBC_DRIVER);
		Class.forName(DRIVER);

		final String URL = props.getProperty(JDBC_DRIVER);
		final String USER = props.getProperty(JDBC_USER);
		final String PASSWORD = props.getProperty(JDBC_PASSWORD);

		connection = DriverManager.getConnection(URL, USER, PASSWORD);
	}
}