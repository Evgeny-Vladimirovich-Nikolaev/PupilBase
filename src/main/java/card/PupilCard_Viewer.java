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
public class PupilCard_Viewer extends PupilCard_Editor {

    
    
    public PupilCard_Viewer(ArrayList currentBase, ArrayList deleteBase, Pupil pupil, List_Layout list, int index){
        super(currentBase, deleteBase, pupil, list, index);
        disableEditing();
    }    
    
    private void disableEditing()
    {
        area_1_Semester.setEditable(false);
        area_2_Semester.setEditable(false);
        area_Adress.setEditable(false);
        area_Father_Work.setEditable(false);
        area_Mother_Work.setEditable(false);
        area_Notes.setEditable(false);
        box_Birth_Certificate.setEnabled(false);
        box_Child_SNILS.setEnabled(false);
        box_Class.setEditable(false);
        box_Contract.setEnabled(false);
        box_Date_Born.setEditable(false);
        box_Date_Enrolment.setEditable(false);
        box_Father_Consent.setEnabled(false);
        box_Father_Passport.setEnabled(false);
        box_Father_SNILS.setEnabled(false);
        box_First.setEditable(false);
        box_Gender.setEnabled(false);
        box_Hours.setEditable(false);
        box_Medical_Certificate.setEnabled(false);
        box_Month_Born.setEditable(false);
        box_Month_Enrolment.setEditable(false);
        box_Mother_Consent.setEnabled(false);
        box_Mother_Passport.setEnabled(false);
        box_Mother_SNILS.setEnabled(false);
        box_Photo.setEnabled(false);
        box_Program.setEditable(false);
        box_School.setEditable(false);
        box_School_Class.setEditable(false);
        box_School_Class_Letter.setEditable(false);
        box_School_Number.setEditable(false);
        box_Second.setEditable(false);
        box_Statement.setEnabled(false);
        box_Third.setEditable(false);
        box_Year_Born.setEditable(false);
        box_Year_Enrolment.setEditable(false);
        button_Cancel.setVisible(false);
//        button_OK.setVisible(false);
        field_Choir_Teacher.setEditable(false);
        field_Ensemble_Teacher.setEditable(false);
        field_Father_First_Name.setEditable(false);
        field_Father_Last_Name.setEditable(false);
        field_Father_Patronymic.setEditable(false);
        field_Father_Phone.setEditable(false);
        field_Father_Post.setEditable(false);
        field_First_Name.setEditable(false);
        field_Instrument.setEditable(false);
        field_Last_Name.setEditable(false);
        field_Mother_First_Name.setEditable(false);
        field_Mother_Last_Name.setEditable(false);
        field_Mother_Patronymic.setEditable(false);
        field_Mother_Phone.setEditable(false);
        field_Mother_Post.setEditable(false);
        field_Patronymic_Name.setEditable(false);
        field_Phone.setEditable(false);
        field_Piano_Teacher.setEditable(false);
        field_Spec_Teacher.setEditable(false);
        field_Speciality.setEditable(false);
        field_Theor_Teacher.setEditable(false);
        table_Achievment.setEnabled(false);
    }
    
}
