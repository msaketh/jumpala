/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHANKALI SAKETH
 */
public class Refresh {
    public static void refresh()
    {
        try
        {
            Connection con = Connectiond.getconn();
            Statement stmt = con.createStatement();
            String sql = "SELECT id,Value FROM central";
            ResultSet rs = stmt.executeQuery(sql);
            int id;
            int presentday = 1;
            while(rs.next())
            {
                 id  = rs.getInt("id");
                 if(id ==14)
                 {
                            
                     presentday = rs.getInt("Value");
                            
                  }
             }
            sql = "ALTER TABLE roomsa DROP COLUMN D"+presentday;
            stmt.executeUpdate(sql);
            sql = "ALTER TABLE roomsna DROP COLUMN D"+presentday;
            stmt.executeUpdate(sql);
            sql = "ALTER TABLE roomda DROP COLUMN D"+presentday;
            stmt.executeUpdate(sql);
            sql = "ALTER TABLE roomdna DROP COLUMN D"+presentday;
            stmt.executeUpdate(sql);
            int  j =0;
            sql = "ALTER TABLE roomsa ADD D";
            j = presentday + 90;
            sql = sql +j+" char DEFAULT 'A'";
            stmt.executeUpdate(sql);
            sql = "ALTER TABLE roomsna ADD D";
            j = presentday + 90;
            sql = sql +j+" char DEFAULT 'A'";
            stmt.executeUpdate(sql);
           sql = "ALTER TABLE roomda ADD D";
            j = presentday + 90;
            sql = sql +j+" char DEFAULT 'A'";
            stmt.executeUpdate(sql);
            sql = "ALTER TABLE roomdna ADD D";
            j = presentday + 90;
            sql = sql +j+" char DEFAULT 'A'";
            stmt.executeUpdate(sql);
            String updatestr = "UPDATE central SET Value = ?  WHERE id = 14";
            PreparedStatement pp = Connectiond.getconn().prepareStatement(updatestr);
            ++presentday;
            int k = presentday;
            pp.setObject(1,k);
            pp.executeUpdate();
        }
        catch(Exception ex)
        {
            
        }
    }
    
}
