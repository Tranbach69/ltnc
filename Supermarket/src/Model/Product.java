/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class Product {
    int ProdID;
    String ProdName;
    int ProdQty;
    double ProdPrice;
    String ProdCat;

    public Product(int ProdID, String ProdName, int ProdQty, double ProdPrice, String ProdCat) {
        this.ProdID = ProdID;
        this.ProdName = ProdName;
        this.ProdQty = ProdQty;
        this.ProdPrice = ProdPrice;
        this.ProdCat = ProdCat;
    }

    public Product(String ProdName, int ProdQty, double ProdPrice, String ProdCat) {
        this.ProdName = ProdName;
        this.ProdQty = ProdQty;
        this.ProdPrice = ProdPrice;
        this.ProdCat = ProdCat;
    }

    public int getProdID() {
        return ProdID;
    }

    public void setProdID(int ProdID) {
        this.ProdID = ProdID;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String ProdName) {
        this.ProdName = ProdName;
    }

    public int getProdQty() {
        return ProdQty;
    }

    public void setProdQty(int ProdQty) {
        this.ProdQty = ProdQty;
    }

    public double getProdPrice() {
        return ProdPrice;
    }

    public void setProdPrice(double ProdPrice) {
        this.ProdPrice = ProdPrice;
    }

    public String getProdCat() {
        return ProdCat;
    }

    public void setProdCat(String ProdCat) {
        this.ProdCat = ProdCat;
    }
    
}
