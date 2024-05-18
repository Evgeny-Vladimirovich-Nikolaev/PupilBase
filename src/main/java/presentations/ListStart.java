/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentations;

import java.io.File;
import java.util.ArrayList;



/**
 * @author Nobilis
 */
public class ListStart extends List_Layout {
    
    public ListStart() {
        super();
    }
    
    public ListStart(File file) {
        super(file);
        getTable();
        //createlayout();
    }
    
    public ListStart(File file, ArrayList currentBase, ArrayList deleteBase) {
        super();//вызов конструктора this(file) приведёт к повторному чтению из файла
        this.setTitle(file.toString());
        this.file = file;
        this.currentBase = currentBase;
        this.deleteBase = deleteBase;
        getTable();
        //createlayout();
    }
    
    
//Моделирование таблицы вынесено за рамки метода initComponents(), 
//чтобы таблицу можно было отедльно перерисовывать в методах 
//menuRefreshActionPerformed, menuUndoDelActionPerformed, menuAgeActionPerformed, 
//menuAlphabetActionPerformed и других методах
    @Override
    public final void getTable(){
        table.setFont(new java.awt.Font("Tahoma", 0, 18));
        table.setModel(new javax.swing.table.DefaultTableModel(
        new Object [currentBase.size()][9] ,
        new String [] {
            "№", "Ученик", "Д/р", "Класс", "Программа", "Специальность", "часы", "1", "2"
        }
        ) {
            Class[] types = new Class [] {
                Object.class, String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
            };

            @Override
        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        });
        table.setRowHeight(24);
        
//цикл for позволяет сделать количество строк равным количеству объектов в currentBase
        for(int set=0; set<currentBase.size(); set++)
            {table.setValueAt(set+1, set, 0);
            table.setValueAt(currentBase.get(set).getName(), set, 1);
            table.setValueAt(currentBase.get(set).getDateBirth(), set, 2);
            table.setValueAt(currentBase.get(set).getKlass(), set, 3);
            table.setValueAt(currentBase.get(set).getProgram(), set, 4);
            table.setValueAt(currentBase.get(set).getSpeciality(), set, 5);
            table.setValueAt(currentBase.get(set).getHours(), set, 6);
            table.setValueAt(currentBase.get(set).getWeekDayFirst(), set, 7);
            table.setValueAt(currentBase.get(set).getWeekDaySecond(), set, 8);}
        
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
            table.getColumnModel().getColumn(0).setMaxWidth(40);
            table.getColumnModel().getColumn(1).setPreferredWidth(220);
            table.getColumnModel().getColumn(1).setMinWidth(160);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
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
            table.setComponentPopupMenu(popupMenu_);
    }
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListStart().setVisible(true);
            }
        });
    }
}

