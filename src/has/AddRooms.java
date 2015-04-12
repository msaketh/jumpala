/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author MAHANKALI SAKETH
 */
public class AddRooms extends javax.swing.JFrame {

    /**
     * Creates new form AddRooms
     */
    public AddRooms() {
        
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

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();
        l1 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 90, -1));

        jLabel2.setBackground(new java.awt.Color(0, 51, 204));
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("ENTER TYPE OF ROOM YOU WANT TO ADD:-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 270, 20));

        type.setBackground(new java.awt.Color(51, 51, 255));
        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SINGLE-AC", "SINGLE-NONAC", "DOUBLE-AC", "DOUBLE-NONAC" }));
        getContentPane().add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 220, -1));

        l1.setForeground(new java.awt.Color(51, 0, 51));
        l1.setText("ENTER ROOM NUMBER:-");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 200, -1));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 220, -1));

        b1.setBackground(new java.awt.Color(0, 51, 204));
        b1.setText("SAVE");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\Room.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        String str = (String)type.getSelectedItem();
        String p = t1.getText();
        String pp;
        byte[] arr;
        if(p.equals(""))
        {
            JOptionPane.showMessageDialog(rootPane,"Please enter room number");
        }
        else if(str.equals("SINGLE-AC"))
        {
            try {
                Connection con = Connectiond.getconn();
                Statement stmt = con.createStatement();
                String sql2 = "SELECT RoomNo FROM roomsa";
                ResultSet rs = stmt.executeQuery(sql2);
                int m = 0;
                pp = "SA"+p;
                while(rs.next())
                {
                    
                    
                    String t = rs.getString("RoomNo");
                    if(t.equalsIgnoreCase(pp))
                    {
                        m = 1;
                        break;
                    }
               
                }
                if(m==1)
                {
                    JOptionPane.showMessageDialog(rootPane,"Room with that room no already exists...please give another number");
                    t1.setText(" ");
                }
                else
                {
                    p = "SA"+p;
                    String sql = "INSERT INTO roomsa(RoomNo)"+"Values('"+p+"')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(rootPane,"Successfully Added");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AddRooms.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(str.equals("SINGLE-NONAC"))
        {
            
            try {
                Connection con = Connectiond.getconn();
                Statement stmt = con.createStatement();
                String sql2 = "SELECT RoomNo FROM roomsna";
                ResultSet rs = stmt.executeQuery(sql2);
                int m = 0;
                pp = "SNA"+p;
                while(rs.next())
                {
                    String t = rs.getString("RoomNo");
                    if(t.equalsIgnoreCase(pp))
                    {
                        m = 1;
                        break;
                    }
               
                }
                if(m==1)
                {
                    JOptionPane.showMessageDialog(rootPane,"Room with that room no already exists...please give another number");
                    t1.setText(" ");
                }
                else
                {
                    p = "SNA"+p;
                    String sql = "INSERT INTO roomsna(RoomNo)"+"Values('"+p+"')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(rootPane,"Successfully Added");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AddRooms.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if(str.equals("DOUBLE-AC"))
        {
            
            try {
                Connection con = Connectiond.getconn();
                Statement stmt = con.createStatement();
                String sql2 = "SELECT RoomNo FROM roomda";
                ResultSet rs = stmt.executeQuery(sql2);
                int m = 0;
                pp = "DA"+p;
                while(rs.next())
                {
                    String t = rs.getString("RoomNo");
                    if(t.equalsIgnoreCase(pp))
                    {
                        System.out.println("Entered");
                        m = 1;
                        break;
                    }
               
                }
                if(m==1)
                {
                    JOptionPane.showMessageDialog(rootPane,"Room with that room no already exists...please give another number");
                    t1.setText(" ");
                }
                else
                {
                    p = "DA"+p;
                    String sql = "INSERT INTO roomda(RoomNo)"+"Values('"+p+"')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(rootPane,"Successfully Added");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AddRooms.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
     
            
        }
        else if(str.equals("DOUBLE-NONAC"))
        {
            
            try {
                Connection con = Connectiond.getconn();
                Statement stmt = con.createStatement();
                String sql2 = "SELECT RoomNo FROM roomdna";
                ResultSet rs = stmt.executeQuery(sql2);
                int m = 0;
                pp = "DNA"+p;
                while(rs.next())
                {
                    String t = rs.getString("RoomNo");
                    if(t.equalsIgnoreCase(pp))
                    {
                        m = 1;
                        break;
                    }
               
                }
                if(m==1)
                {
                    JOptionPane.showMessageDialog(rootPane,"Room with that room no already exists...please give another number");
                    t1.setText(" ");
                }
                else
                {
                    p = "DNA"+p;
                    String sql = "INSERT INTO roomdna(RoomNo)"+"Values('"+p+"')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(rootPane,"Successfully Added");
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(AddRooms.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }//GEN-LAST:event_b1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
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
            java.util.logging.Logger.getLogger(AddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new AddRooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel l1;
    private javax.swing.JTextField t1;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables
}
