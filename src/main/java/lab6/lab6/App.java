package lab6.lab6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

public class App 
{
	//main method
    public static void main(String args[]) throws SQLException{
    	
    	//variable to store id of the person, user wants to update or delete or get
    	int id;
    	
    	//Scanner for taking input
    	Scanner scan = new Scanner(System.in);
    	
    	//Configuration Object
    	Configuration config = new Configuration();
    	
    	//load the properties and fill configuration object
    	loadProperties(args, config);
    
    	
    	//debugging - properties load successful
		//System.out.println(config.getUrl() + " " + config.getUsername()+ " " + config.getPassword());

		
		//instance of handler class
    	Handler dbHandler = new Handler(config);
    	Person person = new Person();

    	
    	System.out.println("Enter your option (1/2/3/4):\n"
    			+ "1) Save\n"
    			+ "2) Update\n"
    			+ "3) Delete\n"
    			+ "4) Get information");
    	int choice = scan.nextInt(); scan.nextLine();
    	while(true){
	    	if(choice == 1){
	    		
	    		
	    		System.out.println("Please enter name:-");
	    		person.setName(scan.nextLine());
	    		//scan.nextLine();
	    		System.out.println("Please enter father name:-");
	    		person.setFatherName(scan.nextLine()); 
	    		//scan.nextLine();
	    		System.out.println("Please enter organization:-");
	    		person.setOrganization(scan.nextLine());
	    		//scan.nextLine();
	    		System.out.println("Please enter mobile number:-");
	    		person.setMobile(scan.nextLine());
	    		//scan.nextLine();
	    		dbHandler.save(person);
	    		break;
	    		
	    	} else if(choice == 2){
	    		System.out.println("Please enter the id of the person you want updated: ");
	    		id = scan.nextInt();
	    		dbHandler.update(id);
	    		break;
	    		
	    	} else if(choice == 3){
	    		
	    		System.out.println("Please enter the id of the record you want to delete:");
	    		id = scan.nextInt();
	    		dbHandler.delete(id);
	    		break;
	    		
	    	} else if(choice == 4){
	    		
	    		System.out.println("Please enter the id of the record you want to get:");
	    		id = scan.nextInt();
	    		dbHandler.get(id);
	    		break;
	    		
	    	} else {
	    		
	    		System.out.println("Please enter valid option (1/2/3/4)");
	    		choice = scan.nextInt();
	    	
	    	}
	  	}
    	
    }
    	
		    
	//private static method to load the properties from file and fill the configuration object
    private static void loadProperties(String args[], Configuration config){
	    	
	    	//Properties class object
			Properties prop = new Properties();
			
			//Creating input stream instance
			InputStream input = null;
	
				try {	//begin try block
	
				//opening file for reading
				input = new FileInputStream(args[0]);	
			
				// load a properties file
				prop.load(input);
			
				
				//get properties and initialize to variables
				config.setUrl(prop.getProperty("url"));		
				config.setUsername( prop.getProperty("username"));
				config.setPassword(prop.getProperty("password"));
				
				} catch (IOException ex) { ex.printStackTrace(); } 
					finally {
						if (input != null) {
							try {
								input.close();
							} catch (IOException e) { e.printStackTrace(); }
						}
					}
				
	    }
	    
    
} //end of class DBMain
