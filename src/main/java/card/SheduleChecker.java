/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package card;

/**
 *
 * @author Nobilis
 */
public final class SheduleChecker {
    
    /*int first = 0, second = 0, third = 0;
        double hours = 0;
        if(!" ".equals((String)box_First.getSelectedItem()))first = valueOfDay((String)box_First.getSelectedItem());
        if(!" ".equals((String)box_Second.getSelectedItem()))second = valueOfDay((String)box_Second.getSelectedItem());
        if(!" ".equals((String)box_Third.getSelectedItem()))third = valueOfDay((String)box_Third.getSelectedItem());
        if(!" ".equals((String)box_Hours.getSelectedItem()))hours = Double.parseDouble(((String)box_Hours.getSelectedItem()).replace(',', '.'));
        if(first>second&&second!=0){
        int t = first;
        first = second;
        second = t;
        }*/
        
    private final javax.swing.JComboBox box_First, box_Second, box_Third;
    protected int[] days = new int[3];
    
    SheduleChecker(javax.swing.JComboBox box_First, 
            javax.swing.JComboBox box_Second, 
            javax.swing.JComboBox box_Third){
        this.box_First = box_First;
        this.box_Second = box_Second;
        this.box_Third = box_Third;
        initVariable();
        sort();
        check();
        }
    
    private void initVariable(){
        days[0] = valueOfDay(box_First.getSelectedItem().toString());
        days[1] = valueOfDay(box_Second.getSelectedItem().toString());
        days[2] = valueOfDay(box_Third.getSelectedItem().toString());
    }
    
    private void sort(){
        for(int i = 0; i < 2; i++){
            for(int k = i + 1; k < 3; k++){
                if(days[i] > days[k]){
                    int t = days[i];
                    days[i] = days[k];
                    days[k] = t;
                }
            }
        }
    }
    
    private int valueOfDay(String day){
        int d;
        switch (day) {
            case "Понедельник" : d = 1; break;
            case "Вторник" : d = 2; break;
            case "Среда" : d = 3; break;
            case "Четверг" : d = 4; break;
            case "Пятница" : d = 5; break;
            case "Суббота" : d = 6; break;
            case "Воскресенье" : d = 7; break;
            default: d = 8;
        }
        return d;    
    }
    
    private void check(){
        for(int day : days) if(day == 8) day = 0;
        for(int day : days) System.out.println("SheduleChecker.check " + day);
    }
}
