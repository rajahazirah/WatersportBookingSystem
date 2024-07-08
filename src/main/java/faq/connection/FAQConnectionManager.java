package faq.connection;

/*
 * Author: FES
 * March 2024
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FAQConnectionManager {
	static Connection con;
	//define and initialize database driver
	//private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	//define and initialize database url
	//private static final String DB_CONNECTION = "jdbc:mysql://localhost/watersport";
	//define and initialize database user
	//private static final String DB_USER = "root";
	//define and initialize database password
	//private static final String DB_PASSWORD = "";
	
//	//oracle
//	 private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";//Driver class
//	 private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";//Connection URL
//	 private static final String DB_USER = "WS";  //Change to your DB Username
//	 public static final String DB_PASSWORD = "oracle"; //Change to your DB Password
	 
	//postgres
		 private static final String DB_DRIVER = "org.postgresql.Driver"; //Driver class
		 private static final String DB_CONNECTION = "jdbc:postgresql://cat670aihdrkt1.cluster-czrs8kj4isg7.us-east-1.rds.amazonaws.com:5432/da14ci8e55q175";
		 private static final String DB_USER = "u99kt00jb50138";
		 private static final String DB_PASSWORD = "p11d5e3ac7f3f0424fad5f1a19ade7bd919afd394833607205924193151b00727";
		 public static void main(String[] args) {
		        try {
		            Connection con = getConnection();
		            if (con != null) {
		                System.out.println("Connected to the PostgreSQL Server.");

//		                // Retrieve all accounts and print them out
//		                printAllAccounts(con);

		                con.close();
		            }
		        } catch (SQLException e) {
		            System.out.println("ERROR: Connection to PostgreSQL Server failed.");
		            e.printStackTrace();
		        }
		    }
		 
	public static Connection getConnection() {
	
		try {
			//1. load the driver
			Class.forName(DB_DRIVER);
			
			try {
				//2. create connection
				con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
				System.out.println("Connected");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return con;
	}
}