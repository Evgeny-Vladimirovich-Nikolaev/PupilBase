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
 */
public class PupilCard_Editor extends PupilCard_New{
    
    private final ArrayList deleteBase;
    
    public PupilCard_Editor(ArrayList currentBase, ArrayList deleteBase, Pupil pupil, List_Layout list, int index){
        super(currentBase, pupil, list);
        this.index = index;
        this.deleteBase = deleteBase;
        this.setTitle(getPupilCardTitle());
        copyDocuments();
        rewriteFields();
    }
    
    @Override
    protected String getPupilCardTitle(){
        return ("Изменить запись " + pupil.getName());
    }
    
    protected void copyDocuments(){
        for(int i = 0; i < 12; i++)
            documents[i] = pupil.getDocuments()[i] == true;
    }
    
    private void rewriteFields(){
        resetSchools();
        resetSchoolNumbers();
        resetSchoolClasses();
        resetClassLetters();
        resetGender();
        resetDates();
        resetProgram();
        resetClasses();
        resetHours();
        resetWeek();
        resetDocuments();
        resetFields();
        resetAchievmentTable();
        setTableSettings();
    }
    
    private void resetSchools(){
        if(pupil.getSchool() != null && !" ".equals(pupil.getSchool())) 
        box_School.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] 
            {pupil.getSchool(), " ", "школа", "лицей", "гимназия", "детский сад"}));
    }
    private void resetSchoolNumbers(){
        String numbers[];
        if(pupil.getSchoolNumber() != null && !" ".equals(pupil.getSchoolNumber())) 
            {numbers = new String[42];
            numbers[0] = pupil.getSchoolNumber();
            numbers[1] = " ";
            for(int i = 2; i <42; i++){
                numbers[i] = Integer.toString(i - 1);
            }
            box_School_Number.setModel(new javax.swing.DefaultComboBoxModel<>(numbers));
        }
    }
    
    private void resetSchoolClasses(){
        if(!"  ".equals(pupil.getSchoolClass())&&pupil.getSchoolClass().length()!=0){
            StringBuilder res = new StringBuilder(pupil.getSchoolClass());
            res.deleteCharAt(pupil.getSchoolClass().length() - 1);
            box_School_Class.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] 
                {res.toString(), " ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"}));
        }
    }
    
    private void resetClassLetters(){
        if(pupil.getSchoolClass().length() != 0){
            String s = "" + pupil.getSchoolClass().charAt(pupil.getSchoolClass().length() - 1);
            if (!" ".equals(s)) box_School_Class_Letter.setModel
                (new javax.swing.DefaultComboBoxModel<>
                (new String[] {s, " ", "А", "Б", "В", "Г", "Д", "Е"}));
        }
    }
    
    private void resetGender(){
        if(!" ".equals(pupil.getGender())&&pupil.getGender().length() != 0)
            box_Gender.setModel(new javax.swing.DefaultComboBoxModel<>
        (new String[] {pupil.getGender(), " ", "мужской", "женский"}));
    }
    
    private void resetDates(){
        resetDate(box_Year_Born, box_Month_Born, box_Date_Born, pupil.getDateBirth(), 73, 2022);
        resetDate(box_Year_Enrolment, box_Month_Enrolment, box_Date_Enrolment, pupil.getEnrolment(), 26, 2026);
    }
    
    private void resetDate(javax.swing.JComboBox y, javax.swing.JComboBox m, 
    javax.swing.JComboBox d, String formatedDate, int years, int lastYear){
        String[] date = valueFromDate(formatedDate);
        if(date[0] != null && !" ".equals(date[0])){
            String[] allYears = new String [years];
            allYears[0] = date[0];
            allYears[1] = " ";
            for(int i = 2; i < years; i++){
                allYears[i] = Integer.toString(lastYear-i);
            }
            y.setModel(new javax.swing.DefaultComboBoxModel<>(allYears));}
        if(date[1] != null && !" ".equals(date[1])){
            m.setModel(new javax.swing.DefaultComboBoxModel<>
            (new String[] {monthFromDate(date[1]), " ", "январь", "февраль", 
            "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", 
            "октябрь", "ноябрь", "декабрь"}));
        }
        if(date[2] != null && !" ".equals(date[2])){
            d.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
            {date[2], " ", "01", "02", "03", "04", "05", "06", "07", "08", "09", 
            "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        }
    }
    
    private String[] valueFromDate(String date){
        String t[] = new String[] {"", "", ""}; 
        int i = 0, k = 0;
        do
            {while(i<date.length()&&date.charAt(i)!='-')
                {t[k] += date.charAt(i);
                i++;}
            i++;
            k++;
            }while(k != 3);
        return t;
    }
    
    private String monthFromDate(String m){
        String month = " ";
        switch(m){
            case "01" : month = "январь";break;
            case "02" : month = "февраль";break;
            case "03" : month = "март";break;
            case "04" : month = "апрель";break;
            case "05" : month = "май";break;
            case "06" : month = "июнь";break;
            case "07" : month = "июль";break;
            case "08" : month = "август";break;
            case "09" : month = "сентябрь";break;
            case "10" : month = "октябрь";break;
            case "11" : month = "ноябрь";break;
            case "12" : month = "декабрь";
        }
        return month;
    }
    
    private void resetProgram(){
        if(!" ".equals(pupil.getProgram()))
            box_Program.setModel(new javax.swing.DefaultComboBoxModel<>
            (new String[] {pupil.getProgram(), " ", "ДПОП", "ДООП", "ДОП", "ДПУ"}));
    }
    
    private void resetClasses(){
        if(!" ".equals(pupil.getKlass()))
            box_Class.setModel(new javax.swing.DefaultComboBoxModel<>
            (new String[] {pupil.getKlass(), " ", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
    }
    
    private void resetHours(){
        if(pupil.getHours() != 0.0)
            box_Hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] 
            {(Double.toString(pupil.getHours())).replace('.', ','), 
                " ", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5", "4,0"}));
    }
    
    private void resetWeek(){
        if(pupil.getFirst() != 0)setDay(box_First, pupil.getFirst());
        if(pupil.getSecond() != 0)setDay(box_Second, pupil.getSecond());
        if(pupil.getThird() != 0)setDay(box_Third, pupil.getThird());
    }
    
    private void setDay(javax.swing.JComboBox box_Day, int day){
        String[] week = new String[]{" ", " ", "Понедельник", "Вторник", "Среда", "Четверг", 
            "Пятница", "Суббота", "Воскресенье"};
        switch(day){
            case 1 : week[0] = "Понедельник"; break;
            case 2 : week[0] = "Вторник"; break;
            case 3 : week[0] = "Среда"; break;
            case 4 : week[0] = "Четверг"; break;
            case 5 : week[0] = "Пятница"; break;
            case 6 : week[0] = "Суббота"; break;
            case 7 : week[0] = "Воскресенье"; break;
        }
        box_Day.setModel(new javax.swing.DefaultComboBoxModel<>(week));
    }
    
    private void resetDocuments(){
        box_Statement.setSelected(pupil.getDocuments()[0]);
        box_Contract.setSelected(pupil.getDocuments()[1]);
        box_Birth_Certificate.setSelected(pupil.getDocuments()[2]);
        box_Medical_Certificate.setSelected(pupil.getDocuments()[3]);
        box_Child_SNILS.setSelected(pupil.getDocuments()[4]);
        box_Photo.setSelected(pupil.getDocuments()[5]);
        box_Mother_Passport.setSelected(pupil.getDocuments()[6]);
        box_Mother_SNILS.setSelected(pupil.getDocuments()[7]);
        box_Mother_Consent.setSelected(pupil.getDocuments()[8]);
        box_Father_Passport.setSelected(pupil.getDocuments()[9]);
        box_Father_SNILS.setSelected(pupil.getDocuments()[10]);
        box_Father_Consent.setSelected(pupil.getDocuments()[11]);
    }
    
    private void resetFields(){
        String[] motherName =  getNameFromFIO(pupil.getMotherName());
        String[] fatherName =  getNameFromFIO(pupil.getFatherName());
        field_Last_Name.setText(pupil.getLastName());
        field_First_Name.setText(pupil.getFirstName());
        field_Patronymic_Name.setText(pupil.getPatrName());
        field_Speciality.setText(pupil.getSpecialty());
        field_Instrument.setText(pupil.getInstrument());
        field_Phone.setText(pupil.getPhone());
        field_Mother_Last_Name.setText(motherName[0]);
        field_Mother_First_Name.setText(motherName[1]);
        field_Mother_Patronymic.setText(motherName[2]);
        field_Mother_Phone.setText(pupil.getMotherPhone());
        field_Mother_Post.setText(pupil.getMotherPost());
        field_Father_Last_Name.setText(fatherName[0]);
        field_Father_First_Name.setText(fatherName[1]);
        field_Father_Patronymic.setText(fatherName[2]);
        field_Father_Phone.setText(pupil.getFatherPhone());
        field_Father_Post.setText(pupil.getFatherPost());
        field_Spec_Teacher.setText(pupil.getSpesTeacher());
        field_Theor_Teacher.setText(pupil.getTheorTeacher());
        field_Choir_Teacher.setText(pupil.getChoirTeacher());
        field_Piano_Teacher.setText(pupil.getPianoTeacher());
        field_Ensemble_Teacher.setText(pupil.getEnsembleTeacher());
        area_Adress.setText(reversChangeString(pupil.getAdress()));
        area_Mother_Work.setText(reversChangeString(pupil.getMotherWork()));
        area_Father_Work.setText(reversChangeString(pupil.getFatherWork()));
        area_1_Semester.setText(reversChangeString(pupil.getRepertoire1()));
        area_2_Semester.setText(reversChangeString(pupil.getRepertoire2()));
        area_Notes.setText(reversChangeString(pupil.getNotes()));
    }
    
    private String[] getNameFromFIO(String name){
        String t[] = new String[] {"", "", ""}; 
        int i=0, k=0;
        do
            {while(i<name.length()&&name.charAt(i)!='¤')
                {t[k] += name.charAt(i);
                i++;}
            i++;
            k++;
            }while(k!=3);
        return t;
    }
    
    private String reversChangeString(String str){
        str=str.replace('¤', '\t');
        str=str.replace('¬', '\n');
        return str;
    }
    
    void resetAchievmentTable(){
        table_Achievment.setModel(new javax.swing.table.DefaultTableModel(
            regetTableContent(),
            new String [] {
                "Предмет", "I", "II", "III", "IV", "год.", "экз.", "итог."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    String[][] regetTableContent(){
        String[][] table = new String[6][8];
        int count = 0;
        table[0][0] = "Специальность";
        table[1][0] = "Сольфеджио";
        table[2][0] = "Муз. литература";
        table[3][0] = "Хор";
        table[4][0] = "Ансамбль";
        table[5][0] = "Доп. инструмент";
        for(int row=0; row<6; row++){
            for(int column=1; column<8; column++){
                table[row][column] = "";
                while(pupil.getAchievement().charAt(count)!='¤'){
                    table[row][column] += pupil.getAchievement().charAt(count);
                    count++;
                }
                count++;
            }
        }
        return table;
    }
    
    /*@Override
    protected void getNewRecord(){
    allProperties[6] = convertDate2((String)box_Year_Born.getSelectedItem(),
    (String)box_Month_Born.getSelectedItem(), (String)box_Date_Born.getSelectedItem());
    allProperties[7] = convertDate2((String)box_Year_Enrolment.getSelectedItem(),
    (String)box_Month_Enrolment.getSelectedItem(), (String)box_Date_Enrolment.getSelectedItem());
    pupil = new Pupil(allProperties, documents, days, hours);
    }*/
    
    String convertDate2(String year, String month, String date){
        String temp;
        switch(month){
            case "январь": temp = "01";break;
            case "февраль": temp = "02";break;
            case "март": temp = "03";break;
            case "апрель": temp = "04";break;
            case "май": temp = "05";break;
            case "июнь": temp = "06";break;
            case "июль": temp = "07";break;
            case "август": temp = "08";break;
            case "сентябрь": temp = "09";break;
            case "октябрь": temp = "10";break;
            case "ноябрь": temp = "11";break;
            case "декабрь": temp = "12";break;
            default: temp = " ";
        }
        return year + '-' + temp + '-' + date;
    }
    
    String convertDate(String year, String month, String date){
        String temp;
        switch(month){
            case "январь": temp = "01";break;
            case "февраль": temp = "02";break;
            case "март": temp = "03";break;
            case "апрель": temp = "04";break;
            case "май": temp = "05";break;
            case "июнь": temp = "06";break;
            case "июль": temp = "07";break;
            case "август": temp = "08";break;
            case "сентябрь": temp = "09";break;
            case "октябрь": temp = "10";break;
            case "ноябрь": temp = "11";break;
            case "декабрь": temp = "12";break;
            default: temp = " ";
        }
        return year + '-' + temp + '-' + date;
    }
    
    @Override
    protected    void cancel(){
        while(index > currentBase.size()) index--;
        currentBase.add(index, pupil);
        deleteBase.remove(pupil);
        list.getTable();
        this.dispose();
    }
    
}