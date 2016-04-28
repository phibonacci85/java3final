/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Violation;
import insurance.model.ViolationType;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class ViolationDAO {
    private static List<Violation> violations = new ArrayList<>();
    
    public static List<Violation> getDriverViolations(String liscenseNumber)
        throws ClassNotFoundException{
        violations = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectViolationsByLiscenseNumber(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = liscenseNumber;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Violation violation = new Violation();
                violation.setViolationId(resultSet.getInt(0));
                violation.setLiscenseNumber(resultSet.getString(1));
                violation.setType(ViolationType.valueOf(resultSet.getString(2)));
                violation.setDateOccured(resultSet.getDate(3));
                violation.setConvictionDate(resultSet.getDate(4));
                violations.add(violation);
            } 
        } catch (SQLException ex) {
            System.out.println("Technical Difficulties... ");
            System.err.println(ex.getMessage());
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Technical Difficulties");
                System.err.println(ex.getMessage());
            }
        }
        return violations;
    }
    
    public static boolean createViolation(Violation violation)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_insertViolation(?,?,?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, violation.getLiscenseNumber());
            callableStatement.setString(2, violation.getType().toString());
            callableStatement.setDate(4, (java.sql.Date) violation.getConvictionDate());
            callableStatement.setDate(3, (java.sql.Date) violation.getDateOccured());
            
            succeeded = callableStatement.execute();
            
        } catch (SQLException ex) {
            System.out.println("Technical Difficulties... ");
            System.err.println(ex.getMessage());
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Technical Difficulties");
                System.err.println(ex.getMessage());
            }
        }
        return succeeded;
    }
}
