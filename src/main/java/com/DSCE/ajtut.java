package com.DSCE;


import java.awt.BorderLayout;
import java.awt.Component;
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



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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


public class ajtut extends JFrame implements ActionListener
{
	
	
String userName;
String password;
String result;
    JFrame f,f1;
    JPanel panel,p;
    JLabel user_label, password_label, message;
    JLabel user_label1, password_label1,name1_label;
    JTextField userName_text,name1;
    JTextField userName_text1;
    JPasswordField password_text;
    JPasswordField password_text1;
    JButton signin,signup,submit, cancel,signup1,signin1;

    ajtut() {
    	
    
    	/*
    	 f= new JFrame("login");
    	 signup = new JButton("SIGN UP");
    	 signin = new JButton("SIGN IN");
    	 panel.add(signup);
    	 panel.add(signin);
    	 
    	 panel = new JPanel(new GridLayout(3, 1));
    	*/
  
    /*    // User Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");
        signup = new JButton("SIGN up");
        

        panel = new JPanel(new GridLayout(6, 8));

        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        panel.add(signup);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        signup.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(300, 100);
        setVisible(true);
*/
    	
    	
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
   	 signin = new JButton("SIGN IN");
   	 
   	panel = new JPanel(new GridLayout(6, 8));

    	panel.add(signup);
    	panel.add(signin);
    	//panel.add(ii);
 //   	panel.add(label)
;    	f1.add(panel);
    	
    	
    	signin.addActionListener(this);
    	 
        signup.addActionListener(this);
       
       
        
    	
    	
    	
    	
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
    	
       new ajtut();
    }

    public void actionPerformed(ActionEvent ae) {
    	
    	if(ae.getSource()==signup) {
    		
    		
    	    
    		f= new JFrame("signup");
    		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        // Set frame attributes
    	        f.setVisible(true);
    	        f.setSize(400, 300);
    	        f.setResizable(false);
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
            
          
    		
    		String userName = userName_text1.getText();
            String password = password_text1.getText();
            
            
    	
    	}
    	
    	if((ae.getSource()==signup1))
    	{ 
    		userName = userName_text1.getText();
            password = password_text1.getText();
           
    		System.out.println(userName);
    		try {
				signup(userName,password);
			} catch (FirebaseAuthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    	
    	
    	if((ae.getSource()==signin) )
    	{
    		
    		  
    		f1= new JFrame("signup");
    		 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        // Set frame attributes
    	        f1.setVisible(true);
    	        f1.setSize(800, 600);
    	        f1.setResizable(false);
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
        
        
        
    	}
       
        
    	
    	
    	
    	
    	
   

    }
    
    
	private void signup(String userName2, String password2) throws FirebaseAuthException {
		 
		    	CreateRequest request = new CreateRequest()
					    .setEmail(userName2)
					    .setEmailVerified(true)
					    .setPassword(password2)
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
	   
	   
	 
	
	 System.out.println("Successfully fetched user data: " + userRecord.getEmail());
	// UserRecord userRecord = FirebaseAuth.getInstance().getUserByPassword(password);
	// System.out.println("Successfully fetched user data: " + userRecord.getPassword());
//	 System.out.println("name"+ uname);
	String us=userRecord.getEmail();
	 
    
    }
    
  
    
  
    


}