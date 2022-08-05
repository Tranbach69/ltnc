/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import Model.Category;
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
public class CategoryModify {
    public static List<Category> findAll()
    {
        Connection Con = null;
        Statement St = null;
        ResultSet Rs = null;
    
        List<Category> CategoryList = new ArrayList<>();
        try{
        Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
        St = Con.createStatement();
        Rs = St.executeQuery("Select * from User1.CATEGORYTBL");
        while(Rs.next())
        {
            Category cat = new Category(Rs.getInt("CATID"),Rs.getString("CATNAME"),Rs.getString("CATDESC"));
            CategoryList.add(cat);
        }
     
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
        return CategoryList;
    }
    public static void insert(Category Cat)
    {
        Connection Con = null;
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
            PreparedStatement add = Con.prepareStatement("insert into CATEGORYTBL values (?,?,?)");
            add.setInt(1, Integer.valueOf(Cat.getCatID()));
            add.setString(2, Cat.getCatName());
            add.setString(3, Cat.getCatDesc());
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
                String query = "Delete from User1.CATEGORYTBL Where CATID =" + id;
                Statement Add = Con.createStatement();
                Add.executeUpdate(query);
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    public static void update(Category Cat)
    {
        Connection Con = null;
        try{
                Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
                String query = "Update User1.CATEGORYTBL set CATNAME='"+Cat.getCatName()+"'"+",CATDESC='"+Cat.getCatDesc()+"'"+"where CATID="+ Cat.getCatID();
                Statement add = Con.createStatement();
                add.executeUpdate(query);
                
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
    }
    
}
