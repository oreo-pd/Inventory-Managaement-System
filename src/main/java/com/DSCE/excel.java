package com.DSCE;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {

public static void main(String args[]) throws IOException, InvalidFormatException
{
	String name="nm";
    String cost="789";
    String p="3456";
   
   

Workbook workbook = new HSSFWorkbook();
       Sheet spreadsheet = workbook.createSheet("sample2");

       Row row = spreadsheet.createRow(0);

      /* for (int j = 0; j<1; j++) {
       
            row.createCell(j).setCellValue("Product Name");
           row.createCell(j+1).setCellValue("COst");
           row.createCell(j+2).setCellValue("ID");
     
           
       }

       for (int i = 0; i <1; i++) {
           row = spreadsheet.createRow(i+1);
           for (int j = 0; j < 1; j++) {
            row.createCell(j).setCellValue(name);
            row.createCell(j+1).setCellValue(cost);
            row.createCell(j+2).setCellValue(p);
         
               }
       
           }
           */
 
       final String FILE_NAME 
       = "C:\\Users\\HP\\Desktop\\Workbook2.xls"; 
    InputStream inp = new FileInputStream(FILE_NAME); 
     //  Workbook wb = WorkbookFactory.create(inp); 
     //  Sheet sheet = wb.getSheetAt(0); 
       int num = spreadsheet.getLastRowNum(); 
       Row row1 = spreadsheet.createRow(++num); 
       row1.createCell(0).setCellValue(name); 
       row1.createCell(1).setCellValue(cost); 
       row1.createCell(2).setCellValue(p); 
     
           // Now this Write the output to a file 
           FileOutputStream fileOut = new FileOutputStream(new File(FILE_NAME)); 
       workbook.write(fileOut); 
       fileOut.close(); 
   
       
     
}

}
