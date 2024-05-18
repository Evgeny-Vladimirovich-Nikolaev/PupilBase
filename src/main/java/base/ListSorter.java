/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;

/**
 *
 * @author Nobilis
 */
public class ListSorter {
    private ArrayList<Pupil> Temp;
    int [] levels;
    int [] settings;
    String Date;
    int count;//Счётчик уровней сортировки; обнуляется после необходимого количества сравнений 2 элементов
    int min;
    int in;

    public ListSorter(ArrayList Base, int[] lev, int[] sett, String D) {
        Temp = Base;
        levels = lev;
        settings = sett;
        Date = D;
        start();
    }
    
    private void start(){
// Сортировка выбором        
        for (int out=0; out<Temp.size()-1 ; out++){
            min=out;
        for (in=min+1; in<Temp.size(); in++){
            selectOrder();
            count=0;}
        if(min!=out)swap(out);
        }
    }
    
    private void selectOrder() {
//Метод обращается к массиву lelvels, передающемуся в конструктор из SortSetting 
//и отражающему критерии многоуровневой сортировки     
        switch(levels[count]){
            case 0 : break;
            case 1 : compareName (); break;
            case 2 : compareAge (); break;
            case 3 : compareSchedule (); break;
            case 4 : compareProgramme (in); break;
            case 5 : compareClass (); break;
            case 6 : compareSpecialty (in); break;
            case 7 : compareHours (in); break;
            case 8 : compareTeacher (in); break;
        }
    }
    
    private void compareName(){
        CyrillicCompare cyrillic = new CyrillicCompare(Temp.get(min).getName(), Temp.get(in).getName());
        if(cyrillic.caseInsensitive()<0&&
        (settings[count]==0)
        ||(cyrillic.caseInsensitive()>0&&
        (settings[count]==1)))min = in;
        else if(cyrillic.caseInsensitive()==0)resume();
    }
    
   private void compareAge(){
        if((Temp.get(min).getDateBirth().compareTo(Temp.get(in).getDateBirth())<0&&
                (settings[count]==0|settings[count]==2))
                ||(Temp.get(min).getDateBirth().compareTo(Temp.get(in).getDateBirth())>0&&
                (settings[count]==1|settings[count]==3)))min = in;
        else if(Temp.get(min).getDateBirth().compareTo(Temp.get(in).getDateBirth())==0)resume();
    }
    
    private void compareSchedule (){
        CompareSchedule cs = new CompareSchedule();
        int day = settings[count]+1;
        int fMin, sMin, fIn, sIn;
        int compare;
        if(Temp.get(min).getFirst()>Temp.get(min).getSecond()&Temp.get(min).getSecond()!=0){
            int temp = Temp.get(min).getFirst();
            Temp.get(min).setFirst(Temp.get(min).getSecond()); 
            Temp.get(min).setSecond(temp);
        }
        if(Temp.get(min).getFirst()<day&Temp.get(min).getSecond()>=day){
            int temp = Temp.get(min).getFirst();
            Temp.get(min).setFirst(Temp.get(min).getSecond()); 
            Temp.get(min).setSecond(temp);
        }
        if(Temp.get(in).getFirst()>Temp.get(in).getSecond()&Temp.get(in).getSecond()!=0){
            int temp = Temp.get(in).getFirst();
            Temp.get(in).setFirst(Temp.get(in).getSecond()); 
            Temp.get(in).setSecond(temp);
        }
        if(Temp.get(in).getFirst()<day&Temp.get(in).getSecond()>=day){
            int temp = Temp.get(in).getFirst();
            Temp.get(in).setFirst(Temp.get(in).getSecond()); 
            Temp.get(in).setSecond(temp);
        }
        fMin = Temp.get(min).getFirst();
        sMin = Temp.get(min).getSecond();
        fIn = Temp.get(in).getFirst();
        sIn = Temp.get(in).getSecond();
        
        compare = cs.firstCompare(fMin, sMin, fIn, sIn);
        if(compare==0)compare=cs.secondCompare(fMin, fIn);
        if(compare==0)compare=cs.secondCompare(sMin, sIn);
        if(compare==0)compare=cs.thirdCompare(day, fMin, fIn);
        if(compare==0)compare=cs.thirdCompare(day, sMin, sIn);
        if(compare==-1)min=in;
        if(compare==0)resume();
    }
      
    private void compareProgramme(int i){
        int first=programmeNumber(Temp.get(min).getProgram());
        int second=programmeNumber(Temp.get(i).getProgram());
        if(second<first)min=i;
        else if(second==first)resume();
    }
    
    private int programmeNumber(String p){
        int prog=4;
        switch(p){
            case "ДПОП" : prog=0; break;
            case "ДОП" : prog=1; break;
            case "ДООП" : prog=2; break;
            case "ДПУ" : prog=3; break;
        }
        return prog;
    }
    
    private void compareClass(){
        int first = scanString(Temp.get(min).getKlass());
        int second = scanString(Temp.get(in).getKlass());
        if(first>second&settings[count]==0||first<second&settings[count]==1)min = in;
        else if(first==second)resume();
    }
    private int scanString (String s){
        int klass;
        try {klass = Integer.valueOf(s);
        }catch(NumberFormatException e){
        klass = 0;
        }
        return klass;
    }
    
    private void compareSpecialty (int i){
        String first = Temp.get(min).getSpeciality();
        String second = Temp.get(i).getSpeciality();
        if(second=="")second="яя";
        if(first=="")first="я";
        compareAlfabet(i, first, second);
    }
    
    private void compareHours (int i){
        if(Temp.get(min).getHours()<Temp.get(i).getHours())min=i;
        else if (Temp.get(min).getHours()==Temp.get(i).getHours())resume();
    }
    
    private void compareTeacher (int i){
        String first="", second="";
        switch(settings[count]){
            case 0 : first=Temp.get(min).getSpesTeacher();
            second=Temp.get(i).getSpesTeacher();
            break;
            case 1 : first=Temp.get(min).getTheorTeacher();
            second=Temp.get(i).getTheorTeacher();
            break;
            case 2 : first=Temp.get(min).getChoirTeacher();
            second=Temp.get(i).getChoirTeacher();
            break;
        }
        compareAlfabet(i, first, second);  
    }
    
    private void compareAlfabet(int i, String first, String second){
        CyrillicCompare cyrillic = new CyrillicCompare(first, second);
        if(cyrillic.caseInsensitive()<0)min = i;
        else if(cyrillic.caseInsensitive()==0)resume();
    }

// Метод вызывается, если при сравнении двух элементов возвращается равенство
    private void resume(){
        if(count<4){
        count++;
        selectOrder();
        }
    }
    
    private void swap(int out){
        Temp.add(out, Temp.get(min));
        Temp.add(min+1, Temp.get(out+1));
        Temp.remove(out+1);
        Temp.remove(min+1);
    }

}