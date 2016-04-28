/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Accident;
import insurance.model.Agent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristi
 */
public class AgentDAO {
    
    Agent agent = new Agent();
    
    public Agent getUserAccidents(String username)
        throws ClassNotFoundException{
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectAgentByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                agent.setUsername(resultSet.getString(1));
                agent.setFirstname(resultSet.getString(2));
                agent.setLastname(resultSet.getString(3));
                agent.setDOB(resultSet.getDate(4));
                agent.setAddress(resultSet.getString(5));
                agent.setPhone(resultSet.getInt(6));
                agent.setPayGrade(resultSet.getString(7));
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
        return agent;
    }
    
    public static boolean createAgent(Agent agent)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_insertAgent(?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, agent.getUsername());
            callableStatement.setString(2, agent.getFirstname());
            callableStatement.setDate(3, (java.sql.Date) agent.getDOB());
            callableStatement.setString(4, agent.getAddress());
            callableStatement.setInt(5, agent.getPhone());
            callableStatement.setString(6, agent.getPayGrade());
            
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
