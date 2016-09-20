package onlinesale.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static DBConnection instance;

	private Connection connection;

	public static DBConnection getInstance(){
		if(instance == null){
			instance = new DBConnection();
		}
		return instance;
	}

	public DBConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesale","root","password");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
    
    public Connection getConnection(){
	    return connection;
    }
    
    public void closeConnection(){
	    if(connection != null){
			try{
				connection.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	    }
    }
}
