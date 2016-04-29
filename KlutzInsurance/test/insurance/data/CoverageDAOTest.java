/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Coverage;
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
public class CoverageDAOTest {

    public CoverageDAOTest() {
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
     * Test of getCoverageByCoverageId method, of class CoverageDAO.
     */
    @Test
    public void testGetCoverageByCoverageIdInvalid() throws Exception {
        try {
            int coverageId = 0;
            Coverage result = CoverageDAO.getCoverageByCoverageId(coverageId);
            fail("Didn't catch invalid id.");
        } catch (IllegalArgumentException iae) {
        }

    }

    /**
     * Test of getCoverageByCoverageId method, of class CoverageDAO.
     */
    @Test
    public void testGetCoverageByCoverageValid() throws Exception {
        try {
            int coverageId = 1;
            Coverage result = CoverageDAO.getCoverageByCoverageId(coverageId);
            assertEquals(coverageId, result.getCoverageId());
        } catch (IllegalArgumentException iae) {
        }

    }

    /**
     * Test of getCoverages method, of class CoverageDAO.
     */
    @Test
    public void testGetCoverages() throws Exception {
        System.out.println("getCoverages");
        try {

            List<Coverage> result = CoverageDAO.getCoverages();

            if (result.size() == 0) {
                fail("No results returned.");
            }

        } catch (Exception e) {
            fail("Threw exception. " + e.getMessage());
        }
        /*
         List<Coverage> expResult = null;
         List<Coverage> result = CoverageDAO.getCoverages();
         assertEquals(expResult, result);
         // TODO review the generated test code and remove the default call to fail.
         fail("The test case is a prototype.");*/
    }

    /**
     * Test of getUserCoverages method, of class CoverageDAO.
     */
    @Test
    public void testGetUserCoverages() throws Exception {
        System.out.println("getUserCoverages");
        try {
            String username = "";

            List<Coverage> result = CoverageDAO.getUserCoverages(username);
        } catch (Exception e) {
            fail("Exception was thrown.");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of createCoverage method, of class CoverageDAO.
     */
    @Test
    public void testCreateCoverage() throws Exception {
        System.out.println("createCoverage");
        try{
        Coverage coverage = null;

        boolean result = CoverageDAO.createCoverage(coverage);
        }
        catch(Exception e){
            fail("Exception was thrown.");
        }
    }

}
