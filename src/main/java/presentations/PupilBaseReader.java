/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentations;

import base.Pupil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nobilis
 */
public class PupilBaseReader {
    
    private final File file;
    protected ArrayList<Pupil> currentBase;
    protected ArrayList<Pupil> deleteBase;
    private String[] tags;
    
    //private File file;
    public PupilBaseReader(File file){
        this.file = file;
        currentBase = new ArrayList<Pupil>();
        deleteBase = new ArrayList<Pupil>();
        tags = new String[]{
            "#Pupil Base file", 
            "#Version file format 3.0"};
        checkFile();
    }
    
    private void parseVersion(String version){
        readFileVersion_3();
    }
    
    public void readFileVersion_2(){
        try(BufferedReader br = new BufferedReader (new FileReader(file)))
        {
            String property = "";    //поле объекта Pupil_OLD
            int c;    //переменная для специальных символов, разграничивающих файл
            int sel = 0;    //инкременируется при достижении символа µ
            while((c=br.read())!=-1)
            {
                String[] allProperties = new String[34];        
                int count = 0;                                             
                do
                { 
                    if(c=='µ')++sel;    //µ - отделяет в файле удаленные записи
                    else if(c!='\t' & c!='\n'){
                        if(c!=13){//игнорируем 13 - Carriage return
                            property += (char)c;//добавление символа в поле объекта,
                        }
                    }        
                                                   
                    else{
                        allProperties[count]=property; 
                        property = "";                  
                        ++count;
                    }                      
                }
                while((c=br.read()) != '\n');
                Pupil ppl = new Pupil(allProperties);
                if(sel == 0)currentBase.add(ppl);
                else deleteBase.add(ppl);
            }
            br.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void readFileVersion_3(){
        try(BufferedReader br = new BufferedReader (new FileReader(file)))
        {
            String property = "";    //поле объекта Pupil_OLD
            int ch;    //переменная для специальных символов, разграничивающих файл
            int sel = 0;    //инкременируется при достижении символа µ
            while((ch = br.read()) == '#'){
                while((ch = br.read()) != '\n');
            }
            while((ch=br.read())!=-1){
                String[] allProperties = new String[37];        
                int count = 0;                                             
                do{ 
                    if(ch=='µ'){
                        ++sel;
                    }else if(ch!='\t' & ch!='\n'){
                        if(ch!=13){//игнорируем 13 - Carriage return
                            property += (char)ch;//добавление символа в поле объекта,
                        }
                    }else{
                        allProperties[count]=property; 
                        property = "";                  
                        ++count;
                    }                      
                }while((ch=br.read()) != '\n');
                Pupil ppl = new Pupil(allProperties, 3);
                if(sel == 0){
                    currentBase.add(ppl);
                }else{
                    deleteBase.add(ppl);
                }
            }
            br.close();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void checkFile(){
        try(BufferedReader br = new BufferedReader (new FileReader(file)))
        {
            int line = 0;
            int ch;     
            while((ch = br.read())!= -1 && line < 5){
                if(ch == '#'){
                    StringBuilder sb = new StringBuilder("#");
                    boolean valid = false;
                    while((ch = br.read())!= '\n'){
                        sb.append((char)ch);
                        if(sb.toString().equals(tags[0])){
                            break;
                        }
                        else if(sb.toString().equals(tags[1]))valid = true;
                    }
                    if(valid){
                        parseVersion(sb.toString());
                        br.close();
                        return;
                    }
                }
                else if(line == 0) {
                    
                    readFileVersion_2(); //parseOldFormate();
                    br.close();
                    return;
                }
                line++;
            }
            br.close();
        }catch(IOException ioEx){
            
        }
    }
}
