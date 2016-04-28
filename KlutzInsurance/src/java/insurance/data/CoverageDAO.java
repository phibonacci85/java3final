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
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class CoverageDAO {
    
    private static List<Coverage> coverages = new ArrayList<>();
    private static Coverage coverage = new Coverage();
    
    /**
     * gets the coverage by the coverageId
     * @param coverageId
     * @return
     * @throws ClassNotFoundException 
     */
    public static Coverage getCoverageByCoverageId(int coverageId)
        throws ClassNotFoundException{
        coverages = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectCoverageByCoverageId(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            int id = coverageId;
            
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                coverage.setCoverageId(resultSet.getInt(1));
                coverage.setUsername(resultSet.getString(2));
                coverage.setType(CoverageType.valueOf(resultSet.getString(3)));
                coverage.setBiStateMinimum(resultSet.getString(4));
                coverage.setPdStateMinimum(resultSet.getInt(5));
                coverage.setDeductibleOption(DeductibleOption.valueOf(resultSet.getString(6)));
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
        return coverage;
    }
    
    /**
     * gets all coverages
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Coverage> getCoverages()
        throws ClassNotFoundException{
        coverages = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectCoveragesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Coverage coverage = new Coverage();
                coverage.setCoverageId(resultSet.getInt(1));
                coverage.setUsername(resultSet.getString(2));
                coverage.setType(CoverageType.valueOf(resultSet.getString(3)));
                coverage.setBiStateMinimum(resultSet.getString(4));
                coverage.setPdStateMinimum(resultSet.getInt(5));
                coverage.setDeductibleOption(DeductibleOption.valueOf(resultSet.getString(6)));
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
    
    /**
     * gets all the coverages by by the user from the username
     * @param username
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Coverage> getUserCoverages(String username)
        throws ClassNotFoundException{
        coverages = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectCoveragesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Coverage coverage = new Coverage();
                coverage.setCoverageId(resultSet.getInt(1));
                coverage.setUsername(resultSet.getString(2));
                coverage.setType(CoverageType.valueOf(resultSet.getString(3)));
                coverage.setBiStateMinimum(resultSet.getString(4));
                coverage.setPdStateMinimum(resultSet.getInt(5));
                coverage.setDeductibleOption(DeductibleOption.valueOf(resultSet.getString(6)));
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
    
    /**
     * creates a coverage record
     * @param coverage
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean createCoverage(Coverage coverage)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_insertCoverage(?,?,?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setInt(1, coverage.getCoverageId());
            callableStatement.setString(2, coverage.getUsername());
            callableStatement.setString(3, coverage.getType().toString());
            callableStatement.setString(4, coverage.getBiStateMinimum());
            callableStatement.setInt(5, coverage.getPdStateMinimum());
            callableStatement.setString(6, coverage.getDeductibleOption().toString());
            callableStatement.setInt(7, coverage.getMedPay());
            
            if(!callableStatement.execute()) {
                int updateCount = callableStatement.getUpdateCount();
                if(updateCount == 1) {
                    succeeded = true;
                }
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
        return succeeded;
    }
}
