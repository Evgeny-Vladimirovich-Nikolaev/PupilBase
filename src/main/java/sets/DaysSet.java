/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sets;

/**
 *
 * @author Nobilis
 */
public class DaysSet {
    
    private static String[] days;
        
    static {
        days = new String[32];
        days[0] = " ";
        for(int i = 1; i < 10; i++) {
            days[i] = "0" + i;
        }
        for(int i = 10; i < 32; i++) {
            days[i] = String.valueOf(i);
        }
    }
    
    public static String[] getDays() {
        return days;
    }
    
}
