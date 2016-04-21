/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Policy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class PolicyDAO {
    private static List<Policy> policies = new ArrayList<Policy>();
    
    public static List<Policy> getUserPolicies(String username){
        return policies;
    }
}
