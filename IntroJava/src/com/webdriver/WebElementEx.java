package com.webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementEx {

	static Scanner scan;
	public static void main(String[] args) {
	
	// mercury();
	//	mercuryLinks();
	// salesforce();
	//	readExcel();
	//	mercuryLoginExcel();
	//	writeExcel();
	//	cromeDriver();
	//	alertBox();
		findFrame();
	//	fileUpload();
	}
	
	private static void salesforce() {
		 WebDriver dr = new FirefoxDriver();
		 dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
		 dr.get("http://www.salesforce.com/in/");
		 dr.findElement(By.id("free-trial-trigger")).click();

		 dr.findElement(By.id("UserFirstName")).sendKeys("amitabh");
		 dr.findElement(By.id("UserLastName")).sendKeys("jain");
		 dr.findElement(By.className("selectBox-arrow")).click();
		/* WebElement userTitle=dr.findElement(By.id("UserTitle"));
		 Select s = new Select(userTitle);
		 s.selectByIndex(2);*/
		 dr.findElement(By.className("selectBox-selected")).sendKeys("Operations_Manager_AP");
			 
		 
		 dr.findElement(By.id("UserPhone")).sendKeys("9088989890");
		 dr.findElement(By.id("CompanyName")).sendKeys("ATS");
		 WebElement CompanyEmployees=dr.findElement(By.id("CompanyEmployees"));
		 Select s1 = new Select(CompanyEmployees);
		 s1.selectByIndex(1);
		 dr.findElement(By.xpath("//input[@name='SubscriptionAgreement'][1]")).click();
		 
		 
	}
	

	private static void mercury() {
		 
		 System.out.println("Please Enter a City !!");
		 scan=new Scanner(System.in);
		 String city= scan.next();
		 WebDriver dr = new FirefoxDriver();
		 dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
		 dr.get("http://newtours.demoaut.com/");
		 dr.findElement(By.name("userName")).sendKeys("amitabh1");
		 dr.findElement(By.name("password")).sendKeys("amitabh1");
		 dr.findElement(By.name("login")).click();
		 dr.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		 
		// WebElement wb =dr.findElement(By.id("round_trip_button1"));
		// String s=wb.getAttribute("class");
		 
		/* if(s.contains("active"))
			 System.out.println("Test passed !!");*/
		/* WebElement wb = dr.findElement(By.xpath("//input[2]"));
		 if(wb.isSelected()){
			 System.out.println("Test passed !!");
		 }
		 else
			 System.out.println("Test Failed !!");
		 */
		 dr.findElement(By.xpath("//input[@name='tripType'][1]")).click();
		 WebElement passCount=dr.findElement(By.name("passCount"));
		 Select s = new Select(passCount);
		 s.selectByIndex(2);
		 
		 WebElement fromPort=dr.findElement(By.name("fromPort"));
		 Select s1 = new Select(fromPort);
		List<WebElement> list= s1.getOptions();
		for(WebElement we:list)
		{
			//System.out.println("City for From Port is : "+we.getText());
			if(city.equals(we.getText())){
				System.out.println("Entered City is Present in the List");
			}
			
		}
	}
	
	
	private static void mercuryLinks() {
		
		WebDriver dr = new FirefoxDriver();
		 dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
		 dr.get("http://newtours.demoaut.com/");
		List<WebElement> listLinks= dr.findElements(By.tagName("a"));
		
		for(WebElement e : listLinks){

			System.out.println("Title For link is :"+e.getText());
			dr.findElement(By.linkText(e.getText())).click();
		}
	}
	
	
	private static void readExcel(){
		
		String FilePath = "C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\SampleData.xls";
		FileInputStream fs;
		try {
			
			WebDriver dr = new FirefoxDriver();
			 dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			 dr.get("http://www.google.com/");
			 dr.manage().window().maximize();
			
			fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(0);
			
			for(int r=0;r<sh.getRows();r++){
				
				for(int c=0;c<sh.getColumns();c++){
					
					String CellGetContent = sh.getCell(c,r).getContents();
					System.out.println(CellGetContent);
					dr.findElement(By.name("q")).sendKeys(CellGetContent);
					dr.findElement(By.name("q")).sendKeys(Keys.ENTER);
					File scrshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
					 try {
						FileUtils.copyFile(scrshot, new File("C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\screenShot1.jpg"));
					} catch (IOException e) {
						e.printStackTrace();
					}
					dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
					dr.navigate().back();
					dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
				}
				
			}
							
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void mercuryLoginExcel(){
		
		String FilePath = "C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\LoginData.xls";
		FileInputStream fs;
		try {
			
			 WebDriver dr = new FirefoxDriver();
			 dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			 dr.get("http://newtours.demoaut.com/");
			 dr.manage().window().maximize();
			
			fs = new FileInputStream(FilePath);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(0);
			
			for(int r=0;r<sh.getRows();r++){
				
				for(int c=0;c<sh.getColumns();c++){
					
					String CellGetContent = sh.getCell(c,r).getContents();
					 System.out.println(CellGetContent);
					 if(c==0)
					 dr.findElement(By.name("userName")).sendKeys(CellGetContent);
					 if(c==1)
					 dr.findElement(By.name("password")).sendKeys(CellGetContent);
					 					 
				}
				dr.findElement(By.name("login")).click();
				dr.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
				WebElement home = dr.findElement(By.xpath("/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a"));
				home.click(); 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void writeExcel(){
				
		WritableWorkbook workbook;
		try {
			 WebDriver dr = new FirefoxDriver();
			 dr.manage().timeouts().pageLoadTimeout(45,TimeUnit.SECONDS);
			 dr.get("http://newtours.demoaut.com/");
			 dr.findElement(By.name("userName")).sendKeys("amitabh1");
			 dr.findElement(By.name("password")).sendKeys("amitabh1");
			 dr.findElement(By.name("login")).click();
			 dr.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			workbook = Workbook.createWorkbook(new File("C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\SampleCities.xls"));
			WritableSheet wSheet=workbook.createSheet("city_names", 0);
			
			WritableFont cellFont = new WritableFont(WritableFont.TIMES,14);
			cellFont.setBoldStyle(WritableFont.BOLD); 
			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setWrap(true);
			Label label= new Label(0, 0, "Cities",cellFormat);
			
			wSheet.addCell(label);   
			WebElement fromPort=dr.findElement(By.name("fromPort"));
			Select s1 = new Select(fromPort);
			List<WebElement> list= s1.getOptions();
			int i=1;
			for(WebElement we:list)
			{	
				Label label1= new Label(0,i, we.getText());
				wSheet.addCell(label1);   
				i++;
			}
			workbook.write();
			workbook.close();
			
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RowsExceededException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	
	private static void cromeDriver(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		 dr.get("http://www.google.com/");
		 dr.manage().window().maximize();
	}
	
	private static void alertBox(){
	
		try {
		WebDriver dr = new FirefoxDriver();
		dr.get("C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\alertBoxEx.html");
		dr.manage().window().maximize();
		Thread.sleep(4000);
		dr.findElement(By.xpath("//button[@onclick='alertFunction()']")).click();
		Alert alert= dr.switchTo().alert();
		System.out.println("Alert is :"+alert.getText());
		//alert.dismiss();
		alert.accept();
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
	}
	
	private static void findFrame(){
		
		WebDriver dr = new FirefoxDriver();
		dr.get("http://jqueryui.com/dialog");
		dr.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		List<WebElement> listFrame= dr.findElements(By.tagName("iframe"));
		int i=0;
		for(WebElement we :listFrame)
		{
			System.out.println("Frame Name is : "+ we.getText());
			dr.switchTo().frame(i);
			i++;
			dr.switchTo().defaultContent();
		}
		dr.close();
		dr.quit();
		
	}
	
	private static void fileUpload(){
		
		WebDriver dr = new FirefoxDriver();
		dr.get("http://wikisend.com/");
		dr.manage().window().maximize();
		WebElement element= dr.findElement(By.id("uploadfield"));
		element.sendKeys("C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\SampleData.xls");
		dr.findElement(By.id("upload_but")).click();
		
	}
	
	private static void clickEvent(){
		
		WebDriver dr = new FirefoxDriver();
		dr.get("http://wikisend.com/");
		dr.manage().window().maximize();
	}
	
}
