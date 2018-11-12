package lab6.lab6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class Configuration {

	 private  String url, username, password;
	
	 
	//Getters and Setters
	//
	//Setters 
	 public void setUrl(String x){
		url = x;
	}
	
	public void  setUsername(String x){
		username = x;
	}
		
	public void setPassword(String x){
		password = x;
	}
	
	
	//Getters
	//
	public String getUrl(){
		return url;
	}
	
	public String getUsername(){
		return username;
	}
		
	public String getPassword(){
		return password;
	}
		
}
	

