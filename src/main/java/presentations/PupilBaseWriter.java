/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentations;

import base.Pupil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nobilis
 */
public class PupilBaseWriter {
    
    private final File file;
    protected ArrayList<Pupil> currentBase;
    protected ArrayList<Pupil> deleteBase;
    
    public PupilBaseWriter(File file, 
            ArrayList currentBase, 
            ArrayList deleteBase, 
            boolean rewrite){
        this.file = file;
        this.currentBase = currentBase;
        this.deleteBase = deleteBase;
        if(rewrite)
            eraseFile();
        saveFile();
    }
    
    //заменить трассировку стека окном с сообщением
    private void eraseFile(){
        try (BufferedWriter eraser = 
                new BufferedWriter(new java.io.FileWriter(file, false))) {
                eraser.write("");
                eraser.flush();
                eraser.close();
            }catch(IOException e){
           e.printStackTrace();}   
    }
    
    //заменить трассировку стека окном с сообщением
    private void saveFile(){
        try
        {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, true));
            String s;
            String lineSeparator = System.getProperty("line.separator");
            s = "#Pupil Base file\n#Version file format 3.0";
            writer.write(s + lineSeparator);
            writer.flush();
            s = "" + 'µ';//открывает текущий список
            writer.write(s);
            writer.flush();
            for(int i=0; i<currentBase.size(); i++)
            {
                s = currentBase.get(i).getAll();
                writer.write(s + lineSeparator);
                writer.flush();
            }
        if(!deleteBase.isEmpty())
        {
            s = "" + 'µ';//открывает удалённый список
            writer.write(s);
            writer.flush();
            for(int i = 0; i < deleteBase.size(); i++)
            {
                s = deleteBase.get(i).getAll();
                writer.write(s + lineSeparator);
                writer.flush();
            }
            writer.close();
        }
        }
        catch(IOException err)
        {
            err.printStackTrace();
        }
        
    }    
}
