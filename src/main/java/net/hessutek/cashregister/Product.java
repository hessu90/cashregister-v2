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
    private Price price;
    private int quan;

    public Product(String productName, Price price, int quan) {
        this.productName = productName;
        this.price = price;
        this.quan = quan;
    }

    public Price getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuan() {
        return quan;
    }
    
    public Price getTotalPrice() {
        return this.price.multiply(this.quan);
    }
    
    public void setQuan(int quan) {
        this.quan = quan;
    }

    @Override
    public String toString() {
        return this.quan + " * (" + this.price + ")" + " == " + this.getTotalPrice() + " -- " + this.productName;
    }
    
}
