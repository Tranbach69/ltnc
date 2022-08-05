/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modify;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Model.KhuPho;

/**
 *
 * @author Administrator
 */
public class BillModify {
    public static void insert(KhuPho B)
    {
        Connection Con = null;
        try{
            Con = DriverManager.getConnection("jdbc:derby://localhost:1527/Supermarketdb","User1","1234");
            PreparedStatement add = Con.prepareStatement("insert into BILLTBL values (?,?,?,?)");
            add.setInt(1, Integer.valueOf(B.getBilID()));
            add.setDouble(2, B.getMoney());
            add.setString(3, B.getSelName());
            add.setDate(4, B.getCreateDay());
            int row = add.executeUpdate();
            
            Con.close();
            
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
