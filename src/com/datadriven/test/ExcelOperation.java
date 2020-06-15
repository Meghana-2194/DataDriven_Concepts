package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperation {

	public static void main(String[] args) {
		// get test data from excel file 
	Xls_Reader reader = new Xls_Reader("C:\\Java Selenium\\DataDrivenFrameork\\DataDrivenConcepts\\src\\com\\testdata\\MercuryTourTestdata.xlsx");
				
	// Different methods:
	//add sheet 
		
	reader.addSheet("HomePage");
	
	// does sheet exist or not 
	if (!reader.isSheetExist("HomePage")){
		reader.addSheet("Success");
	}
	
	// Row count
	int rowCount = reader.getRowCount("RegTestData");
	System.out.println(rowCount);
	
	// Column count 
	int colCount = reader.getColumnCount("RegTestData");
	System.out.println(colCount);
	

	}

}
