/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Nobilis
 */
public class CompareSchedule {
    
    public int firstCompare (int a, int b, int c, int d){
        int compare = 0;
        if ((a==0&b==0)&(c!=0|d!=0))compare = -1;
        if ((a!=0|b!=0)&(c==0&d==0))compare = 1;
        return compare;
    }
    
    public int secondCompare (int a, int b){
        int compare = 0;
        if(a==0&b!=0)compare = -1;
        if(a!=0&b==0)compare = 1;
        return compare;
    }
    
    public int thirdCompare (int day, int a, int b){
        int compare = 0;
        if(a>b)compare = -1;
        if(a<b)compare = 1;
        if(a<day&b>=day)compare = -1;
        if(a>=day&b<day)compare = 1; 
        return compare;
    }
   
}
