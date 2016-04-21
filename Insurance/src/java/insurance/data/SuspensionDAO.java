/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Suspension;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class SuspensionDAO {
    private static List<Suspension> suspensions = new ArrayList<Suspension>();
    
    public static List<Suspension> getUserSuspensions(String username){
        return suspensions;
    }
}
