/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package card;

import base.Pupil;
import presentations.List_Layout;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author Nobilis
 */
public abstract class PupilCard_Model extends PupilCard_Layout{
    protected ArrayList<Pupil> currentBase;
    protected Pupil pupil;
    protected boolean[] documents;
    protected List_Layout list;
    protected int index;
    
    public PupilCard_Model(){
            setTableSettings();
    }
    
    public PupilCard_Model(ArrayList currentBase,  List_Layout list){
        this();
        this.currentBase = currentBase;
        this.list = list;
        //index = 0;
    }
    
    @Override
    protected String[] setSchools(){
        return new String[] {" ", "школа", "лицей", "гимназия", "детский сад"};
    }
    
    @Override
    protected String[] setSchoolNumbers(){
        String[] numbers = new String[41];
        numbers[0] = " ";
        for(int i = 1; i < 41; i++){
            numbers[i] = Integer.toString(i);
        }
        return numbers;
    }
    
    @Override
    protected String[] setSchoolClasses(){
        return new String[] {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
            "10", "11"};
    }
    
    @Override
    protected String[] setClassLetters(){
        return new String[] {" ", "А", "Б", "В", "Г", "Д", "Е", "Ж", 
            "З", "И", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", 
            "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ы", "Э", "Ю", "Я"};
    }
    
    @Override
    protected String[] setGender(){
        return new String[] {" ", "мужской", "женский" };
    }
    
    @Override
    protected String[] setBornYears(){
        String[] years = new String[72];
        years[0] = " ";
        for(int i = 1; i < 72; i++)years[i] = Integer.toString(2021 - i);
        return years;
    }
    
    @Override
    protected String[] setEnrolmentYears(){
        String[] years = new String[25];
        years[0] = " ";
        for(int i = 1; i < 25; i++)years[i] = Integer.toString(2024 - i);
        return years;
    }
    
    @Override
    protected String[] setBornMonths(){
        return new String[] {" ", "январь", "февраль", "март", "апрель", "май",
            "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь ", "декабрь"}; 
    }
    
    @Override
    protected String[] setEnrolmentMonths(){
        return setBornMonths();
    }
    
    @Override
    protected String[] setBornDates(){
        String[] dates = new String[32]; 
        dates[0] = "";
        for(int i = 1; i < 32; i++){
            dates[i] = Integer.toString(i);
        }
        for(int i = 1; i < 10; i++){
            dates[i] = "0" + dates[i];
        }
        return dates;
    }
    
    @Override
    protected String[] setEnrolmentDates(){
        return setBornDates();
    }
    
    @Override
    protected String[] setProgram(){
        return new String[] {" ", "ДПОП", "ДООП", "ДОП", "ДПУ"};
    }
    
    @Override
    protected String[] setClasses(){
        return new String[] {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }
    
    @Override
    protected String[] setHours(){
        return new String[] {" ", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0", "3,5", "4,0"};
    }
    
    @Override
    protected String[] setWeek(){
        return new String[] {" ", "Понедельник", "Вторник", "Среда", "Четверг", 
            "Пятница", "Суббота", "Воскресенье"};
    }
    
    @Override
    protected DefaultTableModel setAchievmentTable() {
        return new DefaultTableModel(
            getTableContent(),
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
        };
    }
    
    @Override
    protected final void setTableSettings(){
        if (table_Achievment.getColumnModel().getColumnCount() > 0) {
            table_Achievment.getColumnModel().getColumn(0).setMinWidth(140);
            table_Achievment.getColumnModel().getColumn(0).setPreferredWidth(155);
            table_Achievment.getColumnModel().getColumn(0).setMaxWidth(220);
            table_Achievment.getColumnModel().getColumn(1).setMinWidth(40);
            table_Achievment.getColumnModel().getColumn(1).setPreferredWidth(50);
            table_Achievment.getColumnModel().getColumn(1).setMaxWidth(60);
            table_Achievment.getColumnModel().getColumn(2).setMinWidth(40);
            table_Achievment.getColumnModel().getColumn(2).setPreferredWidth(50);
            table_Achievment.getColumnModel().getColumn(2).setMaxWidth(60);
            table_Achievment.getColumnModel().getColumn(3).setMinWidth(40);
            table_Achievment.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_Achievment.getColumnModel().getColumn(3).setMaxWidth(60);
            table_Achievment.getColumnModel().getColumn(4).setMinWidth(40);
            table_Achievment.getColumnModel().getColumn(4).setPreferredWidth(50);
            table_Achievment.getColumnModel().getColumn(4).setMaxWidth(60);
            table_Achievment.getColumnModel().getColumn(5).setMinWidth(65);
            table_Achievment.getColumnModel().getColumn(5).setPreferredWidth(75);
            table_Achievment.getColumnModel().getColumn(5).setMaxWidth(90);
            table_Achievment.getColumnModel().getColumn(6).setMinWidth(65);
            table_Achievment.getColumnModel().getColumn(6).setPreferredWidth(75);
            table_Achievment.getColumnModel().getColumn(6).setMaxWidth(90);
            table_Achievment.getColumnModel().getColumn(7).setMinWidth(65);
            table_Achievment.getColumnModel().getColumn(7).setPreferredWidth(75);
            table_Achievment.getColumnModel().getColumn(7).setMaxWidth(90);
        }
    }
    
    @Override
    protected String[][] getTableContent(){
        String[][] table = new String[6][8];
        table[0][0] = "Специальность";
        table[1][0] = "Сольфеджио";
        table[2][0] = "Муз. литература";
        table[3][0] = "Хор";
        table[4][0] = "Ансамбль";
        table[5][0] = "Доп. инструмент";
        for(int row=0; row<6; row++){
            for(int column=1; column<8; column++){
                table[row][column] = "";
            }
        }
        return table;
    }

    @Override
    protected void setDocumentsItem(int item) {
        documents[item] = !(documents[item]);
    }

}
