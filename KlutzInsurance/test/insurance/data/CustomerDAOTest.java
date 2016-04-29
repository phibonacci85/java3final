/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Customer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ruth
 */
public class CustomerDAOTest {

    public CustomerDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUserCustomer method, of class CustomerDAO.
     */
    @Test
    public void testGetUserCustomer() throws Exception {
        System.out.println("getUserCustomer");
        try {
            String username = "";
            CustomerDAO instance = new CustomerDAO();
            Customer result = instance.getUserCustomer(username);
        } catch (Exception e) {
            fail("Exception was thrown.");

        }

    }

    /**
     * Test of getCustomers method, of class CustomerDAO.
     */
    @Test
    public void testGetCustomers() throws Exception {
        System.out.println("getCustomers");
        try {
            List<Customer> result = CustomerDAO.getCustomers();
        } catch (Exception e) {
            fail("Exception was thrown.");
        }
    }

    /**
     * Test of createCustomer method, of class CustomerDAO.
     */
    @Test
    public void testCreateCustomer() throws Exception {
        System.out.println("createCustomer");
        try {
            Customer customer = null;
            boolean result = CustomerDAO.createCustomer(customer);
        } catch (Exception e) {
            fail("Exception was thrown.");
        }
    }

}
