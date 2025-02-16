/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Rfid {

    private long id;
    private String pyPath;

    public Rfid(String pyPath) {
        this.id = 0;
        this.pyPath = pyPath;
    }

    public Rfid() {
    }

    public long read() {

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                proc = rt.exec("cmd /c C://Users//Lenovo//Documents//NetBeansProjects//cashregister-v2//Read.py");
            } else {
                proc = rt.exec("python3 " + pyPath);
            }
            
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(proc.getInputStream())));
            if (!scanner.hasNext(".*Error*")) {
                id = Long.parseLong(scanner.next());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;

    }

    public void killPython() {
        try {
            Runtime.getRuntime().exec("killall python3");
        } catch (IOException ex) {
            Logger.getLogger(Rfid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
