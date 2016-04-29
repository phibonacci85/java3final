/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Agent;
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
public class AgentDAOTest {

    public AgentDAOTest() {
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
     * Test of getUserAgent method, of class AgentDAO.
     */
    @Test
    public void testGetUserAgent() throws Exception {
        try {
            System.out.println("getUserAgent");
            String username = "";
            AgentDAO instance = new AgentDAO();

            Agent result = instance.getUserAgent(username);
            if (result.size() == 0) {
                fail("No results returned.");
            }

        } catch (Exception e) {
            fail("No agent was retrieved.");
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAgents method, of class AgentDAO.
     */
    @Test
    public void testGetAgents() throws Exception {
        try {
            System.out.println("getAgents");
            AgentDAO instance = new AgentDAO();
            List<Agent> result = instance.getAgents();
            if (result.size() == 0) {
                fail("No results returned.");
            }

        } catch (Exception e) {
            fail("no Agent retrieved");
        }
    }

    /**
     * Test of createAgent method, of class AgentDAO.
     */
    @Test
    public void testCreateAgent() throws Exception {
        try {
            System.out.println("createAgent");
            Agent agent = null;
            AgentDAO instance = new AgentDAO();

            boolean result = instance.createAgent(agent);

        } catch (Exception e) {
           fail("Exception was thrown.");
        }

    }
}
