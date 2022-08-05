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
public class Seller {
    int SelID;
    String SelName;
    String SelPass;
    String SelGender;
    
    public Seller() {
    }

    public Seller(int SelID, String SelName, String SelPass, String SelGender) {
        this.SelID = SelID;
        this.SelName = SelName;
        this.SelPass = SelPass;
        this.SelGender = SelGender;
    }

    public Seller(String SelName, String SelPass, String SelGender) {
        this.SelName = SelName;
        this.SelPass = SelPass;
        this.SelGender = SelGender;
    }

    public int getSelID() {
        return SelID;
    }

    public void setSelID(int SelID) {
        this.SelID = SelID;
    }

    public String getSelName() {
        return SelName;
    }

    public void setSelName(String SelName) {
        this.SelName = SelName;
    }

    public String getSelPass() {
        return SelPass;
    }

    public void setSelPass(String SelPass) {
        this.SelPass = SelPass;
    }

    public String getSelGender() {
        return SelGender;
    }

    public void setSelGender(String SelGender) {
        this.SelGender = SelGender;
    }
    
}
