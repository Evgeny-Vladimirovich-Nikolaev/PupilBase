/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pupilbase;


import pupilbase.mainframe.MainFrame;


/**
 *
 * @author Nobilis
 */
public class PupilBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mFr = new MainFrame();
        mFr.setBounds(400, 300, 300, 100);
        mFr.setVisible(true);
        /*Card c = new Card();
        c.setVisible(true);*/
    }
    
}
