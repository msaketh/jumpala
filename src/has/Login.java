






















































































































































































































/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHANKALI SAKETH
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        text = new javax.swing.JTextField();
        c1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel5.setFont(jLabel5.getFont().deriveFont((jLabel5.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD));
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("WELCOME TO HOTEL AUTOMATION SOFTWARE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        getContentPane().add(text, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 30));

        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MANAGER", "RECEPTIONIST", "CATERING SERVICES" }));
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 140, -1));

        jLabel4.setText("LOGIN AS:-");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));

        jLabel3.setText("PASSWORD:-");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, 30));

        jLabel2.setText("USERNAME:-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/has/Hotel1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String str = (String)c1.getSelectedItem();
        String str1 = t1.getText();
        
        String str2 = text.getText();
        String m1 = "";
           String m2 = "";
           String r1 = "";
           String r2 = "";
           String c1 = "";
           String c2 = "";
           String sql;
           int presentday =1;
        try 
        {
           
           Connection con =  Connectiond.getconn();
           Statement stmt = con.createStatement();
           sql = "SELECT id,Value FROM central";
           ResultSet rs = stmt.executeQuery(sql);
           
           int id;
           while(rs.next())
           {
               id  = rs.getInt("id");
               /*byte[] buf = rs.getBytes("copyDetails");
                ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(buf));
                ArrayList<SubBook> copyDetails = (ArrayList<SubBook>) o.readObject();*/
               if(id == 1)
               {
                    m1 = rs.getString("Value");
               }
               if(id == 2)
               {
                    m2 = rs.getString("Value");
               }
               if(id == 3)
               {
                    c1 = rs.getString("Value");
               }
               if(id == 4)
               {
                    c2 = rs.getString("Value");
               }
               if(id == 5)
               {
                    r1 = rs.getString("Value");
               }
               if(id == 6)
               {
                    r2 = rs.getString("Value");
                    break;
               }
                 
            }
           }
           catch(Exception ex)
           {
              
           }
           if(str.equals("MANAGER"))
           {
                try {
                      if(str1.equals(m1)&& str2.equals(m2) )
                      {
                        ManagerFunctions2 m = new ManagerFunctions2();
                        t1.setText("");
                        text.setText("");
                        m.setVisible(true);
                     }
                   else{
                       JOptionPane.showMessageDialog(rootPane,"PLease enter username/password correctly");
                    }
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
           if(str.equals("RECEPTIONIST"))
           {
                try {
                      if(str1.equals(r1)&& str2.equals(r2) )
                      {
                         Connection con2 =  Connectiond.getconn();
                         Statement stmt2 = con2.createStatement();
                         String sql2 = "SELECT id,Value FROM central";
                         ResultSet rs2 = stmt2.executeQuery(sql2);
                         int id;
                         while(rs2.next())
                        {
                            id  = rs2.getInt("id");
                            if(id ==14)
                            {
                            
                                 presentday = rs2.getInt("Value");
                            
                             }
                        }
    
                        String sql3 = "SELECT id,ECID,ISAC FROM Customer";
                        Connection con3 =  Connectiond.getconn();
                        Statement stmt3 = con3.createStatement();
                        ResultSet rs3 = stmt3.executeQuery(sql3);
                        byte[] arr=null;
                        Vector ecid = new Vector();
                        int check1 = 0;
                        int g = 0;
                        while(rs3.next())
                       {
                             check1  = 0;
                             arr = rs3.getBytes("ECID");
                             g = rs3.getInt("id");
                             if(arr!=null)
                             {
                                   ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr)); 
                                   ecid = (Vector)o.readObject();
                                   for(int j=0;j<ecid.size();++j)
                                  {
                                        if((long)presentday == (long)ecid.get(j))
                                         {
                                              check1  =1;
                                              break;
                                         }
                                  }
                                  if(check1==1)
                                  {
                                     String  sql4="UPDATE customer"+" SET ISAC=1" +" WHERE id="+g;
                                     Connection con4 = Connectiond.getconn();
                                     Statement stmt4 = con4.createStatement();
                                     stmt4.executeUpdate(sql4);
                                     sql4="SELECT history FROM Customer"+" WHERE id="+g;
                                     int history=0,present=0;
                                     double fre=0;
                                     try {
                                           ResultSet rsz = stmt4.executeQuery(sql4);
                                            history = rsz.getInt("history");         
                                         } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                     sql4 = "SELECT id,Value FROM central";
                                     {
                                        ResultSet rsz = stmt4.executeQuery(sql4);
                                        double d = 0.0;
                                        int iad;
                                        while(rsz.next())
                                         {
                                              iad  = rsz.getInt("id");
                                              if(iad == 9)
                                              {
                                                    fre = rsz.getDouble("Value");
                                               }
               
                                          }
                                      }
                                     double custfre=history/(int)presentday;
                                     if(custfre>=fre)
                                     {
                                          sql4="SELECT id,Identity FROM Customer"+" WHERE id="+g;
                                          String sa=null;
                                          try {
                                          ResultSet rsz = stmt4.executeQuery(sql4);
                                          sa= rsz.getString("Identity");         
                                         } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                          if(sa==null)
                                          {
                                            String s = null;
                                            sql4 = "SELECT id,Value FROM central";
                                           {
                                         ResultSet rsz = stmt4.executeQuery(sql4);
                                          int iad;
                                           while(rsz.next())
                                            {
                                                iad  = rsz.getInt("id");
                                                if(iad == 8)
                                                {
                                                    s= rsz.getString("value");
                                                }
               
                                            }
                                           }
                                           try {
                                                     String s1=s.substring(1);
                                                     int i=Integer.parseInt(s1);
                                                     i=i+1;
                                                     s1="I"+i;
                                                     sql4="UPDATE customer"+" SET I="+"'"+s1+"'"+" WHERE id="+g;
                                                     stmt4.executeUpdate(sql4);
                                                      sql4="UPDATE customer"+" SET Identity="+"'"+s1+"'"+" WHERE id="+g;
                                                     stmt4.executeUpdate(sql4);
                                                     sql4="UPDATE central"+" SET Value="+"'"+s1+"'"+" WHERE id=8";
                                                      stmt4.executeUpdate(sql4);
                                              } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                          }
                                          else
                                          {
                                               sql4 ="UPDATE customer"+" SET I="+"'"+sa+"'"+" WHERE id="+g;
                                               stmt4.executeUpdate(sql4);
                                          } 
                            
                                     }
                                     else
                                     {
                                         String s=null;
                                         sql4 = "SELECT id,Value FROM central";
                                         {
                                            ResultSet rsz = stmt4.executeQuery(sql4);
                                            int iad;
                                            while(rsz.next())
                                            {
                                                iad  = rsz.getInt("id");
                                                if(iad == 7)
                                                {
                                                     s= rsz.getString("value");
                                                }
               
                                            }
                                         }
                                         try {
                                          
                                                String s1=s.substring(1);
                                                int i=Integer.parseInt(s1);
                                                i=i+1;
                                                s1="T"+i;
                                                sql4="UPDATE customer"+" SET I="+"'"+s1+"'"+" WHERE id="+g;
                                                stmt4.executeUpdate(sql4);
                                                sql4="UPDATE central"+" SET Value="+"'"+s1+"'"+" WHERE id=7";
                                                stmt4.executeUpdate(sql4);
                                              } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                              }
                                     }
                             }
                        }
                    }
                        //GenerateReceipt ppp = new GenerateReceipt();
                        
                    CheckOut c = new CheckOut();
                        c.setVisible(true);
                        
                        t1.setText("");
                        text.setText("");
                        Receptionist r  = new Receptionist();
                        r.setVisible(true);
                    }
                   else{
                       JOptionPane.showMessageDialog(rootPane,"PLease enter username/password correctly");
                    }
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
            if(str.equals("CATERING SERVICES"))
            {
                try {
                      if(str1.equals(c1)&& str2.equals(c2) )
                      {
                        
                        CateringServices c = new CateringServices();
                        t1.setText("");
                        text.setText("");
                        c.setVisible(true);
                    }
                   else{
                       
                          System.out.println("m1 == "+m1);
                          System.out.println("m2 == "+m2);
                          System.out.println(t1.getText());
                          System.out.println(text.getText());
                          JOptionPane.showMessageDialog(rootPane,"PLease enter username/password correctly");
                    }
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
           
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField text;
    // End of variables declaration//GEN-END:variables
}
