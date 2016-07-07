package it.gvb.selenium.testng;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import it.gvb.selenium.util.TestUtil;

public class NavigateHomePage extends TestUtil {
	

	
	@SuppressWarnings("rawtypes")
	public Map companyJsonMap = null;
	@SuppressWarnings("rawtypes")
	public Map customerJsonMap = null;
	
	public NavigateHomePage() {
		super();
	}
	
	
	@BeforeClass
	public void loadJSON(){
		
		sleep(20000);
		/*customerJsonMap=loadResponseFromJSONFile(SearchCustomerConstant.filePathCustomer);
		companyJsonMap=loadResponseFromJSONFile(SearchCustomerConstant.filePathCompany);*/
	}
	
	// Your Activity Portlet
	public final static By byActivityAppointment1 = By.xpath("//*[contains(@id,'activityAppointment')]/div/div/div[2]/div[4]/div[1]");
	public final static By byChiudiActivityButton = By.xpath("//*[contains(@id,'chiudiActivityButton')]");
	public final static By byActivityAppointment2 = By.xpath("//*[contains(@id,'activityAppointment')]/div/div/div[2]/div[4]/div[2]");
	public final static By byMenuItemClose = By.xpath("//*[@id='gvb-theme-appcontainer_tablist']/div[5]/div/div[2]/span[4]");

/*	@Test(priority=0)
	public void testNavigateActivity() throws Exception {
	try{
	highlightElement(byActivityAppointment1, true).click();
	sleep(4000);
	highlightElement(byChiudiActivityButton, true).click();
	sleep(4000);
	highlightElement(byActivityAppointment2, true).click();
	sleep(10000);
	highlightElement(byMenuItemClose, true).click();
	sleep(5000);
	}
	catch(Exception e){
	throw(e);
	}
	
   }*/
	
	// Customer Base Portlet
	public final static By byRelazionePopupIcon = By.xpath("//*[contains(@id,'relazionePopupIcon')]");
	public final static By byRelazioneClose = By.xpath("//*[contains(@id,'infoDataPopupId')]/div[2]/div/div[8]/span/span");
	public final static By byRelazioneColumnChart1 = By.xpath("//*[@id='widgetsPocPortlet:columnChart1']/div[2]");
	public final static By byRelazioneColumnChart2 = By.xpath("//*[@id='widgetsPocPortlet:columnChart2']/div[2]");
	public final static By byRelazioneColumnChart3 = By.xpath("//*[@id='widgetsPocPortlet:columnChart3']/div[2]");
	public final static By byRelazioneArchEntitlement2 = By.xpath("//*[contains(@id,'ArchEntitlement')]/a/div/div");
	public final static By byRelazioneArchTabClose = By.xpath("//*[@id='gvb-theme-appcontainer_tablist']/div[5]/div/div[2]/span[4]");
	
/*	@Test(priority=1)
	public void testNavigateCustommerBase() throws Exception {
	
	try{
	
	highlightElement(byRelazionePopupIcon, true).click();
	sleep(4000);
	highlightElement(byRelazioneClose, true).click();
	sleep(2000);
	highlightElement(byRelazioneColumnChart1, true).click();
	sleep(1000);
	highlightElement(byRelazioneColumnChart2, true).click();
	sleep(1000);
	highlightElement(byRelazioneColumnChart3, true).click();
	sleep(1000);
	highlightElement(byRelazioneArchEntitlement2, true).click();
	sleep(10000);
	highlightElement(byRelazioneArchTabClose, true).click();
	sleep(5000);
	}
	catch(Exception e){
	throw(e);
	}
   }*/

	// Your Initiative Portlet
	public final static By byActiveInitaitive = By.xpath("//*[contains(@class,'homepagecomportamenticommercialiAttivitaValue')]");
	public final static By byActiveInitaitiveClose = By.xpath("//*[contains(@id,'gvb-theme-appcontainer_tablist')]/div[5]/div/div[2]/span[4]");
	
	/*@Test(priority=2)
	public void testNavigateInitiatives() throws Exception {
		try{
		highlightElement(byActiveInitaitive, true).click();
		sleep(5000);
		highlightElement(byActiveInitaitiveClose, true).click();
		sleep(2000);
		}
	catch(Exception e){
	throw(e);
	}
	}
	*/
	
	// Performance Portlet
	public final static By byPerformancePopupIcon = By.xpath("//*[contains(@id,'performancePopupIcon')]");
	public final static By byPerformancePopupClose = By.xpath("//*[contains(@id,'performanceInfoDataPopupId')]/div[2]/div/div[8]/span/span");
	public final static By byRelazioneArchEntitlement32 = By.xpath("//*[contains(@id,'ArchEntitlement')]/table/tbody/tr/td[2]/div/a/div/div");
	public final static By byRelazioneArchEntitlement33 = By.xpath("//*[contains(@id,'ArchEntitlement')]/table/tbody/tr/td[3]/div/a/div/div");
	public final static By byBisogniContainerNodeId2 = By.xpath("//*[contains(@id,'bisogniContainerNodeId')]/span[2]");
	public final static By byBisogniContainerNodeId3 = By.xpath("//*[contains(@id,'bisogniContainerNodeId')]/span[3]");
	public final static By byBisogniContainerNodeId4 = By.xpath("//*[contains(@id,'bisogniContainerNodeId')]/span[4]");
	public final static By byBisogniContainerNodeId5 = By.xpath("//*[contains(@id,'bisogniContainerNodeId')]/span[5]");
	public final static By byRelazioneArchEntitlement34 = By.xpath("//*[contains(@id,'ArchEntitlement')]/table/tbody/tr/td[4]/div/a/div/div/span[2]");
	public final static By byCreditoChart = By.xpath("//*[contains(@id,'creditoChart')]/div[1]/div");
	public final static By byRelazioneArchEntitlement35 = By.xpath("//*[contains(@id,'ArchEntitlement')]/table/tbody/tr/td[5]/div/a/div/div");
	
	
	@Test(priority=3)
	public void testNavigatePerformance() throws Exception {
		try{
		highlightElement(byPerformancePopupIcon, true).click();
		sleep(3000);
		highlightElement(byPerformancePopupClose, true).click();
		sleep(2000);
		// Collection
		highlightElement(byRelazioneArchEntitlement32, true).click();
		sleep(7000);
		highlightElement(byRelazioneArchTabClose, true).click();
		sleep(2000);
		
		// Applications
		highlightElement(byRelazioneArchEntitlement33, true).click();
		sleep(7000);
		highlightElement(byRelazioneArchTabClose, true).click();
		sleep(2000);
		
		// Products Sold
		highlightElement(byBisogniContainerNodeId2, true).click();
		sleep(1000);
		highlightElement(byBisogniContainerNodeId3, true).click();
		sleep(1000);
		highlightElement(byBisogniContainerNodeId4, true).click();
		sleep(1000);
		highlightElement(byBisogniContainerNodeId5, true).click();
		sleep(1000);
		highlightElement(byRelazioneArchEntitlement34, true).click();
		sleep(7000);
		highlightElement(byRelazioneArchTabClose, true).click();
		sleep(2000);
		
		
		// Credit Quality
		hoverOverElement(driver,byCreditoChart);
		sleep(2000);
		highlightElement(byRelazioneArchEntitlement35, true).click();
		sleep(7000);
		highlightElement(byRelazioneArchTabClose, true).click();
		sleep(2000);
	}
	catch(Exception e){
	throw(e);
	}
	}

	
  	@AfterSuite
	public void afterAllTests() {
		sleep(60000);
		driver.close();
	}
}
