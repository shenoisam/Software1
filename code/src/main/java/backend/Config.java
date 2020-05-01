package backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Properties;
 

/**
 * generates a config object for database access 
 * 
 * 
 * @author samshenoi
 *
 */
public class Config
{
   Properties configFile;
   
   /**
    * constructor for the Config object
    * 
    */
   public Config()
   {
	 configFile = new java.util.Properties();
	 try {
	   configFile.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));

	 }catch(Exception eta){
		
			System.out.println("Error: You do not have a configuration file created.");
		    System.out.println("This config file is needed in order to configure the database connection.");
		    System.out.println("Please create a file called config.properties in the src/main/resources folder with the following stuff");
			
		    System.out.println("====================================");
		    System.out.println("#This is a configuration file for the CShare database.");
		    System.out.println("db=CShare");
		    System.out.println("user=root");
		    System.out.println("password=<your mysql password>");
		    System.out.println("host=localhost");
		    System.out.println("port=3306");
		    System.out.println("====================================");
			
		    eta.printStackTrace();
		
	 }
   }
 
   /**
    * gets the property from the config file
    * 
    * @param key the key for the property
    * @return the value of the property
    */
   public String getProperty(String key)
   {
	   	String value = this.configFile.getProperty(key);
	   	return value;
   }
   

}