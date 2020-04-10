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
		  //try {
			  System.out.println("Error: You do not have a configuration file created.");
				 System.out.println("This config file is needed in order to configure the database connection.");
				 System.out.println("A file has been created for you. Please fill it out in the src/main/resources folder");
				
			
			 /* This is somehow working but I cant find the file...
			File f = new File(getClass().getClassLoader().getResource("person-icon.jpg").getFile());
			final File myfile = new File(f.getParentFile(), "config.properties");
			myfile.createNewFile();
			FileWriter myWriter = new FileWriter(myfile);
            myWriter.write("#This is a configuration file for the CShare database.\n");
            myWriter.write("db=CShare\n");
            myWriter.write("user=root\n");
            myWriter.write("password=<your mysql password>\n");
            myWriter.write("host=localhost\n");
            myWriter.write("port=3306\n");
            myWriter.close();
            */
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		 eta.printStackTrace();
	 }
   }
 
   public String getProperty(String key)
   {
	   	String value = this.configFile.getProperty(key);
	   	return value;
   }
   

}