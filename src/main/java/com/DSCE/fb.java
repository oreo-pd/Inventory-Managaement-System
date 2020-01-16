package com.DSCE;






import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.BasicConfigurator;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Query;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;  
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class fb {
	  
    public static void main(String args[]) throws IOException
{
   
           BasicConfigurator.configure();
    	    	FileInputStream serviceAccount=
    			new FileInputStream("C:\\Users\\HP\\Downloads\\CSEFacHelper-master\\src\\main\\java\\serviceAccountKey.json");
    	FirebaseOptions options = new FirebaseOptions.Builder()
    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    			  .setDatabaseUrl("https://demoproj-fad72.firebaseio.com")
    			  .build();

    FirebaseApp.initializeApp(options);
    ArrayList<ArrayList<String>> big = new ArrayList<ArrayList<String>>();
    ArrayList<String> smol = new ArrayList<String>();
 
    import java.awt.BorderLayout;
    import java.awt.GridLayout;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.WindowAdapter;
    import java.awt.event.WindowEvent;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JPasswordField;
    import javax.swing.JTextField;


    public class LoginDemo extends JFrame implements ActionListener {

        JPanel panel;
        JLabel user_label, password_label, message;
        JTextField userName_text;
        JPasswordField password_text;
        JButton submit, cancel;

        LoginDemo() {
            
            // User Label
            user_label = new JLabel();
            user_label.setText("User Name :");
            userName_text = new JTextField();
            
            // Password

            password_label = new JLabel();
            password_label.setText("Password :");
            password_text = new JPasswordField();

            // Submit

            submit = new JButton("SUBMIT");

            panel = new JPanel(new GridLayout(3, 1));

            panel.add(user_label);
            panel.add(userName_text);
            panel.add(password_label);
            panel.add(password_text);

            message = new JLabel();
            panel.add(message);
            panel.add(submit);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Adding the listeners to components..
            submit.addActionListener(this);
            add(panel, BorderLayout.CENTER);
            setTitle("Please Login Here !");
            setSize(300, 100);
            setVisible(true);

        }

        public static void main(String[] args) {
        	
        	
        }
            new LoginDemo();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String userName = userName_text.getText();
            String password = password_text.getText();
            if (userName.trim().equals("admin") && password.trim().equals("admin")) {
                message.setText(" Hello " + userName
                        + "");
            } else {
                message.setText(" Invalid user.. ");
            }

        }

    }