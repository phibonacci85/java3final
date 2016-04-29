/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Accident;
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
public class AccidentDAOTest {

    public AccidentDAOTest() {
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
     * Test of getAccidentsByAccidentId method, of class AccidentDAO.
     */
    @Test
    public void testGetAccidentsByAccidentIdInvalid() throws Exception {
        System.out.println("getAccidentsByAccidentId");
        try {
            int accidentId = 0;
            Accident result = AccidentDAO.getAccidentsByAccidentId(accidentId);
            fail("Didn't catch invalid id.");
        } catch (IllegalArgumentException iae) {
        }
    }

    /**
     * Test of getAccidentsByAccidentId method, of class AccidentDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAccidentsByAccidentIdValid() throws Exception {
        System.out.println("getAccidentsByAccidentId");

        try {
            int accidentId = 1;
            Accident result = AccidentDAO.getAccidentsByAccidentId(accidentId);
            assertEquals(accidentId, result.getAccidentId());
        } catch (IllegalArgumentException iae) {
            fail("Didn't catch invalid id.");
        }

    }

    /**
     * Test of getAccidents method, of class AccidentDAO.
     */
    @Test
    public void testGetAccidents() throws Exception {
        System.out.println("getAccidents");
        try {
            
            //List<Accident> expResult = null;

            List<Accident> result = AccidentDAO.getAccidents();
            //assertEquals(expResult, result);
            if (result.size() == 0) {
                fail("No results returned.");
            }

        } catch (Exception e) {
            fail("Threw exception. " + e.getMessage());
        }
        /*
         List<Accident> expResult = null;
         List<Accident> result = AccidentDAO.getAccidents();
         assertEquals(expResult, result);
         // TODO review the generated test code and remove the default call to fail.
         fail("The test case is a prototype.");
         */
    }

    /**
     * Test of getAccidentsByDriverId method, of class AccidentDAO.
     */
    @Test
    public void testGetAccidentsByDriverId() throws Exception {
        System.out.println("getAccidentsByDriverId");
        try {
            int driverId = 0;
            List<Accident> result = AccidentDAO.getAccidentsByDriverId(driverId);
            fail("Didn't catch invalid id.");
        } catch (Exception e) {
        }
    }

    /**
     * Test of createAccident method, of class AccidentDAO.
     */
    @Test
    public void testCreateAccident() throws Exception {
        System.out.println("createAccident");
        try{
        Accident accident = new Accident();
        boolean result = AccidentDAO.createAccident(accident);
        }catch(Exception e){
      fail("Accident was not created.");

    }

    }
}