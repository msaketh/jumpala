/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import static has.Url.url;
import static has.Url.user;
import static has.Url.password;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author SivaKesava1
 */
public class advancebooking extends javax.swing.JFrame {

    /**
     * Creates new form advancebooking
     */
   
    public advancebooking() {
        initComponents();
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        jLabel4.setVisible(false);
        jLabel9.setVisible(false);
        jLabel7.setVisible(false);
        jButton1.setVisible(false);
        jButton7.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton6.setEnabled(false);
        
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setEditable(false);
        jTextField5.setEditable(false);
        jTextField6.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        
    }
public static void updateroom(String roomno,int s,int t,int d) throws SQLException
{
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
      /*  System.out.println(roomno+s);
        System.out.println(t);
        System.out.println(d);*/
        String sql2,sql="UPDATE ";
        
           if(d==0)
                sql=sql+"roomsa";   
            if(d==1)
                sql=sql+"roomsna"; 
            if(d==2)
                sql=sql+"roomda"; 
            if(d==3)
                sql=sql+"roomdna"; 
            sql=sql+" SET D";
            sql2=sql;
                    for(int i=s;i<=t;i++)
                    {
                        sql=sql2+i;
                        
                        sql=sql+"="+"'B'";
                        sql=sql+" WHERE roomno = ";
                        sql=sql+"'"+roomno+"'";
                        System.out.println(sql);
                        stmt.executeUpdate(sql);
                    }
          
}
public void updatecustomer(int id1)throws SQLException, IOException, ClassNotFoundException
{
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
       try{
              String sql = "SELECT id,Advance_room,Advance,ECID,ECOD,ISAC FROM Customer";
              ResultSet rs = stmt.executeQuery(sql);
              int id;
              String property;
              while(rs.next())
              {
               id  = rs.getInt("id");
               if(id == id1)
               {
                   System.out.println("Inside id"+id);
                    ObjectInputStream o = null;
                  byte[] arr = rs.getBytes("Advance_room");
                   Vector Advance_room = new Vector();
                  if(arr!=null)
                  {
                      o = new ObjectInputStream(new ByteArrayInputStream(arr));
                        Advance_room= (Vector)o.readObject();
                  } 
                 // Vector Advance_room= (Vector)o.readObject();
                 
                       Advance_room.add(room);
                  
                 String updatestr = "UPDATE customer SET Advance_room = ?  WHERE id = "+id1;
                 PreparedStatement p = conn.prepareStatement(updatestr);
                 p.setObject(1,Advance_room);
                 p.executeUpdate();
                 
                  System.out.println("Inside id after room");
                  
                 byte[] arr2 = rs.getBytes("Advance");
                 Vector advance =new Vector();
                if(arr2!=null)
                  {
                      o = new ObjectInputStream(new ByteArrayInputStream(arr2));
                      advance = (Vector)o.readObject();
                  } 
                     advance.add(jTextField6.getText());
                
                  
                 
                String updatestr1 = "UPDATE customer SET Advance = ?  WHERE id = "+id1;
                 PreparedStatement pp = conn.prepareStatement(updatestr1);
                 pp.setObject(1,advance);
                 pp.executeUpdate();
                  
                   byte[] arr3 = rs.getBytes("ECID");
                   Vector ECID =new Vector();
                  if(arr3!=null)
                  {
                   o = new ObjectInputStream(new ByteArrayInputStream(arr3));
                       ECID = (Vector)o.readObject();
                  }  
                  
                  ECID.add(a);
                 String updatestr2 = "UPDATE customer SET ECID = ?  WHERE id = "+id1;
                 PreparedStatement ppa = conn.prepareStatement(updatestr2);
                 ppa.setObject(1,ECID);
                 ppa.executeUpdate();
                  
                  byte[] arr4 = rs.getBytes("ECOD");
                   Vector ECOD=new Vector();
                  if(arr4!=null)
                  {
                      o = new ObjectInputStream(new ByteArrayInputStream(arr4));
                      ECOD = (Vector)o.readObject();
                  } 
                  ECOD.add(b);
                  String updatestr3 = "UPDATE customer SET ECOD = ?  WHERE id = "+id1;
                 PreparedStatement ppaa= conn.prepareStatement(updatestr3);
                 ppaa.setObject(1,ECOD);
                 ppaa.executeUpdate(); 
                 
                 String sql1 = "UPDATE Customer " +
                   "SET ISAC = 0 WHERE id ="+id1;
                  stmt.executeUpdate(sql1);

                   break;
               }
               
              }
       }
              catch(Exception ex)
          {
              ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select the type of Room");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 20, 240, 30);

        jComboBox1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single Bed  AC", "Single Bed Non AC", "Double Bed AC", "Double Bed Non AC" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(270, 20, 180, 30);

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Period Of Stay");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 80, 230, 30);

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(120, 150, 110, 30);

        jTextField1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 0, 204), null));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(270, 150, 180, 30);

        jLabel6.setFont(jLabel5.getFont());
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(120, 200, 90, 32);

        jTextField2.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 0), null));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(270, 200, 180, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("This field cannot be empty");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(470, 160, 150, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("This field cannot be empty");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(470, 260, 150, 14);

        jLabel8.setFont(jLabel6.getFont());
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mobile Number");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(100, 250, 160, 30);

        jTextField3.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), null));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(270, 250, 180, 30);

        jTextField4.setFont(jTextField3.getFont());
        jTextField4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(102, 102, 0), null));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(270, 80, 120, 25);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("This field cannot be empty");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(470, 210, 150, 14);

        jButton1.setFont(new java.awt.Font("Vijaya", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 51));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(210, 330, 80, 30);

        jButton2.setFont(jButton1.getFont());
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(330, 330, 100, 30);

        jButton3.setFont(jButton1.getFont());
        jButton3.setForeground(new java.awt.Color(0, 0, 204));
        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(250, 380, 105, 30);

        jButton4.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 102));
        jButton4.setText(">>Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(526, 10, 87, 30);

        jButton5.setIcon(new javax.swing.ImageIcon("F:\\SEMESTER-4\\Software\\Java\\Travel\\calendar_icon.png")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(390, 80, 30, 27);

        jTextField5.setFont(jTextField4.getFont());
        jTextField5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 153), null));
        jPanel1.add(jTextField5);
        jTextField5.setBounds(440, 80, 130, 25);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/has/calendar_icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(570, 80, 30, 27);

        jButton7.setFont(new java.awt.Font("Vijaya", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 153, 153));
        jButton7.setText("Check  Availability");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(440, 110, 160, 27);

        jLabel10.setFont(jLabel5.getFont());
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Advance");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(150, 290, 86, 30);

        jTextField6.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), null));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(270, 290, 180, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("This field cannot be empty");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(470, 300, 150, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/has/Professional-powerpoint-templates-free-download-animated-desktop.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-10, -10, 640, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
  String str1,str2,str3,str4 = null;
      str1=jTextField1.getText();
      if(str1.length()==0)
          jLabel4.setVisible(true);
      else
          jLabel4.setVisible(false);
      str2=jTextField2.getText();
      if(str2.length()==0)
          jLabel9.setVisible(true);
      else
          jLabel9.setVisible(false);
      str3=jTextField3.getText();
      if(str3.length()==0)
          jLabel7.setVisible(true);
      else
          jLabel7.setVisible(false);
      str4=jTextField6.getText();
      if(str4.length()==0)
          jLabel11.setVisible(true);
      else
          jLabel11.setVisible(false);
      if(str1.length()!=0 && str2.length()!=0 && str3.length()!=0 && str4.length()!=0)
      {   int g = 0;
            try {
                
                g=Checkcustomer.check(str1,str3,str2);
                 //System.out.println("g="+g);
                } catch (SQLException ex) {
                Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            try{
              String sql = "SELECT id,ECID,ECOD,ISAC FROM Customer";
              ResultSet rs = stmt.executeQuery(sql);
              int id;
              String property;
              while(rs.next())
              {
               id  = rs.getInt("id");
               int is=rs.getInt("ISAC");
               if(is!=0)
               {
                   showMessageDialog(null, "You have already checked In  ");
                   return;
               }
               if(id == g)
               {
                  
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
                         
                     }
                     else
                     {
                         showMessageDialog(null, "You have already Booked during that period  ");
                     return;
                     }
                  }
              }
              }
              }catch(Exception ex)
                       {
                       
                       }
         
      try {
          System.out.println(room);
          System.out.println(g);
         updateroom(room,(int)a,(int)b,z);
          updatecustomer(g);
          showMessageDialog(null, "Succesfully Booked the room  ");
          dispose();
      } catch (SQLException ex) {
          Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
      }
           
            
      }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
dispose();     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        calendar cd=new calendar();     
        calendar.date=1;
        calendar.month=0;
        calendar.year=2015;
        
        
   			cd.btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String s;
                                        Calendar cz=Calendar.getInstance();
                                        cz.set(calendar.year,calendar.month, calendar.date);
                                        if((cz.getTimeInMillis()-System.currentTimeMillis())<0)
                                        {
                                     showMessageDialog(null, "This is a past date  ");
                                     jButton6.setEnabled(false);
                                     jTextField4.setText("");
                                     return;
                                        }
                                        long a=(cz.getTimeInMillis())- (System.currentTimeMillis());
                                        a=a/1000;
                                        a=a/60;
                                        a=a/60;
                                        a=a/24;
                                        if(a>60)
                                        {
                                             showMessageDialog(null, "Advanced Booking is not allowed for that period  ");
                                            jButton6.setEnabled(false);
                                             return;
                                        }
						s=(calendar.date.toString())+"-"+(((Integer)(calendar.month+1)).toString())+"-"+(calendar.year.toString()) ;
							jTextField4.setText(s);
                                                        jButton6.setEnabled(true);
						}           
					});
				  cd.setVisible(true);
                                  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        	jButton5.setEnabled(false);
                jButton6.setEnabled(true);
				
				cal=(Calendar) datecalendar.c.clone();
				calendar cd=new calendar();
				cal1=Calendar.getInstance();
				cd.btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String s;
						
						s=(calendar.date.toString())+"-"+(((Integer)(calendar.month+1)).toString())+"-"+(calendar.year.toString()) ;
						cal1.set(calendar.year,calendar. month, calendar.date);
						if((cal1.getTimeInMillis()-cal.getTimeInMillis())<0)
						{
							showMessageDialog(null, "Expected Check Out Date is before Check In Date  ");
                                                      jButton7.setVisible(false);
                                                        return;
						}
							jTextField5.setText(s);
                                                         jButton7.setVisible(true);
						}                 
					});
				 cd.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      z=jComboBox1.getSelectedIndex();
      jLabel5.setVisible(false);
        jButton5.setEnabled(true);
        jButton6.setEnabled(false);
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        jTextField6.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel4.setVisible(false);
        jLabel9.setVisible(false);
        jLabel7.setVisible(false);
        jButton1.setVisible(false);
        jButton7.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton6.setEnabled(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
          Connection conn = null;
          jButton5.setEnabled(false);
                jButton6.setEnabled(false);
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
        String sql="SELECT id,Value FROM Central"+" WHERE id=14";
         int presentday = 1;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            presentday = rs.getInt("Value");
        } catch (SQLException ex) {
           //Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
            a=(cal.getTimeInMillis())- (System.currentTimeMillis());
                                        a=a/1000; a=a/60;a=a/60; a=a/24;
            b=(cal1.getTimeInMillis())- (System.currentTimeMillis());  
            b=b/1000;b=b/3600;b=b/24;
            
        try {
            /*System.out.println((int)a+presentday);
            System.out.println((int) b+presentday);
              System.out.println(z);*/
            a=a+presentday;
            b=b+presentday;
               room= Checkavailable.check((int)a,(int) b,z );
            // System.out.println(room);
        } catch (SQLException ex) {
            Logger.getLogger(advancebooking.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(room!=null)
        {
        jLabel5.setVisible(true);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(true);
        jLabel6.setVisible(true);
        jLabel8.setVisible(true);
        jTextField6.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(false);
        jLabel4.setVisible(false);
        jLabel9.setVisible(false);
        jLabel7.setVisible(false);
        jComboBox1.setEditable(false);
        jButton5.setEnabled(false);
        jButton5.setEnabled(false);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jTextField3.setVisible(true);
        }
        else
        {
      	showMessageDialog(null, "Please Try for other Duration  ");
        jLabel5.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton5.setEnabled(true);
        jTextField6.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jButton6.setEnabled(false);
        jLabel6.setVisible(false);
        jLabel8.setVisible(false);
        jLabel4.setVisible(false);
        jLabel9.setVisible(false);
        jLabel7.setVisible(false);
        jButton1.setVisible(false);
        jButton7.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton6.setEnabled(false);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTextField3.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField6.setText("");
        jLabel4.setVisible(false);
        jLabel7.setVisible(false);
        jLabel9.setVisible(false);
        jLabel11.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(advancebooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(advancebooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(advancebooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(advancebooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new advancebooking().setVisible(true);
            }
        });
    }
    Calendar cal,cal1,present;
    int z;   
    long a,b;
    String room;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
