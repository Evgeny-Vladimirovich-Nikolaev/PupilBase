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
        field_Last_Name.setEditable(false);
    }
    
}
