package com.DSCE.dsa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Table.Cell;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Product {

@FXML
   private TextField pro_name;

   @FXML
   private TextField pro_cost;

   @FXML
   private TextField pid;
 
   @FXML
   private TextField qty;
   
   @FXML
   private TextField expiry;

   

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button store;
    
    @FXML
    private Button view;
 /*   
   int cost_array[]=new int[15];
   String pname_array[]=new String[15];
   
   int pid_array[]=new int[15];
   
  */ public String exp;
    
    final ArrayList<Float> cost_array = new ArrayList<Float>();
    final ArrayList<String> pname_array = new ArrayList<String>();
    final ArrayList<Integer> pid_array = new ArrayList<Integer>();
    final ArrayList<Integer> qty_array = new ArrayList<Integer>();
    final ArrayList<String> exp_array = new ArrayList<String>();
     public float cost1;
     public int q1;
    @FXML
    void add(ActionEvent event) throws IOException {
   
    String name=pro_name.getText();
    String cost=pro_cost.getText();
   cost1= Integer.parseInt(cost);
   
    String p=pid.getText();
    int p1= Integer.parseInt(p);
    String q=qty.getText();
     q1= Integer.parseInt(q);
   
      exp=expiry.getText();
    String qa="Product details";
    cost_array.add(cost1);
    pname_array.add(name);
    pid_array.add(p1);
    qty_array.add(q1);
    exp_array.add(exp);
    
    System.out.println(qty_array);
    System.out.println("---------------------");
    System.out.println("---------------------");
    System.out.println("---------------------");
    System.out.println("---------------------");
    FileInputStream file = new FileInputStream(new File("C:\\Users\\HP\\Desktop\\Workbook2.xls"));
	
	  //Get the workbook instance for XLS file 
	  HSSFWorkbook workbook = new HSSFWorkbook(file);

	  //Get first sheet from the workbook
	  HSSFSheet sheet = workbook.getSheetAt(0);
	

  int rc=sheet.getLastRowNum();
  System.out.println(rc);
/*  for (int j = 0; j<1; j++) {
  
       row.createCell(j).setCellValue("Product Name");
      row.createCell(j+1).setCellValue("COst");
      row.createCell(j+2).setCellValue("ID");

      
  }

/*   for (int i = 0; i <1; i++) {
      row = spreadsheet.createRow(i+1);
      for (int j = 0; j < 1; j++) {
       row.createCell(j).setCellValue(name);
       row.createCell(j+1).setCellValue(cost);
       row.createCell(j+2).setCellValue(p);
    
          }
          */
  for(int i=0;i<pname_array.size();i++) 
  {
 	  Row row=sheet.createRow(++rc);
	   row.createCell(0).setCellValue(pname_array.get(0));
	 row.createCell(1).setCellValue(pid_array.get(0));
	 row.createCell(2).setCellValue(cost_array.get(0));
	 row.createCell(3).setCellValue(qty_array.get(0));
	 row.createCell(4).setCellValue(exp_array.get(0));

	  // spreadsheet.createRow(i+2);
	   
  
      }

 
  
FileOutputStream fileOut = new FileOutputStream("C:\\Users\\HP\\Desktop\\Workbook2.xls");
  workbook.write(fileOut);
  fileOut.close();
  

   


     
       
       try{  
          final CountDownLatch latch1 = new CountDownLatch(1);
          DatabaseReference root = FirebaseDatabase.getInstance().getReference(qa);
      //    root.addListenerForSingleValueEvent(new ValueEventListener() {
//      @Override
//      public void onDataChange(DataSnapshot dataSnapshot) {
     String prod_id=pid.getText();
     String pr_name=pro_name.getText();
     String cost2=pro_cost.getText();
     String quant=qty.getText();
     String exp1=expiry.getText();

     System.out.println(prod_id);
     DatabaseReference newkey = root.push();

   
     String postId = newkey.getKey();
     DatabaseReference ref = FirebaseDatabase.getInstance().getReference(qa+"/" + postId);
     // DatabaseReference ref = FirebaseDatabase.getInstance().getReference(qa+"/"+postId+"/"+date);
     DatabaseReference child_name = FirebaseDatabase.getInstance().getReference();
     child_name=ref.child("name");
     child_name.setValueAsync(pr_name);
     DatabaseReference child_descp = FirebaseDatabase.getInstance().getReference();
     child_descp=ref.child("ID");
     child_descp.setValueAsync(prod_id);
     DatabaseReference child_answer = FirebaseDatabase.getInstance().getReference();
     child_answer=ref.child("cost");
     child_answer.setValueAsync(cost2);
     DatabaseReference child_ans = FirebaseDatabase.getInstance().getReference();
     child_ans=ref.child("quantity");
     child_ans.setValueAsync(quant);
     latch1.await();
             
       
     Alert alerts=new Alert(AlertType.INFORMATION);
     alerts.setTitle("Information Dialog");
     alerts.setHeaderText(null);
     alerts.setContentText("Successfully added");
     alerts.showAndWait();
     
   
           
   
   
   
     }
     catch (InterruptedException ef) {
         ef.printStackTrace();
     }
       
       
   
    }
    
    @FXML
    public void store_details(ActionEvent event) throws UnsupportedEncodingException, IOException {
   
   
   /* final ArrayList<ArrayList<String>> big = new ArrayList<ArrayList<String>>();
    final ArrayList<String> smol = new ArrayList<String>();
 
    final ArrayList<DataSnapshot> Userlist = new ArrayList<DataSnapshot>();
    try {
    	
    	
            final CountDownLatch latch = new CountDownLatch(1);
            DatabaseReference root = FirebaseDatabase.getInstance().getReference("Product details");
            
            root.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
int i=0;
                   //ArrayList<Object> Userlist = new ArrayList<Object>();  
//String[] arr=new String[4];
                   ArrayList<ArrayList<String>> big_arr = new ArrayList<ArrayList<String>>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    System.out.println(dsp.getChildren());
                  //  count=dsp.getChildrenCount();
                    System.out.println(dsp.getChildrenCount());
                    System.out.println("------------------------");
                    System.out.println(dsp.getKey());
                    System.out.println(dsp.getValue().toString());
                    smol.add(dsp.getValue().toString());
                    
                   
                      Userlist.add(dsp);
                      big.add(smol);
                                           
                       }
                    System.out.println(Userlist); 
             //       System.out.println(Userlist.get(1).getValue().toString()); 
                    for(i=1;i<4;i++)
                    {
                   // System.out.println(Userlist.get(i).toString());
                    	System.out.println(Userlist.get(i).getValue().toString()); 
                    	                 
                                
                   // smol.add(Userlist.get(i).getValue().toString());
                   
                    i++;
                    }
                   // big.add(smol);
                   System.out.println(big);  
                  
                                                                 latch.countDown();
                                                                 
                       String[] arr = new String[big.size()]; 
                                   arr = big.toArray(arr);                                         
                                                                 
                                   for (String x : arr) 
                                       System.out.print(x + " ");        
                                                          
                                                                 
                                                                 
        }

             private void store() throws UnsupportedEncodingException, IOException
             {
			
            	

				
			}

			public void onCancelled(DatabaseError error) {
             latch.countDown();
             
             }
            });
            latch.await();
      }
    catch (InterruptedException en) {
           en.printStackTrace();
       }
    
    
    */
    	/*
    	 String name=pro_name.getText();
    	    String cost=pro_cost.getText();
    	    String p=pid.getText();
    	    String qa="Product details";
    	    cost_array.add(cost);
    	    pname_array.add(name);
    	    pid_array.add(p);
    	    
    	    System.out.println(pname_array);
    	    System.out.println("---------------------");
    	    System.out.println("---------------------");
    	    System.out.println("---------------------");
    	    System.out.println("---------------------");
    	   

    	
    	    FileInputStream file = new FileInputStream(new File("C:\\Users\\HP\\Desktop\\Workbook2.xls"));
			
    	  //Get the workbook instance for XLS file 
    	  HSSFWorkbook workbook = new HSSFWorkbook(file);

    	  //Get first sheet from the workbook
    	  HSSFSheet sheet = workbook.getSheetAt(0);
    	
    	
    //	 Workbook workbook = new HSSFWorkbook();
       //  Sheet spreadsheet = workbook.createSheet("sample2");
        
         int rc=sheet.getLastRowNum();
         System.out.println(rc);
       /*  for (int j = 0; j<1; j++) {
         
              row.createCell(j).setCellValue("Product Name");
             row.createCell(j+1).setCellValue("COst");
             row.createCell(j+2).setCellValue("ID");
       
             
         }

      /*   for (int i = 0; i <1; i++) {
             row = spreadsheet.createRow(i+1);
             for (int j = 0; j < 1; j++) {
              row.createCell(j).setCellValue(name);
              row.createCell(j+1).setCellValue(cost);
              row.createCell(j+2).setCellValue(p);
           
                 }
                 */
   /*      for(int i=0;i<pname_array.size();i++) 
         {
        	  Row row=sheet.createRow(++rc);
      	   row.createCell(0).setCellValue(pname_array.get(0));
      	 row.createCell(1).setCellValue(pid_array.get(0));
      	 row.createCell(2).setCellValue(cost_array.get(0));
      	  // spreadsheet.createRow(i+2);
      	   
      	 
      	         
             }
        
         
         
         
    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\HP\\Desktop\\Workbook2.xls");
         workbook.write(fileOut);
         fileOut.close();
         
     */
         
         
    
       
      }
   
     
                             
     

    

    
    
    
    
    

    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void view_table(ActionEvent event) throws IOException {
   
    Stage primaryStage=new Stage();
Parent root=FXMLLoader.load(getClass().getResource("ViewTable.fxml"));
Rectangle2D screenBounds = Screen.getPrimary().getBounds();
Screen screen = Screen.getPrimary();


int width = (int) screenBounds.getWidth();
width = (width/100)*60;

int height = (int) screenBounds.getWidth();
height = (height/100)*50;
primaryStage.initStyle(StageStyle.UNDECORATED);

Scene scene = new Scene(root,width,height);

scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
primaryStage.setScene(scene);
primaryStage.show();
   

    }

   

    


}

