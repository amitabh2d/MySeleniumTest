package it.gvb.selenium.testng;


import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import it.gvb.selenium.constants.SearchCustomerConstant;
import it.gvb.selenium.util.TestUtil;

public class SearchCustomer extends TestUtil {
 
public final static By byQuickSearchButton = By.xpath("//*[@id='quickSearchButton_label']");
public final static By byQuickSearchBox = By.xpath("//*[@id='quickSearchTextBox']");
public final static By byQuickAdvancedSearchButton = By.xpath("//*[@id='quickAdvancedSearchButton_label']");
public final static By byClose = By.xpath("//*[@id='dijit_MenuItem_0_text']");
public final static By byNdg1 = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__ndg1']");
public final static By bycercaButtonPF = By.xpath("//*[contains(@id,'cercaButtonPF')]");
public final static By byDgriddata = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__searchgrid-row-0']/table");
public final static By bySelectCompany = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__radioazienda']");
public final static By bySurname = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__surname']");
public final static By byName = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__name']");
public final static By byCleanPF = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__pulisciButtonPF_label']");
public final static By byCompanyNdg2 = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__ndg2']");
public final static By bycercaButtonCom = By.xpath("//*[contains(@id,'cercaButtonCompany_label')]");
public final static By byCleanCom = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__pulisciButtonCompany_label']");
public final static By byCompanyName = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__companyname']");
public final static By byCompanyVAT = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__vatnumber']");


public final static By byRegionalunit = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__regionalunit']");
public final static By byMenuItem3 = By.xpath("//*[@id='dijit_MenuItem_3_text']");
public final static By byRegionalArea = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__regionalarea']");
public final static By byMenuItem129 = By.xpath("//*[@id='dijit_MenuItem_129_text']");
public final static By byBranch = By.xpath("//*[@id='ns_Z7_119EHA40KGMR00A23R4QJM20G5__branch']");
public final static By byMenuItem49 = By.xpath("//*[@id='dijit_MenuItem_49_text']");

@SuppressWarnings("rawtypes")
public Map companyJsonMap = null;
@SuppressWarnings("rawtypes")
public Map customerJsonMap = null;

	@BeforeClass
	public void loadJSON(){
		
		customerJsonMap=loadResponseFromJSONFile(SearchCustomerConstant.filePathCustomer);
		companyJsonMap=loadResponseFromJSONFile(SearchCustomerConstant.filePathCompany);
	}

	@Test
	public void testSearchCustomer() throws Exception{
	
		try{
		sleep(20000);
		waitForElementPresence(driver, byQuickSearchBox, 20);
		driver.findElement(byQuickSearchBox).sendKeys((String)customerJsonMap.get("ndgCode"));
		waitForElementPresence(driver, byQuickSearchButton, 20);
		WebElement btn = driver.findElement(byQuickSearchButton);
		highlightElement(driver, btn, true);
		btn.click();		
		sleep(4000);
	}
	catch(Exception e){
	throw(e);
	}
	}


   @Test
   public void testAdvanceSearchCustomer() throws Exception{
	   try{   
	    sleep(6000);
	    driver.findElement(byQuickSearchBox).clear();
		waitForElementPresence(driver, byQuickAdvancedSearchButton, 20);
		WebElement btn = driver.findElement(byQuickAdvancedSearchButton);
		highlightElement(driver, btn, true);
		btn.click();
		sleep(4000);
   }
	catch(Exception e){
	throw(e);
	}
	}
	
  @Test(priority=1)
  public void testSelectCompany() throws Exception{
	
	try{
    driver.findElement(bySelectCompany).click();
	sleep(2000);
  }
	catch(Exception e){
	throw(e);
	}
   }
  		
  	
	  @Test(priority=2)		
	  
	  public void testNameSearch() throws Exception{
		
		try{
		testClearPFSearch();
		waitForElementPresence(driver, bySurname, 20);  
		WebElement surnameField = (driver.findElement(bySurname));
		//surnameField.clear();
		surnameField.sendKeys((String)customerJsonMap.get("surname"));
		sleep(2000);
		driver.findElement(byName).sendKeys((String)customerJsonMap.get("name"));
		sleep(1000);
		
		/*WebElement regionalUnit = driver.findElement(byRegionalunit);
		regionalUnit.click();
		WebElement labelContainer = getElement(driver, By.xpath("//*[contains(@id,'regionalunit')]/tbody"));
		List<WebElement> labels = getListOfElements(labelContainer,
	    By.cssSelector("*[class='dijitReset dijitMenuItemLabel']"));
		labels.get(2).click();*/
				 
		// AssertJUnit.assertTrue(labels.size() > 0);// combox values present
		// String classAttivaComboBoxValue = labels.get(1).getText();
		// AssertJUnit.assertEquals(classAttivaComboBoxValue, classAttivaComboBox.getText());
		/*driver.findElement(byMenuItem3).click();
		driver.findElement(byRegionalArea).click();
		driver.findElement(byMenuItem129).click();
		driver.findElement(byBranch).click();
		driver.findElement(byMenuItem49).click();*/
		WebElement cercaBtn = driver.findElement(bycercaButtonPF);
		highlightElement(driver, cercaBtn, true);
		cercaBtn.click();
		sleep(3000);
	  }
		catch(Exception e){
		throw(e);
		}
	} 
	  
	  @Test(priority=3)
	  public void testNDGSearch() throws Exception{
		
		try{
		testClearPFSearch();
		waitForElementPresence(driver, byNdg1, 50);
		WebElement ndgField = (driver.findElement(byNdg1));
		sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(ndgField,(String)customerJsonMap.get("ndgCode")).build().perform();
		sleep(2000);
		WebElement cercaBtn = driver.findElement(bycercaButtonPF);
		highlightElement(driver, cercaBtn, true);
		cercaBtn.click();
		sleep(3000);
	  }
		catch(Exception e){
		throw(e);
		}
	}
	  
	  @Test(priority=5)
	  public void testSearchComapanyNDG() throws Exception{
		try{
		testClearComSearch();
		driver.findElement(byCompanyNdg2).sendKeys((String)companyJsonMap.get("ndgCode"));
		//sleep(1000);
		WebElement cercaBtn = driver.findElement(bycercaButtonCom);
		highlightElement(driver, cercaBtn, true);
		cercaBtn.click();
		sleep(4000);
	  }
		catch(Exception e){
		throw(e);
		}
	}
	  
	  
	  @Test(priority=6)
	  public void testSearchComapanyName() throws Exception{
		try{
		testClearComSearch();
		driver.findElement(byCompanyName).sendKeys((String)companyJsonMap.get("name"));
		//sleep(2000);
		WebElement cercaBtn = driver.findElement(bycercaButtonCom);
		highlightElement(driver, cercaBtn, true);
		cercaBtn.click();
		sleep(4000);
	  }
		catch(Exception e){
		throw(e);
		}
	}
	  
	  
	  @Test(priority=7)
	  public void testSearchComapanyVAT() throws Exception{
		
		try{
		testClearComSearch();
		driver.findElement(byCompanyVAT).sendKeys((String)companyJsonMap.get("vatNumber"));
		//sleep(2000);
		WebElement cercaBtn = driver.findElement(bycercaButtonCom);
		highlightElement(driver, cercaBtn, true);
		cercaBtn.click();
		sleep(4000);
	  }
		catch(Exception e){
		throw(e);
		}
	}
	
	  @Test(priority=8)
	  public void testRecord(){
			
		  try{
			 driver.findElement(byDgriddata); 
		  }catch(NoSuchElementException e){
			  AssertJUnit.assertTrue(false);
		  }
		      AssertJUnit.assertTrue(true);
		}
	  

	  	@AfterSuite
		public void afterAllTests() {
			sleep(60000);
			driver.close();
		}
	  
	  public void testClearPFSearch() throws Exception{
		  try{
		  WebElement clearBtn = driver.findElement(byCleanPF);
		  highlightElement(driver, clearBtn, true);
		  clearBtn.click();
	  }
		catch(Exception e){
		throw(e);
		}
	  }
	  
	  public void testClearComSearch() throws Exception{
		try{  
		  WebElement clearBtn = driver.findElement(byCleanCom);
		  highlightElement(driver, clearBtn, true);
		  clearBtn.click();
	  }
		catch(Exception e){
		throw(e);
		}
	  }
	  
	
}
