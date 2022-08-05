/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import Model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ProductModify {
    public static List<Product> findAll()
    {
        Connection Con = null;
        Statement St = null;
        ResultSet Rs = null;
    
        List<Product> ProductList = new ArrayList<>();
        try{
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
        St = Con.createStatement();
        Rs = St.executeQuery("Select * from User1.PRODTBL");
        while(Rs.next())
        {
            Product Prod = new Product(Rs.getInt("PRODID"),Rs.getString("PRODNAME"),Rs.getInt("PRODQTY"),Rs.getDouble("PRODPRICE"),Rs.getString("PRODCAT"));
            ProductList.add(Prod);
        }
     
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
        return ProductList;
    }
    public static void insert(Product Prod)
    {
        Connection Con = null;
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
            PreparedStatement add = Con.prepareStatement("insert into PRODTBL values (?,?,?,?,?)");
            add.setInt(1, Integer.valueOf(Prod.getProdID()));
            add.setString(2, Prod.getProdName());
            add.setInt(3, Prod.getProdQty());
            add.setDouble(4, Prod.getProdPrice());
            add.setString(5, Prod.getProdCat());
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
                String query = "Delete from User1.PRODTBL Where PRODID =" + id;
                Statement Add = Con.createStatement();
                Add.executeUpdate(query);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    public static void update(Product Prod)
    {
        Connection Con = null;
        try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
                String query = "Update User1.PRODTBL set PRODNAME='"+Prod.getProdName()+"'"+",PRODQTY="+Prod.getProdQty()+",PRODPRICE="+Prod.getProdPrice()+",PRODCAT='"+Prod.getProdCat()+"'"+"where PRODID="+ Prod.getProdID();
                Statement add = Con.createStatement();
                add.executeUpdate(query);
                
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
    }
    
}
