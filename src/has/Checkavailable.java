/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SivaKesava1
 */
public class Checkavailable {
      static String url = "jdbc:mysql://10.117.13.121:3306/dbhas";
      static String password = "89878";
      static String user = "kkk"; 
    public static String check(int s,int t,int d) throws SQLException
    {
         Statement stmt = null;
         String w=null;
         int found=0;
        // System.out.println("At the start");
           try{ Connection conn= DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();}
           catch(Exception rx)
           {
               System.out.println("in catch");
           }
             String sql = "SELECT RoomNo, ";
            for(int i=s;i<t;i++)
            {
             sql=sql+" D"+i+","   ;
            }
            sql=sql+" D"+t+" FROM ";
            if(d==0)
                sql=sql+"roomsa";   
            if(d==1)
                sql=sql+"roomsna"; 
            if(d==2)
                sql=sql+"roomda"; 
            if(d==3)
                sql=sql+"roomdna"; 
            //System.out.println(sql);
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
        if(found==1)
        {
            break;
        }
         for(int j=s;j<=t;j++)
         {
             String sa="D"+j;

            String c= rs.getString(sa);
          //   System.out.println(c);
             if(c.equalsIgnoreCase("A"))
             {
                 found=1;
                 w=rs.getString("RoomNo");
             }
             else
             {
                 found=0;
                 w=null;
                 break;
             }
                 
         }
         
      }
      rs.close();
  /*     try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }*/
        return w;
        
    }
}
