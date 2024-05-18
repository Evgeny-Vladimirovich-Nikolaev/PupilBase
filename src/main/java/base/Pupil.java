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
public class Pupil {
    private int first;
    private int second;
    private int third;//version 99.41
    private double hours;
    private boolean[] documents;
    private String last_Name;
    private String first_Name;
    private String patronymic;
    private String gender;
    private String specialty;
    private String instrument;
    private String date_Birth;
    private String date_Enrolment;
    private String school;
    private String school_Number;
    private String school_Class;
    private String phone;
    private String adress;    
    private String mother_FIO;
    private String mother_Phone;
    private String mother_Work;
    private String mother_Post;
    private String father_FIO;
    private String father_Phone;
    private String father_Work;
    private String father_Post;
    private String program;
    private String music_Class;
    private String speciality_Teacher;
    private String theory_Teacher;
    private String choir_Teacher;
    private String piano_Teacher;//version 99.41
    private String ensemble_Teacher;//version 99.41
    private String repertoire1; //репертуар за 1 полугодие
    private String repertoire2; //репертуар за 2 полугодие
    private String notes; //заметки
    private String achievement; //успеваемость
    
    
    
    
////////////////////////////////////////
    
    public Pupil(){}
    
    public Pupil(String[] args){
        first = Integer.valueOf(args[30]);
        second = Integer.valueOf(args[31]);
        hours = Double.parseDouble(args[32]);
        documents = new boolean[12];
        strToDocuments(args[33]);
        addOtherProperties(args);
    }
    
    public Pupil(String[] args, int version){
        switch(version){
            case 3 : parseVersion3(args);
                //break;
        }
        addNewFormatOtherProperties(args);
    }
    
    public Pupil(String[] args, boolean[] documents, int[] days, double hours){
        this.documents = documents;
        this.first = days[0];
        this.second = days[1];
        this.third = days[2];//version 99.41
        this.hours = hours;
        addNewFormatOtherProperties(args);
    }
    
    private void parseVersion3(String[] args){
        first = Integer.valueOf(args[32]);
        second = Integer.valueOf(args[33]);
        third = Integer.valueOf(args[34]);
        hours = Double.parseDouble(args[35]);
        documents = new boolean[12];
        strToDocuments(args[36]);
        addOtherProperties(args);
    }
    
    private void addOtherProperties(String[] args){
        setLastName(args[0]);
        setFirstName(args[1]);
        setPatronymic(args[2]);
        setGender(args[3]);
        setSpecialty(args[4], args[5]);
        setDateBirth(args[6]);
        setEnrolment(args[7]);
        setSchool(args[8]);
        setSchoolNumber(args[9]);
        setSchoolClass(args[10]);
        setPhone(args[11]);
        setAdress(args[12]);
        setMotherFIO (args[13]);
        setMotherPhone(args[14]);
        setMotherWork(args[15]);
        setMotherPost(args[16]);
        setFatherFIO (args[17]);
        setFatherPhone(args[18]);
        setFatherWork(args[19]);
        setFatherPost(args[20]);
        setProgram(args[21]);
        setClass(args[22]);
        setSpecTeacher(args[23]);
        setTheorTeacher(args[24]);
        setChoirTeacher(args[25]);
        //setPianoTeacher(args[26]);//version 99.41
        //setEnsembleTeacher(args[27]);//version 99.41
        setRepertoire1 (args[26]);
        setRepertoire2 (args[27]);
        setNotes(args[28]);
        setAchievement(args[29]);
    }
    
    private void addNewFormatOtherProperties(String[] args){
        setLastName(args[0]);
        setFirstName(args[1]);
        setPatronymic(args[2]);
        setGender(args[3]);
        setSpecialty(args[4], args[5]);
        setDateBirth(args[6]);
        setEnrolment(args[7]);
        setSchool(args[8]);
        setSchoolNumber(args[9]);
        setSchoolClass(args[10]);
        setPhone(args[11]);
        setAdress(args[12]);
        setMotherFIO (args[13]);
        setMotherPhone(args[14]);
        setMotherWork(args[15]);
        setMotherPost(args[16]);
        setFatherFIO (args[17]);
        setFatherPhone(args[18]);
        setFatherWork(args[19]);
        setFatherPost(args[20]);
        setProgram(args[21]);
        setClass(args[22]);
        setSpecTeacher(args[23]);
        setTheorTeacher(args[24]);
        setChoirTeacher(args[25]);
        setPianoTeacher(args[26]);//version 99.41
        setEnsembleTeacher(args[27]);//version 99.41
        setRepertoire1 (args[28]);
        setRepertoire2 (args[29]);
        setNotes(args[30]);
        setAchievement(args[31]);
    }
    
///////////////////////////////////////////////////////////////////////////////
    
    public void setLastName(String l){
        last_Name = l;
    }
    public void setFirstName(String f){
        first_Name = f;
    }
    public void setPatronymic(String p){
        patronymic = p;
    }
    public void setGender(String g){
        gender = g;
    }
    public void setSpecialty (String sp, String ins){
        specialty = sp;
        instrument = ins;
    }
    public void setDateBirth (String date){
        date_Birth = date;
    }
    public void setEnrolment(String date){
        date_Enrolment = date;
    }
    public void setSchool(String s){
        school = s;
    }
    public void setSchoolNumber(String n){
        school_Number = n;
    }
    public void setSchoolClass(String c){
        school_Class = c;
    }
    public void setPhone (String p){
        phone = p;
    }
    public void setAdress (String adr){
        adress = adr;
    }
    public void setMotherFIO (String fio){
        mother_FIO = fio;
    }
    public void setMotherPhone(String p){
        mother_Phone = p;
    }
    public void setMotherWork(String w){
        mother_Work = w;
    }
    public void setMotherPost(String p){
        mother_Post = p;
    }
    public void setFatherFIO (String fio){
        father_FIO = fio;
    }
    public void setFatherPhone(String p){
        father_Phone = p;
    }
    public void setFatherWork(String w){
        father_Work = w;
    }
    public void setFatherPost(String p){
        father_Post = p;
    }
    public void setProgram (String pr){
        program = pr;
    }
    public void setClass (String cl){
        music_Class = cl;
    }
    public void setSpecTeacher (String specT){
        speciality_Teacher = specT;
    }
    public void setTheorTeacher (String theorTeacher){
        theory_Teacher = theorTeacher;
    }
    public void setChoirTeacher (String choirTeacher){
        choir_Teacher = choirTeacher;
    }
    //version 99.41
    public void setPianoTeacher(String pianoTeacher){
        piano_Teacher = pianoTeacher;
    }
    //version 99.41
    public void setEnsembleTeacher(String ensemleTeacher){
        ensemble_Teacher = ensemleTeacher;
    }
    public void setFirst (int fst){
        first = fst;
    }
    public void setSecond (int snd){
        second = snd;
    }
    //version 99.41
    public void setThird(int thd){
        third = thd;
    }
    public void setRepertoire1 (String rpr){
        repertoire1 = rpr;
    }
    public void setRepertoire2 (String rpr){
        repertoire2 = rpr;
    }
    public void setNotes(String note){
        notes = note;
    }
    public void setAchievement(String ach){
        achievement = ach;
    }
    public void setDocuments(int index, boolean doc){
        documents[index] = doc;
    }
    
///////////////////////////////////////////////////////////////////////////////
    
    public String getLastName(){
        return last_Name;
    }
    public String getFirstName(){
        return first_Name;
    }
    public String getPatrName(){
        return patronymic;
    }
    public String getName(){
        return last_Name + " " + first_Name;
    }
    public String getGender(){
        return gender;
    }
    public String getDateBirth (){
        return date_Birth;
    }
    public String getEnrolment(){
        return  date_Enrolment;
    }
    public String getSchool(){
        return "" + school;
    }
    public String getSchoolNumber(){
        return school_Number;
    }
    public String getSchoolClass(){
        return school_Class;
    }
    public String getSpecialty(){
        return specialty;
    }
    public String getInstrument(){
        return instrument;
    }
    public String getSpeciality(){
        String Spec = specialty;
        if (!instrument.equals(""))Spec = specialty + " (" + instrument +")";
        return Spec;
    }
    public String getProgram (){
        return program;
    }
    public String getKlass (){
        return music_Class;
    }
    public String getPhone (){
        return phone;
    }
    public String getAdress (){
        return adress;
    }
    public String getMotherName(){
       return mother_FIO;
    }
    public String getMotherPhone(){
        return mother_Phone;
    }
    public String getMotherWork(){
        return mother_Work;
    }
    public String getMotherPost(){
        return mother_Post;
    }
    public String getFatherName(){
        return father_FIO;
    }
    public String getFatherPhone(){
        return father_Phone;
    }
    public String getFatherWork(){
        return father_Work;
    }
    public String getFatherPost(){
        return father_Post;
    }
    public String getSpesTeacher (){
        return speciality_Teacher;
    }
    public String getTheorTeacher (){
        return theory_Teacher;
    }
    public String getChoirTeacher (){
        return choir_Teacher;
    }
    public String getPianoTeacher (){
        return piano_Teacher;
    }
    public String getEnsembleTeacher (){
        return ensemble_Teacher;
    }
    public int getFirst (){
        return first;
    }
    public String getWeekDayFirst (){
        return getWeekDay(first);
    }
    public int getSecond(){
        return second;
    }
    public String getWeekDaySecond (){
        return getWeekDay(second);
    }
    public int getThird(){
        return third;
    }
    public String getWeekDayThird (){
        return getWeekDay(third);
    }
    public double getHours(){
        return hours;
    }
    public String getRepertoire1(){
        return repertoire1;
    }
    public String getRepertoire2(){
        return repertoire2;
    }
    public String getAchievement (){
        return achievement;
    }
    public String getNotes(){
        return notes;
    }
    public boolean[] getDocuments(){
        return documents;
    }
    public String getAll(){
        String all = "";
        all = last_Name + '\t' + first_Name + '\t' + patronymic + '\t' 
        + gender + '\t' + specialty + '\t' + instrument + '\t' + date_Birth + '\t' 
        + date_Enrolment + '\t' + school + '\t' + school_Number + '\t' 
        + school_Class + '\t' + phone + '\t' + adress + '\t' + mother_FIO + '\t'
        + mother_Phone + '\t' + mother_Work + '\t' + mother_Post + '\t' 
        + father_FIO + '\t' + father_Phone + '\t' + father_Work + '\t' 
        + father_Post + '\t' + program + '\t' + music_Class  + '\t' 
        + speciality_Teacher  + '\t' + theory_Teacher + '\t' + choir_Teacher + '\t' 
        + piano_Teacher  + '\t' + ensemble_Teacher + '\t' + repertoire1+ '\t' 
        + repertoire2 + '\t' + notes + '\t' + achievement+ '\t' + first + '\t' 
        + second + '\t' + third + '\t' + hours + '\t' + documentsToInt() + '\t';
    return all;
    }
    
////////////////////////////////////////////////////////////////////////////////
    private void strToDocuments(String doc){
        for(int i=0; i<12; i++){
            documents[i] = doc.charAt(i)=='1';
        }
    }
    public String documentsToInt(){
        String doc = "";
        for(int i=0; i<12; i++){
            if(documents[i]) doc += '1';
            else doc += '0';
        }
        return doc;
    }
    private String getWeekDay(int day){
        String weekDay = "";
        switch (day){
            case 1: weekDay = "Пн"; break;
            case 2: weekDay = "Вт"; break;
            case 3: weekDay = "Ср"; break;
            case 4: weekDay = "Чт"; break;
            case 5: weekDay = "Пт"; break;
            case 6: weekDay = "Сб"; break;
            case 7: weekDay = "Вс"; break;
        }
        return weekDay;
    }
}
