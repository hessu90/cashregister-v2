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
        System.out.println(db.saveProductData(123445, "kissa", new Price(12,12), new Price(99,99)));
        System.out.println(db.saveProductData(12344, "kissa", new Price(12,12), new Price(99,99)));
        System.out.println(db.saveProductData(1235, "kissa", new Price(12,12), new Price(99,99)));
        System.out.println(db.saveProductData(1445, "kissa", new Price(12,12), new Price(99,99)));
        
        
    }
    
}
