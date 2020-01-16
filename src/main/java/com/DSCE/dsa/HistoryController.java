package com.DSCE.dsa;

//import java.awt.TextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

import com.DSCE.dsa.ViewTable.Person;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.usermodel.DateAndTime;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class HistoryController implements Initializable  {
	
	
	 @FXML
	    private Button search;
	 @FXML
	    private Button reorder;
	 @FXML
	    private TextArea t_area;
	 @FXML
	    private Button button;

	@FXML
	private TextField pid;
	
	 @FXML
		ComboBox year=new ComboBox();
	 @FXML
		ComboBox month=new ComboBox();

	    
  String name;
  String desc,cost,id;
  final ArrayList<String> pid_list = new ArrayList<String>();
  final ArrayList<String> exp_list = new ArrayList<String>();
	    
  private static String USER_NAME = "priyadineshsn";   
  private static String PASSWORD = "priyadineshsns11996699*p"; // GMail password
	    
	   
	  public void initialize(URL url, ResourceBundle rb)
	    {
	    	 ObservableList<Integer> options = 
	    	       	    FXCollections.observableArrayList(2019,2020,2021);
	    	       
	    		        year.getItems().addAll(options);
	    		        
	    		        
	    		       
	    		        
	    		        ObservableList<String> opt = 
	    	    	       	    FXCollections.observableArrayList("September","October","November");
	    	    	       
	    	    		        month.getItems().addAll(opt);
	    	    		       
	    	    		      
	    	    		        
	    	   		       

	    	    		        
	    	    		 
	    }
	    
	

	    @FXML
	    void search(ActionEvent event) {
	    	
	    	 System.out.println("Button Clicked and a new Row Added");
	    
	    	 System.out.println( month.getValue());
	    	 String mon_nm=month.getValue().toString();
	    	 try {
	             final CountDownLatch latch1 = new CountDownLatch(1);
	             DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
	             DatabaseReference ref2;    
	             System.out.println("stupid internet");
	              ref2 = ref1.child("Months/" + mon_nm);


	              ref2.addListenerForSingleValueEvent(new ValueEventListener() {
	               @Override
	               public void onDataChange(DataSnapshot dataSnapshot) {

	                   ArrayList<String> Userlist = new ArrayList<String>();   
	                  // ArrayList<ArrayList<String>> big_arr = new ArrayList<ArrayList<String>>();
	                  	                      for (DataSnapshot dsp : dataSnapshot.getChildren()) {
	                         Userlist.add(String.valueOf(dsp.getValue())); 
	                      
	                       }
	                //   big_arr.add(Userlist);
	        				     System.out.println(Userlist.toString());
	        				   name=Userlist.get(0).toString();
	        				  id=Userlist.get(1).toString();
	        				  cost=Userlist.get(2).toString();
	        				  desc=Userlist.get(3).toString();
	        				  
	        				 System.out.println(name);
	        				 System.out.println(desc);

	                                               latch1.countDown();
	    				     }

	 			        	  @Override
	 			        	  public void onCancelled(DatabaseError error) {
	 			        		  latch1.countDown();
	 			        		  
	 			        	  }
	 			        	});
	 			        	 latch1.await();
	    			   } 
	    			 catch (InterruptedException e) {
	 				        e.printStackTrace();
	 				    }
	    	 
	    	    t_area.setText("");
	    	    t_area.setText("Name:  " + name + "\n");
	    	    t_area.appendText("ID:  " + id + "\n");
	    	    t_area.appendText("Summary:  " + desc + "\n");
	    	    t_area.appendText("Cost:  " + cost + "\n");
	   	 
	    	
	    }

	   @FXML
	    void reorder(ActionEvent event)
	    {
		   String mail="priyadineshsn@gmail.com";
    	   System.out.println("lolo");
    	   String RECIPIENT = mail;
    	   String from = USER_NAME;
           String pass = PASSWORD;
           String[] to = { RECIPIENT }; // list of recipient email addresses
           String subject = "placement of order";
           String body = "Name:  " + name + "\n" + "Cost:  " +cost + "\n" + "Desc:  " + desc + "\n" + "ID:  " + id + "\n" + "We would like to place an immediate order for the above cited product" + "\n" + "Thank you!";

           sendFromGMail(from, pass, to, subject, body);
		   
	    }
	   
	   private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", from);
	        props.put("mail.smtp.password", pass);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");

	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(from));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }

	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, from, pass);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }

	   @FXML
	    void check_expiry(ActionEvent event) throws IOException, ParseException {
		   
			String str = "C:\\Users\\HP\\Desktop\\Workbook2.xls";

			InputStream ExcelFileToRead = new FileInputStream(str);
		   
		   String id=pid.getText();
		   HSSFWorkbook  wb = new HSSFWorkbook(ExcelFileToRead);
			HSSFSheet sheet = wb.getSheetAt(0);


			HSSFRow row; 
			HSSFCell cell;

			Iterator rows = sheet.rowIterator();

			String[] sheetrows ;

			sheetrows = new String[7];

			int k =0;
			System.out.println(sheet.getPhysicalNumberOfRows());

			while(k<sheet.getPhysicalNumberOfRows())
			{

		System.out.println(sheet.getRow(k).getCell(1));
	//	System.out.println(sheet.getRow(k).getCell(3));

				pid_list.add(
						String.valueOf((int)sheet.getRow(k).getCell(1).getNumericCellValue())
						);
				exp_list.add(
						String.valueOf((sheet.getRow(k).getCell(4).toString()))
						);
				
			//System.out.println(sheet.getRow(k).getCell(2).getStringCellValue());
			k++;
			}
			System.out.println(pid_list);
			System.out.println(exp_list);
         for(int i=0;i<pid_list.size();i++)
         {
			if(id.equals(pid_list.get(i)))
			{
				System.out.println("equal");
			  
				System.out.println(exp_list.get(i));
				
				
				 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");  
				    Date date = new Date();  
				    System.out.println(formatter.format(date));  
				    
				String dateStart = exp_list.get(i);
			    String dateStop =formatter.format(date).toString();

			  //  Custom date format
			    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

			    Date d1 = null;
			    Date d2 =null;
			    try {
			        d2 = format.parse(dateStart);
			        d1 = format.parse(dateStop);
			    } catch (ParseException e) {
			        e.printStackTrace();
			    }

			    // Get msec from each, and subtract.
			    long diff = d2.getTime() - d1.getTime();
			    long diffSeconds = diff / 1000 % 60;
			    long diffMinutes = diff / (60 * 1000) % 60;
			    long diffHours = diff / (60 * 60 * 1000);
			    int diffInDays = (int) diff / (1000 * 60 * 60 * 24);

			    System.out.println("Time in seconds: " + diffSeconds + " seconds.");
			    System.out.println("Time in minutes: " + diffMinutes + " minutes.");
			    System.out.println("Time in hours: " + diffHours + " hours.");
			    System.out.println("Time in days: " + diffInDays + " days.");
			
			
			    if(diffInDays<=10)
			    {
			    	Alert alert = new Alert(AlertType.WARNING);
			    	alert.setTitle("Alert Box");
			    	alert.setHeaderText("Status : Product nearing EXPIRY");
			    	alert.setContentText("Status : Product nearing EXPIRY");
			    	alert.setContentText("Expires in " + diffInDays + " days");
			    	alert.showAndWait();
			    	//return;
			    }
			    else
			    {
			    	Alert alert = new Alert(AlertType.INFORMATION);
			    	alert.setTitle("Alert Box");
			  //  	alert.setHeaderText("Look, an Error Dialog");
			    	alert.setContentText("Status : Well behind expiry");
			    	alert.setContentText("Expires in " + diffInDays + " days");
			    	alert.showAndWait();
			    	
			    }
			//    Product pd= new Product();
			    //String expiry_pd= pd.exp;
			   // System.out.println(expiry_pd);
			
			}
         }
	    }


	    
	
	    
	    
	  
}
