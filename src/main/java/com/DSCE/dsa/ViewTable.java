package com.DSCE.dsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.function.Predicate;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


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
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
  
public class ViewTable 
{
	
	@FXML
    private Button view,delete,back;
	
	String tfsem = "";
	String tfsec = "";
	
	
	@FXML
	private TableView<Person> table = new TableView<Person>();
    @FXML
    private TextField filterField;
    
//	@FXML
//	TableColumn PNameCol,PidCol,CostCol;
	 @FXML
	    private TableColumn PNameCol;

	    @FXML
	    private TableColumn PidCol;

	    @FXML
	    private TableColumn CostCol;
	    
	  //  @FXML
	   // private TableColumn QtyCol;

	
	@FXML
	
	   
	   private ObservableList<Person> data =
	       FXCollections.observableArrayList(
	    		   //new Person("tjb", 11,123)
	    		   );
	
	public void initialize() throws IOException
	{
		
		 table.setEditable(true);
	PNameCol = new TableColumn("Product NAME");
    PNameCol.setMinWidth(150);
    PNameCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Pname"));
    
    PidCol = new TableColumn("Product ID");
    PidCol.setMinWidth(150);
    PidCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Pid"));
    
    CostCol = new TableColumn("Product COSt");
    CostCol.setMinWidth(150);
    CostCol.setCellValueFactory(
            new PropertyValueFactory<Person, String>("Cost"));
    
    
   /* QtyCol = new TableColumn("Product Qty");
    QtyCol.setMinWidth(150);
    QtyCol.setCellValueFactory(
            new PropertyValueFactory<Person, ImageView>("Quantity"));
*/
    
    table.setItems(data);
    table.getColumns().addAll(PNameCol,PidCol,CostCol);
   
        
    
    FilteredList<Person> filteredData = new FilteredList<>(data, p -> true);
    filterField.setOnKeyReleased(p ->{
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
      /*      
            if (person.getPname().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            } else if (person.getPname().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches last name.
            }
      */
            return false; // Does not match.
        });
    });
    
    
    SortedList<Person> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    
    
    });
    
	}
    
    
   
public void importExcelFile(ActionEvent e) throws IOException
{
	table.getColumns().clear();
	table.getColumns().addAll(PNameCol,PidCol,CostCol);
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

	sheetrows = new String[7];

	int k =0;
	System.out.println(sheet.getPhysicalNumberOfRows());

	while(k<sheet.getPhysicalNumberOfRows())
	{

System.out.println(sheet.getRow(k).getCell(0));
System.out.println(sheet.getRow(k).getCell(3));

		data.add(new Person(sheet.getRow(k).getCell(0).getStringCellValue(),
				String.valueOf((int)sheet.getRow(k).getCell(1).getNumericCellValue()),
	String.valueOf((int)sheet.getRow(k).getCell(2).getNumericCellValue())
	//String.valueOf((int)sheet.getRow(k).getCell(3).getNumericCellValue())
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
    //private final SimpleStringProperty qty1;
    
    
    Person(String string,String string1, String string2) {
    this.pname = new SimpleStringProperty(string);
    this.pid =new SimpleStringProperty(string1);
        this.cost =new SimpleStringProperty(string2);
      //  this.qty1 =new SimpleStringProperty(string3);
        
        
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
 /*   public String getQty() {
        
        return qty1.get();
        }

        public void setQty(String u) {
            qty1.set(u);
           
        }
        */

    
    
    
   
}

}





