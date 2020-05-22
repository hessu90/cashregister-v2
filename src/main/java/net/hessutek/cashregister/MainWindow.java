/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Admin
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    private ArrayList<Product> productList;
    private ExecuteCommand mw;
    private DBHandler db;
    private ErrorMsg errHandler;

    public MainWindow() {
        initComponents();
        this.EAN.requestFocus();
        this.db = new DBHandler("MainDB.db");
        this.productList = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        but6 = new javax.swing.JButton();
        but5 = new javax.swing.JButton();
        but4 = new javax.swing.JButton();
        but9 = new javax.swing.JButton();
        ENTER = new javax.swing.JButton();
        but8 = new javax.swing.JButton();
        but0 = new javax.swing.JButton();
        but7 = new javax.swing.JButton();
        period = new javax.swing.JButton();
        but3 = new javax.swing.JButton();
        but2 = new javax.swing.JButton();
        but1 = new javax.swing.JButton();
        backspace = new javax.swing.JButton();
        EAN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        products = new javax.swing.JList<>();
        quan = new javax.swing.JTextField();
        multiplybut = new javax.swing.JButton();
        sumLab = new javax.swing.JLabel();
        sum = new javax.swing.JLabel();
        delbut = new javax.swing.JButton();
        stock = new javax.swing.JButton();
        cardpayment = new javax.swing.JButton();
        cashpayment = new javax.swing.JButton();
        admin = new javax.swing.JButton();
        addproduct = new javax.swing.JButton();
        stock2 = new javax.swing.JButton();
        stock3 = new javax.swing.JButton();
        warnings = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);

        but6.setText("6");
        but6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but5.setText("5");
        but5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but4.setText("4");
        but4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but9.setText("9");
        but9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        ENTER.setText("ENTER");
        ENTER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EANHandler(evt);
            }
        });

        but8.setText("8");
        but8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but0.setText("0");
        but0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but7.setText("7");
        but7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        period.setText(".");
        period.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but3.setText("3");
        but3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but2.setText("2");
        but2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        but1.setText("1");
        but1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });

        backspace.setText("<--");
        backspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backspaceActionPerformed(evt);
            }
        });

        EAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EANHandler(evt);
            }
        });

        products.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(products);

        quan.setText("1");

        multiplybut.setText("*");
        multiplybut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiplybutActionPerformed(evt);
            }
        });

        sumLab.setText("Summa");

        sum.setText("0.00");

        delbut.setText("DEL");
        delbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbutActionPerformed(evt);
            }
        });

        stock.setText("Varasto");
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });

        cardpayment.setText("Korttimaksu");
        cardpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardpaymentActionPerformed(evt);
            }
        });

        cashpayment.setText("Käteismaksu");

        admin.setText("ADMIN");
        admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminActionPerformed(evt);
            }
        });

        addproduct.setText("Lisää tuote");
        addproduct.setEnabled(false);
        addproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addproductActionPerformed(evt);
            }
        });

        stock2.setEnabled(false);

        stock3.setEnabled(false);

        warnings.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quan, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EAN, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(warnings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sumLab, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sum, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cashpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cardpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addproduct, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(stock2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stock3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(but4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(but7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(but1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(but0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backspace))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ENTER)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(multiplybut, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delbut, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EAN, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(quan)
                    .addComponent(sum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sumLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(warnings, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stock2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stock3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cardpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cashpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(but7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(but4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(but1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(but0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(multiplybut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delbut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPressed
        if (this.EAN.getText().contains("INVALIIDI") || this.EAN.getText().contains("PRODUCT NO")) {
            this.EAN.setText("");
        }
        Texthandler texthandler = new Texthandler(EAN);
        texthandler.addChar(evt);
        this.EAN.requestFocus();
    }//GEN-LAST:event_buttonPressed

    private void backspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backspaceActionPerformed
        Texthandler texthandler = new Texthandler(EAN);
        texthandler.deleteLastChar();
    }//GEN-LAST:event_backspaceActionPerformed

    private void multiplybutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiplybutActionPerformed

        try {
            this.quan.setText("" + Integer.parseInt(this.EAN.getText()));
            this.EAN.setText("");
        } catch (Exception e) {
            this.warnings.setText("INVALIIDI NUMBER");
        }
        this.EAN.requestFocus();
    }//GEN-LAST:event_multiplybutActionPerformed

    private void delbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbutActionPerformed
        DefaultListModel<String> dlm = new DefaultListModel<String>();
        ListModel<String> model = this.products.getModel();

        this.EAN.setText("");
        this.warnings.setText("");
        this.addproduct.setEnabled(false);

        if (this.products.getSelectedIndex() == -1) {
            this.EAN.requestFocus();
            return;
        }

        int selected = this.products.getSelectedIndex();
        Price sum = new Price(0, 0);
        productList.remove(selected);

        for (Product pro : productList) {
            dlm.addElement(pro.toString());
            sum = sum.plus(pro.getTotalPrice());
        }

        this.sum.setText("" + sum);
        this.products.setModel(dlm);
        this.EAN.requestFocus();

    }//GEN-LAST:event_delbutActionPerformed

    private void EANHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EANHandler
        if (EAN.getText().equals("ABORT")) {
            System.exit(0);
        }
        this.addproduct.setEnabled(false);
        this.warnings.setText("");

        long EAN = 0;

        try {
            EAN = Long.valueOf(this.EAN.getText());
        } catch (Exception e) {
            this.warnings.setText("EAN / SKU INVALIIDI");
            return;
        }

        Product product = db.getProduct(EAN);
        if (product == null) {
            this.warnings.setText("PRODUCT NO FOUND");
            this.addproduct.setEnabled(true);
            return;
        }
        Price price = product.getsPrice();
        int quan = 1;

        try {
            quan = Integer.valueOf(this.quan.getText());
        } catch (Exception e) {
            this.warnings.setText("INVALIIDI QUANTITY");
            return;
        }

        Price sum = new Price(0, 0);
        System.out.println(sum);

        product.setQuan(quan);
        productList.add(product);

        DefaultListModel<String> dlm = new DefaultListModel<String>();
        ListModel<String> model = this.products.getModel();

        for (Product pro : productList) {
            dlm.addElement(pro.toString());
            sum = sum.plus(pro.getTotalPrice());
        }

        this.products.setModel(dlm);
        this.EAN.setText("");
        this.quan.setText("1");
        this.sum.setText(sum + "");
        this.EAN.requestFocus();

    }//GEN-LAST:event_EANHandler

    private void cardpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardpaymentActionPerformed

        mw = new ExecuteCommand();
        CardDlg dlg = new CardDlg(this, true, mw);
        dlg.setVisible(true);
        long id = 0;
        try {
            id = mw.get();
            System.out.println(id);
        } catch (InterruptedException | ExecutionException | CancellationException ex) {
            id = 0;
        }
        if (id == 0) {
            this.EAN.setText("Virhe maksussa!");
        } else {
            this.EAN.setText("Maksu onnistui");
        }
    }//GEN-LAST:event_cardpaymentActionPerformed

    private void addproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addproductActionPerformed

        long EAN = 0;
        try {
            EAN = Long.parseLong(this.EAN.getText());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (EAN == 0) {
            this.warnings.setText("INVALIIDI EAN");
            return;
        }
        JDialog dlg = new AddProduct(this, true, EAN);

        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            dlg.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        }
        dlg.setVisible(true);

        this.addproduct.setEnabled(false);
        this.EAN.setText("");
        this.warnings.setText("");
        this.EAN.requestFocus();

    }//GEN-LAST:event_addproductActionPerformed

    private void adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminActionPerformed
        if (this.EAN.getText().contains("999")) {
            System.exit(0);
        }

        mw = new ExecuteCommand();
        CardDlg cardDlg = new CardDlg(this, true, mw);
        cardDlg.setVisible(true);
        long id = 0;
        try {
            id = mw.get();
        } catch (InterruptedException | ExecutionException | CancellationException ex) {
            id = 0;
            return;
        }

        if (db.getPrivilege(id) != 999) {
            JOptionPane.showMessageDialog(this,
                    "Ei oikeuksia admin paneeliin :(",
                    "Ei oikeuksia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        JDialog dlg = new UserHandlerDlg(this, true);
        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            dlg.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        }
        dlg.setVisible(true);

        this.addproduct.setEnabled(false);
        this.EAN.setText("");
        this.warnings.setText("");
        this.EAN.requestFocus();
    }//GEN-LAST:event_adminActionPerformed

    private void stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockActionPerformed

        mw = new ExecuteCommand();
        CardDlg cardDlg = new CardDlg(this, true, mw);
        cardDlg.setVisible(true);
        long id;
        try {
            id = mw.get();
        } catch (InterruptedException | ExecutionException | CancellationException ex) {
            id = 0;
        }
        if (id == 0) {
            JOptionPane.showMessageDialog(this,
                    "Kortti virhe, kokeile uudestaan",
                    "Kortti virhe",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int userID = db.getUserID(id);
        if (userID == -1) {
            JOptionPane.showMessageDialog(this,
                    "Kortti virhe, kokeile uudestaan",
                    "Kortti virhe",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        //long id = Long.parseLong("990390461325");
        //int userID = 1;
        int privilege = db.getPrivilege(id);
        boolean isAdmin;
        isAdmin = privilege == 999;

        JDialog dlg = new StockUI(this, true, isAdmin, userID);

        if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
            dlg.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        }
        dlg.setVisible(true);

        this.addproduct.setEnabled(false);
        this.EAN.setText("");
        this.warnings.setText("");
        this.EAN.requestFocus();

    }//GEN-LAST:event_stockActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow dlg = new MainWindow();
                if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                    dlg.setExtendedState(dlg.MAXIMIZED_BOTH);
                    dlg.setSize(Toolkit.getDefaultToolkit().getScreenSize());
                }

                dlg.setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EAN;
    private javax.swing.JButton ENTER;
    private javax.swing.JButton addproduct;
    private javax.swing.JButton admin;
    private javax.swing.JButton backspace;
    private javax.swing.JButton but0;
    private javax.swing.JButton but1;
    private javax.swing.JButton but2;
    private javax.swing.JButton but3;
    private javax.swing.JButton but4;
    private javax.swing.JButton but5;
    private javax.swing.JButton but6;
    private javax.swing.JButton but7;
    private javax.swing.JButton but8;
    private javax.swing.JButton but9;
    private javax.swing.JButton cardpayment;
    private javax.swing.JButton cashpayment;
    private javax.swing.JButton delbut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton multiplybut;
    private javax.swing.JButton period;
    private javax.swing.JList<String> products;
    private javax.swing.JTextField quan;
    private javax.swing.JButton stock;
    private javax.swing.JButton stock2;
    private javax.swing.JButton stock3;
    private javax.swing.JLabel sum;
    private javax.swing.JLabel sumLab;
    private javax.swing.JLabel warnings;
    // End of variables declaration//GEN-END:variables
}
