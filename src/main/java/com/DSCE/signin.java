package com.DSCE;




import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

import javafx.scene.control.Alert;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.log4j.BasicConfigurator;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Query;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.NonNull;
import com.sun.javafx.tk.Toolkit.Task;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import jxl.read.biff.File;


public class signin extends JFrame implements ActionListener
{
	
	
String userName;
String password;
String result;
    JFrame f,f1;
    JPanel panel,p;
    JLabel user_label, password_label, message,l,l1;
    JLabel user_label1, password_label1,name1_label;
    JTextField userName_text,name1;
    JTextField userName_text1;
    JPasswordField password_text;
    JPasswordField password_text1;
    JButton signinn,signup,submit, cancel,signup1,signin1, login;

    signin() {
    	
         
    	 panel = new JPanel(new GridLayout(3, 1));
    	
    	f1= new JFrame("login");
		 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        // Set frame attributes
	        f1.setVisible(true);
	       
	        f1.setResizable(true);
	        // Set Layout
	        f1.setLayout(new BorderLayout());
	        
	        l = new JLabel("DAYANANDA SAGAR COLLEGE OF ENGINEERING",  JLabel.CENTER);
	        l.setFont (l.getFont ().deriveFont (40.0f));
	        //l.setAlignmentX(0);
	        // l.setAlignmentY(0);
	        System.out.println("\n\n");
	       
	        panel.add(l);
	    //    panel.add(l1);
	        JLabel label= new JLabel("", JLabel.CENTER);
	    	label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\im.jpeg"));
	    //	label.setLocation(400,400);
	        
	        	    	panel.add(label);
	        	    	 Dimension size = label.getPreferredSize();
	        	         label.setBounds(100, 100, size.width, size.height);
	    	f1.setLocationRelativeTo(null);
	    	f1.pack();
	       
    		        
	        login = new JButton("LOGIN");
	       // login.setPreferredSize(new Dimension(40, 40));
	      //  login.setBounds(10,40,20,20);
	        GridBagConstraints gbc= new GridBagConstraints();
	        gbc.gridwidth=GridBagConstraints.REMAINDER;
	        panel.add(login, gbc);
	        f1.add(panel);
	        f1.setSize(400, 300);
	        
	        login.addActionListener(this);
    	
    	
    	
    }

    public static void main(String[] args) throws IOException {
    	

		 BasicConfigurator.configure();
		     	FileInputStream serviceAccount=
		  new FileInputStream("C:\\Users\\HP\\Downloads\\servkey.json");
		  FirebaseOptions options = new FirebaseOptions.Builder()
				  
		  
		   .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		   .setDatabaseUrl("https://dbmsproj-54534.firebaseio.com")
		   .build();

		  FirebaseApp.initializeApp(options);
    	
       new signin();
    }

    public void actionPerformed(ActionEvent ae) 
    {
    	
    	if((ae.getSource()==signinn) )
    	{
    		
    		  
    		f1= new JFrame("signin");
    		 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        // Set frame attributes
    	        f1.setVisible(true);
    	        f1.setSize(400, 300);
    	        f1.setResizable(true);
    	        // Set Layout
    	        f1.setLayout(new BorderLayout());
    	        // Add Components
    	  //      f.add(drawMenuBar(), BorderLayout.NORTH);
    		
    		
    		// User Label
            user_label = new JLabel();
            user_label.setText("User Name :");
            userName_text = new JTextField();
            
            // Password

            password_label = new JLabel();
            password_label.setText("Password :");
            password_text = new JPasswordField();
    		
            signin1 = new JButton("SIGN IN");
            
            panel = new JPanel(new GridLayout(6, 8));
            f1.add(panel);
            panel.add(user_label);
            panel.add(userName_text);
         
            panel.add(password_label);
            panel.add(password_text);
        //    p.add(name1);
            panel.add(signin1);
            signin1.addActionListener(this);
    	
        String userName = userName_text.getText();
        String password = password_text.getText();
    	}
    	
    	
    	if(ae.getSource()==signin1)
    	{
    		 userName = userName_text.getText();
          password = password_text.getText();
        try {
			loginUser(userName,password);
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	}
    	
    	
if(ae.getSource()==signup) {
    		
    		
    	    
    		f= new JFrame("signup");
    		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        // Set frame attributes
    	        f.setVisible(true);
    	        f.setSize(800, 600);
    	        f.setResizable(true);
    	        // Set Layout
    	        f.setLayout(new BorderLayout());
    	        // Add Components
    	  //      f.add(drawMenuBar(), BorderLayout.NORTH);
    		
    		
    		// User Label
            user_label1 = new JLabel();
            user_label1.setText("User Name :");
            userName_text1 = new JTextField();
            
            // Password

            password_label1 = new JLabel();
            password_label1.setText("Password :");
            password_text1 = new JPasswordField();
         // User Label
            name1_label = new JLabel();
            name1_label.setText(" Name :");
            name1 = new JTextField();
            

            // Submit

            
            signup1 = new JButton("SIGN up");
            
            p = new JPanel(new GridLayout(6, 8));
            f.add(p);
            p.add(user_label1);
            p.add(userName_text1);
         
            p.add(password_label1);
            p.add(password_text1);
            p.add(name1);
            p.add(signup1);
            
            signup1.addActionListener(this);
       	 
    		
    	 userName = userName_text1.getText();
           password = password_text1.getText();
       	System.out.println(userName);
            
    	
    	}
if((ae.getSource()==signup1))
{ 
	//userName = userName_text1.getText();
  //  password = password_text1.getText();
   
	System.out.println(userName);
	try {
		signup();
		
		
	} catch (FirebaseAuthException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

    	if(ae.getSource()==login)
    	{
    		
    		f1= new JFrame("signup");
   		 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	        // Set frame attributes
   	        f1.setVisible(true);
   	        f1.setSize(400, 300);
   	        f1.setResizable(false);
   	        // Set Layout
   	        f1.setLayout(new BorderLayout());
       	//ImageIcon ii= new ImageIcon("C:\\Users\\Darshan\\Downloads\\images (1).jpeg");
     //  	BufferedImage image=ImageIO.read(new File("C:\\Users\\Darshan\\Downloads\\images(1).jpeg");
       //	JLabel label=new Label(new ImageIcon(image));
       	
       	signup = new JButton("SIGN UP");
      	 signinn = new JButton("SIGN IN");
      	 
      	panel = new JPanel(new GridLayout(6, 8));

       	panel.add(signup);
       	panel.add(signinn);
       	//panel.add(ii);
    //   	panel.add(label)
   ;    	f1.add(panel);
       	
       	
       	signinn.addActionListener(this);
       	 
           signup.addActionListener(this);
    	}
    	
    	
        
    }
        
        
    	
       
        
    	
    	
    	
    	
    	
   

    
    
    
	private void signup() throws FirebaseAuthException {
		
		 userName = userName_text1.getText();
         password = password_text1.getText();
         System.out.println(userName);
		 
		    	CreateRequest request = new CreateRequest()
					    .setEmail(userName)
					    .setEmailVerified(true)
					    .setPassword(password)
					    .setDisabled(false);
		    	
		    	
		    	UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
		    	System.out.println("Successfully created new user: " + userRecord.getUid());
		    	 
		    	final CountDownLatch latch1 = new CountDownLatch(1);
		    //	 String tchr_name=userName2.getText();
		    //	 String sec= password2.getText();
		    	// String sem=c.getSelectionModel().getSelectedItem().toString();

		    	DatabaseReference ref1 = FirebaseDatabase.getInstance().getReference("user/"+userRecord.getUid());
		    	 DatabaseReference child_name = FirebaseDatabase.getInstance().getReference();
				 	 child_name=ref1.child("email");
				 	child_name.setValueAsync(userRecord.getEmail());
				 	 DatabaseReference child_descp = FirebaseDatabase.getInstance().getReference();
			    	 child_descp=ref1.child("password");
			    	 child_descp.setValueAsync(password);
			    	 DatabaseReference child_answer = FirebaseDatabase.getInstance().getReference();
			    	 child_answer=ref1.child(" name");
			    	 child_answer.setValueAsync(name1);
			    	
			    	 JDialog d = new JDialog(f, "dialog Box"); 
			   	  
			         // create a label 
			         JLabel l = new JLabel("user logged in"); 

			         d.add(l); 

			         // setsize of dialog 
			         d.setSize(300, 250); 

			         // set visibility of dialog 
			         d.setVisible(true); 
			    	 

					try {
						UserRecord userRecord1 = FirebaseAuth.getInstance().createUser(request);
						System.out.println("Created....");
					} catch (FirebaseAuthException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    }
		
	

	void loginUser(String email, String password) throws FirebaseAuthException, InterruptedException, IOException
    {
    	 userName= userName_text.getText();
    	 password=password_text.getText();
    	 
    	 
    	 
    	 
    	  
	 UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);
	   
	 JDialog d = new JDialog(f, "dialog Box"); 
	  
     // create a label 
     JLabel l = new JLabel("user logged in"); 

     d.add(l); 

     // setsize of dialog 
     d.setSize(300, 250); 

     // set visibility of dialog 
     d.setVisible(true); 
	 
		 System.out.println("Successfully fetched user data: " + userRecord.getEmail());
	
		 String us=userRecord.getEmail();
	
	
    
    }
    
  
    
  
    


}