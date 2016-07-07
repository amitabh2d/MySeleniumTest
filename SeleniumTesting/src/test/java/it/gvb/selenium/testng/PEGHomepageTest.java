package it.gvb.selenium.testng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import it.gvb.selenium.util.TestUtil;

/**
 * The class PEGHomepageTest extends PEGTestSuite.
 * @author amitabh.jain
 *
 */
public class PEGHomepageTest extends TestUtil {
	
	public final static By byTab1Title = By.xpath("//div[contains(@id,'praticheInGestione')]");
	
	public final static By byScaduteDivTitle = By.xpath("//div[contains(@id,'scadutaDiv')]");
	
	public final static By byScadanzaDivTitle = By.xpath("//div[contains(@id,'inScadenza')]");
	
	public final static By byInCorsoDivTitle = By.xpath("//div[contains(@id,'inCorsoDiv')]");
	
	public final static By byStrategiaDivTitle = By.xpath("//div[contains(@id,'strategiaDiv')]");
	
	public final static By byAssegnazioneDivTitle = By.xpath("//div[contains(@id,'praticheDiv2')]");
	
	public final static By byRiesameDivTitle = By.xpath("//div[contains(@id,'inRiesameDiv')]");
	
	public final static By byscaduteLink = By.xpath("//*[contains(@id,'ScaduteAnchor')]");
	
	public final static By byDataGrid = By.xpath("//*[contains(@id,'tableContainer')]");
	
	public final static By byScaduteItems = By.xpath("//*[contains(@id,'scaduteItems')]/ul");
	
	public final static By byScadanzaItems = By.xpath("//*[contains(@id,'inScadenzaItems')]/ul");
	
	public final static By byInCorsoItems = By.xpath("//*[contains(@id,'incorsoItems')]/ul");
	
	public final static By byRiesameItems = By.xpath("//*[contains(@id,'reviewItems')]/ul");
	
	public final static By byAll = By.xpath("*");
	
	public final static By bySpanItemCount = (By.cssSelector(".bper-advance-search-box-number"));
	
	public final static By byScandanzaLink = By.xpath("//*[contains(@id,'ScadenzaAnchor')]");
	
	public final static By byInCorsoLink = By.xpath("//*[contains(@id,'CorsoAnchor')]");
	
	public final static By byStrategiaLink = By.xpath("//*[contains(@id,'strategiaAnchor')]");
	
	public final static By byAssegnazioneLink = By.xpath("//*[contains(@id,'praticheAnchor2')]");
	
	public final static By byRiesameLink = By.xpath("//*[contains(@id,'RiesameAnchor')]");
	
	public final static By byChildItemClick = (By.cssSelector(".bper-advance-search-box-label"));
	
	public final static By byLensIcon = (By.cssSelector(".bper-advance-search-icon"));
	
	public final static By byExportButton = By.xpath("//*[contains(@id,'exportButton')]");
	
	

	public PEGHomepageTest() {
		super();
	}

	/**
	 * Method to load driver, properties file and URL before executing any other
	 * test case.
	 */
	@BeforeSuite
	public void beforeTest() {
		try {
			loadDriver("ie");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//driver.get(getNdgAndUrl("URL"));
		driver.manage().window().maximize();
	}

	/**
	 * Method to verify the title of PEG Application.
	 */
	@Test
	public void testPegTitle() {

		String title = driver.getTitle();
		AssertJUnit.assertTrue(title.contains(prop.getProperty("PEGTitle")));

	}

	/**
	 * Method to verify HomePage tab1 - 'Pratiche In Gestione' title.
	 */
	@Test
	public void testHomepageTab1Title() {

		waitForElementPresence(driver, byTab1Title, 10);
		WebElement tab1Title = getElement(driver, byTab1Title);
		AssertJUnit.assertTrue(tab1Title.getText().contains(prop.getProperty("Tab1Title")));
		System.out.println("HomePage tab 1 title : " + tab1Title.getText());

	}
	
	/**
	 * Method to verify Scadute div title.
	 */
	@Test
	public void testScaduteDivTitle() {

		waitForElementPresence(driver, byScaduteDivTitle, 10);
		WebElement scaduteDivTitle = getElement(driver, byScaduteDivTitle);
		AssertJUnit.assertTrue(scaduteDivTitle.getText().contains(prop.getProperty("ScaduteDiv")));
		System.out.println("HomePage Scadute div title : "+scaduteDivTitle.getText());

	}
	
	/**
	 * Method to verify Scadanza div title.
	 */
	@Test
	public void testScadanzaDivTitle() {

		waitForElementPresence(driver, byScadanzaDivTitle, 10);
		WebElement scadanzaDivTitle = getElement(driver, byScadanzaDivTitle);
		AssertJUnit.assertTrue(scadanzaDivTitle.getText().contains(prop.getProperty("ScadanzaDiv")));
		System.out.println("HomePage scadanza div title : "+scadanzaDivTitle.getText());

	}
	
	/**
	 * Method to verify In corso div title.
	 */
	@Test
	public void testInCorsoDivTitle() {

		waitForElementPresence(driver, byInCorsoDivTitle, 10);
		WebElement inCorsoDivTitle = getElement(driver, byInCorsoDivTitle);
		AssertJUnit.assertTrue(inCorsoDivTitle.getText().contains(prop.getProperty("IncorsoDiv")));
		System.out.println("HomePage in corso div title : "+inCorsoDivTitle.getText());

	}
	
	/**
	 * Method to verify Strategia Terminata div title.
	 */
	@Test
	public void testStrategiaDivTitle() {

		waitForElementPresence(driver, byStrategiaDivTitle, 10);
		WebElement strategiaDivTitle = getElement(driver, byStrategiaDivTitle);
		AssertJUnit.assertTrue(strategiaDivTitle.getText().contains(prop.getProperty("TerminataDiv")));
		System.out.println("HomePage strategia terminata div title : "+strategiaDivTitle.getText());

	}
	
	/**
	 * Method to verify PRATICHE IN CARICO ALL'UO IN ATTESA DI ASSEGNAZIONE div title.
	 */
	@Test
	public void testAssegnazioneDivTitle() {

		waitForElementPresence(driver, byAssegnazioneDivTitle, 10);
		WebElement assegnazioneDivTitle = getElement(driver, byAssegnazioneDivTitle);
		AssertJUnit.assertTrue(assegnazioneDivTitle.getText().contains(prop.getProperty("AssegnazioneDiv")));
		System.out.println("HomePage in assegnazione div title : "+assegnazioneDivTitle.getText());

	}
	
	/**
	 * Method to verify PRATICHE IN RIESAME div title.
	 */
	@Test
	public void testRiesameDivTitle() {

		waitForElementPresence(driver, byRiesameDivTitle, 10);
		WebElement riesameDivTitle = getElement(driver, byRiesameDivTitle);
		AssertJUnit.assertTrue(riesameDivTitle.getText().contains(prop.getProperty("RiesameDiv")));
		System.out.println("HomePage riesame div title : "+riesameDivTitle.getText());

	}
	
	/**
	 * Method to verify title of child links in scadute div.
	 */
	@Test
	public void testScaduteItems() {

		waitForElementPresence(driver, byScaduteItems, 30);
		WebElement elem = getElement(driver, byScaduteItems);
		List<WebElement> allElements = getListOfElements(elem, byAll);
		for (WebElement element : allElements) {
			childElementTextContains(element.getText());
		}
	}

	/**
	 * Method to verify title of child links in scadute div.
	 */
	@Test
	public void testScadanzaItems() {

		waitForElementPresence(driver, byScadanzaItems, 30);
		WebElement elem = getElement(driver, byScadanzaItems);
		List<WebElement> allElements = getListOfElements(elem, byAll);
		for (WebElement element : allElements) {
			childElementTextContains(element.getText());
		}

	}
	
	/**
	 * Method to verify title of child links in in corso div.
	 */
	@Test
	public void testInCorsoItems() {

		waitForElementPresence(driver, byInCorsoItems, 30);
		WebElement elem = getElement(driver, byInCorsoItems);
		List<WebElement> allElements = getListOfElements(elem, byAll);
		for (WebElement element : allElements) {
			childElementTextContains(element.getText());
		}

	}
	
	/**
	 * Method to verify title of child links in riesame div.
	 */
	@Test
	public void testRiesameItems() {

		waitForElementPresence(driver, byRiesameItems, 30);
		WebElement elem = getElement(driver, byRiesameItems);
		List<WebElement> allElements = getListOfElements(elem, byAll);
		for (WebElement element : allElements) {
			childElementTextContains(element.getText());
		}

	}
	
	/**
	 * Method to retrieve titles of div from properties file,
	 * @param text
	 */
	public void childElementTextContains(String text) {
		if (null != text && !text.isEmpty()) {
			if (text.contains(prop.getProperty("DefPianoChildElem"))) {
				assertText(text, prop.getProperty("DefPianoChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("DeliberaChildElem"))) {
				assertText(text, prop.getProperty("DeliberaChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("ActionExecChildElem"))) {
				assertText(text, prop.getProperty("ActionExecChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("RestChildElem"))) {
				assertText(text, prop.getProperty("RestChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("OutsourcerChildElem"))) {
				assertText(text, prop.getProperty("OutsourcerChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("ChiusuraChildElem"))) {
				assertText(text, prop.getProperty("ChiusuraChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("ActionExecIncorsoChildElem"))) {
				assertText(text, prop.getProperty("ActionExecIncorsoChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("PropostaUtenteChildElem"))) {
				assertText(text, prop.getProperty("PropostaUtenteChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("ForborneNonPerformingChildElem"))) {
				assertText(text, prop.getProperty("ForborneNonPerformingChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("AnomalieDaRiesameChildElem"))) {
				assertText(text, prop.getProperty("AnomalieDaRiesameChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("ClassificazioneChildElem"))) {
				assertText(text, prop.getProperty("ClassificazioneChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("Pastdue30ChildElem"))) {
				assertText(text, prop.getProperty("Pastdue30ChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("TerminProbPeriodChildElem"))) {
				assertText(text, prop.getProperty("TerminProbPeriodChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("ReforborneChildElem"))) {
				assertText(text, prop.getProperty("ReforborneChildElem"));
				System.out.println(text);
			}
			if (text.contains(prop.getProperty("StrategiaTermChildElem"))) {
				assertText(text, prop.getProperty("StrategiaTermChildElem"));
				System.out.println(text);
			}
			
		} else {
			AssertJUnit.assertTrue("No child Elements present in the item",true);
		}
	}
	
	/**
	 * Method to verify Scadute heading link click.
	 */
	@Test(priority = 1)
	public void testScaduteLink() {

		boolean isClickable = false;
		waitForElementPresence(driver, byscaduteLink, 10);
		WebElement scaduteLink = getElement(driver, byscaduteLink);
		WebElement scaduteCount = scaduteLink.findElement(bySpanItemCount);
		System.out.println("Scadute Count : " + scaduteCount.getText());
		if(Integer.parseInt(scaduteCount.getText()) > 0 ) {
			sleep(20000);
			scaduteLink.click();
			assertExists(driver, byDataGrid,30);
			System.out.println("Data grid is present" + byDataGrid);
			refreshPage(10000,driver);
		} else {
			AssertJUnit.assertFalse(isClickable);
			System.out.println("Scadute link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify Scadanza heading link click.
	 */
	//@Test(priority = 2)
	public void testScadanzaLink() {

		boolean isClickable = false;
		waitForElementPresence(driver, byScandanzaLink, 10);
		WebElement scadanzaLink = getElement(driver, byScandanzaLink);
		WebElement scadanzaCount = scadanzaLink.findElement(bySpanItemCount);
		System.out.println("Scadanza Count : " + scadanzaCount.getText());
		if(Integer.parseInt(scadanzaCount.getText()) > 0 ) {
			sleep(20000);
			scadanzaLink.click();
			assertExists(driver, byDataGrid,30);
			isClickable = true;
			System.out.println("Data grid is present" + byDataGrid);
			refreshPage(10000,driver);
		} else {
			AssertJUnit.assertFalse(isClickable);
			System.out.println("Scadanza link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify InCorso heading link click.
	 */
	//@Test(priority = 3)
	public void testInCorsoLink() {

		boolean isClickable = false;
		waitForElementPresence(driver, byInCorsoLink, 10);
		WebElement inCorsoLink = getElement(driver, byInCorsoLink);
		WebElement inCorsoCount = inCorsoLink.findElement(bySpanItemCount);
		System.out.println("InCorso Count : " + inCorsoCount.getText());
		if(Integer.parseInt(inCorsoCount.getText()) > 0 ) {
			sleep(20000);
			inCorsoLink.click();
			assertExists(driver, byDataGrid,30);
			isClickable = true;
			System.out.println("Data grid is present" + byDataGrid);
			refreshPage(10000,driver);
		} else {
			AssertJUnit.assertFalse(isClickable);
			System.out.println("InCorso link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify Strategia terminata heading link click.
	 */
	//@Test(priority = 4)
	public void testStrategiaLink() {

		boolean isClickable = false;
		waitForElementPresence(driver, byStrategiaLink, 10);
		WebElement strategiaLink = getElement(driver, byStrategiaLink);
		WebElement strategiaCount = strategiaLink.findElement(bySpanItemCount);
		System.out.println("Scadanza Count : " + strategiaCount.getText());
		if(Integer.parseInt(strategiaCount.getText()) > 0 ) {
			sleep(20000);
			strategiaLink.click();
			assertExists(driver, byDataGrid,30);
			isClickable = true;
			System.out.println("Data grid is present" + byDataGrid);
			refreshPage(10000,driver);
		} else {
			AssertJUnit.assertFalse(isClickable);
			System.out.println("Strategia Terminata link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify Assegnazione heading link click.
	 */
	//@Test(priority = 5)
	public void testAssegnazioneLink() {

		boolean isClickable = false;
		waitForElementPresence(driver, byAssegnazioneLink, 10);
		WebElement assegnazioneLink = getElement(driver, byAssegnazioneLink);
		WebElement assegnazioneCount = assegnazioneLink.findElement(bySpanItemCount);
		System.out.println("Assegnazione Count : " + assegnazioneCount.getText());
		if(Integer.parseInt(assegnazioneCount.getText()) > 0 ) {
			sleep(20000);
			assegnazioneLink.click();
			assertExists(driver, byDataGrid,30);
			isClickable = true;
			System.out.println("Data grid is present" + byDataGrid);
			refreshPage(10000,driver);
		} else {
			AssertJUnit.assertFalse(isClickable);
			System.out.println("Assegnazione link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify Pratiche in Riesame heading link click.
	 */
	//@Test(priority = 6)
	public void testRiesameLink() {

		boolean isClickable = false;
		waitForElementPresence(driver, byRiesameLink, 10);
		WebElement riesameLink = getElement(driver, byRiesameLink);
		WebElement riesameCount = riesameLink.findElement(bySpanItemCount);
		System.out.println("Riesame Count : " + riesameCount.getText());
		if(Integer.parseInt(riesameCount.getText()) > 0 ) {
			sleep(20000);
			riesameLink.click();
			assertExists(driver, byDataGrid,30);
			isClickable = true;
			System.out.println("Data grid is present" + byDataGrid);
			refreshPage(10000,driver);
		} else {
			AssertJUnit.assertFalse(isClickable);
			System.out.println("Pratiche in riesame link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify link click of each child item in scadute div.
	 */
	//@Test(priority = 7)
	public void testScaduteItemsLinkClick() {

		boolean hasItems = false;
		waitForElementPresence(driver, byscaduteLink, 20);
		WebElement scaduteLink = getElement(driver, byscaduteLink);
		WebElement scaduteCount = scaduteLink.findElement(bySpanItemCount);
		if (Integer.parseInt(scaduteCount.getText()) > 0) {
			hasItems = true;
			waitForElementPresence(driver, byScaduteItems, 20);
			WebElement elem = getElement(driver, byScaduteItems);
			List<WebElement> allElements = getListOfElements(elem, byAll);
			for (WebElement element : allElements) {
				if (null != element.getText() && !element.getText().isEmpty()) {
					System.out.println("Element to be clicked " + element.getText());
					WebElement childLink = element.findElement(byChildItemClick);
					System.out.println("Child Link is visible " + childLink.getText());
					new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(childLink)).click();
					System.out.println("Child Link js got clicked " + childLink.getText());
					assertExists(driver, byDataGrid, 30);
					System.out.println("Datagrid is visible on Clicking " + element.getText() + " link");
					sleep(20000);
				}
			}
		} else {
			AssertJUnit.assertFalse(hasItems);
			System.out.println("Scadute link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify link click of each child item in scadanza div.
	 */
	//@Test(priority = 8)
	public void testScadanzaItemsLinkClick() {

		boolean hasItems = false;
		waitForElementPresence(driver, byScandanzaLink, 20);
		WebElement scadanzaLink = getElement(driver, byScandanzaLink);
		WebElement scadanzaCount = scadanzaLink.findElement(bySpanItemCount);
		if (Integer.parseInt(scadanzaCount.getText()) > 0) {
			hasItems = true;
			waitForElementPresence(driver, byScadanzaItems, 20);
			WebElement elem = getElement(driver, byScadanzaItems);
			List<WebElement> allElements = getListOfElements(elem, byAll);
			for (WebElement element : allElements) {
				if (null != element.getText() && !element.getText().isEmpty()) {
					System.out.println("Element to be clicked " + element.getText());
					WebElement childLink = element.findElement(byChildItemClick);
					System.out.println("Child Link is visible " + childLink.getText());
					new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(childLink)).click();
					System.out.println("Child Link js got clicked " + childLink.getText());
					assertExists(driver, byDataGrid, 30);
					System.out.println("Datagrid is visible on Clicking " + element.getText() + " link");
					sleep(20000);
				}
			}
		} else {
			AssertJUnit.assertFalse(hasItems);
			System.out.println("Scadanza link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify link click of each child item in incorso div.
	 */
	//@Test(priority = 9)
	public void testIncorsoItemsLinkClick() {

		boolean hasItems = false;
		waitForElementPresence(driver, byInCorsoLink, 20);
		WebElement incorsoLink = getElement(driver, byInCorsoLink);
		WebElement incorsoCount = incorsoLink.findElement(bySpanItemCount);
		if (Integer.parseInt(incorsoCount.getText()) > 0) {
			hasItems = true;
			waitForElementPresence(driver, byInCorsoItems, 20);
			WebElement elem = getElement(driver, byInCorsoItems);
			List<WebElement> allElements = getListOfElements(elem, byAll);
			for (WebElement element : allElements) {
				if (null != element.getText() && !element.getText().isEmpty()) {
					System.out.println("Element to be clicked " + element.getText());
					WebElement childLink = element.findElement(byChildItemClick);
					System.out.println("Child Link is visible " + childLink.getText());
					new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(childLink)).click();
					System.out.println("Child Link js got clicked " + childLink.getText());
					assertExists(driver, byDataGrid, 30);
					System.out.println("Datagrid is visible on Clicking " + element.getText() + " link");
					sleep(20000);
				}
			}
		} else {
			AssertJUnit.assertFalse(hasItems);
			System.out.println("Incorso link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify link click of each child item in riesame div.
	 */
	//@Test(priority = 10)
	public void testRiesameItemsLinkClick() {

		boolean hasItems = false;
		waitForElementPresence(driver, byRiesameLink, 20);
		WebElement riesameLink = getElement(driver, byRiesameLink);
		WebElement riesameCount = riesameLink.findElement(bySpanItemCount);
		if (Integer.parseInt(riesameCount.getText()) > 0) {
			hasItems = true;
			waitForElementPresence(driver, byRiesameItems, 20);
			WebElement elem = getElement(driver, byRiesameItems);
			List<WebElement> allElements = getListOfElements(elem, byAll);
			for (WebElement element : allElements) {
				if (null != element.getText() && !element.getText().isEmpty()) {
					System.out.println("Element to be clicked " + element.getText());
					WebElement childLink = element.findElement(byChildItemClick);
					System.out.println("Child Link is visible " + childLink.getText());
					new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(childLink)).click();
					System.out.println("Child Link js got clicked " + childLink.getText());
					assertExists(driver, byDataGrid, 30);
					System.out.println("Datagrid is visible on Clicking " + element.getText() + " link");
					sleep(30000);
				}
			}
		} else {
			AssertJUnit.assertFalse(hasItems);
			System.out.println("Riesame link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify export button on data grid.
	 */
	//@Test(priority = 11)
	public void testExportBtnClick() {

		boolean isnavigated = false;
		waitForElementPresence(driver, byInCorsoLink, 30);
		WebElement inCorsoLink = getElement(driver, byInCorsoLink);
		WebElement inCorsoCount = inCorsoLink.findElement(bySpanItemCount);
		System.out.println("InCorso Count : " + inCorsoCount.getText());
		if(Integer.parseInt(inCorsoCount.getText()) > 0 ) {
			sleep(50000);
			inCorsoLink.click();
			waitForVisible(driver,byDataGrid,60);
			WebElement exportBtn = getElement(driver, byExportButton);
			sleep(20000);
			exportBtn.click();
			System.out.println("exportBtn clicked"+exportBtn.getText());
			sleep(20000);
			Robot robotObject = null;
			try {
				robotObject = new Robot();
				robotObject.keyPress(KeyEvent.VK_ALT);
				robotObject.keyPress(KeyEvent.VK_S);
				robotObject.keyRelease(KeyEvent.VK_ALT);
				robotObject.keyRelease(KeyEvent.VK_S);
			} catch (AWTException e) {
				e.printStackTrace();
			};
            sleep(20000);

		}

		else {
			AssertJUnit.assertFalse(isnavigated);
			System.out.println("InCorso link is non-clickable as it has 0 items");
		}
	}
	
	/**
	 * Method to verify lens icon on data grid.
	 */
	//@Test(priority = 12)
	public void testLensIconLink() {

		boolean isnavigated = false;
		waitForElementPresence(driver, byInCorsoLink, 20);
		WebElement inCorsoLink = getElement(driver, byInCorsoLink);
		WebElement inCorsoCount = inCorsoLink.findElement(bySpanItemCount);
		System.out.println("InCorso Count : " + inCorsoCount.getText());
		if(Integer.parseInt(inCorsoCount.getText()) > 0 ) {
			sleep(30000);
			inCorsoLink.click();
			waitForVisible(driver,byDataGrid,30);
			WebElement grid = getElement(driver, byDataGrid);
			WebElement lens = grid.findElement(byLensIcon);
			sleep(20000);
			lens.click();
			System.out.println("lens clicked");
			sleep(20000);
			if(driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("EvaluationPageUrl"))) {
				isnavigated = true;
				System.out.println("Eval page");
				AssertJUnit.assertTrue("Page navigated to eval page", isnavigated);
			} else if(driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("ProposalPageUrl"))) {
				isnavigated = true;
				System.out.println("Proposal page");
				AssertJUnit.assertTrue("Page navigated to proposal page", isnavigated);
			} else if(driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("DeliberaPageUrl"))) {
				isnavigated = true;
				System.out.println("Delibera page");
				AssertJUnit.assertTrue("Page navigated to delibera page", isnavigated);
			} else if(driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("ActionExecutionPageUrl"))) {
				isnavigated = true;
				System.out.println("action page");
				AssertJUnit.assertTrue("Page navigated to action execution page", isnavigated);
			} else {
				AssertJUnit.assertFalse(isnavigated);
			}
		} else {
			AssertJUnit.assertFalse(isnavigated);
			System.out.println("InCorso link is non-clickable as it has 0 items");
		}
	}
	
	@AfterSuite
	public void afterAllTests() {
		sleep(60000);
		driver.close();
	}
}
