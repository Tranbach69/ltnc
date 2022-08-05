/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import Model.Seller;

/**
 *
 * @author Administrator
 */
public class SellerModify {
   
    public static List<Seller> findAll()
    {
        Connection Con = null;
        Statement St = null;
        ResultSet Rs = null;
    
        List<Seller> sellerList = new ArrayList<>();
        try{
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
        St = Con.createStatement();
        Rs = St.executeQuery("Select * from User1.UNTITLED");
        while(Rs.next())
        {
            Seller Sel = new Seller(Rs.getInt("SELID"),Rs.getString("SELNAME"),Rs.getString("SELPASS"),Rs.getString("SELGENDER"));
            sellerList.add(Sel);
        }
     
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
        return sellerList;
    }
    public static void insert(Seller Sel)
    {
        Connection Con = null;
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
            PreparedStatement add = Con.prepareStatement("insert into UNTITLED values (?,?,?,?)");
            add.setInt(1, Integer.valueOf(Sel.getSelID()));
            add.setString(2, Sel.getSelName());
            add.setString(3, Sel.getSelPass());
            add.setString(4, Sel.getSelGender());
            int row = add.executeUpdate();
            
            Con.close();
            
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void delete(int id)
    {
        Connection Con = null;
        try
            {
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
                String query = "Delete from User1.UNTITLED Where SELID =" + id;
                Statement Add = Con.createStatement();
                Add.executeUpdate(query);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    public static void update(Seller Sel)
    {
        Connection Con = null;
        try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
                String query = "Update User1.UNTITLED set SELNAME='"+Sel.getSelName()+"'"+",SELPASS='"+Sel.getSelPass()+"'"+",SELGENDER='"+Sel.getSelGender()+"'"+"where SELID="+ Sel.getSelID();
                Statement add = Con.createStatement();
                add.executeUpdate(query);
                
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
    }
    
}
