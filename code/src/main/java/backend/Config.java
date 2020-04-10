package backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Properties;
 

//Class adapted from: https://www.opencodez.com/java/read-config-file-in-java.htm
public class Config
{
   Properties configFile;
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
 
   public String getProperty(String key)
   {
	   	String value = this.configFile.getProperty(key);
	   	return value;
   }
   

}