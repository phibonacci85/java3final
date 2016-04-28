/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Violation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class ViolationDAO {
    private static List<Violation> violations = new ArrayList<>();
    
    public static List<Violation> getUserViolations(String username){
        return violations;
    }
}
