/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sets;

import java.time.LocalDateTime;

/**
 *
 * @author Nobilis
 */
public class YearsSet {
    
    private static int currentYear;
    
    static {
        LocalDateTime now = LocalDateTime.now();
        currentYear = now.getYear();
    }
    
    public static String[] getSet() {
        return getSet(0);
    }
    
    public static String[] getSet(int addedYears) {
        final String[] years = new String[100];
        years[0] = " ";
        for(int i = 1; i < 100; i++) {
            years[i] = String.valueOf(currentYear + addedYears - i + 1);
        }
        return years;
    }
    
}
