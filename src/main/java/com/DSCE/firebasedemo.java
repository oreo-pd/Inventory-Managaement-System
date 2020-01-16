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

public class firebasedemo {
	  
    public static void main(String args[]) throws IOException, InterruptedException
{
   
           BasicConfigurator.configure();
    	    	FileInputStream serviceAccount=
    			new FileInputStream("C:\\Users\\HP\\Downloads\\servkey.json");
    	FirebaseOptions options = new FirebaseOptions.Builder()
    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    			  .setDatabaseUrl("https://dbmsproj-54534.firebaseio.com")
    			  .build();

    FirebaseApp.initializeApp(options);
    String qa="Product details";
    		  	
     
        	
    	try {
            final CountDownLatch latch1 = new CountDownLatch(1);
            DatabaseReference ref1= FirebaseDatabase.getInstance().getReference();
            DatabaseReference ref2;    
            System.out.println("stupid internet");
             ref2 = ref1.child("Months/October");


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
       				  String name=Userlist.get(0).toString();
       				  String desc=Userlist.get(1).toString();
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
   			
                             }}  
			      