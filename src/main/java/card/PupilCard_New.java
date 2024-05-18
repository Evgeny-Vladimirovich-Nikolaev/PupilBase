/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card;

import base.Pupil;
import presentations.List_Layout;

import java.util.ArrayList;


/**
 *
 * @author Nobilis
 * In getNewRecord() there is an unsafe getting hours method
 * In Ok() there is no handling out of bounds exceptions
 */
public class PupilCard_New extends PupilCard_Model{
    protected String[] allProperties;
    
    public PupilCard_New(ArrayList currentBase, List_Layout list) {
        super(currentBase, list);
        this.setTitle(getPupilCardTitle());
        documents = new boolean[12];
        //allProperties = new String[30];
    }
    
    public PupilCard_New(ArrayList currentBase, Pupil pupil, List_Layout list) {
        super(currentBase, list);
        this.pupil = pupil;
        this.setTitle(getPupilCardTitle());
        documents = new boolean[12];
        allProperties = new String[30];
    }
    
    protected String getPupilCardTitle(){
        System.out.println("PupilCard_New");
        return "Новая запись";
    }
    
    protected void getNewRecord(){
        int[] days = new SheduleChecker(box_First, box_Second, box_Third).days;
        pupil = new Pupil(
            allProperties, 
            documents, 
            days,  
            (double)box_Hours.getSelectedIndex()/2);
        System.out.println("класс кард-нью, метод гетНьюРекорд: " + pupil.getAll());
    }
    
    protected void getAllProperties(){
        allProperties = new String[32];
        allProperties[0] = field_Last_Name.getText();
        allProperties[1] = field_First_Name.getText();
        allProperties[2] = field_Patronymic_Name.getText();
        allProperties[3] = (String)box_Gender.getSelectedItem();
        allProperties[4] = field_Speciality.getText();
        allProperties[5] = field_Instrument.getText();
        allProperties[6] = convertDate((String)box_Year_Born.getSelectedItem(), 
                (String)box_Date_Born.getSelectedItem(), 
                box_Month_Born.getSelectedIndex());
        allProperties[7] = convertDate((String)box_Year_Enrolment.getSelectedItem(), 
                (String)box_Date_Enrolment.getSelectedItem(), 
                box_Month_Enrolment.getSelectedIndex());
        allProperties[8] = (String)box_School.getSelectedItem();
        allProperties[9] = (String)box_School_Number.getSelectedItem();
        allProperties[10] = getSchoolClass();
        allProperties[11] = field_Phone.getText();
        allProperties[12] = changeString(area_Adress.getText());
        allProperties[13] = getFIO (field_Mother_Last_Name.getText(), field_Mother_First_Name.getText(), 
                field_Mother_Patronymic.getText());
        allProperties[14] = field_Mother_Phone.getText();
        allProperties[15] = area_Mother_Work.getText();
        allProperties[16] = field_Mother_Post.getText();
        allProperties[17] = getFIO (field_Father_Last_Name.getText(), field_Father_First_Name.getText(), 
                field_Father_Patronymic.getText());
        allProperties[18] = field_Father_Phone.getText();
        allProperties[19] = area_Father_Work.getText();
        allProperties[20] = field_Father_Post.getText();
        allProperties[21] = (String)box_Program.getSelectedItem();
        allProperties[22] = (String)box_Class.getSelectedItem();
        allProperties[23] = field_Spec_Teacher.getText();
        allProperties[24] = field_Theor_Teacher.getText();
        allProperties[25] = field_Choir_Teacher.getText();
        allProperties[26] = field_Piano_Teacher.getText();
        allProperties[27] = field_Ensemble_Teacher.getText();
        allProperties[28] = changeString(area_1_Semester.getText());
        allProperties[29] = changeString(area_2_Semester.getText());
        allProperties[30] = changeString(area_Notes.getText());
        allProperties[31] = "";
        for(int row=0; row<6; row++){
            for(int column=1; column<8; column++){
                allProperties[31]+= 
                        (String)table_Achievment.getValueAt(row, column) + "¤";
            }
        }
    }
    
    String getFIO (String lName, String fName, String pName){
        return lName + '¤' + fName + '¤' + pName;
    }
    
    String convertDate(String year, String date, int index){
        String temp;
        switch(index){
            case 1: temp = "01";break;
            case 2: temp = "02";break;
            case 3: temp = "03";break;
            case 4: temp = "04";break;
            case 5: temp = "05";break;
            case 6: temp = "06";break;
            case 7: temp = "07";break;
            case 8: temp = "08";break;
            case 9: temp = "09";break;
            case 10: temp = "10";break;
            case 11: temp = "11";break;
            case 12: temp = "12";break;
            default: temp = " ";
        }
        return year + '-' + temp + '-' + date;
    }
    
    String changeString(String str){
        str=str.replace('\t', '¤');
        str=str.replace('\n', '¬');
        return str;
    }
    
    String getSchoolClass(){
        String schoolClass = (String)box_School_Class.getSelectedItem();
        if(!schoolClass.equals(" ")) schoolClass 
                += (String)box_School_Class_Letter.getSelectedItem();
        else schoolClass += " ";
        return schoolClass;
    }
    
    @Override
    protected void Ok() {
        getAllProperties();
        getNewRecord();
        currentBase.add(index, pupil);
        list.getTable();
        this.dispose();
    }

    @Override
    protected void cancel() {
        this.dispose();
    }
}

