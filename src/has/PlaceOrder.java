/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHANKALI SAKETH
 */
public class PlaceOrder extends javax.swing.JFrame {

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
        try
        {
            Connection con =  Connectiond.getconn();
            Statement  stmt = con.createStatement();
            String sql = "SELECT Item FROM menu";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String t = rs.getString("Item");
                c1.addItem(t);
               
            }
        }
        catch(Exception ex)
        {
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\Order.jpg")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("SELECT ITEM :-");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 220, -1));

        jLabel5.setText("ENTER QUANTITY:-");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 220, -1));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 220, -1));

        jLabel7.setText("ENTER MOBILE:-");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));
        getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 220, -1));

        jLabel6.setText("ENTER NAME:-");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        jButton1.setText("PLACE ORDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\Order.jpg")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 280));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\background3.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 460, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s1 = (String)t1.getText();
        String s2 = (String)t2.getText();
        String s3 = (String)t3.getText();
        String item1 = (String)c1.getSelectedItem();
        int bill = 0;
        try
        {
            int check = CheckCustomer2.check(s2, s3);
            int quan = Integer.parseInt(s1);
            if(check==0)
            {
                JOptionPane.showMessageDialog(rootPane,"You didnot check into hotel");
                        
            }
            else 
            {
                Connection con = Connectiond.getconn();
                Statement stmt = con.createStatement();
                String sql = "SELECT ISAC,id FROM Customer";
                ResultSet rs = stmt.executeQuery(sql);
                int i =0;
                while(rs.next())
                {
                    int id  = rs.getInt("id");
                    if(id == check)
                    {
                       i = rs.getInt("ISAC");
                       break;
                    }
                }
                if(i==0)
                {
                    JOptionPane.showMessageDialog(rootPane,"You didnot check into the hotel");
                }
                else
                {
                    String sql3 = "SELECT Catering,id FROM Customer";
                    rs = stmt.executeQuery(sql3);
                    byte[] arr = null;
                    while(rs.next())
                    {
                        int id  = rs.getInt("id");
                        if(id == check)
                        {
                            arr = rs.getBytes("Catering");
                            break;
                        }
                    }
                    Vector catering = new Vector();
                    if(arr!=null)
                    {
                        ObjectInputStream o = new ObjectInputStream(new ByteArrayInputStream(arr));
                        catering  = (Vector)o.readObject();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        Date date = new Date();
                        String s = dateFormat.format(date);
                        CateringObject cc = new CateringObject();
                        cc.date = s;
                        Connection con2 =  Connectiond.getconn();
                        Statement  stmt2 = con2.createStatement();
                        String sql2 = "SELECT Item,Price FROM menu";
                        ResultSet rs2 = stmt2.executeQuery(sql2);
                        while(rs2.next())
                        {
                            String t = rs2.getString("Item");
                            if(t.equalsIgnoreCase(item1))
                            {
                                bill = rs2.getInt("Price");
                            }
               
                        }
                        bill = bill* quan;
                        cc.bill = bill;
                        cc.quantity = quan;
                        cc.item =item1;
                        catering.add(cc);
                        String updatestr = "UPDATE Customer SET Value = ?  WHERE id = "+check;
                        PreparedStatement p = Connectiond.getconn().prepareStatement(updatestr);
                        p.setObject(1,catering);
                        p.executeUpdate();
                    }
                    else
                    {
                        
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                        Date date = new Date();
                        String s = dateFormat.format(date);
                        CateringObject cc = new CateringObject();
                        cc.date = s;
                        Connection con2 =  Connectiond.getconn();
                        Statement  stmt2 = con2.createStatement();
                        String sql2 = "SELECT Item,Price FROM menu";
                        ResultSet rs2 = stmt2.executeQuery(sql2);
                        while(rs2.next())
                        {
                            String t = rs2.getString("Item");
                            if(t.equalsIgnoreCase(item1))
                            {
                                bill = rs2.getInt("Price");
                            }
               
                        }
                        bill = bill* quan;
                        cc.bill = bill;
                        cc.quantity = quan;
                        cc.item =item1;
                        catering.add(cc);
                        String updatestr = "UPDATE Customer SET Value = ?  WHERE id = "+check;
                        PreparedStatement p = Connectiond.getconn().prepareStatement(updatestr);
                        p.setObject(1,catering);
                        p.executeUpdate();
                    }
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(rootPane,"Improper format of entered details...please enter again");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    // End of variables declaration//GEN-END:variables
}
