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
        int test = db.getPrivilege(Long.parseLong("990390461325"));
        System.out.println(test);
        
    }
    
}
