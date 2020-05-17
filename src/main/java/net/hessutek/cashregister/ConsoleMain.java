/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

/**
 *
 * @author Admin
 */
public class ConsoleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DBHandler db = new DBHandler("MainDB.db");
        String[] groups = db.getGroups().toArray(new String[0]);
        System.out.println(groups[0]);
        db.saveUserData(1234567, "kissa", 3);
        
        
        
    }
    
}
