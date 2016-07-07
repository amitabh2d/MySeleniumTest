package it.gvb.selenium.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import it.gvb.selenium.constants.CommonConstant;
//import org.testng.annotations.Parameters;

/**
 * The class TestUtil.
 * @author amitabh.jain
 */
public class TestUtil {
	public static WebDriver driver = null;
	public static Properties prop = null;
	public static JavascriptExecutor js = null;
	@SuppressWarnings("rawtypes")
	public Map JsonInput = null;
	public HashMap<String, String> dataAndURLs = new HashMap<String, String>();

	/**
	 * Method for loading properties file.
	 */
	/*public void loadPropertiesFile() {

		if (prop == null) {
			prop = new Properties();
			// Read properties file.
			File file = new File("src\\main\\resources\\dataFile.properties");

			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			// Load properties file.
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}*/
	
	public String getProperty(String key){
		
		return (String)prop.getProperty(key);
	}

	
	/**
	 * Method for Loading the IE driver.
	 */
	// @Parameters("browser")
	public void loadDriver(String browser) throws Exception {
		System.out.println("*** In class - TestUtil ***");
		//loadPropertiesFile();
	//	loadDatabase();
		if (driver == null) {
			if (browser.equalsIgnoreCase(CommonConstant.firefoxDriver)) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase(CommonConstant.chromeDriver)) {
				System.setProperty("webdriver.chrome.driver",CommonConstant.chromeDriverPath);
				//System.setProperty("webdriver.chrome.driver","C:\\Users\\amitabh.jain\\Downloads\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase(CommonConstant.ieDriver)) {
			//	System.setProperty("webdriver.ie.driver", prop.getProperty("IEDriver"));
				System.setProperty("webdriver.ie.driver", CommonConstant.ieDriverPath);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new InternetExplorerDriver();

			} else {
				throw new Exception("Browser is not correct");
			}
		}
	}

	/**
	 * Method to find an element by By.
	 * 
	 * @param driver
	 * @param by
	 * @return -WebElement or null if not found
	 */
	public WebElement getElement(WebDriver driver, By by) {
		WebElement element = null;
		try {
			element = driver.findElement(by);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return element;
	}

	/**
	 * Method to find an element within element.
	 * 
	 * @param driver
	 * @param by
	 * @return -WebElement or null if not found
	 */
	public WebElement getElement(WebDriver driver, WebElement element, By by, int duration) {
		WebElement elem = null;
		waitForVisible(driver, by, duration);
		try {
			elem = element.findElement(by);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return elem;
	}

	/**
	 * Method to locate the presence of an element.
	 * 
	 * @param driver
	 * @param by
	 * @param duration
	 */
	public void waitForElementPresence(WebDriver driver, By by, int duration) {
		try {
			new WebDriverWait(driver, duration).until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to explicitly wait for an element to become visible.
	 * 
	 * @param driver
	 * @param by
	 * @param duration
	 */
	public void waitForVisible(WebDriver driver, By by, int duration) {
		try {
			new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method testing the existence of specified element
	 * 
	 * @param driver
	 * @param by
	 * @param duration
	 */
	public void assertExists(WebDriver driver, By by, int duration) {
		waitForVisible(driver, by, duration);
		WebElement elem = getElement(driver, by);
		if (elem.isDisplayed()) {
			AssertJUnit.assertTrue(elem.isDisplayed());
		} else {
			AssertJUnit.fail("Web element does not exists");
		}
	}
	
	/**
	 * Method testing the existence of specified element
	 * 
	 * @param driver
	 * @param by
	 * @param duration
	 */
	public void assertExists(WebElement element, int duration) {
		if (element.isDisplayed()) {
			AssertJUnit.assertTrue(element.isDisplayed());
		} else {
			AssertJUnit.fail("Web element does not exists");
		}
	}

	/**
	 * Method to wait for certain amount of time.
	 * 
	 * @param milliseconds
	 */
	public static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to click element
	 * 
	 * @param driver
	 * @param by
	 */
	public void clickElement(WebDriver driver, By by, int duration) {
		waitForElementPresence(driver, by, duration);
		getElement(driver, by).click();
	}

	public void clickElement(WebDriver driver, By by, String selector, int duration) {
		waitForElementPresence(driver, by, duration);
		hoverOverElement(driver, by);
		WebElement element = getElement(driver, by);
		// highlightElement(driver, element, true);
		element.click();
		System.out.println(selector + " clicked.");
	}

	/**
	 * Method to find list of elements.
	 * 
	 * @param element
	 * @param by
	 */
	public List<WebElement> getListOfElements(WebElement element, By by) {
		List<WebElement> listElem = null;
		try {
			listElem = element.findElements(by);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listElem;

	}

	/**
	 * Method to verify the text of element
	 * 
	 * @param driver
	 * @param by
	 * @param match
	 */
	public void assertText(String text, String match) {
		boolean result = false;
		result = text.contains(match);
		if (result) {
			AssertJUnit.assertTrue("Text is present in the element", result);
		} else {
			AssertJUnit.fail("Text is not present in the element");
		}
	}

	/**
	 * Method to verify the text of element
	 * 
	 * @param driver
	 * @param by
	 * @param match
	 */
	public void assertText(WebElement element, String match) {
		String text = null;
		boolean result = false;

		if ((null != element.getTagName()) && ("input".equals(element.getTagName().toLowerCase()))) {
			text = element.getAttribute("value");
		} else {
			text = element.getText();
		}
		result = text.contains(match);
		if (result) {
			AssertJUnit.assertTrue("Text is present in the element", result);
		} else {
			AssertJUnit.fail("Text is not present in the element");
		}
	}

	/**
	 * Method to verify the text of element
	 * 
	 * @param driver
	 * @param by
	 * @param match
	 */
	public void assertText(WebDriver driver, By by, String match) {
		waitForElementPresence(driver, by, 10);
		WebElement element = getElement(driver, by);
		String text = null;

		boolean result = false;

		if ((null != element.getTagName()) && ("input".equals(element.getTagName().toLowerCase()))) {
			text = element.getAttribute("value");
		} else {
			text = element.getText();
		}
		result = text.contains(match);
		if (result) {
			AssertJUnit.assertTrue("Text is present in the element", result);
		} else {
			AssertJUnit.fail("Text is not present in the element");
		}
	}

	/**
	 * Method to find an web element list by By.
	 * 
	 * @param driver
	 * @param by
	 * @return -WebElement or null if not found
	 */
	public List<WebElement> getListOfElements(WebDriver driver, By by) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(by);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return element;
	}

	/**
	 * Method to refresh the page after certain time.
	 * 
	 * @param driver
	 */
	public void refreshPage(long milliseconds, WebDriver driver) {
		sleep(milliseconds);
		driver.navigate().refresh();
	}

	/**
	 * @param driver
	 * @param element
	 * @param isUnhighlight
	 * @throws InterruptedException
	 */
	public static void highlightElement(WebDriver driver, WebElement element, boolean isUnhighlight) {
		// Creating JavaScriptExecuter Interface
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus()", element);
		for (int iCnt = 0; iCnt < 1; iCnt++) {
			// Execute javascript
			if (isUnhighlight) {
				js.executeScript("arguments[0].style.border='4px groove red'", element);
			}
			sleep(5000);
			js.executeScript("arguments[0].style.border=''", element);
		}
	}
	
	
	/**
	 * @param driver
	 * @param by
	 * @param isUnhighlight
	 * @throws InterruptedException
	 */
	public static WebElement highlightElement(By by, boolean isUnhighlight) {
		// Creating JavaScriptExecuter Interface
		WebElement element = driver.findElement(by);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus()", element);
		for (int iCnt = 0; iCnt < 1; iCnt++) {
			// Execute javascript
			if (isUnhighlight) {
				js.executeScript("arguments[0].style.border='4px groove red'", element);
			}
			sleep(5000);
			js.executeScript("arguments[0].style.border=''", element);
		}
		return element;
	}
	
	
	
	/**
	 * Method - callRobotClass().
	 */
	public void callRobotClass() {
		Robot robotObject = null;
		try {
			robotObject = new Robot();
			robotObject.keyPress(KeyEvent.VK_ALT);
			robotObject.keyPress(KeyEvent.VK_S);
			robotObject.keyRelease(KeyEvent.VK_ALT);
			robotObject.keyRelease(KeyEvent.VK_S);
		} catch (AWTException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Function to explicitly wait for an element to be clickable
	 * 
	 * @param driver
	 * @param by
	 * @param duration
	 */
	protected static void waitForClickable(WebDriver driver, By by, int duration) {
		for (int x = 0; x <= 5; x++) {
			try {
				new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(by));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Function to hover over the designated element
	 * 
	 * @param driver
	 * @param by
	 */
	protected static void hoverOverElement(WebDriver driver, By by) {
		try {
			new Actions(driver).moveToElement(getWebElement(driver, by)).perform();
		} catch (NoSuchElementException e) {
			System.out.println("Eception caught.");
		}
	}

	/**
	 * Function to simplify the calling of findElementTries & add a better name
	 * for general use
	 * 
	 * @param driver
	 * @param by
	 * @param selector
	 * @return - WebElement described by By variable
	 */
	protected static WebElement getWebElement(WebDriver driver, By by) {
		return findElementTries(driver, by, true);
	}

	/**
	 * Function to allow multiple attempts to find an element by By
	 * 
	 * @param driver
	 * @param by
	 * @param failIfNotFound
	 * @return -WebElement or null if not found
	 */
	protected static WebElement findElementTries(WebDriver driver, By by, boolean failIfNotFound) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement element = null;
		try {
			element = driver.findElement(by);
		} catch (NoSuchElementException e) {
			if (failIfNotFound) {
				System.out.println("timeout. could not find >>>" + by + "<<< in " + 5 + " seconds.");
			}
		}
		return element;
	}

	/**
	 * Function to enter text into an indicated field
	 * 
	 * @param driver
	 * @param by
	 * @param text
	 */
	protected static void enterText(WebDriver driver, By by, String text) {
		waitForVisibility(driver, by, 10);
		System.out.println("Entering Text for - " + by.toString());
		WebElement element = getWebElement(driver, by);
		highlightElement(driver, element, true);
		System.out.println("Entering Text - After get Elemetn");
		if (null != element) {
			System.out.println("Entering Text - Element found" + element.toString());
			Actions action = new Actions(driver);
			action.sendKeys(element, text).build().perform();
		}
	}

	/**
	 * Function to explicitly wait for an element to become visible for a
	 * designated duration
	 * 
	 * @param driver
	 * @param by
	 * @param duration
	 */
	protected static void waitForVisibility(WebDriver driver, By by, int duration) {
		for (int x = 0; x <= 5; x++) {
			try {
				new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(by));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method loadResponseFromJSONFile().
	 * 
	 * @param
	 * @param
	 * @param
	 */
	@SuppressWarnings("rawtypes")
	public Map loadResponseFromJSONFile() {
		JsonParser jsonParser = new JsonParser();
		try {
			Object obj = jsonParser.parse(new FileReader("src\\main\\resources\\JsonInput.json"));
			JsonObject jsonObject = (JsonObject) obj;
			JsonInput = createHashMapFromJsonString(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return JsonInput;

	}

	
	@SuppressWarnings("rawtypes")
	public Map loadResponseFromJSONFile(String FilePath) {
		JsonParser jsonParser = new JsonParser();
		try {
			Object obj = jsonParser.parse(new FileReader(FilePath));
			JsonObject jsonObject = (JsonObject) obj;
			JsonInput = createHashMapFromJsonString(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return JsonInput;

	}
	
	
	/**
	 * Method createHashMapFromJsonString().
	 * 
	 * @param
	 * @param
	 * @param match
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static HashMap<String, Object> createHashMapFromJsonString(String json) {
		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(json);
		Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		HashMap<String, Object> map = new HashMap<String, Object>();

		while (iterator.hasNext()) {

			Map.Entry<String, JsonElement> entry = iterator.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();

			if (null != value) {
				if (!value.isJsonPrimitive()) {
					if (value.isJsonObject()) {

						map.put(key, createHashMapFromJsonString(value.toString()));
					} else if (value.isJsonArray() && value.toString().contains(":")) {

						List<HashMap<String, Object>> list = new ArrayList();
						JsonArray array = value.getAsJsonArray();
						if (null != array) {
							for (JsonElement element : array) {
								list.add(createHashMapFromJsonString(element.toString()));
							}
							map.put(key, list);
						}
					} else if (value.isJsonArray() && !value.toString().contains(":")) {
						map.put(key, value.getAsJsonArray());
					}
				} else {
					map.put(key, value.getAsString());
				}
			}
		}
		return map;
	}
	
	
	/*  public void testClassAttivaComboBox() {

	      WebElement classAttivaComboBox = getElement(driver, By.xpath("//*[contains(@id,'classAttivaComboBox')]"));

	      if (classAttivaComboBox.isEnabled()) {
	        classAttivaComboBox.click();
	        WebElement labelContainer = getElement(driver, By.xpath("//*[contains(@id,'classAttivaComboBox_menu')]/tbody"));
	        List<WebElement> labels = getListOfElements(labelContainer,
	            By.cssSelector("*[class='dijitReset dijitMenuItem']"));

	        AssertJUnit.assertTrue(labels.size() > 0);// combox values present
	        String classAttivaComboBoxValue = labels.get(1).getText();
	        labels.get(1).click();
	        AssertJUnit.assertEquals(classAttivaComboBoxValue, classAttivaComboBox.getText());
	      }
	  	    }*/


}
