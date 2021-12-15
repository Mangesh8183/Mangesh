package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	public static Connection getconnection() throws SQLException
	{
		Connection conn = null;
		String databasename="farmer";
		String url="jdbc:mysql://localhost:3306/"+databasename;
		String drivername="com.mysql.jdbc.Driver";
		String username="root";
		String password="root";
		try
	    {
			Class.forName(drivername);
	        conn = (Connection) DriverManager.getConnection(url,username,password);
	 	    if (conn != null)
	 	    {
	 	        }
	 	        else
	 	        {
	 	        }            
	        }
	        catch (ClassNotFoundException e)
	        {
	            e.printStackTrace();
	        }  
	       /* finally
	        {
	        	conn.close();
	        }*/
	        return conn;
	}	
}
