package com.autodesk.tripadvisor.basicutils;


	
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



	/**
	 * 
	 * @author VIJAY
	 *
	 */
	
	public class FileUtils {		
		
	/*****
	 * 
	 * @param path
	 * @param key
	 * @return
	 * @throws IOException
	 */

		public String getDataFromProperties(String key) 
		{
			FileInputStream f=null;
			try {
				f = new FileInputStream("./src/main/resources/properties/commondata.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties p= new Properties();
			try {
				p.load(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			return p.getProperty(key);
			
		}
		
		
		
		
		
	}

	
	
	
	