/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MAHANKALI SAKETH
 */
public class EditItem extends javax.swing.JFrame {

    /**
     * Creates new form EditItem
     */
    public EditItem() {
        initComponents();
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        t4.setVisible(false);
        b1.setVisible(false);
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

        jButton1 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        l4 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        c1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("PROCEED");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 100, -1));

        l1.setText("Item:-");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        l3.setText("OLD DETAILS");
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        b1.setText("SAVE");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 90, -1));

        t2.setEditable(false);
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 100, -1));
        getContentPane().add(t3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 130, -1));
        getContentPane().add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 130, -1));

        l4.setText("ENTER NEW DETAILS");
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        l2.setText("Rate:-");
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        t1.setEditable(false);
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 100, -1));

        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 260, -1));

        jLabel2.setText("SELECT ITEM YOU WANT TO EDIT:-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 200, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\background3.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        t1.setVisible(true);
        t2.setVisible(true);
        t3.setVisible(true);
        t4.setVisible(true);
        b1.setVisible(true);
        String str = (String)c1.getSelectedItem();
        try
        {
            Connection con =  Connectiond.getconn();
            Statement  stmt = con.createStatement();
            String sql = "SELECT Item,Price FROM menu";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String t = rs.getString("Item");
                if(t.equals(str))
                {
                    t1.setText(t);
                    t2.setText(Double.toString(rs.getDouble("Price")));
                    break;
                }
            }
        }
        catch(Exception ex)
        {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        String str1 = t3.getText();
        String str2 = t4.getText();
        double d  = 0.0;
        String str3 = (String)t1.getText();
        try
        {
            
            d = Double.parseDouble(str2);
            Connection con =  Connectiond.getconn();
            Statement  stmt = con.createStatement();
            /* String sql = "UPDATE Registration " +
                   "SET age = 30 WHERE id in (100, 101)";
      stmt.executeUpdate(sql);*/
            String sql = "SELECT id,Item,Price FROM menu";
            ResultSet rs = stmt.executeQuery(sql);
            int id1 =0;
            while(rs.next())
            {
                String t = rs.getString("Item");
                if(t.equals(str3))
                {
                    id1 = rs.getInt("id");
                    break;
                }
            }
            String sql1 = "UPDATE menu "+"SET Item = '"+str1+"'"+" WHERE id in ("+id1+")";
            stmt.executeUpdate(sql1);
            String sql2 = "UPDATE menu "+"SET Price = "+d+" WHERE id in ("+id1+")";
            stmt.executeUpdate(sql2);
            JOptionPane.showMessageDialog(rootPane,"Successfully Edited");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(rootPane,"Improper format of prices..please enter again");
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JComboBox c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}
