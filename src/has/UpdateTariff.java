/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHANKALI SAKETH
 */
public class UpdateTariff extends javax.swing.JFrame {

    /**
     * Creates new form UpdateTariff
     */
    public UpdateTariff() {
        initComponents();
        b2.setVisible(false);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        t1.setVisible(false);
        t3.setVisible(false);
        t2.setVisible(false);
        l4.setVisible(false);
        t4.setVisible(false);
        l5.setVisible(false);
        t5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        c1 = new javax.swing.JComboBox();
        t1 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        l5 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        l4 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        b2 = new javax.swing.JButton();
        l2 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 70, -1));

        c1.setForeground(new java.awt.Color(0, 102, 204));
        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SINGLE-AC", "SINGLE-NONAC", "DOUBLE-AC", "DOUBLE-NONAC" }));
        c1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c1ItemStateChanged(evt);
            }
        });
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 180, -1));

        t1.setEditable(false);
        t1.setForeground(new java.awt.Color(0, 102, 204));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 130, -1));

        t5.setForeground(new java.awt.Color(0, 51, 204));
        getContentPane().add(t5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 130, -1));

        l5.setForeground(new java.awt.Color(0, 51, 204));
        l5.setText("ENTER NEW RATE:-");
        getContentPane().add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 110, -1));

        t4.setEditable(false);
        t4.setForeground(new java.awt.Color(0, 51, 204));
        getContentPane().add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 130, -1));

        t3.setForeground(new java.awt.Color(0, 102, 204));
        getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 130, -1));

        l4.setForeground(new java.awt.Color(0, 51, 204));
        l4.setText("OLD ROOM RATE:-");
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, -1));

        l3.setForeground(new java.awt.Color(0, 102, 204));
        l3.setText("ENTER NEW TARIFF:-");
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        b2.setForeground(new java.awt.Color(0, 102, 204));
        b2.setText("SAVE");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 70, -1));

        l2.setForeground(new java.awt.Color(0, 102, 204));
        l2.setText("OLD TARIFF RATE:-");
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        t2.setEditable(false);
        t2.setForeground(new java.awt.Color(0, 102, 204));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\tariffs.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 420));

        b1.setForeground(new java.awt.Color(0, 102, 204));
        b1.setText("PROCEED");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        l1.setForeground(new java.awt.Color(0, 102, 204));
        l1.setText("OCCUPANCY RATE OF IT:-");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 150, 20));

        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("SELECT TYPE OF ROOM:-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 140, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\background2.jpeg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 600, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
       
        b2.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        t1.setVisible(true);
        t3.setVisible(true);
        t2.setVisible(true);
        l4.setVisible(true);
        t4.setVisible(true);
        l5.setVisible(true);
        t5.setVisible(true);
        String str = (String)c1.getSelectedItem();
        int m = 0;
        if(str.equals("SINGLE-AC"))
        {
            m = 0;
        }
        else if(str.equals("SINGLE-NONAC"))
        {
            m = 1;
        }
        else if(str.equals("DOUBLE-AC"))
        {
            m = 2;
        }
        else if(str.equals("DOUBLE-NONAC"))
        {
            m = 3;
        }
        
        try {
           
            
            Connection con =  Connectiond.getconn();
            Statement stmt = con.createStatement();
            String sql = "SELECT id,Property,Value FROM central";
            ResultSet rs = stmt.executeQuery(sql);
            int id;
            String property;
            Vector value = new Vector();
            int days = 1;
            int rates = 0;
            int totals = 0;
            double tariff=0.0;
            byte[] arr;
            Vector rate = new Vector();
            Vector total = new Vector();
            while(rs.next())
            {
               id  = rs.getInt("id");
               /*byte[] buf = rs.getBytes("copyDetails");
               ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(buf));
               ArrayList<SubBook> copyDetails = (ArrayList<SubBook>) o.readObject();*/
               if(id == 10)
               {
                  arr = rs.getBytes("Value");
                  ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr)); 
                   value= (Vector)o.readObject();
               }
               if(id == 11)
               {
                   arr = rs.getBytes("Value");
                   ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr)); 
                   rate= (Vector)o.readObject();
               }
               if(id == 12)
               {
                   arr = rs.getBytes("Value");
                   ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr)); 
                   total= (Vector)o.readObject();
               }
               if(id ==14)
               {
                   
                   days = rs.getInt("Value");
             
               }
             }
            double d = 0.0;
            tariff = (double)value.get(m);
            rates = (int)rate.get(m);
            totals = (int)total.get(m);
            t2.setText(Double.toString(tariff));
            t4.setText(Integer.toString(rates));
            d = (double)totals/days;
            t1.setText(Double.toString(d));
            rs.close();
            
            }
        catch (Exception ex) {
            System.out.println("entered");
            ex.printStackTrace();
        }
       
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
          String str = t3.getText();
          String str1 = t5.getText();
          double tariff;
          int rate;
          Vector value = new Vector();
           byte[] arr;
          Vector rates = new Vector();
          String str2 = (String)c1.getSelectedItem();
         int m = 0;
        if(str2.equals("SINGLE-AC"))
        {
            m = 0;
        }
        else if(str2.equals("SINGLE-NONAC"))
        {
            m = 1;
        }
        else if(str2.equals("DOUBLE-AC"))
        {
            m = 2;
        }
        else if(str2.equals("DOUBLE-NONAC"))
        {
            m = 3;
        }
          try 
          {
           
            
              Connection con =  Connectiond.getconn();
              Statement stmt = con.createStatement();
              String sql = "SELECT id,Property,Value FROM central";
              ResultSet rs = stmt.executeQuery(sql);
              int id;
              String property;
              
              while(rs.next())
              {
               id  = rs.getInt("id");
               /*byte[] buf = rs.getBytes("copyDetails");
               ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(buf));
               ArrayList<SubBook> copyDetails = (ArrayList<SubBook>) o.readObject();*/
               if(id == 10)
               {
                  arr = rs.getBytes("Value");
                  ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr)); 
                  value= (Vector)o.readObject();
               }
               if(id == 11)
               {
                   arr = rs.getBytes("Value");
                   ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr)); 
                   rates = (Vector)o.readObject();
                   break;
               }
               
              }
          }
          catch(Exception ex)
          {
              
          }
          
          try
          {
               tariff = Double.parseDouble(str);
               rate  = Integer.parseInt(str1);
              /*String updateTableSQL = "UPDATE DBUSER SET USERNAME = ? WHERE USER_ID = ?";
                PreparedStatement preparedStatement = dbConnection.prepareStatement(updateTableSQL);
                preparedStatement.setString(1, "mkyong_new_value");
                preparedStatement.setInt(2, 1001);
               // execute insert SQL stetement
               preparedStatement .executeUpdate();*/
              String updatestr = "UPDATE central SET Value = ?  WHERE id = 10";
              PreparedStatement p = Connectiond.getconn().prepareStatement(updatestr);
              value.set(m,(double)tariff);
              rates.set(m,(int)rate);
              p.setObject(1,value);
              p.executeUpdate();
              updatestr = "UPDATE central SET Value = ?  WHERE id = 11";
              PreparedStatement pp = Connectiond.getconn().prepareStatement(updatestr);
              pp.setObject(1,rates);
              pp.executeUpdate();
              JOptionPane.showMessageDialog(rootPane,"Successfully updated");
              
              
              
          }
          catch(Exception ex)
          {
              ex.printStackTrace();
              JOptionPane.showMessageDialog(rootPane,"Invalid format of tariff/ rate format");
          }
          
    }//GEN-LAST:event_b2ActionPerformed

    private void c1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c1ItemStateChanged
          t3.setText("");
          t5.setText("");
    }//GEN-LAST:event_c1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                 dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
  /*  public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateTariff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTariff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTariff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTariff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateTariff().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JComboBox c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    // End of variables declaration//GEN-END:variables
}
