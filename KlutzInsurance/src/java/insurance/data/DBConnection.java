/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nh228u27
 */
public class DBConnection {
    
    public static Connection getConnection() 
            throws SQLException, ClassNotFoundException{
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/j3project2?noAccessToProcedureBodies=true"
                ,"root"
                ,"password"
            );
               
        } catch (SQLException | ClassNotFoundException ex) {
           throw ex;
        } 
        return conn;
    }
}
