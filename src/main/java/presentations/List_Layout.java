/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentations;

import base.ListSorter;
import base.Pupil;
import card.PupilCard_Editor;
import card.PupilCard_New;
import card.PupilCard_Viewer;
import pupilbase.mainframe.SortSetting;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Nobilis
 */
public abstract class List_Layout extends javax.swing.JFrame {
    protected ArrayList<Pupil> currentBase;
    protected ArrayList<Pupil> deleteBase;
    protected File file;
    
    public List_Layout(){
        initComponents();
    }

    public List_Layout(File file) {
        this();
        this.setTitle(file.toString());
        this.file = file;
        readFile();
    }
    
    protected final void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        initMenu();
        initPopupMenu();
        initTable();
        createlayout();
        pack();
    }
    
    protected void initMenu(){
        Font menuFont = new Font("Tahoma", 0, 24);
        Font menuItemFont = new Font("Tahoma", 0, 20);
        menuBar_ = new javax.swing.JMenuBar();
        
        initMenuFile(menuFont, menuItemFont);
        initMenuEdit(menuFont, menuItemFont);
        initMenuArrays(menuFont, menuItemFont);
        initMenuSotring(menuFont, menuItemFont);
        
        setJMenuBar(menuBar_);
}

    protected void initMenuFile(Font menuFont, Font menuItemFont){
        menuBar_File_ = new javax.swing.JMenu();
        menuBar_File_Save = new javax.swing.JMenuItem();
        menuBar_File_SaveAs = new javax.swing.JMenuItem();
        menuBar_File_Open = new javax.swing.JMenuItem();
        menuBar_File_Refresh = new javax.swing.JMenuItem();
        menuBar_File_Close = new javax.swing.JMenuItem();
        menuBar_File_NewBase = new javax.swing.JMenuItem();
        
        menuBar_File_.setText("Файл");
        menuBar_File_.setFont(menuFont);

        menuBar_File_Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuBar_File_Save.setFont(menuItemFont);
        menuBar_File_Save.setText("Сохранить");
        menuBar_File_Save.addActionListener(this::saveAction);
        menuBar_File_.add(menuBar_File_Save);

        menuBar_File_SaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuBar_File_SaveAs.setFont(menuItemFont); 
        menuBar_File_SaveAs.setText("Сохранить как");
        menuBar_File_SaveAs.addActionListener(this::saveAsAction);
        menuBar_File_.add(menuBar_File_SaveAs);

        menuBar_File_Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuBar_File_Open.setFont(menuItemFont);
        menuBar_File_Open.setText("Открыть");
        menuBar_File_Open.addActionListener(this::openAction);
        menuBar_File_.add(menuBar_File_Open);

        menuBar_File_Refresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuBar_File_Refresh.setFont(menuItemFont); 
        menuBar_File_Refresh.setText("Обновить");
        menuBar_File_Refresh.addActionListener(this::refreshAction);
        menuBar_File_.add(menuBar_File_Refresh);

        menuBar_File_Close.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuBar_File_Close.setFont(menuItemFont);  
        menuBar_File_Close.setText("Закрыть");
        menuBar_File_Close.addActionListener(this::closeAction);
        menuBar_File_.add(menuBar_File_Close);

        menuBar_File_NewBase.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        menuBar_File_NewBase.setFont(menuItemFont);  
        menuBar_File_NewBase.setText("Новая база");
        menuBar_File_NewBase.addActionListener(this::newBaseAction);
        menuBar_File_.add(menuBar_File_NewBase);

        menuBar_.add(menuBar_File_);
    }
    
    protected void initMenuEdit(Font menuFont, Font menuItemFont){
        menuBar_Edit_ = new javax.swing.JMenu();
        menuBar_Edit_Undo = new javax.swing.JMenuItem();
        menuBar_Edit_Redo = new javax.swing.JMenuItem();
        menuBar_Edit_NewRecord = new javax.swing.JMenuItem();
        menuBar_Edit_UndoDelete = new javax.swing.JMenuItem();
        menuBar_Edit_UndoDeleteLast = new javax.swing.JMenuItem();
        menuBar_Edit_DeleteFinaly = new javax.swing.JMenuItem();
        
        menuBar_Edit_.setText("Правка");
        menuBar_Edit_.setFont(menuFont);

        menuBar_Edit_Undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuBar_Edit_Undo.setFont(menuItemFont);  
        menuBar_Edit_Undo.setText("Отменить");
        menuBar_Edit_Undo.addActionListener(this::undoAction);
        menuBar_Edit_.add(menuBar_Edit_Undo);

        menuBar_Edit_Redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuBar_Edit_Redo.setFont(menuItemFont);  
        menuBar_Edit_Redo.setText("Вернуть");
        menuBar_Edit_Redo.addActionListener(this::redoAction);
        menuBar_Edit_.add(menuBar_Edit_Redo);

        menuBar_Edit_NewRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        menuBar_Edit_NewRecord.setFont(menuItemFont);  
        menuBar_Edit_NewRecord.setText("Новая запись"); 
        menuBar_Edit_NewRecord.addActionListener(this::newRecordAction);
        menuBar_Edit_.add(menuBar_Edit_NewRecord);

        menuBar_Edit_UndoDelete.setText("Вернуть удаленные записи");
        menuBar_Edit_UndoDelete.setFont(menuItemFont);  
        menuBar_Edit_UndoDelete.addActionListener(this::undoDeleteAction);
        menuBar_Edit_.add(menuBar_Edit_UndoDelete);
        
        menuBar_Edit_UndoDeleteLast.setText("Вернуть последнюю запись");
        menuBar_Edit_UndoDeleteLast.setFont(menuItemFont);  
        menuBar_Edit_UndoDeleteLast.addActionListener(this::undoDeleteLastAction);
        menuBar_Edit_.add(menuBar_Edit_UndoDeleteLast);

        menuBar_Edit_DeleteFinaly.setText("Удалить помеченные");
        menuBar_Edit_DeleteFinaly.setFont(menuItemFont);  
        menuBar_Edit_DeleteFinaly.addActionListener(this::deleteFinalyAction);
        menuBar_Edit_.add(menuBar_Edit_DeleteFinaly);

        menuBar_.add(menuBar_Edit_);
    }
    
    protected void initMenuArrays(Font menuFont, Font menuItemFont){
        menuBar_Arrays_ = new javax.swing.JMenu();
        menuBar_Arrays_DeletedRecords = new javax.swing.JMenuItem();
        menuBar_Arrays_Documents = new javax.swing.JMenuItem();
        menuBar_Arrays_AllAchievement = new javax.swing.JMenuItem();
        menuBar_ArraysSub_SelectAchievement_ = new javax.swing.JMenu();
        menuBar_ArraysSub_SelectAchievement_1 = new javax.swing.JMenuItem();
        menuBar_ArraysSub_SelectAchievement_2 = new javax.swing.JMenuItem();
        menuBar_ArraysSub_SelectAchievement_3 = new javax.swing.JMenuItem();
        menuBar_ArraysSub_SelectAchievement_4 = new javax.swing.JMenuItem();
        menuBar_ArraysSub_SelectAchievement_Year = new javax.swing.JMenuItem();
        
        menuBar_Arrays_.setText("Множества");
        menuBar_Arrays_.setFont(menuFont);
        menuBar_Arrays_DeletedRecords.setFont(menuItemFont);  
        menuBar_Arrays_DeletedRecords.setText("Удаленные записи");
        menuBar_Arrays_DeletedRecords.addActionListener(this::deletedRecordAction);
        menuBar_Arrays_.add(menuBar_Arrays_DeletedRecords);
        
        menuBar_Arrays_Documents.setFont(menuItemFont);  
        menuBar_Arrays_Documents.setText("Все документы");
        menuBar_Arrays_Documents.addActionListener(this::documentsAction);
        menuBar_Arrays_.add(menuBar_Arrays_Documents);
        
        menuBar_Arrays_AllAchievement.setFont(menuItemFont);  
        menuBar_Arrays_AllAchievement.setText("Сводка успеваемости");
        menuBar_Arrays_AllAchievement.addActionListener(this::allAchievementAction);
        menuBar_Arrays_.add(menuBar_Arrays_AllAchievement);
        
        menuBar_ArraysSub_SelectAchievement_.setFont(menuItemFont);  
        menuBar_ArraysSub_SelectAchievement_.setText("Успеваемость за");
        menuBar_ArraysSub_SelectAchievement_.addActionListener(this::selectAchievementAction);
        menuBar_Arrays_.add(menuBar_ArraysSub_SelectAchievement_);
        
        menuBar_ArraysSub_SelectAchievement_1.setFont(menuItemFont);  
        menuBar_ArraysSub_SelectAchievement_1.setText("I четверть");
        menuBar_ArraysSub_SelectAchievement_1.addActionListener(this::selectAchievement_1_Action);
        menuBar_ArraysSub_SelectAchievement_.add(menuBar_ArraysSub_SelectAchievement_1);
        
        menuBar_ArraysSub_SelectAchievement_2.setFont(menuItemFont);  
        menuBar_ArraysSub_SelectAchievement_2.setText("II четверть");
        menuBar_ArraysSub_SelectAchievement_2.addActionListener(this::selectAchievement_2_Action);
        menuBar_ArraysSub_SelectAchievement_.add(menuBar_ArraysSub_SelectAchievement_2);
        
        menuBar_ArraysSub_SelectAchievement_3.setFont(menuItemFont);  
        menuBar_ArraysSub_SelectAchievement_3.setText("III четверть");
        menuBar_ArraysSub_SelectAchievement_3.addActionListener(this::selectAchievement_3_Action);
        menuBar_ArraysSub_SelectAchievement_.add(menuBar_ArraysSub_SelectAchievement_3);
        
        menuBar_ArraysSub_SelectAchievement_4.setFont(menuItemFont);  
        menuBar_ArraysSub_SelectAchievement_4.setText("IV четверть");
        menuBar_ArraysSub_SelectAchievement_4.addActionListener(this::selectAchievement_4_Action);
        menuBar_ArraysSub_SelectAchievement_.add(menuBar_ArraysSub_SelectAchievement_4);
        
        menuBar_ArraysSub_SelectAchievement_Year.setFont(menuItemFont);  
        menuBar_ArraysSub_SelectAchievement_Year.setText("год");
        menuBar_ArraysSub_SelectAchievement_Year.addActionListener(this::selectAchievement_Year_Action);
        menuBar_ArraysSub_SelectAchievement_.add(menuBar_ArraysSub_SelectAchievement_Year);
        
        menuBar_.add(menuBar_Arrays_);
    }
    
    protected void initMenuSotring(Font menuFont, Font menuItemFont){
        menuBar_Sorting_ = new javax.swing.JMenu();
        menuBar_Sorting_Alphabet = new javax.swing.JMenuItem();
        menuBar_Sorting_Age = new javax.swing.JMenuItem();
        menuBar_Sorting_Complex = new javax.swing.JMenuItem();
        
        menuBar_Sorting_.setText("Сортировка");
        menuBar_Sorting_.setFont(menuFont);
        
        menuBar_Sorting_Alphabet.setFont(menuItemFont);  
        menuBar_Sorting_Alphabet.setText("Алфавит");
        menuBar_Sorting_Alphabet.addActionListener(this::alphabetSortAction);
        menuBar_Sorting_.add(menuBar_Sorting_Alphabet);
        
        menuBar_Sorting_Age.setFont(menuItemFont);  
        menuBar_Sorting_Age.setText("Возраст");
        menuBar_Sorting_Age.addActionListener(this::ageSortAction);
        menuBar_Sorting_.add(menuBar_Sorting_Age);
        menuBar_.add(menuBar_Sorting_);
        
        menuBar_Sorting_Complex.setFont(menuItemFont);  
        menuBar_Sorting_Complex.setText("Сложная");
        menuBar_Sorting_Complex.addActionListener(this::complexSortAction);
        menuBar_Sorting_.add(menuBar_Sorting_Complex);
    }
    
    protected void initPopupMenu(){
        popupMenu_ = new javax.swing.JPopupMenu();
        popupMenu_ChangeRecord = new javax.swing.JMenuItem();
        popupMenu_DeleteRecord = new javax.swing.JMenuItem();
        popupMenuSub_View_ = new javax.swing.JMenu();
        popupMenuSub_View_Contacts = new javax.swing.JMenuItem();
        popupMenuSub_View_Achievment = new javax.swing.JMenuItem();
        popupMenuSub_View_Repertoire = new javax.swing.JMenuItem();
        popupMenuSub_View_Notes = new javax.swing.JMenuItem();
        popupMenuSub_View_All = new javax.swing.JMenuItem();
    }
    
    protected void initTable(){
        tablePanel = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
    }
    
    protected void initPopupMenuActions(){  
        Font menuItemFont = new Font("Tahoma", 0, 20);
        
        popupMenuSub_View_.setFont(menuItemFont); 
        popupMenuSub_View_.setText("Показать");
        popupMenu_.add(popupMenuSub_View_);
        
        popupMenu_ChangeRecord.setFont(menuItemFont);
        popupMenu_ChangeRecord.setText("Изменить запись");
        popupMenu_ChangeRecord.addActionListener(this::callCardEditorAction);
        popupMenu_.add(popupMenu_ChangeRecord);
        
        popupMenu_DeleteRecord.setFont(menuItemFont);
        popupMenu_DeleteRecord.setText("Удалить запись");
        popupMenu_DeleteRecord.addActionListener(this::deleteRecordAction);
        popupMenu_.add(popupMenu_DeleteRecord);
        
        popupMenuSub_View_Contacts.setFont(menuItemFont);
        popupMenuSub_View_Contacts.setText("Контактные данные");
        popupMenuSub_View_Contacts.addActionListener(this::showContactsAction);
        popupMenuSub_View_.add(popupMenuSub_View_Contacts);
        
        popupMenuSub_View_Achievment.setFont(menuItemFont);
        popupMenuSub_View_Achievment.setText("Успеваемость");
        popupMenuSub_View_Achievment.addActionListener(this::showAchievmentAction);
        popupMenuSub_View_.add(popupMenuSub_View_Achievment);
        
        popupMenuSub_View_Repertoire.setFont(menuItemFont);
        popupMenuSub_View_Repertoire.setText("Репертуар");
        popupMenuSub_View_Repertoire.addActionListener(this::showRepertoireAction);
        popupMenuSub_View_.add(popupMenuSub_View_Repertoire);
        
        popupMenuSub_View_Notes.setFont(menuItemFont);
        popupMenuSub_View_Notes.setText("Заметки");
        popupMenuSub_View_Notes.addActionListener(this::showNotesAction);
        popupMenuSub_View_.add(popupMenuSub_View_Notes);
        
        popupMenuSub_View_All.setFont(menuItemFont);
        popupMenuSub_View_All.setText("Всё");
        popupMenuSub_View_All.addActionListener(this::callCardViewerAction);
        popupMenuSub_View_.add(popupMenuSub_View_All);
    }
    
   
    
//Моделирование таблицы вынесено за рамки метода initComponents(), 
//чтобы таблицу можно было отедльно перерисовывать в методах 
//menuRefreshActionPerformed, menuUndoDelActionPerformed, menuAgeActionPerformed, 
//menuAlphabetActionPerformed и других методах
    public abstract void getTable();
    
    protected void createlayout(){
        scrollPanel.setViewportView(table);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout panelForTableLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(panelForTableLayout);
        panelForTableLayout.setHorizontalGroup(
            panelForTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        panelForTableLayout.setVerticalGroup(
            panelForTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelForTableLayout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }

    protected final void readFile(){
    PupilBaseReader fileReader = new PupilBaseReader(file);
        currentBase = fileReader.currentBase;
        deleteBase = fileReader.deleteBase;
    }
    
    protected void newBaseAction(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    protected final void saveAction(java.awt.event.ActionEvent evt) {                                           
        new PupilBaseWriter(file, currentBase, deleteBase, true);
    }                      
    
    protected void saveAsAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    protected void openAction(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    protected void refreshAction(java.awt.event.ActionEvent evt) {                                            
        getTable();
    }                                           

    protected void closeAction(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

    protected void undoAction(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    protected void redoAction(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    protected void newRecordAction(java.awt.event.ActionEvent evt) {                                              
        PupilCard_New newRecord = new PupilCard_New(currentBase, this);
        newRecord.setBounds(245, 100, 790, 660);
        newRecord.setVisible(true);
    }                                             

    protected void undoDeleteAction(java.awt.event.ActionEvent evt) {                                            
        if (!deleteBase.isEmpty()) {
            deleteBase.forEach((e) -> currentBase.add(e));
            deleteBase.clear();
            getTable();
        }
    }
    
    protected void undoDeleteLastAction(java.awt.event.ActionEvent evt) {                                            
        if(!deleteBase.isEmpty()){
            currentBase.add(deleteBase.get(deleteBase.size()-1));
            deleteBase.remove(deleteBase.size()-1);
            getTable();
        }
    }

    protected void deleteFinalyAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    protected void deletedRecordAction(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }
    
    protected void documentsAction(java.awt.event.ActionEvent evt) {                                               
        AllDocuments ad = new AllDocuments(file, currentBase, deleteBase);
        ad.setVisible(true);
        this.dispose();
    }
    
    protected void allAchievementAction(java.awt.event.ActionEvent evt) {                                               
        AllAchievment aa = new AllAchievment(file, currentBase, deleteBase);
        aa.setVisible(true);
        this.dispose();
    }
    
    protected void selectAchievementAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }
    
    protected void selectAchievement_1_Action(java.awt.event.ActionEvent evt) {                                               
        SelectlAchievment sa = new SelectlAchievment(file, currentBase, deleteBase, 0);
        sa.setVisible(true);
        this.dispose();
    }
    
    protected void selectAchievement_2_Action(java.awt.event.ActionEvent evt) {                                               
        SelectlAchievment sa = new SelectlAchievment(file, currentBase, deleteBase, 1);
        sa.setVisible(true);
        this.dispose();        
    }
     
    protected void selectAchievement_3_Action(java.awt.event.ActionEvent evt) {                                               
        SelectlAchievment sa = new SelectlAchievment(file, currentBase, deleteBase, 2);
        sa.setVisible(true);
        this.dispose();        
    }
    
    protected void selectAchievement_4_Action(java.awt.event.ActionEvent evt) {                                               
        SelectlAchievment sa = new SelectlAchievment(file, currentBase, deleteBase, 3);
        sa.setVisible(true);
        this.dispose();        
    }
    
    protected void selectAchievement_Year_Action(java.awt.event.ActionEvent evt) {                                               
        SelectlAchievment sa = new SelectlAchievment(file, currentBase, deleteBase, 4);
        sa.setVisible(true);
        this.dispose();        
    }
    
    protected void ageSortAction(java.awt.event.ActionEvent evt) {
        int[] levels = {2, 0, 0, 0, 0};
        int[] settings = {0, 0, 0, 0, 0};
        String date;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        date = df.format(currentDate);
        new ListSorter (currentBase, levels, settings, date);
        getTable();    
    }
    
    protected void alphabetSortAction(java.awt.event.ActionEvent evt) {                                             
        int[] levels = {1, 0, 0, 0, 0};
        int[] settings = {0, 0, 0, 0, 0};
        String date;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        date = df.format(currentDate);
        new ListSorter (currentBase, levels, settings, date);
        getTable();
    }
    
    protected void complexSortAction(java.awt.event.ActionEvent evt) {                                             
        SortSetting sort = new SortSetting(file, currentBase, deleteBase);
        sort.setBounds(355, 300, 684, 360);
        sort.setVisible(true);
        this.dispose();
    }

    protected void tableMouseClicked(java.awt.event.MouseEvent evt){
        initPopupMenuActions();
    } 
    
    protected void deleteRecordAction(java.awt.event.ActionEvent evt) {                                           
        int ind = table.getSelectedRow();
        if (ind>-1) {
            deleteBase.add(currentBase.get(ind));
            currentBase.remove(ind);
            getTable();
        }
    }
    
    protected void callCardEditorAction(java.awt.event.ActionEvent evt) {
        int ind = table.getSelectedRow();
        if(ind>-1)
        {
            deleteBase.add(currentBase.get(ind));
            currentBase.remove(ind);
            Pupil pl = deleteBase.get(deleteBase.size()-1);
            PupilCard_Editor cardEditor = new PupilCard_Editor(
                    currentBase, 
                    deleteBase, 
                    pl,
                    this, 
                    ind);
            getTable();
            deleteBase.remove(deleteBase.size()-1);
            cardEditor.setBounds(245, 100, 790, 660);
            cardEditor.setVisible(true);
        }
    }
    
    protected void callCardViewerAction(java.awt.event.ActionEvent evt) {
        int ind = table.getSelectedRow();
        if(ind>-1)
        {
            deleteBase.add(currentBase.get(ind));
            currentBase.remove(ind);
            Pupil pl = deleteBase.get(deleteBase.size()-1);
            PupilCard_Viewer cardViewer = new PupilCard_Viewer(
                    currentBase, 
                    deleteBase, 
                    pl,
                    this, 
                    ind);
            getTable();
            deleteBase.remove(deleteBase.size()-1);
            cardViewer.setBounds(245, 100, 790, 660);
            cardViewer.setVisible(true);
        }
    }

    protected void showContactsAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }
    
    protected void showAchievmentAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }
    
    protected void showRepertoireAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }
    
    protected void showNotesAction(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
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
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListStart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    protected javax.swing.JMenuBar menuBar_;
    protected javax.swing.JMenu menuBar_File_;
    protected javax.swing.JMenuItem menuBar_File_Save;
    protected javax.swing.JMenuItem menuBar_File_SaveAs;
    protected javax.swing.JMenuItem menuBar_File_Open;
    protected javax.swing.JMenuItem menuBar_File_Refresh;
    protected javax.swing.JMenuItem menuBar_File_Close;
    protected javax.swing.JMenuItem menuBar_File_NewBase;
    protected javax.swing.JMenu menuBar_Edit_;
    protected javax.swing.JMenuItem menuBar_Edit_Undo;
    protected javax.swing.JMenuItem menuBar_Edit_Redo;
    protected javax.swing.JMenuItem menuBar_Edit_NewRecord;
    protected javax.swing.JMenuItem menuBar_Edit_UndoDelete;
    protected javax.swing.JMenuItem menuBar_Edit_UndoDeleteLast;
    protected javax.swing.JMenuItem menuBar_Edit_DeleteFinaly;
    protected javax.swing.JMenu menuBar_Arrays_;
    protected javax.swing.JMenuItem menuBar_Arrays_DeletedRecords;
    protected javax.swing.JMenuItem menuBar_Arrays_Documents;
    protected javax.swing.JMenuItem menuBar_Arrays_AllAchievement;
    protected javax.swing.JMenu menuBar_ArraysSub_SelectAchievement_;
    protected javax.swing.JMenuItem menuBar_ArraysSub_SelectAchievement_1;
    protected javax.swing.JMenuItem menuBar_ArraysSub_SelectAchievement_2;
    protected javax.swing.JMenuItem menuBar_ArraysSub_SelectAchievement_3;
    protected javax.swing.JMenuItem menuBar_ArraysSub_SelectAchievement_4;
    protected javax.swing.JMenuItem menuBar_ArraysSub_SelectAchievement_Year;
    protected javax.swing.JMenu menuBar_Sorting_;
    protected javax.swing.JMenuItem menuBar_Sorting_Alphabet;
    protected javax.swing.JMenuItem menuBar_Sorting_Age;
    protected javax.swing.JMenuItem menuBar_Sorting_Complex;
    protected javax.swing.JPopupMenu popupMenu_;
    protected javax.swing.JMenuItem popupMenu_ChangeRecord;
    protected javax.swing.JMenuItem popupMenu_DeleteRecord;
    protected javax.swing.JMenu popupMenuSub_View_;
    protected javax.swing.JMenuItem popupMenuSub_View_Contacts;
    protected javax.swing.JMenuItem popupMenuSub_View_Achievment;
    protected javax.swing.JMenuItem popupMenuSub_View_Repertoire;
    protected javax.swing.JMenuItem popupMenuSub_View_Notes;
    protected javax.swing.JMenuItem popupMenuSub_View_All;
    protected javax.swing.JTable table;
    protected javax.swing.JPanel tablePanel;
    protected javax.swing.JScrollPane scrollPanel;
    
    // End of variables declaration                   
}

