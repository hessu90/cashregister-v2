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
public class Product {

    private String productName;
    private Price sPrice, pPrice;
    private int quan;
    private long SKU;

    public Product(String productName, Price sPrice, int quan) {
        this.productName = productName;
        this.sPrice = sPrice;
        this.quan = quan;
    }

    public Product(String productName, Price sPrice, int quan, long SKU) {
        this.productName = productName;
        this.sPrice = sPrice;
        this.quan = quan;
        this.SKU = SKU;
    }
    
    public Product(String productName, Price sPrice, Price pPrice,  int quan, long SKU) {
        this.productName = productName;
        this.sPrice = sPrice;
        this.pPrice = pPrice;
        this.quan = quan;
        this.SKU = SKU;
    }
    

    public Price getPrice() {
        return sPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuan() {
        return quan;
    }
    
    public Price getTotalPrice() {
        return this.sPrice.multiply(this.quan);
    }
    
    public void setQuan(int quan) {
        this.quan = quan;
    }

    public long getSKU() {
        return this.SKU;
    }
    

    @Override
    public String toString() {
        return this.quan + " * (" + this.sPrice + ")" + " == " + this.getTotalPrice() + " -- " + this.productName;
    }
    
}
