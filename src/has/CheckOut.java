/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package has;

import static has.Url.password;
import static has.Url.url;
import static has.Url.user;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SivaKesava1
 */
public class CheckOut extends javax.swing.JFrame {

    /**
     * Creates new form CheckOut
     */
     DefaultTableModel tb,tb2;
    public CheckOut() throws SQLException, IOException, ClassNotFoundException {
        initComponents();
        tb = (DefaultTableModel)jTable1.getModel();
        tb2 = (DefaultTableModel)jTable2.getModel();
          Statement stmt = null;
          Connection conn=null;
         String w=null;
         int found=0;
        // System.out.println("At the start");
           try{ 
               conn= DriverManager.getConnection(url, user, password);
              stmt = conn.createStatement();}
           catch(Exception rx)
           {
               System.out.println("in catch");
           }
           int present=0;
           double minfre=0;
                                String sql2 = "SELECT id,Value FROM central";
                                     Vector tariff = null,discount=null,rates = null,totalbookings = null;
                                         ResultSet rsz = stmt.executeQuery(sql2);
                                          int iad;
                                                  while(rsz.next())
                                                  {
                                                   iad  = rsz.getInt("id");
              
                                                   if(iad == 9)
                                                                  {
                                                                minfre = rsz.getDouble("Value");
                                                                  }
                                                   if(iad==10)
                                                   {
                                                        ObjectInputStream o = null;
                                                           byte[] arr = rsz.getBytes("Value");
                                                         tariff = new Vector();
                                                     if(arr!=null)
                                                      {
                                                             o = new ObjectInputStream(new ByteArrayInputStream(arr));
                                                              tariff= (Vector)o.readObject();
                                                       } 
                                                   }
                                                   if(iad==11)
                                                   {
                                                        ObjectInputStream o = null;
                                                           byte[] arr = rsz.getBytes("Value");
                                                        rates = new Vector();
                                                     if(arr!=null)
                                                      {
                                                             o = new ObjectInputStream(new ByteArrayInputStream(arr));
                                                              rates= (Vector)o.readObject();
                                                       } 
                                                   }
                                                   
                                                   if(iad==12)
                                                   {
                                                        ObjectInputStream o = null;
                                                           byte[] arr = rsz.getBytes("Value");
                                                         totalbookings = new Vector();
                                                     if(arr!=null)
                                                      {
                                                             o = new ObjectInputStream(new ByteArrayInputStream(arr));
                                                              totalbookings= (Vector)o.readObject();
                                                       } 
                                                   }
                                                   
                                                   if(iad==13)
                                                   {
                                                        ObjectInputStream o = null;
                                                           byte[] arr = rsz.getBytes("Value");
                                                        discount = new Vector();
                                                     if(arr!=null)
                                                      {
                                                             o = new ObjectInputStream(new ByteArrayInputStream(arr));
                                                              discount= (Vector)o.readObject();
                                                       } 
                                                   }
                                                   
                                                       if(iad == 14)
                                                                  {
                                                                 present = rsz.getInt("Value");
                                                                  }
               
                                                    }
                                      
           
           String sql="SELECT * FROM Customer ";
            ResultSet rs = null,rs1= null;
         try {
             rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
         }
           while(rs.next())
           {
               int x=rs.getInt("ISAC");
               if(x==2)
              {
                int y=rs.getInt("SCOD");
                if(present==y)
                {
                  double Totalbill=0,amount=0;
                  ObjectInputStream o = null;
                  byte[] arr = rs.getBytes("Catering");
                   Vector Catering = new Vector();
                  if(arr!=null)
                  {
                      o = new ObjectInputStream(new ByteArrayInputStream(arr));
                      Catering= (Vector)o.readObject();
                  } 
                  if(Catering.size()!=0)
                  {
                                        CateringObject obj=(CateringObject) Catering.elementAt(0);
                                        Totalbill=obj.bill;
                                         tb.addRow(new Object[]{new String(rs.getString("Name")),new String(rs.getString("I")),new String(obj.date),new String(obj.item),new Double(obj.bill) });
                                                         for(int f=1;f<Catering.size();f++)
                                                          {
                                                              obj=(CateringObject) Catering.elementAt(f);
                                                            tb.addRow(new Object[]{new String(""),new String(""),new String(obj.date),new String(obj.item),new Double(obj.bill) });
                                                            Totalbill=Totalbill+obj.bill;
                                                           }
                                                         String updatestr = "UPDATE customer SET Catering = ?  WHERE id = "+rs.getInt("id");
                                                         PreparedStatement p = conn.prepareStatement(updatestr);
                                                         p.setObject(1,null);
                                                         p.executeUpdate();
                  }
                  sql="UPDATE customer SET ISAC=0 WHERE id= "+rs.getInt("id");
                  stmt.executeUpdate(sql);
                  int ap=rs.getInt("History")+rs.getInt("SCOD")-rs.getInt("SCID"),ap1=+rs.getInt("SCOD")-rs.getInt("SCID");
                   sql="UPDATE customer SET history="+ap+" WHERE id= "+rs.getInt("id");
                  stmt.executeUpdate(sql);
                  int to=0;
                  String room=rs.getString("Room");
                  String roompart=room.substring(0,1);
                  
                 double roomrent=0,tariffa=0,dicounta=0,advance=0;
                  advance=rs.getDouble("RTP");
                  if(roompart.equalsIgnoreCase("SA")){
                      amount=ap1*(double) rates.elementAt(0);
                      roomrent=amount;
                       amount=amount+Totalbill;
                       tariffa=(amount*(double)tariff.elementAt(0))/100;
                       amount=amount+tariffa;
                       to=(int) totalbookings.elementAt(0);
                       to=to+ap;
                       totalbookings.setElementAt(to,0);
                       
                  }
                  
                  if(roompart.equalsIgnoreCase("SNA"))amount=(double) rates.elementAt(1);
                  {
                       amount=ap1*(double) rates.elementAt(1);
                       roomrent=amount;
                       amount=amount+Totalbill;
                        tariffa=(amount*(double)tariff.elementAt(1))/100;
                       amount=amount+(amount*(double)tariff.elementAt(1))/100;
                       to=(int) totalbookings.elementAt(1);
                       to=to+ap;
                       totalbookings.setElementAt(to,1);
                  }
                  if(roompart.equalsIgnoreCase("DA"))
                  {
                       amount=ap1*(double) rates.elementAt(2);
                        roomrent=amount;
                       amount=amount+Totalbill;
                       tariffa=(amount*(double)tariff.elementAt(2))/100;
                       amount=amount+(amount*(double)tariff.elementAt(2))/100;
                       to=(int) totalbookings.elementAt(2);
                       to=to+ap;
                       totalbookings.setElementAt(to,2);
                  }
                  if(roompart.equalsIgnoreCase("DNA"))
                  {
                      amount=ap1*(double) rates.elementAt(3);
                      roomrent=amount;
                       amount=amount+Totalbill;
                        tariffa=(amount*(double)tariff.elementAt(3))/100;
                       amount=amount+(amount*(double)tariff.elementAt(3))/100;
                       to=(int) totalbookings.elementAt(3);
                       to=to+ap;
                       totalbookings.setElementAt(to,3);
                  }
                  String updatestr = "UPDATE central SET Value = ?  WHERE id =12 ";
                                                         PreparedStatement p = conn.prepareStatement(updatestr);
                                                         p.setObject(1,totalbookings);
                                                         p.executeUpdate();
                 int history=rs.getInt("history");
                 double cusfre=history/present;
                 double minfree=(double) discount.elementAt(0);
                 double minbill=(double) discount.elementAt(1);
                 double d1=(double) discount.elementAt(2);
                 double d2=(double) discount.elementAt(3);
                 double d3=(double) discount.elementAt(4);
                 double d4=(double) discount.elementAt(5);
                
                 if(cusfre<minfree && amount<minbill)
                 {
                     
                 }
                     
                     
                     
                  tb.addRow(new Object[]{new String(rs.getString("Name")),new String(rs.getString("I")),new Double(advance),new Double(roomrent),new Double(tariffa)});


                }
              }
               
               
               
               
               
               
               
               
               
               
               
             if(x==1)
             {
                
             }
           }
           
    
    
    
    
    }
     /*   for(int j=1;j<=;++j)
        {
            s = x.getBook(j, I, R);
            if(s!=null)
            {
                str3 = s.name+"-"+Integer.toString(s.serial);
                if(s.isissuable())
                {
                    str2 = "Y";
                }
                else
                {
                    str2 = "N";
                }
                tb.addRow(new Object[]{new String(str3),new Integer(s.year),new String(s.date),new Integer(s.price),new String(s.publisher),new String(str2) });
                
            }
        }
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 51, 204), null));
        jTable1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Unique Number", "Date", "Item", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 30, 740, 210);

        jTable2.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Unique Number", "Total Catering Bill", "Advance", "Room Rent", "Tariff", "Discount", "Final Bill"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(12, 260, 750, 180);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CheckOut().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
