/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hessutek.cashregister;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBHandler {

    private String dbPath;
    private Connection conn;

    public DBHandler(String dbName) {
        this.dbPath = dbName;
    }

    public void connect() {
        this.conn = null;

        try {
            String url = "jdbc:sqlite:" + this.dbPath;
            this.conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
    }
    
    

    public long getSKU(long EAN) {
        this.connect();
        String sql = "SELECT SKU FROM EAN WHERE EAN=?";
        long SKU = 0;
        
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setLong(1, EAN);
            ResultSet rs = pstmt.executeQuery();

            SKU = rs.getLong("SKU");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        
        if (SKU == 0) {
            return EAN;
        } else {
            return SKU;
        }
        

    }

    public String getProductName(long SKU) {
        this.connect();
        String sql = "SELECT ProductName FROM Products WHERE SKU=?";
        String tuote = null;
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            tuote = rs.getString("ProductName");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return tuote;
    }

    public Product getProduct(long EAN) {
        long SKU = this.getSKU(EAN);

        if (this.getProductName(SKU) == null) {
            return null;
        } else {
            return new Product(this.getProductName(SKU), this.getSPrice(EAN), this.getPPrice(EAN),  0, SKU);
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
            System.out.println(e.getMessage() + " " + e.getClass());
            product = null;
        }

        return product;
    }

    public int getStockAmount(long SKU) throws SQLException {
        this.connect();
        String sql = "SELECT InStock FROM Stock WHERE SKU=?";
        int quan = 0;
        
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        

        pstmt.setLong(1, SKU);
        ResultSet rs = pstmt.executeQuery();

        quan = rs.getInt("InStock");
        this.close();
                
        return quan;
    }

    public Price getSPrice(long EAN) {
        long SKU = this.getSKU(EAN);
        String sql = "SELECT Price FROM Products WHERE SKU=?";
        Double price = 0.00;
        
        this.connect();
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            price = rs.getDouble("Price");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return new Price(price);
    }
    
    
    
    public Price getPPrice(long EAN) {
        long SKU = this.getSKU(EAN);
        String sql = "SELECT PurchacePrice FROM Products WHERE SKU=?";
        Double price = 0.00;
        
        this.connect();
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            ResultSet rs = pstmt.executeQuery();

            price = rs.getDouble("PurchacePrice");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return new Price(price);
    }

    public String getUserName(long cardNo) {
        this.connect();
        String sql = "SELECT Name FROM Users WHERE CardNo=?";
        String userName = "";

        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setLong(1, cardNo);
            ResultSet rs = pstmt.executeQuery();
            userName = rs.getString("Name");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return userName;
    }

    public ArrayList<String> getGroups() {
        this.connect();
        String sql = "SELECT * FROM Groups";
        ArrayList<String> groups = new ArrayList<>();

        try (Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                groups.add(rs.getString("Privilege") + " -- " + rs.getString("GroupName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return groups;
    }

    public boolean saveUserData(long cardNo, String userName, int groupID) {
        
        String sql = "";
        if (this.getUserName(cardNo).length() == 0) {
            sql = "INSERT INTO Users(Name, GroupID, CardNo) VALUES(?,?,?)";
        } else {
            sql = "UPDATE Users SET Name = ? , GroupID = ? WHERE CardNo = ?";
        }
        
        this.connect();
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setString(1, userName);
            pstmt.setInt(2, groupID);
            pstmt.setLong(3, cardNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
            return false;
        }
        this.close();
        return true;
    }

    public int getUserGroup(long cardNo) {
        this.connect();
        int groupID = -1;
        String sql = "SELECT GroupID FROM Users WHERE CardNo=?";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setLong(1, cardNo);
            ResultSet rs = pstmt.executeQuery();
            groupID = rs.getInt("GroupID");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return groupID;
    }

    public int getPrivilege(long cardNo) {
        this.connect();
        int privilegeNo = -1;

        String sql = "SELECT Privilege FROM Groups, Users WHERE Users.CardNo=? AND Users.GroupID=Groups.ID";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {
            pstmt.setLong(1, cardNo);
            ResultSet rs = pstmt.executeQuery();
            privilegeNo = rs.getInt("Privilege");

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
        }
        this.close();
        return privilegeNo;

    }

    public boolean saveProductData(long EAN, String productName, Price purchPrice, Price sellPrice, int quan) {
        
        if (getSKU(EAN) != EAN) {
            return updateProductData(new Product(productName, sellPrice, purchPrice, quan, EAN), getSKU(EAN));
        }
        
        String sql = "INSERT INTO Products(ProductName, PurchacePrice, Price) VALUES(?,?,?)";
        
        long SKU = 0;
        double pPrice = Double.parseDouble(purchPrice.toString());
        double sPrice = Double.parseDouble(sellPrice.toString());
        
        this.connect();
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
        if (!addEANToDB(SKU, EAN) || !addProductToStock(SKU, quan)) {
            deleteFromProducts(SKU);
            deleteFromEAN(SKU);
            return false;
        }
        this.close();
        return true;

    }

    private boolean addEANToDB(long SKU, long EAN) {
        this.connect();
        String sqlEAN = "INSERT INTO EAN(SKU, EAN) VALUES(?,?)";

        try (PreparedStatement pstmt = this.conn.prepareStatement(sqlEAN)) {
            pstmt.setLong(1, SKU);
            pstmt.setLong(2, EAN);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        this.close();
        return true;
    }

    private boolean addProductToStock(long SKU, int quan) {
        this.connect();
        String sqlEAN = "INSERT INTO Stock(SKU, InStock) VALUES(?,?)";
        
        try (PreparedStatement pstmt = this.conn.prepareStatement(sqlEAN)) {
            pstmt.setLong(1, SKU);
            pstmt.setInt(2, quan);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        this.close();
        return true;
    }

    private boolean deleteFromProducts(long SKU) {
        this.connect();
        String sql = "DELETE FROM Products WHERE SKU = ?";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setLong(1, SKU);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
            return false;
        }
        this.close();
        return true;
    }

    private boolean deleteFromEAN(long EAN) {
        this.connect();
        String sql = "DELETE FROM EAN WHERE SKU = ?";
        try (PreparedStatement pstmt = this.conn.prepareStatement(sql)) {

            pstmt.setLong(1, EAN);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage() + " " + e.getClass());
            return false;
        }
        this.close();
        return true;
    }
    private boolean updateProductData(Product product, long SKU) {
        this.connect();
        String sqlUpdate = "UPDATE Products SET ProductName = ?, PurchacePrice = ?, "
                + "Price = ? WHERE SKU = ?";
        
        try (PreparedStatement pstmt = this.conn.prepareStatement(sqlUpdate)) {
            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, Double.parseDouble(product.getpPrice().toString()));
            pstmt.setDouble(3, Double.parseDouble(product.getsPrice().toString()));
            pstmt.setLong(4, SKU);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + " " + e.getClass());
            return false;
        }
        this.close();
        return true;
        
    }
    
 

}
