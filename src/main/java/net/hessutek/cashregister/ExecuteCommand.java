/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Admin
 */
public class ExecuteCommand extends SwingWorker<Long, Object> {

    public ExecuteCommand() {
    }

    @Override
    public Long doInBackground() {
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            return (new Rfid("C://Users/Lenovo/Documents/NetBeansProjects/cashregister-v2/Read.py").read());
        } else {
            return (new Rfid("Read.py").read());
        }
    }

    @Override
    protected void done() {
        try {
        } catch (Exception ignore) {
        }
    }
    

}
