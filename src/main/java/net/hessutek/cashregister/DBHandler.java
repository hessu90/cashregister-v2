/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DBHandler {

    private String dbPath;

    public DBHandler(String dbName) {
        this.dbPath = dbName;
    }

    public Connection connect() {
        Connection conn = null;

        try {

            String url = "jdbc:sqlite:" + this.dbPath;
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public long getSKU(long EAN) {
        String sql = "SELECT SKU FROM EAN WHERE EAN=?";
        long SKU = 0;
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, EAN);
            ResultSet rs = pstmt.executeQuery();

            SKU = rs.getLong("SKU");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (SKU == 0) {
            return EAN;
        } else {
            return SKU;
        }

    }

    public String getProductName(long SKU) {
        String sql = "SELECT ProductName FROM Products WHERE SKU=?";
        String tuote = null;
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            tuote = rs.getString("ProductName");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tuote;
    }

    public String getProduct(long EAN) {
        long SKU = this.getSKU(EAN);
        return this.getProductName(SKU);

    }

    public Price getPrice(long EAN) {
        long SKU = this.getSKU(EAN);
        String sql = "SELECT Price FROM Products WHERE SKU=?";
        Double price = 0.00;
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            price = rs.getDouble("Price");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Price(price);
    }

    public String getUserName(long cardNo) {

        return null;
    }

    public ArrayList<String> getGroups() {

        String sql = "SELECT * FROM Groups";
        ArrayList<String> groups = new ArrayList<String>();
        
        

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
               groups.add(rs.getString("Privilege") + " -- " + rs.getString("GroupName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return groups;
    }
}
