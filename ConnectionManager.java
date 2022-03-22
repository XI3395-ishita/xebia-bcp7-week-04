package examplePackage;
import java.sql.*;
import java.util.*;
public class ConnectionManager {
	static Connection con;
    static String url;
          
    public static Connection getConnection()
    {
      
       try
       {
          String url = "jdbc:mysql://bcp7-java-db-01.cs4gnvom3jcr.ap-south-1.rds.amazonaws.com:3306/" + "UserExample"; 
          // assuming "DataSource" is your DataSource name

          Class.forName("com.mysql.jdbc.Driver");
          
          try
          {            	
             con = DriverManager.getConnection(url,"ishitas","bcp7javaee"); 
              								
          // assuming your SQL Server's	username is "username"               
          // and password is "password"
               
          }
          
          catch (SQLException ex)
          {
             ex.printStackTrace();
          }
       }

       catch(ClassNotFoundException e)
       {
          System.out.println(e);
       }

    return con;
}
}
