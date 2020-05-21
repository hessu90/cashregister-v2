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
        System.out.println(db.saveProductData(1445, "kissa3", new Price(0,0), new Price(1, 0), 0));
        
    }
    
}
