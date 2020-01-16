package com.DSCE.dsa;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.text.TableView.TableRow;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.scene.control.TableCell;
/**
 *
 * @author AMIT
 */
public class ProductDetails implements Initializable {
	
	String qty1,newqty,val;
	int value;
   
    @FXML
    private Label label;
   
    @FXML
    private Button button,btn;
    @FXML
    private TextField id,pname;

    @FXML
    private TextField qty,name;

    @FXML
    private Button update,extract;
   
    @FXML private TableView<Employee> tableview;
    @FXML private TableColumn<Employee, String> EmpID;
    @FXML private TableColumn<Employee, String> empName;
    @FXML private TableColumn<Employee, String> empEmail;
    @FXML private TableColumn<Employee, String> department;
    @FXML private TableColumn<Employee, String> salary;
    @FXML private TableColumn<Employee, String> empImage;
    TableColumn<Employee, Void> colBtn = new TableColumn("Button Column");

   
                   // heroCol.setCellValueFactory(new PropertyValueFactory<Hero, Hero>("hero"));
                   
   
    private final ObservableList<Employee> data = FXCollections.observableArrayList();
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
    	
    	
    	 String tf=pname.getText();
         
         if(tf.equalsIgnoreCase("sugar"))
         {
         // inside Observablelist and then set these inside tableview

        	 ImageView emp1photo = new ImageView(new Image(this.getClass().getResourceAsStream("madhur.jpg")));
             emp1photo.setFitHeight(115);
              emp1photo.setFitWidth(100);
              ImageView emp2photo = new ImageView(new Image(this.getClass().getResourceAsStream("loose.jpg")));
              emp2photo.setFitHeight(115);
              emp2photo.setFitWidth(100);
              ImageView emp3photo = new ImageView(new Image(this.getClass().getResourceAsStream("image1.jpg")));
              emp3photo.setFitHeight(115);
              emp3photo.setFitWidth(100);
        
        
        Employee emp2 = new Employee(emp1photo, 115, "madhur Sugar", "good refined sugar", "5 KG", 40000);
        Employee emp3 = new Employee(emp2photo, 116, "Loose sugar", "Good Quality", "15 Kg", 80000);
        Employee emp4 = new Employee(emp3photo,117, "Organic Sugar", "Organic", "10 Kg", 80000);
        
        data.add(emp2);
        data.add(emp3);
        data.add(emp4);
        
        
        tableview.setItems(data);
         }   
         
         if(tf.equalsIgnoreCase("rice"))
         {
        	 
        	 ImageView emp1photo = new ImageView(new Image(this.getClass().getResourceAsStream("r1.jpg")));
             emp1photo.setFitHeight(115);
              emp1photo.setFitWidth(100);
              ImageView emp2photo = new ImageView(new Image(this.getClass().getResourceAsStream("r2.jpg")));
              emp2photo.setFitHeight(115);
              emp2photo.setFitWidth(100);
              ImageView emp3photo = new ImageView(new Image(this.getClass().getResourceAsStream("image1.jpg")));
              emp3photo.setFitHeight(115);
              emp3photo.setFitWidth(100);
        	 
              Employee emp2 = new Employee(emp1photo, 118, "India Gate rice..the best there is.", "good refined sugar", "10 KG", 40000);
              Employee emp3 = new Employee(emp2photo, 119, "jeera rice for good tasting rice", "sam@gmail.com", "20 kg", 80000);
              Employee emp4 = new Employee(emp3photo,120, "Organic Sugar", "jhon@gmail.com", "80 kg", 80000);
        	 
        	 
              data.add(emp2);
              data.add(emp3);
              data.add(emp4);
              
              
              tableview.setItems(data);
         }
       
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
     //    empImage.setPrefWidth(80);
                    empImage.setCellValueFactory(new PropertyValueFactory<>("photo"));
        //empImage.setPrefWidth(100);
        //empImage.setCellValueFactory(new PropertyValueFactory<> ("empPhoto"));
                 
   
       
        EmpID.setCellValueFactory(
            new PropertyValueFactory<>("EmpID"));
       
       
        empName.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));
       
        empEmail.setCellValueFactory(
            new PropertyValueFactory<>("email"));
       
       
        department.setCellValueFactory(
            new PropertyValueFactory<>("department"));
       
        salary.setCellValueFactory(
            new PropertyValueFactory<>("salary"));        
        
        colBtn.setCellValueFactory(
                new PropertyValueFactory<>("Update"));        
           
       
     
       // emp1.setempID(111);
       // emp1.setFirstName("SAM");
        //emp1.setEmail("sam@gmail.com");
       // emp1.setDepartment("IT");
        //emp1.setSalary(1000);
       
       // data.add(emp1);
       
        tableview.setItems(data);
        addButtonToTable();
       
       
    }    
   
   
    public void addButtonToTable() {
        TableColumn<Employee, Void> colBtn = new TableColumn("Action");

        Callback<TableColumn<Employee, Void>, TableCell<Employee, Void>> cellFactory = new Callback<TableColumn<Employee, Void>, TableCell<Employee, Void>>() {
            @Override
            public TableCell<Employee, Void> call(final TableColumn<Employee, Void> param) {
               final TableCell<Employee, Void> cell = new TableCell<Employee, Void>() {

                    private final Button btn = new Button("Update");

                    {
                    	
                    	
                        btn.setOnAction((ActionEvent event) -> {
                        	
                        	Alert alert = new Alert(AlertType.CONFIRMATION);
                        	alert.setTitle("Confirmation Dialog");
                        	alert.setHeaderText(" Confirmation Dialog");
                        	alert.setContentText("are you okay with updating quantity from "+qty1+" to "+newqty );

                        	Optional<ButtonType> result = alert.showAndWait();
                        	if (result.get() == ButtonType.OK){
                        		
                        	    // ... user chose OK
                        	} else {
                        	    // ... user chose CANCEL or closed the dialog
                        	}
                        	
                      
                        	/*
                        	for (Employee employee : data) {
                        	if(employee.getEmpID()==115)
                        	{
                        	System.out.println("id:"+employee.getEmpID());	
                        	
                        int value=employee.getEmpID();
                        String val=Integer.toString(value);
                        id.setText(val);
                        
                        	}
                        	
                        	}
                  //          Employee employee = (Employee) getTableRow().getItem();
                   //        System.out.println("selectedData: " + employee.toString());
                       
                          
                   */        
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    } 
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableview.getColumns().add(colBtn);
    }

    @FXML
    void Extract_row_values(ActionEvent event) {
    	ObservableList<Employee> proList;
    	proList=tableview.getSelectionModel().getSelectedItems();
    	System.out.println(proList.get(0).getEmpID());	
    	
    	 value=proList.get(0).getEmpID();
    	 val=Integer.toString(value);
    	 id.setText(val);
    	
    qty1=proList.get(0).getDepartment();
   	 qty.setText(qty1);
   	 
   	 String pname=proList.get(0).getFirstName();
   	 name.setText(pname);
   	 
   	 
    String newqty = qty.getText();
    System.out.println(newqty);	

    	
    	 tableview.getItems().clear();
    	 
    	
    }
    
    @FXML
    void update_table(ActionEvent event) {
    	
    	
    	 newqty = qty.getText();
    
        	ImageView emp1photo = new ImageView(new Image(this.getClass().getResourceAsStream("madhur.jpg")));
        	  emp1photo.setFitHeight(115);
              emp1photo.setFitWidth(100);

        	ImageView emp2photo = new ImageView(new Image(this.getClass().getResourceAsStream("loose.jpg")));
        	  emp2photo.setFitHeight(115);
              emp2photo.setFitWidth(100);

        	ImageView emp3photo = new ImageView(new Image(this.getClass().getResourceAsStream("image1.jpg")));
        	  emp3photo.setFitHeight(115);
              emp3photo.setFitWidth(100);

        	ImageView emp4photo = new ImageView(new Image(this.getClass().getResourceAsStream("r1.jpg")));
        	  emp4photo.setFitHeight(115);
              emp4photo.setFitWidth(100);

        	ImageView emp5photo = new ImageView(new Image(this.getClass().getResourceAsStream("r2.jpg")));
        	  emp5photo.setFitHeight(115);
              emp5photo.setFitWidth(100);

        	ImageView emp6photo = new ImageView(new Image(this.getClass().getResourceAsStream("image1.jpg")));
        	  emp6photo.setFitHeight(115);
              emp6photo.setFitWidth(100);

            if(value==115)
            	
            {
        Employee emp2 = new Employee(emp1photo, 115, "madhur sugar", "good refined sugar  Madhur is the leading sugar brand.",newqty, 280);
        Employee emp3 = new Employee(emp2photo, 116, "Loose Sugar", "Good Sugar", "3kg", 800);
        Employee emp4 = new Employee(emp3photo,117, "Organic Sugar", "Best Organic Sugar Aailable", "5 kg", 800);
       
        data.add(emp2);
        data.add(emp3);
        data.add(emp4);
       
        tableview.setItems(data);
            }
      
       if(value==116) {
       
        	 
            Employee emp2 = new Employee(emp1photo, 115, "madhur sugar", "good refined sugar  Madhur is the leading sugar brand.", "5 kg", 280);
            Employee emp3 = new Employee(emp2photo, 116, "Loose Sugar", "Good Sugar", newqty, 80000);
            Employee emp4 = new Employee(emp3photo,117, "Organic Sugar", "Best Organic Sugar Aailable", "10kg", 80000);
           
            data.add(emp2);
            data.add(emp3);
            data.add(emp4);
           
            tableview.setItems(data);
            }
        if(value==117) {
        	
            Employee emp2 = new Employee(emp1photo, 115, "madhur sugar", "good refined sugar  Madhur is the leading sugar brand.", "5 kg", 280);
            Employee emp3 = new Employee(emp2photo, 116, "Loose Sugar", "Good Sugar", "3 kg", 80000);
            Employee emp4 = new Employee(emp3photo,117, "Organic Sugar", "Best Organic Sugar Aailable", newqty, 80000);
           
            data.add(emp2);
            data.add(emp3);
            data.add(emp4);
           
            tableview.setItems(data);
            }
        
  if(value==118) {
        	
	  Employee emp2 = new Employee(emp4photo, 118, "India Gate rice..the best there is.", "good refined sugar", newqty, 40000);
      Employee emp3 = new Employee(emp5photo, 119, "jeera rice for good tasting rice", "sam@gmail.com", "20 kg", 80000);
      Employee emp4 = new Employee(emp6photo,120, "Organic Sugar", "jhon@gmail.com", "80 kg", 80000);
	 

           
            data.add(emp2);
            data.add(emp3);
            data.add(emp4);
           
            tableview.setItems(data);
            }
    	
  if(value==119) {
  	
	  Employee emp2 = new Employee(emp4photo, 118, "India Gate rice..the best there is.", "good refined sugar", "10 kg", 40000);
      Employee emp3 = new Employee(emp5photo, 119, "jeera rice for good tasting rice", "sam@gmail.com", newqty, 80000);
      Employee emp4 = new Employee(emp6photo,120, "Organic Sugar", "jhon@gmail.com", "80 kg", 80000);
	 

           
            data.add(emp2);
            data.add(emp3);
            data.add(emp4);
           
            tableview.setItems(data);
            }
    	
  if(value==120) {
  	
	  Employee emp2 = new Employee(emp4photo, 118, "India Gate rice..the best there is.", "good refined sugar", "10 kg", 40000);
      Employee emp3 = new Employee(emp5photo, 119, "jeera rice for good tasting rice", "sam@gmail.com", "20 kg", 80000);
      Employee emp4 = new Employee(emp6photo,120, "Organic Sugar", "jhon@gmail.com", newqty, 80000);
	 

           
            data.add(emp2);
            data.add(emp3);
            data.add(emp4);
           
            tableview.setItems(data);
            }
    	

  	
  
    }
    
    

   
   
    public class Employee {
        private ImageView photo;
        private  final SimpleIntegerProperty EmpID;
        private  final SimpleStringProperty firstName;
        private  final SimpleStringProperty email;
        private  final SimpleStringProperty department;
        private  final SimpleIntegerProperty salary;
       
        Employee(ImageView empPhoto, Integer id, String firstname, String mail, String department, Integer salary)
        {
           System.out.println("this is id" + id);
           this.photo = empPhoto;
           System.out.println("image obvject: " + this.photo);
           this.EmpID = new SimpleIntegerProperty(id);
           this.firstName = new SimpleStringProperty(firstname);
           this.email =  new SimpleStringProperty(mail);
           this.department = new SimpleStringProperty(department) ;
           this.salary =  new SimpleIntegerProperty(salary);
       
        }
       

               
        public Button getColBtn() {
			// TODO Auto-generated method stub
			return null;
		}



		public ImageView getPhoto(){
                return photo;
        }
       
       
        public void setPhoto(ImageView photo)
        {
          this.photo =  photo;
       
        }
       
        public int getEmpID() {
            return EmpID.get();
        }

        public void setEmpID(int id) {
            this.EmpID.set(id);
        }
       
       
     
        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String firstname) {
            firstName.set(firstname);
        }
       
       

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String mail) {
            email.set(mail);
        }
       
       
       
       
        public String getDepartment() {
            return department.get();
        }

        public void setDepartment(String street) {
            this.department.set(street);
        }
       
       

        public int getSalary() {
            return salary.get();
        }

        public void setSalary(int salary) {
            this.salary.set(salary);
        }
       
       
    }
       

   
}

