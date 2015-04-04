/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
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
        c1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MANAGER", "RECEPTIONIST", "CATERING SERVICES" }));
        getContentPane().add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 140, -1));

        jLabel4.setText("LOGIN AS:-");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 20));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 30));

        jLabel3.setText("PASSWORD:-");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 140, 30));

        jLabel2.setText("USERNAME:-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\MAHANKALI SAKETH\\Desktop\\Hotel1.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String str = (String)c1.getSelectedItem();
        String str1 = t1.getText();
        String str2 = t2.getText();
        String m1 = "";
           String m2 = "";
           String r1 = "";
           String r2 = "";
           String c1 = "";
           String c2 = "";
        try 
        {
           
           Connection con =  Connectiond.getconn();
           Statement stmt = con.createStatement();
           String sql = "SELECT id,Value FROM central";
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
           if(str1.equals(m1)&& str2.equals(m2) )
           {
               ManagerFunctions a = new ManagerFunctions();
               a.setVisible(true);
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane,"PLease enter username/password correctly");
           }
        }
        else if(str.equals("RECEPTIONIST"))
        {
           if(str1.equals(r1)&& str2.equals(r2) )
           {
               Receptionist a = new Receptionist();
               a.setVisible(true);
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane,"PLease enter username/password correctly");
           }
        }
        else if(str.equals("CATERING SERVICES"))
        {
           if(str1.equals(c1)&& str2.equals(c2) )
           {
               CateringServices a = new CateringServices();
               a.setVisible(true);
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane,"PLease enter username/password correctly");
           }
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
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
