/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import static has.Checkavailable.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SivaKesava1
 */
public class Checkcustomer {
    static String url = "jdbc:mysql://10.117.13.121:3306/dbhas";
      static String password = "89878";
      static String user = "kkk"; 
    public static int check(String name,String mobile,String address) throws SQLException
    {
         Statement stmt = null;
        int w=0,j=0;
        // System.out.println("At the start");
           try{ Connection conn= DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();}
           catch(Exception rx)
           {
               System.out.println("in catch");
           }
             String sql = "SELECT id,name,mobile FROM Customer ";
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()){
       
            j++;
            String c= rs.getString("name");
            String t=rs.getString("mobile");
           // System.out.println(c);
          //  System.out.println(t);
             if(c.equalsIgnoreCase(name))
             {
                System.out.println("Inside c");
                 if(t.equalsIgnoreCase(mobile))
                 {
                      System.out.println("Inside t");
                 w=rs.getInt("id");
                     //System.out.println("w is "+w);
                 break;
                 }                 
             }
             else
             {
                w=0;
             }
                 
         }
       //  System.out.println("wis"+w);
         rs.close();
        if(w==0)
         {
             sql="INSERT INTO Customer(name,mobile,address)"+" VALUES ('"+name+"','"+mobile+"','"+address+"')";
          //  System.out.println(sql);
             stmt.executeUpdate(sql);
             return j+1;
         }
        return w;
      }
      
    }
