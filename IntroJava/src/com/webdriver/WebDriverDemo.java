package com.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverDemo {

	public static void main(String[] args) {
		
		//newTours();
		screenShot();
	}
	
	
	private static void screenShot() {
		
		 WebDriver dr = new FirefoxDriver();
		 dr.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		 dr.get("http://www.google.com/");
		 dr.manage().window().maximize();
		 dr.findElement(By.name("q")).sendKeys("Selenium");
		 dr.findElement(By.name("q")).sendKeys(Keys.ENTER);
		 File scrshot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrshot, new File("C:\\Users\\PDC2A-Training.PDC2A\\Desktop\\Amitabh\\screenShot.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	private static void newTours() {
		WebDriver wd= new FirefoxDriver();
		WebDriver wd1= new FirefoxDriver();
		wd.navigate().to("http://newtours.demoaut.com/");
		wd.get("http://newtours.demoaut.com/");
		wd.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wd.manage().window().maximize();
		wd.navigate().to("http://google.com");
		wd.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		wd.navigate().back();
		wd.navigate().refresh();
		wd.navigate().forward();
		wd.findElement(By.name("q")).sendKeys("Selenium");
		wd.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
