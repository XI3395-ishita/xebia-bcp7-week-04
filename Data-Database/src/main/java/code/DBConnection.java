package code;
import java.sql.*;
public class DBConnection {
	 public Statement st;
     public ResultSet rs;
     public Connection conn;
     public PreparedStatement ps =null;      
        
     public Connection setConnection(){
         try{
                 Class.forName("com.mysql.jdbc.Driver");
                 conn = DriverManager.getConnection("jdbc:mysql://bcp7-java-db-01.cs4gnvom3jcr.ap-south-1.rds.amazonaws.com:3306/UserExample");
         }catch(Exception e){
                 e.printStackTrace();
         }
         return conn;
     }
   
     public PreparedStatement precompiled (String query, Connection conn){
         this.conn = conn;
         try{
                 ps = conn.prepareStatement(query);
               
         }catch(Exception e){
             System.out.println("The Error of ResultSet is" + e);
         }  
         return ps;
     }
   
     public void CloseConn(ResultSet rs, Statement st, PreparedStatement ps, Connection conn){
         if (rs != null) {
             try {
                 rs.close();
             } catch (SQLException e) {
             }
         }
         if (st != null) {
             try {
                 st.close();
             } catch (SQLException e) {
             }
         }
         if (ps != null) {
             try {
                 ps.close();
             } catch (SQLException e) {
             }
         }
         if (conn != null) {
             try {
                 conn.close();
             } catch (SQLException e) {
             }
         }
     }

}
