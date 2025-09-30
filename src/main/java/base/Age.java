/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.time.Year;

/**
 *
 * @author Nobilis
 */
public class Age {
    private String fst;
    private String snd;
    public Age(String fistDate, String secondDate){
        fst = fistDate;
        snd = secondDate;
    }
    
    private int[] parceDate (String s){
        int[] date = new int[3];
// Парсинг строкового представления чисел с учетом того, 
// что цифры в ANSI начинаются с 48 символа 
        try {
            date[0] = ((int) s.charAt(0)) * 1000
                    + ((int) s.charAt(1)) * 100
                    + ((int) s.charAt(2) * 10)
                    + (int) s.charAt(3) - 53328;
            date[1] = (int) s.charAt(5) * 10
                    + (int) s.charAt(6) - 528;
            date[2] = (int) s.charAt(8) * 10
                    + (int) s.charAt(9) - 528;
        } catch (StringIndexOutOfBoundsException e) {
            date[0]=date[1]=date[2]=0;
        }
        return date;
    }
    
    public int[] getAge(){
        int[] age=new int[3];
        int years;
        int months;
        int days;
        int[] f = parceDate(fst);
        int[] s = parceDate(snd);
        if (f[2]!=0) {
            years = s[0] - f[0];
            months = s[1] - f[1];
            if (s[1] < f[1]) {
                months +=12;
                years--;
            }
            days = s[2] - f[2];
            if (days<0) {
                months--;
                if (months < 0) {
                    months+=12;
                    years--;
                }
// Количество дней считается с учётом количества дней в предыдущем месяце (28, 29, 30, 31)
                if (s[1] == 2 | s[1] == 4 | s[1] == 6 | s[1] == 8 | s[1] == 9 | s[1] == 11 | s[1] == 1) {
                    days += 31;
                } else if (s[1] == 5 | s[1] == 7 | s[1] == 10 | s[1] == 12) {
                    days += 30;
                } else {
                    if (Year.isLeap(s[0])) {
                        days += 29;
                    } else {
                        days += 28;
                    }
                }
            }
            age[0] = years;            
            age[1] = months;
            age[2] = days;
        } else {age[0]=age[1]=age[2]=147483647;
        }
        return age;
    }
    
    public String parceAge(){
        String age = " лет ";
        int a[] = getAge();
        if(a[0]==147483647)age="нет данных"; // число произвольное
        else {
            if (a[0] % 10 == 1 & a[0] % 100 != 11) {
                age = " год ";
            } else if ((a[0] % 10 == 2 & a[0] % 100 != 12) | (a[0] % 10 == 3 & a[0] % 100 != 13)
                    | (a[0] % 10 == 4 & a[0] % 100 != 14)) {
                age = " года ";
            }
            age = a[0] + age + a[1] + " мес. " + a[2];
            if (a[2] % 10 == 1 & a[2] % 100 != 11) {
                age = age + " день";
            } else if ((a[2] % 10 == 2 & a[2] % 100 != 12) | (a[2] % 10 == 3 & a[2] % 100 != 13)
                    | (a[2] % 10 == 4 & a[2] % 100 != 14)) {
                age = age + " дня";
            } else {
                age = age + " дней";
            }
        }
        return age;
    }
}
