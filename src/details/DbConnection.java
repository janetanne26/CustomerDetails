/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package details;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class DbConnection {
    public static Connection con(){
        Connection con=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/customer_details","root","");  
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
        
        return con;
    }
    
}
