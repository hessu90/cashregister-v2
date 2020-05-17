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
public class Price {

    private final int eur;
    private final int sent;

    public Price(int eur, int sent) {
        if (sent > 99) {
            eur = eur + sent / 100;
            sent = sent % 100;
        }

        this.eur = eur;
        this.sent = sent;
    }
    public Price(double price) {
        int eur = 0;
        int sent = 0;
        
        try {
            eur = (int) (price);
            price = Math.round((price - eur) * 100);
            sent = (int) price;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.eur = eur;
        this.sent = sent;
    }

    public int eur() {
        return this.eur;
    }

    public int sent() {
        return this.sent;
    }

    @Override
    public String toString() {
        String nolla = "";
        if (this.sent < 10) {
            nolla = "0";
        }

        return this.eur + "." + nolla + this.sent;

    }

    public Price plus(Price plus) {
        int eur = this.eur + plus.eur();
        int sent = this.sent + plus.sent();

        if (sent > 99) {
            sent = sent - 100;
            eur = eur + 1;
        }

        return new Price(eur, sent);

    }

    public Price minus(Price minus) {
        int eur = this.eur - minus.eur();
        int sent = this.sent - minus.sent();

        if (sent < 0) {
            sent = sent + 100;
            eur = eur - 1;
        }

        if (eur < 0) {
            return new Price(0, 0);
        }
        return new Price(eur, sent);

    }

    public Price multiply(int multiplier) {
        int eur = this.eur * multiplier;
        int sent = this.sent * multiplier;

        return new Price(eur, sent);

    }

}
