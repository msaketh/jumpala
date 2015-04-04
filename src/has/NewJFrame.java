/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import static has.Url.url;
import static has.Url.user;
import static has.Url.password;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author SivaKesava1
 */
public class NewJFrame extends javax.swing.JFrame {

     
    /**
     * Creates new form NewJFrame
     */
    long a,b;
    String room;
    int d;
    public NewJFrame(long a,long b,String room,int d) {
        initComponents();
        this.a=a;
        this.b=b;
        this.room=(room);
        this.d=d;
        jLabel9.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("This field cannot be empty");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 90, 160, 14);

        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("This field cannot be empty");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(430, 150, 150, 14);

        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("This field cannot be empty");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(430, 210, 160, 14);

        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("This field cannot be empty");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(430, 260, 150, 14);

        jTextField4.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(153, 51, 0));
        jTextField4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 51, 0), null));
        jPanel1.add(jTextField4);
        jTextField4.setBounds(230, 230, 220, 30);

        jTextField3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(204, 0, 204));
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 204), null));
        jPanel1.add(jTextField3);
        jTextField3.setBounds(230, 170, 220, 30);

        jTextField2.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 0));
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 0), null));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(230, 110, 220, 30);

        jTextField1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 204));
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 153), null));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(230, 50, 220, 30);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 50, 90, 30);

        jLabel3.setFont(jLabel1.getFont());
        jLabel3.setForeground(new java.awt.Color(153, 153, 0));
        jLabel3.setText("Address");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 110, 130, 30);

        jLabel4.setFont(jLabel1.getFont());
        jLabel4.setForeground(new java.awt.Color(204, 0, 204));
        jLabel4.setText("Mobile");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(100, 170, 120, 40);

        jLabel5.setFont(jLabel1.getFont());
        jLabel5.setForeground(new java.awt.Color(153, 51, 0));
        jLabel5.setText("Advance");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(90, 230, 130, 30);

        jButton1.setFont(new java.awt.Font("Vijaya", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 0));
        jButton1.setText("Check In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(290, 280, 90, 27);

        jLabel10.setFont(new java.awt.Font("Vijaya", 0, 24)); // NOI18N
        jLabel10.setText("The Required Room is available.Please give your Details");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 14, 460, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon("F:\\SEMESTER-4\\Software\\Java\\jumpala\\src\\has\\Cool-Eco-PowerPoint-Templates.jpg")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 430);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String str1,str2,str3,str4 = null;
        str1=jTextField1.getText();
        if(str1.length()==0)
        jLabel6.setVisible(true);
        else
        jLabel6.setVisible(false);
        str2=jTextField2.getText();
        if(str2.length()==0)
        jLabel7.setVisible(true);
        else
        jLabel7.setVisible(false);
        str3=jTextField3.getText();
        if(str3.length()==0)
        jLabel8.setVisible(true);
        else
        jLabel8.setVisible(false);
        str4=jTextField4.getText();
        if(str4.length()==0)
        jLabel9.setVisible(true);
        else
        jLabel9.setVisible(false);
        if(str1.length()!=0)
        {
            if (str2.length()!=0) {
                if (str3.length()!=0) {
                    if (str4.length()!=0) {
                        Connection conn = null;
                        Statement stmt=null;
                        try {
                            conn = DriverManager.getConnection(url, user, password);
                        } catch (SQLException ex) {
                            // Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                            System.out.println("Error in conn");
                        }
                        try {
                            stmt = conn.createStatement();
                        } catch (SQLException ex) {
                            //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        int g = 0;
                        try {
                            
                            g=Checkcustomer.check(str1,str3,str2);
                            System.out.println("g="+g);
                        } catch (SQLException ex) {
                            Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try{
                            String sql = "SELECT id,ECID,ECOD,ISAC FROM Customer";
                            ResultSet rs = stmt.executeQuery(sql);
                            int id,found=1;
                            String property;
                            while(rs.next())
                            {
                                id  = rs.getInt("id");
                                int is=rs.getInt("ISAC");
                                System.out.println("Id"+id);
                                if(id == g)
                                {
                                    if(is!=0)
                                {
                                    showMessageDialog(null, "You have already checked In  ");
                                    return;
                                }
                                    ObjectInputStream o = null;
                                    byte[] arr = rs.getBytes("ECID");
                                    Vector ECID = new Vector();
                                    if(arr!=null)
                                    {
                                        o = new ObjectInputStream(new ByteArrayInputStream(arr));                                        
                                        ECID= (Vector)o.readObject();
                                    }
                                    byte[] arr2 = rs.getBytes("ECOD");
                                    Vector ECOD = new Vector();
                                    if(arr!=null)
                                    {
                                        o = new ObjectInputStream(new ByteArrayInputStream(arr2));
                                        ECOD= (Vector)o.readObject();
                                    }
                                    for(int y=0;y<ECID.size();y++)
                                    {
                                        if(b< ((long)ECID.get(y))||a>((long)ECOD.get(y)))
                                        {
                                            found=1;
                                            System.out.println("found");
                                        }
                                        else
                                        {
                                            found=0;
                                            showMessageDialog(null, "You have already Booked during that period  ");
                                            return;
                                        }
                                    }
                                    break;
                                }
                            }
                                if(found==1)
                                {
                                    System.out.println("Entered");
                                   
                                    int x=(int)a;
                                    int uj=(int)b;
                                    sql="UPDATE customer"+" SET SCID="+x+" WHERE id="+g;
                                   System.out.println(sql);
                                    stmt.executeUpdate(sql);
                                    sql="UPDATE customer"+" SET SCOD="+uj+" WHERE id="+g;
                                     System.out.println(sql);
                                    stmt.executeUpdate(sql);
                                    sql="UPDATE customer"+" SET Room="+"'"+room+"'"+" WHERE id="+g;
                                     System.out.println(sql);
                                    stmt.executeUpdate(sql);
                                    sql="UPDATE customer"+" SET RTP="+Double.parseDouble(str4)+" WHERE id="+g;
                                     System.out.println(sql);
                                    stmt.executeUpdate(sql);
                                     sql="UPDATE customer"+" SET ISAC=2" +" WHERE id="+g;
                                      System.out.println(sql);
                                    stmt.executeUpdate(sql);
                                    //sql="SELECT id,Value FROM Central"+" WHERE id=8";
                                     sql="SELECT history FROM Customer"+" WHERE id="+g;
                                     System.out.println(sql);
                                    int history=0,present=0;
                                    double fre=0;
                                     try {
                                          ResultSet rsz = stmt.executeQuery(sql);
                                                     history = rsz.getInt("history");         
                                         } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                     sql = "SELECT id,Value FROM central";
                                     {
                                         ResultSet rsz = stmt.executeQuery(sql);
                                                 double d = 0.0;
                                         Vector value = new Vector();
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
                                    
                                   /*   sql="SELECT id,Value FROM Central"+" WHERE id=14";
                                       System.out.println(sql);
                                     try {
                                          ResultSet rsz = stmt.executeQuery(sql);
                                                     present = rsz.getInt("value");
                                                     System.out.println(present);
                                         } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }*/
                                     double custfre=history/(int)a;
                                     System.out.println(history);
                                     System.out.println(a);
                                     System.out.println("fre"+fre);
                                     System.out.println("custfere"+custfre);
                                     if(custfre>=fre)
                                     {
                                          sql="SELECT id,Identity FROM Customer"+" WHERE id="+g;
                                           System.out.println(sql);
                                          String sa=null;
                                          try {
                                          ResultSet rsz = stmt.executeQuery(sql);
                                                     sa= rsz.getString("Identity");         
                                         } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                          if(sa==null)
                                          {
                                            String s = null;
                                               sql = "SELECT id,Value FROM central";
                                           {
                                         ResultSet rsz = stmt.executeQuery(sql);
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
                                               System.out.println(sql);
                                           try {
                                                     String s1=s.substring(1);
                                                     int i=Integer.parseInt(s1);
                                                     i=i+1;
                                                     s1="I"+i;
                                                     sql="UPDATE customer"+" SET I="+"'"+s1+"'"+" WHERE id="+g;
                                                     stmt.executeUpdate(sql);
                                                      sql="UPDATE customer"+" SET Identity="+"'"+s1+"'"+" WHERE id="+g;
                                                     stmt.executeUpdate(sql);
                                                     sql="UPDATE central"+" SET Value="+"'"+s1+"'"+" WHERE id=8";
                                                      stmt.executeUpdate(sql);
                                              } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                          }
                                          else
                                          {
                                               sql="UPDATE customer"+" SET I="+"'"+sa+"'"+" WHERE id="+g;
                                                     stmt.executeUpdate(sql);
                                          }
                                     }
                                     else
                                     {
                                        String s=null;
                                            sql = "SELECT id,Value FROM central";
                                           {
                                         ResultSet rsz = stmt.executeQuery(sql);
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
                                                     sql="UPDATE customer"+" SET I="+"'"+s1+"'"+" WHERE id="+g;
                                                      System.out.println(sql);
                                                     stmt.executeUpdate(sql);
                                                     sql="UPDATE central"+" SET Value="+"'"+s1+"'"+" WHERE id=7";
                                                      System.out.println(sql);
                                                      stmt.executeUpdate(sql);
                                              } catch (SQLException ex) {
                                                               //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                     }
                                     
                                      advancebooking.updateroom(room, (int)a,(int) b, d);
                                }
                        }catch(Exception ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}