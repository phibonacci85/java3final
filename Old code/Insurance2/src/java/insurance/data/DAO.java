/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author phibo_ruamh0b
 */
public class DAO {
    private String dbUrl;
    private String dbName;
    private String dbUserName;
    private String dbUserPassword;
    
    public DAO() {
        this.dbUrl = "localhost";
        this.dbName = "j3project";
        this.dbUserName = "root";
        this.dbUserPassword = "password";
    }
    
//    public Customer getCustomerById(String customerId) throws SQLException {
//        Customer cust = null;
//        try{
//            DatabaseConnectionFactory factory = DatabaseConnectionFactory.getInstance();
//            Connection conn = factory.getConnection(DatabaseType.MYSQL, dbName, dbUserName, dbUserPassword);
//            CallableStatement callableStatement = conn.prepareCall("{ call get_customer_by_id(?) }");
//            callableStatement.setString(1, customerId);
//            ResultSet resultSet = callableStatement.executeQuery();
//            if(resultSet.next()){
//                int customer_id = resultSet.getInt(1);
//                String customer_name = resultSet.getString(2);
//                String street_address = resultSet.getString(3);
//                String zip_code = resultSet.getString(4);
//                cust = new Customer(customer_id, customer_name, street_address, zip_code);
//            }
//            return cust;
//        }catch(ClassNotFoundException ex){
//            return null;
//        }
//    }
    
    /**
     * @return the dbUrl
     */
    public String getDbUrl() {
        return dbUrl;
    }

    /**
     * @param dbUrl the dbUrl to set
     */
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    /**
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * @param dbName the dbName to set
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * @return the dbUserName
     */
    public String getDbUserName() {
        return dbUserName;
    }

    /**
     * @param dbUserName the dbUserName to set
     */
    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    /**
     * @return the dbUserPassword
     */
    public String getDbUserPassword() {
        return dbUserPassword;
    }

    /**
     * @param dbUserPassword the dbUserPassword to set
     */
    public void setDbUserPassword(String dbUserPassword) {
        this.dbUserPassword = dbUserPassword;
    }
}
