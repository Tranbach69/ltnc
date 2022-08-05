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
public class Category {
    int CatID;
    String CatName;
    String CatDesc;

    public Category(int CatID, String CatName, String CatDesc) {
        this.CatID = CatID;
        this.CatName = CatName;
        this.CatDesc = CatDesc;
    }

    public Category(String CatName, String CatDesc) {
        this.CatName = CatName;
        this.CatDesc = CatDesc;
    }

    public int getCatID() {
        return CatID;
    }

    public void setCatID(int CatID) {
        this.CatID = CatID;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String CatName) {
        this.CatName = CatName;
    }

    public String getCatDesc() {
        return CatDesc;
    }

    public void setCatDesc(String CatDesc) {
        this.CatDesc = CatDesc;
    }
    
}
