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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public long getSKU(long EAN) {
        String sql = "SELECT SKU FROM EAN WHERE EAN=?";
        long SKU = 0;
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            tuote = rs.getString("ProductName");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tuote;
    }

    public Product getProduct(long EAN) {
        long SKU = this.getSKU(EAN);

        if (this.getProductName(SKU) == null) {
            return null;
        } else {
            return new Product(this.getProductName(SKU), this.getPrice(EAN), 0, SKU);
        }
    }

    public Product getProductFromStock(long EAN) {
        
        if (getSKU(EAN) == EAN) {
            return null;
        }
        
        Product product = getProduct(EAN);
        
        if (product == null) {
            return null;
        }
        long SKU = product.getSKU();
        try {
            product.setQuan(getStockAmount(SKU));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            product = null;
        }

        return product;
    }

    public int getStockAmount(long SKU) throws SQLException {
        String sql = "SELECT InStock FROM Stock WHERE SKU=?";
        int quan = 0;
        Connection conn = this.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        

        pstmt.setLong(1, SKU);
        ResultSet rs = pstmt.executeQuery();

        quan = rs.getInt("InStock");
        return quan;
    }

    public Price getPrice(long EAN) {
        long SKU = this.getSKU(EAN);
        String sql = "SELECT Price FROM Products WHERE SKU=?";
        Double price = 0.00;
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            price = rs.getDouble("Price");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Price(price);
    }

    public String getUserName(long cardNo) {
        String sql = "SELECT Name FROM Users WHERE CardNo=?";
        String userName = "";

        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, cardNo);
            ResultSet rs = pstmt.executeQuery();
            userName = rs.getString("Name");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userName;
    }

    public ArrayList<String> getGroups() {

        String sql = "SELECT * FROM Groups";
        ArrayList<String> groups = new ArrayList<>();

        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                groups.add(rs.getString("Privilege") + " -- " + rs.getString("GroupName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return groups;
    }

    public boolean saveUserData(long cardNo, String userName, int groupID) {
        String sql = "";
        if (this.getUserName(cardNo).length() == 0) {
            sql = "INSERT INTO Users(Name, GroupID, CardNo) VALUES(?,?,?)";
        } else {
            sql = "UPDATE Users SET Name = ? , GroupID = ? WHERE CardNo = ?";
        }

        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setInt(2, groupID);
            pstmt.setLong(3, cardNo);
            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getUserGroup(long cardNo) {
        int groupID = -1;
        String sql = "SELECT GroupID FROM Users WHERE CardNo=?";
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, cardNo);
            ResultSet rs = pstmt.executeQuery();
            groupID = rs.getInt("GroupID");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return groupID;
    }

    public int getPrivilege(long cardNo) {
        int privilegeNo = -1;

        String sql = "SELECT Privilege FROM Groups, Users WHERE Users.CardNo=? AND Users.GroupID=Groups.ID";
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, cardNo);
            ResultSet rs = pstmt.executeQuery();
            privilegeNo = rs.getInt("Privilege");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return privilegeNo;

    }

    public boolean saveProductData(long EAN, String productName, Price purchPrice, Price sellPrice) {

        String sql = "INSERT INTO Products(ProductName, PurchacePrice, Price) VALUES(?,?,?)";

        long SKU = 0;
        double pPrice = Double.parseDouble(purchPrice.toString());
        double sPrice = Double.parseDouble(sellPrice.toString());

        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, productName);
            pstmt.setDouble(2, pPrice);
            pstmt.setDouble(3, sPrice);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            SKU = rs.getLong(1);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            SKU = -1;
        }

        if (SKU == -1) {
            return false;
        }
        if (!addEANToDB(SKU, EAN) || !addProductToStock(SKU)) {
            deleteFromProducts(SKU);
            deleteFromEAN(SKU);
            return false;
        }
        return true;

    }

    private boolean addEANToDB(long SKU, long EAN) {
        String sqlEAN = "INSERT INTO EAN(SKU, EAN) VALUES(?,?)";

        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sqlEAN)) {
            pstmt.setLong(1, SKU);
            pstmt.setLong(2, EAN);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    private boolean addProductToStock(long SKU) {
        String sqlEAN = "INSERT INTO Stock(SKU, InStock) VALUES(?,?)";

        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sqlEAN)) {
            pstmt.setLong(1, SKU);
            pstmt.setInt(2, 0);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return true;
    }

    private boolean deleteFromProducts(long SKU) {
        String sql = "DELETE FROM Products WHERE SKU = ?";
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean deleteFromEAN(long EAN) {

        String sql = "DELETE FROM EAN WHERE SKU = ?";
        try ( Connection conn = this.connect();  PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, EAN);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
