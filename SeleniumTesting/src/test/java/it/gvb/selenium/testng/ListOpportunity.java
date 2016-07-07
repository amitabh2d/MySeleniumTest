package it.gvb.selenium.testng;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import it.gvb.selenium.constants.SearchCustomerConstant;
import it.gvb.selenium.util.TestUtil;

public class ListOpportunity extends TestUtil {
	
	// For Navigate Opportunity
	public final static By byMenuList = By.xpath("//*[@id='gvb-theme-appcontainer_tablist']/div[1]");
	public final static By byPlanningList = By.xpath("//*[@id='dijit__TreeNode_2']/div[1]/span[1]");
	public final static By byOpportunity = By.xpath("//*[@id='dijit__TreeNode_11']/div[1]");
	
	// For Hover Over 
	public final static By byVBStatusCounter = By.xpath("//*[contains(@id,'VBStatusCounterBig2')]");
	public final static By byOpportunityitmrellavo1 = By.xpath("//*[@id='opportunityitmrel_lavo1']");
	public final static By byOpportunityitmrelDiv = By.xpath("//*[@id='opportunityitmrel']/div[2]");
	public final static By byOpportunityitmreMaicontatti1 = By.xpath("//*[@id='opportunityitmrel_maicontatti1']");
	public final static By byPieChartSmall1 = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G828Q3__PieChartSmall-1']/div[3]");
	public final static By byPieChartSmall2 = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G828Q3__PieChartSmall-2']/div[3]");
	public final static By byOpportunityitmcommlavo1 = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82860__opportunityitmcomm_lavo1']");
	public final static By byOpportunityitmcomm = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82860__opportunityitmcomm']/div[2]");
	public final static By byOpportunityitmcommMaicontatti1 = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82860__opportunityitmcomm_maicontatti1']");
	public final static By byOpportunityitmmonLavo1 = By.xpath("//*[@id='opportunityitmmon_lavo1']");
	public final static By byOpportunityitmmon = By.xpath("//*[@id='opportunityitmmon']/div[2]");
	public final static By byOpportunityitmmonMaicontatti1 = By.xpath("//*[@id='opportunityitmmon_maicontatti1']");
	public final static By byPieChartSmall1Com = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82860__PieChartSmall-1']/div[3]");
	public final static By byPieChartSmall2Com = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82860__PieChartSmall-2']/div[3]");
	public final static By byPieChartSmall1Cre = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82862__PieChartSmall-1']/div[3]");
	public final static By byPieChartSmall2Cre = By.xpath("//*[@id='ns_Z7_119EHA40K8JO50A2N2P3G82862__PieChartSmall-2']/div[3]");

	
	// For Report
	public final static By byRelazionitab = By.xpath("//*[contains(@id,'relazionitab')]");
	public final static By byRelationInitiativeGrid = By.xpath("//*[contains(@id,'relationInitiativeGrid-row-0')]/table/tr/td[7]/img");
	public final static By byAccessOpportunity = By.xpath("//*[contains(@id,'ArchExtendedTooltip')]/div[1]/div[2]/div/ul/li[1]");
	public final static By byAccessTargetList = By.xpath("//*[contains(@id,'ArchExtendedTooltip')]/div[1]/div[2]/div/ul/li[2]");
	public final static By byCloseRelationDialog = By.xpath("//*[contains(@id,'closeRelationDialog_label')]");
	public final static By byWidgetsearch = By.xpath("//*[contains(@id,'search')]/div[2]/div[2]");
	public final static By byCercaBtn = By.xpath("//*[contains(@id,'cercaBtn_label')]");
	public final static By byBackBtn = By.xpath("//*[contains(@id,'backBtn_label')]");
	public final static By byEventiTabLink = By.xpath("//*[contains(@id,'eventiTabLink')]");
	public final static By byRelationEventiGrid = By.xpath("//*[contains(@id,'relationEventiGrid-row-0')]/table/tr/td[7]/img");

	
	// For Commercial
	public final static By byTabIdx1 = By.xpath("//*[contains(@id,'tabIdx1')]");
	public final static By byCommercialeInitiativeGrid = By.xpath("//*[contains(@id,'commercialeInitiativeGrid-row-0')]/table/tr/td[7]/img");
	public final static By byCloseCommercialDialog = By.xpath("//*[contains(@id,'closeCommercialDialog_label')]");
	public final static By byCommercialeEventiGrid = By.xpath("//*[contains(@id,'commercialeEventiGrid-row-0')]/table/tr/td[7]/img");

	
	// For Monitor Credit
	public final static By byTabIdx2 = By.xpath("//*[contains(@id,'tabIdx2')]");
	public final static By byMonitorcredInitiativeGrid = By.xpath("//*[contains(@id,'monitorcredInitiativeGrid-row-0')]/table/tr/td[7]/img");
	public final static By byCloseCreditDialog = By.xpath("//*[contains(@id,'closeCreditDialog_label')]");
	public final static By byMonitorcredEventiGrid = By.xpath("//*[contains(@id,'monitorcredEventiGrid-row-0')]/table/tr/td[7]/img");
	
	
	//*[@id="VBStatusCounterBig2_83"]
	
	@SuppressWarnings("rawtypes")
	public Map companyJsonMap = null;
	@SuppressWarnings("rawtypes")
	public Map customerJsonMap = null;
	
	public ListOpportunity() {
		super();
	}
	
	
	@BeforeClass
	public void loadJSON(){
		
		customerJsonMap=loadResponseFromJSONFile(SearchCustomerConstant.filePathCustomer);
		companyJsonMap=loadResponseFromJSONFile(SearchCustomerConstant.filePathCompany);
	}
	
	
	@Test(priority=0)
	public void testNavigateListOpportunity() throws Exception {
	try{
	sleep(20000);
	driver.findElement(byMenuList).click();	
	driver.findElement(byPlanningList).click();	
	driver.findElement(byOpportunity).click();	
	sleep(10000);
	}
	catch(Exception e){
	throw(e);
	}
   }
  

			
	@Test(priority=1)
	public void testHoverOverElements() throws Exception {
		
		try{
		//driver.findElement(byVBStatusCounter).click();
		waitForElementPresence(driver, byOpportunityitmrellavo1, 5);
		//highlightElement(driver, driver.findElement(byOpportunityitmrellavo1), true);
		hoverOverElement(driver,byOpportunityitmrellavo1);
		sleep(2000);
		hoverOverElement(driver,byOpportunityitmrelDiv);
		sleep(2000);
		hoverOverElement(driver,byOpportunityitmreMaicontatti1);
		sleep(2000);
		hoverOverElement(driver,byPieChartSmall1);
		sleep(2000);
		hoverOverElement(driver,byPieChartSmall2);
		sleep(2000);
		
		hoverOverElement(driver,byOpportunityitmcommlavo1);
		sleep(2000);
		hoverOverElement(driver,byOpportunityitmcomm);
		sleep(2000);
		hoverOverElement(driver,byOpportunityitmcommMaicontatti1);
		sleep(2000);
		hoverOverElement(driver,byPieChartSmall1Com);
		sleep(2000);
		hoverOverElement(driver,byPieChartSmall2Com);
		sleep(2000);
		
		hoverOverElement(driver,byOpportunityitmmonLavo1);
		sleep(2000);
		hoverOverElement(driver,byOpportunityitmmon);
		sleep(2000);
		hoverOverElement(driver,byOpportunityitmmonMaicontatti1);
		sleep(2000);
		hoverOverElement(driver,byPieChartSmall1Cre);
		sleep(2000);
		hoverOverElement(driver,byPieChartSmall2Cre);
		sleep(2000);
	}
	catch(Exception e){
	throw(e);
	}

	}	
	
	@Test(priority=2)
	public void testNavigateReport() throws Exception {
	
	try{
	driver.findElement(byRelazionitab).click();	
	sleep(3000);
	
	// Browsing Initiative 
	driver.findElement(byRelationInitiativeGrid).click();
	driver.findElement(byAccessOpportunity).click();
	sleep(6000);
	driver.findElement(byCloseRelationDialog).click();
	sleep(2000);
	driver.findElement(byRelationInitiativeGrid).click();
	driver.findElement(byAccessTargetList).click();
	sleep(6000);
	/*driver.findElement(byWidgetsearch).sendKeys((String)customerJsonMap.get("ndgCode"));
	driver.findElement(byCercaBtn).click();*/
	driver.findElement(byBackBtn).click();
	sleep(2000);
		
	
	// Browsing Events 
	driver.findElement(byEventiTabLink).click();
	driver.findElement(byRelationEventiGrid).click();
	driver.findElement(byAccessOpportunity).click();
	sleep(8000);
	driver.findElement(byCloseRelationDialog).click();
	sleep(2000);
	driver.findElement(byRelationEventiGrid).click();
	driver.findElement(byAccessTargetList).click();
	sleep(8000);
	driver.findElement(byBackBtn).click();
	sleep(2000);
	}
	catch(Exception e){
	throw(e);
	}
  }
	
	
	@Test(priority=3)
	public void testNavigateCommercial() throws Exception {
		try{	
		driver.findElement(byTabIdx1).click();
		sleep(2000);
		// Browsing Initiative 
		driver.findElement(byCommercialeInitiativeGrid).click();
		driver.findElement(byAccessOpportunity).click();
		sleep(6000);
		driver.findElement(byCloseCommercialDialog).click();
		sleep(2000);
		driver.findElement(byCommercialeInitiativeGrid).click();
		driver.findElement(byAccessTargetList).click();
		sleep(6000);
		/*driver.findElement(byWidgetsearch).sendKeys((String)customerJsonMap.get("ndgCode"));
		driver.findElement(byCercaBtn).click();*/
		driver.findElement(byBackBtn).click();
		sleep(2000);

		// Browsing Events 
		driver.findElement(byEventiTabLink).click();
		driver.findElement(byCommercialeEventiGrid).click();
		driver.findElement(byAccessOpportunity).click();
		sleep(6000);
		driver.findElement(byCloseCommercialDialog).click();
		sleep(2000);
		driver.findElement(byCommercialeEventiGrid).click();
		driver.findElement(byAccessTargetList).click();
		sleep(6000);
		driver.findElement(byBackBtn).click();
		sleep(2000);
	}
	catch(Exception e){
	throw(e);
	}
		
	}
	
	
	@Test(priority=4)
	public void testNavigateMonitorCredit() throws Exception {
		
		try{
		driver.findElement(byTabIdx2).click();
		sleep(2000);
		
		// Browsing Initiative 
		driver.findElement(byMonitorcredInitiativeGrid).click();
		driver.findElement(byAccessOpportunity).click();
		sleep(6000);
		driver.findElement(byCloseCreditDialog).click();
		sleep(2000);
		driver.findElement(byMonitorcredInitiativeGrid).click();
		driver.findElement(byAccessTargetList).click();
		sleep(6000);
		/*driver.findElement(byWidgetsearch).sendKeys((String)customerJsonMap.get("ndgCode"));
		driver.findElement(byCercaBtn).click();*/
		driver.findElement(byBackBtn).click();
		sleep(2000);
		
		// Browsing Events 
		driver.findElement(byEventiTabLink).click();
		driver.findElement(byMonitorcredEventiGrid).click();
		driver.findElement(byAccessOpportunity).click();
		sleep(6000);
		driver.findElement(byCloseCreditDialog).click();
		sleep(2000);
		driver.findElement(byMonitorcredEventiGrid).click();
		driver.findElement(byAccessTargetList).click();
		sleep(6000);
		driver.findElement(byBackBtn).click();
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
