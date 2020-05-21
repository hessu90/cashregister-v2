/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ErrorMsg {

    private JDialog window;
    
    public ErrorMsg(JDialog window) {
        this.window = window;
    }
 
    public void showErr(String msg, String header) {
        JOptionPane.showMessageDialog(window, msg, header, JOptionPane.ERROR_MESSAGE);
    }
    
    public void showMsg(String msg, String header) {
        JOptionPane.showMessageDialog(window, msg, header, JOptionPane.INFORMATION_MESSAGE);
    }
    
}
