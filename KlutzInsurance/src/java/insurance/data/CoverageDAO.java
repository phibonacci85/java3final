/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Coverage;
import insurance.model.CoverageType;
import insurance.model.DeductibleOption;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author NH228U27
 */
public class CoverageDAO {
    
    private static List<Coverage> coverages = new ArrayList<>();
    
    public static List<Coverage> getUserAccidents(String username)
        throws ClassNotFoundException{
        coverages = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectCoveragesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Coverage coverage = new Coverage();
                coverage.setUsername(resultSet.getString(1));
                coverage.setType(CoverageType.valueOf(resultSet.getString(2)));
                coverage.setBiStateMinimum(resultSet.getString(3));
                coverage.setPdStateMinimum(resultSet.getInt(4));
                coverage.setDeductibleOption(DeductibleOption.valueOf(resultSet.getString(5)));
                coverages.add(coverage);
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
        return coverages;
    }
    
    public static boolean createCoverage(Coverage coverage)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_insertCoverage(?,?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, coverage.getUsername());
            callableStatement.setString(2, coverage.getType().toString());
            callableStatement.setString(3, coverage.getBiStateMinimum());
            callableStatement.setInt(4, coverage.getPdStateMinimum());
            callableStatement.setString(5, coverage.getDeductibleOption().toString());
            callableStatement.setInt(6, coverage.getMedPay());
            
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
