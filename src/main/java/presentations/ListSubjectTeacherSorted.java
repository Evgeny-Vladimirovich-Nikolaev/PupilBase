/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentations;

import base.Pupil;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Nobilis
 */
public class ListSubjectTeacherSorted extends ListStart {
    private ArrayList<Pupil> currentBase;
    private ArrayList<Pupil> deleteBase;
    private File file;
    String date;
    String columnDate;
    String subjectTeacher = "Преподаватель по ";
    int subject;
    
    public ListSubjectTeacherSorted(File file, ArrayList currentBase, ArrayList deleteBase, String date, int subject) {
        super(file, currentBase, deleteBase);
        this.setTitle(file.toString());
        this.date = date;
        columnDate = "возраст на " + date;
        this.subject = subject;
        if(subject == 1)subjectTeacher += "теории";
        else if(subject==2)subjectTeacher += "хору";
        else subjectTeacher += "специальности";
        //initComponents();
    }
}
