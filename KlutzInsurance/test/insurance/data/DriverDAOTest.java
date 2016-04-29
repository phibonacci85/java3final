/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Driver;
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
public class DriverDAOTest {

    public DriverDAOTest() {
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
     * Test of getDriverByLiscenseNumber method, of class DriverDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetDriverByLiscenseNumberInvalid() throws Exception {
        System.out.println("getDriverByLiscenseNumber");
        try {
            String liscenseNumber = "";
            Driver result = DriverDAO.getDriverByLiscenseNumber(liscenseNumber);
            fail("Didn't catch invalid license number.");
        } catch (Exception e) {
            fail("Exception was thrown");
        }

    }

    /**
     * Test of getDriverByLiscenseNumber method, of class DriverDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetDriverByLiscenseNumberValid() throws Exception {
        System.out.println("getDriverByLiscenseNumber");
        try {
            String liscenseNumber = "123xx456";
            Driver result = DriverDAO.getDriverByLiscenseNumber(liscenseNumber);
            assertEquals(liscenseNumber, result.getLicenseNumber());
        } catch (Exception e) {
            fail("Exception was thrown");
        }

    }

    /**
     * Test of getDrivers method, of class DriverDAO.
     */
    @Test
    public void testGetDrivers() throws Exception {
        System.out.println("getDrivers");
        try {
            List<Driver> result = DriverDAO.getDrivers();
            if (result.size() == 0) {
                fail("No results returned.");
            }
        } catch (Exception e) {
            fail("Exception was thrown.");
        }
    }

    /**
     * Test of getVehicleDrivers method, of class DriverDAO.
     */
    @Test
    public void testGetVehicleDrivers() throws Exception {
        System.out.println("getVehicleDrivers");
        int vehicleId = 0;
        List<Driver> result = DriverDAO.getVehicleDrivers(vehicleId);

    }

    /**
     * Test of getUserDrivers method, of class DriverDAO.
     */
    @Test
    public void testGetUserDrivers() throws Exception {
        System.out.println("getUserDrivers");
        try {
            String username = "";
            if (username == null) {
                List<Driver> result = DriverDAO.getUserDrivers(username);
                fail("Didn't catch invalid userName.");
            } else {
                username = "myUserName";
                List<Driver> result = DriverDAO.getUserDrivers(username);
            }
        } catch (Exception e) {
            fail("Exception was thrown.");
        }

    }

    /**
     * Test of createDriver method, of class DriverDAO.
     */
    @Test
    public void testCreateDriver() throws Exception {
        System.out.println("createDriver");
        try {
            Driver driver = null;
            if (driver == null) {
                boolean result = DriverDAO.createDriver(driver);
                fail("Didn't catch invalid driver info.");
            } else {
                boolean result = DriverDAO.createDriver(driver);
            }
        } catch (Exception e) {
            fail("Exception was thrown.");
        }
    }

}
