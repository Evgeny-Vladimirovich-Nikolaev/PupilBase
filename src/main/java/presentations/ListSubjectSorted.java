/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentations;

import base.Age;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Nobilis
 */
public class ListSubjectSorted extends List_Layout{
    
    private String date;
    private String columnDate;
    private String subjectTeacher;
    int subject;
    
    public ListSubjectSorted(File file, ArrayList currentBase, ArrayList deleteBase) {
        super();
        this.setTitle(file.toString());
        this.subjectTeacher = "Преподаватель по ";
        this.file = file;
        this.currentBase = currentBase;
        this.deleteBase = deleteBase;
        getTable();
        //createlayout();
    }
    
    public ListSubjectSorted(
            File file, 
            ArrayList currentBase, 
            ArrayList deleteBase, 
            String date, 
            int subject) 
    {
        super();
        this.setTitle(file.toString());
        this.subjectTeacher = "Преподаватель по ";
        this.file = file;
        this.currentBase = currentBase;
        this.deleteBase = deleteBase;
        this.date = date;
        this.subject = subject;
        columnDate = "возраст на " + date;
        if(subject == 1)subjectTeacher += "теории";
        else if(subject==2)subjectTeacher += "хору";
        else subjectTeacher += "специальности";
        getTable();
        //createlayout();
    }
    
    @Override
    public final void getTable(){
        table.setFont(new java.awt.Font("Tahoma", 0, 18));
        table.setModel(new javax.swing.table.DefaultTableModel(
        new Object [currentBase.size()][10] ,
        new String [] {
            "№", "Ученик", columnDate, "Класс", "Программа", "Специальность", "часы", "1", "2", subjectTeacher
        }
        ) {
        Class[] types = new Class [] {
            Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, String.class
        };
        @Override
        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        });
        table.setRowHeight(24);
        
//цикл for позволяет сделать количество строк равным количеству объектов в currentBase
        for(int set=0; set<currentBase.size(); set++)
            {Age age = new Age(currentBase.get(set).getDateBirth(), date);
            table.setValueAt(set+1, set, 0);
            table.setValueAt(currentBase.get(set).getName(), set, 1);
            table.setValueAt(age.parceAge(), set, 2);
            table.setValueAt(currentBase.get(set).getKlass(), set, 3);
            table.setValueAt(currentBase.get(set).getProgram(), set, 4);
            table.setValueAt(currentBase.get(set).getSpeciality(), set, 5);
            table.setValueAt(currentBase.get(set).getHours(), set, 6);
            table.setValueAt(currentBase.get(set).getWeekDayFirst(), set, 7);
            table.setValueAt(currentBase.get(set).getWeekDaySecond(), set, 8);
            if(subject==1)table.setValueAt(currentBase.get(set).getTheorTeacher(), set, 9);
            else if(subject==2)table.setValueAt(currentBase.get(set).getChoirTeacher(), set, 9);
            else table.setValueAt(currentBase.get(set).getSpesTeacher(), set, 9);}
        
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(210);
            table.getColumnModel().getColumn(1).setMinWidth(160);
            table.getColumnModel().getColumn(2).setPreferredWidth(190);
            table.getColumnModel().getColumn(2).setMinWidth(60);
            table.getColumnModel().getColumn(3).setPreferredWidth(40);
            table.getColumnModel().getColumn(3).setMinWidth(30);
            table.getColumnModel().getColumn(4).setPreferredWidth(60);
            table.getColumnModel().getColumn(4).setMinWidth(45);
            table.getColumnModel().getColumn(5).setPreferredWidth(200);
            table.getColumnModel().getColumn(5).setMinWidth(120);
            table.getColumnModel().getColumn(6).setPreferredWidth(35);
            table.getColumnModel().getColumn(6).setMinWidth(20);
            table.getColumnModel().getColumn(7).setPreferredWidth(25);
            table.getColumnModel().getColumn(7).setMinWidth(15);
            table.getColumnModel().getColumn(8).setPreferredWidth(25);
            table.getColumnModel().getColumn(8).setMinWidth(15);
            table.getColumnModel().getColumn(9).setPreferredWidth(280);
            table.getColumnModel().getColumn(9).setMinWidth(80);
            table.setComponentPopupMenu(popupMenu_);
    }
}
