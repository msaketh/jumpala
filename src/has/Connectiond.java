/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;
 import java.sql.*;
/**
 *
 * @author MAHANKALI SAKETH
 */
public class Connectiond {
    
        static String url = "jdbc:mysql://localhost:3306/dbhas";
        static String password = "89878";
        static String user = "root";
        public static void main(String[] args) {
            
        
    }
        static Connection getconn() throws SQLException
        {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }
    
    
}
