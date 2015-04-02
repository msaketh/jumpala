package has;

import java.io.Serializable;
import java.sql.*;
import java.util.Vector;

public class Has {
   // JDBC driver name and database URL
    static String url = "jdbc:mysql://10.117.13.121:3306/dbhas";
    static String password = "89878";
    static String user = "kkk"; 
   public static void main(String[] args) {
  try{
            Statement stmt = null;
            Connection con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
           Vector a=new Vector();
           sec t = new sec();
           t.a = 898;
           a.add(5);
           a.add(46);
           a.add(98);
           a.add(t);
         /* String sql = "create table Customer" +
                   "(id int auto_increment not null , " +
                   " Name varchar(25), " + 
                   "Mobile varchar(10),"+
                  "Address varchar(50),"+
                  "Advance_room blob,"+
                  "Advance blob,"+
                  "ECID blob,"+
                  "ECOD blob,"+
                  "Room varchar(10),"+
                  "SCID int,"+
                  "SCOD int,"+
                  "RTP double,"+
                  "ISAC int,"+
                  "I varchar(15),"+                  
                  "Catering blob,"+                 
                   "History int,"+
                   " primary key (id))";*/
          
            /* String  sql="create table Menu" +
                   "(id int auto_increment not null , " +
                     "Item varchar(25),"+
                     "Price double,"+
                     " primary key (id))";*/
                     
        /*   String  sql="create table Central" +
                   "(id int auto_increment not null , " +
                     "Property varchar(25),"+
                     "Value blob,"+
                     " primary key (id))";
           stmt.executeUpdate(sql);
             sql ="INSERT INTO Central(property,value) "+"VALUES ('ManagerUsername','User123')"; 
             stmt.executeUpdate(sql);
           sql ="INSERT INTO Central(property,value) "+"VALUES ('Manager Password','User123')";
           stmt.executeUpdate(sql);
           String sql1 ="INSERT INTO Central(property,value) "+"VALUES ('Catering Username','User123')";
           stmt.executeUpdate(sql1);
           sql ="INSERT INTO Central(property,value) "+"VALUES ('Catering Password','User123')";
           stmt.executeUpdate(sql);
           sql ="INSERT INTO Central(property,value) "+"VALUES ('Receptionist Username','User123')";
           stmt.executeUpdate(sql);
             sql ="INSERT INTO Central(property,value) "+"VALUES ('Receptionist Password','User123')";
           stmt.executeUpdate(sql);
             sql ="INSERT INTO Central(property,value) "+"VALUES ('Token Numbers','T00')";
           stmt.executeUpdate(sql);
             sql ="INSERT INTO Central(property,value) "+"VALUES ('Identity Number','I00')";
           stmt.executeUpdate(sql);
             sql ="INSERT INTO Central(property,value) "+"VALUES ('Minimum Frequency','0.00')";
           stmt.executeUpdate(sql);
           Vector b=new Vector();
           b.add(3);
           b.add(2.5);
           b.add(3.5);
           b.add(3);
            sql ="INSERT INTO Central(property,value) "+"VALUES ('Tariff','"+b+"')";
           stmt.executeUpdate(sql);
            Vector c=new Vector();
           c.add(500);
           c.add(300);
           c.add(950);
           c.add(550);
            sql ="INSERT INTO Central(property,value) "+"VALUES ('Rates','"+c+"')";
           stmt.executeUpdate(sql);
            Vector d=new Vector();
           d.add(00);
           d.add(00);
           d.add(0);
           d.add(0);
             sql ="INSERT INTO Central(property,value) "+"VALUES ('Total Bookings','"+d+"')";
           stmt.executeUpdate(sql);*/
            Vector d=new Vector();
           d.add(0.2);
           d.add(2000);
           d.add(2);
           d.add(2.5);
           d.add(3);
           d.add(4);
             String sql ="INSERT INTO Central(property,value) "+"VALUES ('Discount','"+d+"')";
           stmt.executeUpdate(sql);
          // String sql ="INSERT INTO fruits(fruit)"+"VALUES ('"+a+"')";
             
             
             //  System.out.println(sql);
              
        
             /* String sql;  
           for(int i=1;i<89;i++)
           {
               String s="ALTER TABLE RoomSNA ADD D";
               s=s+i+" char DEFAULT 'A'";
               sql=s;
               System.out.println(sql);
                stmt.executeUpdate(sql);
           }*/
            //String sql ="DELETE FROM Central WHERE id=13";
            //stmt.executeUpdate(sql);
        }
        catch(Exception ex){
         }
   
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample

class sec implements Serializable
{
    public int a;
}