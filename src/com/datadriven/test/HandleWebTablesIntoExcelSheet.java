package com.datadriven.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class HandleWebTablesIntoExcelSheet {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MMeghana\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		// tr = row , td = column
		// Capture 1 st column values (Company Name)
		// xpath of all row and 1st column
		// *[@id="customers"]/tbody/tr[2]/td[1]
		// *[@id="customers"]/tbody/tr[3]/td[1]
		// *[@id="customers"]/tbody/tr[4]/td[1]
		// *[@id="customers"]/tbody/tr[5]/td[1]
		// tr are changing and td are same

		// Company
		String before_Xpath_company = "//*[@id='customers']/tbody/tr[";
		String after_Xpath_company = "]/td[1]";

		// for Contact name
		String before_Xpath_Contact = "//*[@id='customers']/tbody/tr[";
		String after_Xpath_Contact = "]/td[2]";

		// Country
		String before_Xpath_country = "//*[@id='customers']/tbody/tr[";
		String after_Xpath_country = "]/td[3]";

		List<WebElement> numberOfRows = driver.findElements(By.xpath("//*[@id = 'customers']//tr"));
		System.out.println("Total number of rows is : " + numberOfRows.size());

		// Print those Webtables values into Excel sheet
		Xls_Reader reader = new Xls_Reader(
				"C:\\Java Selenium\\DataDrivenFrameork\\DataDrivenConcepts\\src\\com\\testdata\\MercuryTourTestdata.xlsx");
		
		reader.addSheet("TableData1");
		reader.addColumn("TableData1", "CompanyName");
		reader.addColumn("TableData1", "ContactName");
		reader.addColumn("TableData1", "CountryName");
		
		// start loop from 2
		for (int i = 2; i <= numberOfRows.size(); i++) {

			System.out.println("******************************");
			// Company name
			String actualXpath_company = before_Xpath_company + i + after_Xpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println("The Company name is " + companyName);
			
			reader.setCellData("TableData1", "CompanyName", i, companyName); // column name u can give any name 

			// Contact Name
			String actualXpath_contact = before_Xpath_Contact + i + after_Xpath_Contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println("The Contact name is " + contactName);
		
			reader.setCellData("TableData1", "ContactName", i, contactName); 

			// Country Name
			String actualXpath_country = before_Xpath_country + i + after_Xpath_country;
			String countryName = driver.findElement(By.xpath(actualXpath_country)).getText();
			System.out.println("The Country name is " + countryName);
			
			reader.setCellData("TableData1", "CountryName", i, countryName); 
		}

		driver.quit();
	}
}
