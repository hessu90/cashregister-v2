/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Texthandler {
    private JTextField textField;

    public Texthandler(JTextField textField) {
        this.textField = textField;
    }
    
    
    public void addChar(ActionEvent evt) {
        
        
        JButton button = null;
        if(evt.getSource() instanceof JButton) button = (JButton)evt.getSource();
        if (button == null) return;
        
        addChar(button.getText());
    }
    public void addChar(String str) {
        String prevText = this.textField.getText();
        this.textField.setText(prevText + str);
    }
    
    public void deleteLastChar() {
        if (this.textField.getText().length() == 0) return;
        this.textField.setText(this.textField.getText().substring(0, this.textField.getText().length() - 1));
    }
    
    
    
}
