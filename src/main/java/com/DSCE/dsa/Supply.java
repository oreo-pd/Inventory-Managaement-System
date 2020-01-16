package com.DSCE.dsa;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.DSCE.dsa.ViewTable.Person;

public class Supply {

    @FXML
    private TextField id;

    @FXML
    private Button btn,view;
    
    @FXML
	private TableView<Person> table = new TableView<Person>();
    //@FXML
  //  private TextField filterField;
    
//	@FXML
//	TableColumn SupName,Email,MobileNo;
	 @FXML
	    private TableColumn SupName;

	    @FXML
	    private TableColumn Email;

	    @FXML
	    private TableColumn MobileNo;
	 
	@FXML
	
	   
	   private ObservableList<Person> data =
	       FXCollections.observableArrayList(
	    		   //new Person("tjb", 11,123)
	    		   );
    
    
    private static String USER_NAME = "priyadineshsn";   
    private static String PASSWORD = "priyadineshsns11996699*p"; // GMail password
   
    public void initialize() throws IOException
	{
		
		 table.setEditable(true);
	SupName = new TableColumn("NAME");
    SupName.setMinWidth(150);
    SupName.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Pname"));
    
    Email = new TableColumn("EMAIL");
    Email.setMinWidth(150);
    Email.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Pid"));
    
    MobileNo = new TableColumn("MOBILE");
    MobileNo.setMinWidth(150);
    MobileNo.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Cost"));
    
    
    table.setItems(data);
    table.getColumns().addAll(SupName,Email,MobileNo);
   
        
    
  //  FilteredList<Person> filteredData = new FilteredList<>(data, p -> true);
   /* filterField.setOnKeyReleased(p ->{
    filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(person -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
            
            
            if (person.getPid().contains(newValue)) {
				return true;
			}
                  return false; // Does not match.
        });
    });
    */
    
    //SortedList<Person> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
    //    sortedData.comparatorProperty().bind(table.comparatorProperty());
      //  table.setItems(sortedData);
    
    
    //});
    
	}
    
    
   
public void importExcelFile(ActionEvent e) throws IOException
{
	table.getColumns().clear();
	table.getColumns().addAll(SupName,Email,MobileNo);
	table.setItems(data);
	
	
	data.clear();
	table.setItems(data);
	
	
	String[] sheetrows ;

	FileChooser fileChooser = new FileChooser();
	File file = fileChooser.showOpenDialog(null);

	String str = file.getAbsolutePath().toString();

	InputStream ExcelFileToRead = new FileInputStream(str);

	//InputStream ExcelFileToRead = new FileInputStream("C:\\Users\\HP\\Desktop\\"+studdat.get(0)+studdat.get(1)+".xls");
	HSSFWorkbook  wb = new HSSFWorkbook(ExcelFileToRead);
	HSSFSheet sheet = wb.getSheetAt(0);


	HSSFRow row; 
	HSSFCell cell;

	Iterator rows = sheet.rowIterator();

	sheetrows = new String[4];

	int k =0;
	System.out.println(sheet.getPhysicalNumberOfRows());

	while(k<sheet.getPhysicalNumberOfRows())
	{

System.out.println(sheet.getRow(k).getCell(0));

System.out.println(sheet.getRow(k).getCell(1));

System.out.println(sheet.getRow(k).getCell(2));

		data.add(new Person(sheet.getRow(k).getCell(0).getStringCellValue(),
				String.valueOf(sheet.getRow(k).getCell(1).getStringCellValue()),
	String.valueOf((long)sheet.getRow(k).getCell(2).getNumericCellValue())
		));
	//System.out.println(sheet.getRow(k).getCell(2).getStringCellValue());
	k++;
	}
	table.setItems(data);
	}



@FXML
void delete_row(ActionEvent event) {
   
	ObservableList<Person> allp,singlep;
	allp=table.getItems();
	singlep=table.getSelectionModel().getSelectedItems();
	singlep.forEach(allp::remove);
}


@FXML
void go_back(ActionEvent event) throws IOException {
	
	Stage primaryStage=new Stage();
	primaryStage.initStyle(StageStyle.UNDECORATED);
	Parent root=FXMLLoader.load(getClass().getResource("FrontEnd.fxml"));
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



public static class Person {
	  
    private final SimpleStringProperty pname;
private final SimpleStringProperty pid;
    private final SimpleStringProperty cost;
    //private final SimpleStringProperty per;
  
    
    Person(String string,String string1, String string2) {
    this.pname = new SimpleStringProperty(string);
    this.pid =new SimpleStringProperty(string1);
        this.cost =new SimpleStringProperty(string2);
      
        
    }
    
   


public String getPname() {
        
        return pname.get();
    }
    
    public void setPname(String u) {
       pname.set(u);
    }

    public String getPid() {
        
        return pid.get();
    }

    
    public void setPid(String u) {
        pid.set(u);
    }

    public String getCost() {
    
    return cost.get();
    }

    public void setCost(String u) {
        cost.set(u);
       
    }
    
       
}
  
  

    @FXML
    void send_mail(ActionEvent event) {
    	
    	   String mail=id.getText();
    	   System.out.println("lolo");
    	   String RECIPIENT = mail;
    	   String from = USER_NAME;
           String pass = PASSWORD;
           String[] to = { RECIPIENT }; // list of recipient email addresses
           String subject = "Java send mail example";
           String body = "Welcome to JavaMail!";

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



    
}