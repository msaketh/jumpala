/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author MAHANKALI SAKETH
 */
public class CheckCustomer2 {
    
    public static int check(String name,String mobile) throws SQLException
    {
        Statement stmt = null;
        int w=0,j=0;
        try
        {
            Connection conn = Connectiond.getconn();   
            stmt = conn.createStatement();
        }
        catch(Exception rx)
        {
              
        }
        String sql = "SELECT id,name,mobile FROM Customer ";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        {
      
             String c= rs.getString("name");
             String t=rs.getString("mobile");
            // System.out.println(c);
            //  System.out.println(t);
            if(c.equalsIgnoreCase(name))
            {
                 if(t.equalsIgnoreCase(mobile))
                 {
                     w=rs.getInt("id");
                     break;
                 }                 
            }
            else
            {
                w=0;
            }
                 
         }
        rs.close();
        return w;
      }
    
}
