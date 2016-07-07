package it.gvb.selenium.testng;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import it.gvb.selenium.constants.CommonConstant;
import it.gvb.selenium.constants.FilaleLoginConstant;
import it.gvb.selenium.util.TestUtil;

public class FilaleLoginPage extends TestUtil {
	

	public FilaleLoginPage() {
		super();
	}
	
	
	/**
	 * Method to load driver, properties file and URL before executing any other
	 * test case.
	 */
	@BeforeSuite
	public void beforeTest() throws Exception {
		try {
		String driverName =CommonConstant.chromeDriver;
		loadDriver(driverName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(CommonConstant.filaleUrl);
		
		// For Chrome Pop-Up control
		if(driverName.equals(CommonConstant.chromeDriver)){
		Robot robotObject = null;
		robotObject = new Robot();
		robotObject.keyPress(KeyEvent.VK_TAB);
		robotObject.keyPress(KeyEvent.VK_TAB);
		robotObject.keyPress(KeyEvent.VK_TAB);
		robotObject.keyPress(KeyEvent.VK_TAB);
		robotObject.keyPress(KeyEvent.VK_ENTER);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
		catch(Exception e){
		throw(e);
		}
	}
	
	/**
	 * @throws Exception
	 */
	@Test
	public void testLogin() throws Exception{
	try {
	 loadResponseFromJSONFile(FilaleLoginConstant.jsonfilePath);	
	// Enter UserName
	 driver.findElement(By.xpath("/html/body/form/font/table/tbody/tr[1]/td[2]/input")).sendKeys((String)JsonInput.get("user"));
	// Enter Password
	 driver.findElement(By.xpath("/html/body/form/font/table/tbody/tr[2]/td[2]/input")).sendKeys((String)JsonInput.get("password"));
	 WebElement btn = driver.findElement(By.xpath("/html/body/form/input[2]"));
	 highlightElement(driver, btn, true);
	 btn.click();	
	}
	catch(Exception e){
	throw(e);
	}
  }
  
}
