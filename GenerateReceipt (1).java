/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshopautomationsoftware;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.lang.*;
import static java.lang.Long.max;
import static javax.swing.JOptionPane.showMessageDialog;

public class GenerateReceipt{
     static Random rand = new Random();
      static int min=0 , max=1000;
  
    static int randomNum = rand.nextInt((max - min) + 1) + min;

    static String name="Bill"+randomNum;
     //private static String FILE = "c:/temp/Bill3.pdf";
    private static final String FILE = "c:/temp/"+name+".pdf";
  private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
      Font.BOLD);
  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.NORMAL, BaseColor.RED);
  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
      Font.BOLD);
  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
      Font.BOLD);
  static final String DB_URL1 = "jdbc:mysql://localhost/bookshop";
    static final String USER1 = "root";
    static final String PASS1 = "bassql";
    public GenerateReceipt()
    {
        try {
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      addTitlePage(document);
      addContent(document);
      document.close();
     } catch (Exception e) {
      e.printStackTrace();
     }
    }
  
  public static void main(String[] args) {
    try {
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream(FILE));
      document.open();
      addMetaData(document);
      addTitlePage(document);
      addContent(document);
      document.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  private static void addMetaData(Document document) {
    document.addTitle("RECEPIT ");
    document.addSubject("Using iText");
    document.addKeywords("Java, PDF, iText");
    document.addAuthor("Ramanth");
    document.addCreator("Ramanth");
  }
  
  static Paragraph preface;
  private static void addTitlePage(Document document)
      throws DocumentException {
    preface = new Paragraph();
    // We add one empty line
    addEmptyLine(preface, 1);
    // Lets write a big header
    preface.add(new Paragraph("              RECEIPT ", catFont));

    addEmptyLine(preface, 1);
    // Will create: Report generated by: _name, _date
    preface.add(new Paragraph("Report generated by: BAS , " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        smallBold));
    addEmptyLine(preface, 1);
    preface.add(new Paragraph("Please keep the bill safe for future advantages ",
        smallBold));

    //addEmptyLine(preface, 8);

   // preface.add(new Paragraph("This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
   //     redFont));

   // document.add(preface);
    // Start a new page
   // document.newPage();
  }
    
 

  private static void addContent(Document document) throws DocumentException {
    Anchor anchor = new Anchor("BILL DETAILS(Generated by BAS) on "+new Date(), catFont);
   // anchor.setName("First Chapter");

    // Second parameter is the number of the chapter
    Chapter catPart = new Chapter(new Paragraph(anchor), 1);

    Paragraph subPara = new Paragraph("CUSTOMER BILL", subFont);
    
    Section subCatPart = catPart.addSection(subPara);
    addEmptyLine(preface, 2);
   // add a table
    createTable(subCatPart);
    
     Paragraph subPara2= new Paragraph("Thanks for choosing us .. please visit again", subFont);
     Section subCatPart2 = catPart.addSection(subPara2);
    /* Anchor anchor2 = new Anchor("Thanks for choosing us .. please visit again", catFont);
     Chapter catPart2 = new Chapter(new Paragraph(anchor), 1);*/

    // now add all this to the document
    document.add(catPart);
    //document.add(catPart2);

  }
  
  private static void createTable(Section subCatPart)
      throws BadElementException {
     PdfPTable table = new PdfPTable(4);

    // t.setBorderColor(BaseColor.GRAY);
    // t.setPadding(4);
    // t.setSpacing(4);
    // t.setBorderWidth(1);
   addEmptyLine(preface, 2);
    PdfPCell c1 = new PdfPCell(new Phrase("slno"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("isbn"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);

    c1 = new PdfPCell(new Phrase("quantity"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    
    c1 = new PdfPCell(new Phrase("price"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    table.addCell(c1);
    
    table.setHeaderRows(1);

    
      try{
            Connection con = DriverManager.getConnection(DB_URL1, USER1, PASS1);
            Statement stmnt = con.createStatement();
            String sql ="SELECT slno,book,quantity FROM cart";
            Connection con1 = DriverManager.getConnection(DB_URL1, USER1, PASS1);
            Statement stmnt1 = con.createStatement();
            int count=0;
            ResultSet rs= stmnt.executeQuery(sql);
            ResultSet rs1;
            float total=0;
            while(rs.next())
            {
                String sql1 ="SELECT isbn,price FROM booktable WHERE isbn = "+rs.getLong("book");
                rs1=stmnt1.executeQuery(sql1);
                rs1.next();
                count++;
                table.addCell(""+rs.getInt("slno"));
                table.addCell(""+rs.getLong("book"));
                table.addCell(""+rs.getInt("quantity"));
                table.addCell(""+rs1.getFloat("price"));
                total+=(rs1.getFloat("price"))*(rs.getInt("quantity"));
                
               //  model.addRow(new Object[]{(""+rs.getInt("slno")),""+rs.getLong("book"),""+rs.getInt("quantity")});
            }
                table.addCell("");
                table.addCell("");
                table.addCell("");
                table.addCell(""+total);
            if(count==0)
            {
              // dispose();
               
               return;
            }
            
        }catch(Exception e)
        {
            System.out.println(" "+e+" is caught");
        }    
    /*table.addCell("1.0");
    table.addCell("1.1");
    table.addCell("1.2");
    table.addCell("2.1");
    table.addCell("2.2");
    table.addCell("2.3");*/

    subCatPart.add(table);

  }
  
  private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }

 /*  private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }*/
}
