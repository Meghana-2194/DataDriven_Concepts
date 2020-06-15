package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		
		//Get Test Data from excel : 
	
		//Create an object of Xls_Reader class from utility
		//Append the excel file path 
		
		Xls_Reader reader = new Xls_Reader("C:\\Java Selenium\\DataDrivenFrameork\\DataDrivenConcepts\\src\\com\\testdata\\MercuryTourTestdata.xlsx");

		//Read the data
		String firstName = reader.getCellData("RegTestData", "First Name", 2);
		System.out.println(firstName);
		
		String lastName = reader.getCellData("RegTestData", "Last Name", 2);
		System.out.println(lastName);
		
		String phone = reader.getCellData("RegTestData", "Phone", 2);
		System.out.println(phone);
		
		String email = reader.getCellData("RegTestData", "Email", 2);
		System.out.println(email);
		
		String address = reader.getCellData("RegTestData", "Address", 2);
		System.out.println(address);
		
		String city = reader.getCellData("RegTestData", "City", 2);
		System.out.println(city);
		
		String state = reader.getCellData("RegTestData", "State/Province", 2);
		System.out.println(state);
		
		String code = reader.getCellData("RegTestData", "Postal Code", 2);
		System.out.println(code);
		
		String country = reader.getCellData("RegTestData", "Country", 2);
		System.out.println(country);
		
		String userName = reader.getCellData("RegTestData", "User Name", 2);
		System.out.println(userName);
		
		String password = reader.getCellData("RegTestData", "Password", 2);
		System.out.println(password);
		
		String confirmPassword = reader.getCellData("RegTestData", "Confirm Password", 2);
		System.out.println(confirmPassword);
		
		//WebDriver Code :
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MMeghana\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  // launch browser
		
		driver.get("http://newtours.demoaut.com/"); // enter url
		
		// Click on Register link
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();  
		
		// enter all the fields fetched from excel data sheet
		driver.findElement(By.name("firstName")).sendKeys(firstName);
		driver.findElement(By.name("lastName")).sendKeys(lastName);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(code);
		
		Select select = new Select(driver.findElement(By.name("country")));
		select.selectByValue(country);
		
		driver.findElement(By.className("email")).sendKeys(userName);
		driver.findElement(By.className("password")).sendKeys(password);
		driver.findElement(By.className("confirmPassword")).sendKeys(confirmPassword);
	}

}
