package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	
	static Connection con;
	public static final String  dbUrl = "jdbc:postgresql://" + "ec2-3-209-124-113.compute-1.amazonaws.com"
										+ "/d2ftf73fn4u98e?sslmode=require";
	public static final  String username= "lqytnisqfkmjum";
	public static final  String password = "4cc35ec3d3b5f50817e444af066abc31ebb9dbcbadaf85c92a8d0640d023dfba";
	
	  public static Connection getConnection() {
		    
		    
		    try {
		    con = DriverManager.getConnection(dbUrl,username,password);
		    System.out.println(" connected to PostgreSQL server");
		    con.close();
		    }
		      catch (SQLException e) {
		        System.out.println("Error in connecting to PostgreSQL server");
		        e.printStackTrace();
		      }
		    return con;
	  	}
}
