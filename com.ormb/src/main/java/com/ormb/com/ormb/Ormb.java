package com.ormb.com.ormb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ormb 
{
	 public static Properties properties;
	 private static final String propertyFilePath= "resources//config.properties";
	 public static WebDriver driver;
	 public static WebElement element;
	 //Webelements
	 public static String emailLink = "//a[text()='Gmail']";
	 static String signIn = "(//a[contains(text(),'Sign in')])[2]";	
	 String id = "//input[@id='identifierId']";	
	    
	 	@FindBy(xpath="//span[contains(text(),'Next')]")
	    WebElement nextB;    
	 	
	 
	
	 public static void ConfigFileReader(){
		 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
		 }
	 public static String getApplicationUrl() {
		 String url = properties.getProperty("ORMB");
		 if(url != null) 
			 return url;
		 else 
			 throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
	 public static void OpenBrowser()
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\Project\\com.ormb\\resources\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 //PageFactory.initElements(driver,driver);
		 driver.get(Ormb.getApplicationUrl());
	 }
	 public static void clickGmail()
	 {
		 element = driver.findElement(By.xpath(emailLink));
		 element.click();
		 element = driver.findElement(By.xpath(signIn));
		 element.click();
		 
		 
	 }
    public static void main( String[] args )    {
        Ormb a = new Ormb();
        Ormb.ConfigFileReader();
        Ormb.OpenBrowser();
        Ormb.clickGmail();
        System.out.println(Ormb.getApplicationUrl());
    }
}

