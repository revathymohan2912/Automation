package AmazonTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.BaseClass;

public class AmazonTest extends BaseClass{
	public WebDriver driver;
	SoftAssert softassert;
	@BeforeMethod
	@Parameters("browzer")
	public void initialization(String browzer) throws Exception {
		
		driver = browzerInitialization(browzer);
		softassert = new SoftAssert();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("Before Method Example");
	}
	
	@Test(priority = 3)
	public void tc01() throws InterruptedException {
		System.out.println("tc 1");
	
	//want to navigate another page
	driver.navigate().to("https://www.amazon.in/s?bbn=81107432031&rh=n%3A81107432031%2Cp_85%3A10440599031&_encoding=UTF8&content-id=amzn1.sym.58c90a12-100b-4a2f-8e15-7c06f1abe2be&pd_rd_r=7a336c83-07cd-43dd-a8cc-cc0b299fb8d3&pd_rd_w=JqrnM&pd_rd_wg=LRd6X&pf_rd_p=58c90a12-100b-4a2f-8e15-7c06f1abe2be&pf_rd_r=T75F64Q8KAP1S2KDY8F8&ref=pd_hp_d_atf_unk");
//Navigational Commands
	/*driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();*/
//Closing and Quitting
	/*driver.close();
	driver.quit();*/
//locators	
	/*driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");	//id, senKeys used to input a value
	driver.findElement(By.name("field-keywords")).clear();					//name
	driver.findElement(By.className("nav-input nav-progressive-attribute")).sendKeys("Samsung");	//class name
	//driver.findElement(By.tagName("input"));								//tagname
	driver.findElement(By.linkText("Shop on Amazon Business")).click();		//link text
	driver.findElement(By.partialLinkText("Conditions of")).click();		//partial link text
	*/
//findElement() & findElements()
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart tv");
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	int productsize = products.size();
	System.out.println("No of Products = "+productsize);
	softassert.assertEquals(productsize, 24);
	
//actions	
	/*Actions action = new Actions(driver);			//obj created for actions class
	action.contextClick().build().perform();		//right clicking
	action.doubleClick(driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]"))).build().perform();		//double click
	*/
	
	//driver.findElement(By.xpath("//span[text()='Xiaomi 125 cm (50 inches) X 4K Dolby Vision Series Smart Google TV L50M8-A2IN (Black)']")).click();

//Basic Web Element Commands	
	String value = driver.findElement(By.xpath("//span[text()='Deals & Discounts']")).getText();
	System.out.println(value);
	softassert.assertEquals(value, "Deals & Discounts");
	String value2 = driver.findElement(By.xpath("//span[text()='Deals & Discounts']")).getTagName();
	System.out.println(value2);
	softassert.assertEquals(value2, "span");
	String value3 = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("name");	
	System.out.println(value3);
	softassert.assertEquals(value3, "field-keywords");
	//driver.findElement(By.id("twotabsearchtextbox")).clear();
//Dropdown
	/*driver.navigate().to("https://demo.guru99.com/test/newtours/register.php");
	WebElement dropdown = driver.findElement(By.name("country"));
	Select obj = new Select(dropdown);
	//obj.selectByValue("ANGOLA");
	obj.selectByVisibleText("ANTARCTICA");*/	
//for dropdown selection with xpath
	//driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
	//driver.findElement(By.id("s-result-sort-select_2")).click();
//Drag & Drop	
	/*driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
	WebElement source = driver.findElement(By.id("column-a"));
	WebElement target = driver.findElement(By.id("column-b"));
	Actions action = new Actions(driver);
	//action.dragAndDrop(source, target).build().perform();
//mouseOvering	
	driver.navigate().to("https://www.amazon.in/ref=nav_logo");
	WebElement signInBox = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
	action.moveToElement(signInBox).build().perform();*/		//mouseOvering
	
	/*driver.navigate().to("https://www.91mobiles.com/phonefinder.php");
//radioButtonSelection & checkBox Selection
	driver.findElement(By.id("latestandexpectprice1000002000001")).click();	//radioButtonSelection
	driver.findElement(By.id("latestandexpectprice2000003000001")).click();	//radioButtonSelection
	driver.findElement(By.id("mobraminmb614401000000")).click();			//checkBox Selection
	
//isSelected()
		boolean buttonSelectedStatus = driver.findElement(By.id("mobraminmb614401000000")).isSelected();
		System.out.println("isSelected="+buttonSelectedStatus);
		
//isDsplayed()
	boolean pricerangeboxVarification = driver.findElement(By.xpath("//div[contains(@class,'price_tag_finder new-finder-left')]")).isDisplayed();
	System.out.println(pricerangeboxVarification);						//isDsplayed()
	//driver.findElement(By.xpath("//input[@id='oneplus2120']")).click();
	//driver.findElement(By.id("samsung157")).click();
	//boolean marketStatusVerification = driver.findElement(By.xpath("//div[@class='new-finder-left heading_block' and @data-header='Market Status']")).isDisplayed();
	//System.out.println("2"+marketStatusVerification);
	//boolean marketStatusVerification2 = driver.findElement(By.xpath("//div[@class='_block'")).isDisplayed();
	//System.out.println("3"+marketStatusVerification2);
	
//isEnabled()
	/*driver.get("https://www.amazon.in/");
	Thread.sleep(3000);
	boolean buyNowButtonStatus = driver.findElement(By.id("nav-search-submit-button")).isEnabled();
	System.out.println(buyNowButtonStatus);
	*/
//ALERT HANDLING
	/*driver.navigate().to("https://demo.guru99.com/test/delete_customer.php");
	driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123");
	driver.findElement(By.name("submit")).click();
	driver.switchTo().alert().accept();	//accepting the alert
	driver.switchTo().alert().accept();	
	/*driver.findElement(By.name("cusid")).sendKeys("987456");
	driver.findElement(By.name("submit")).click();
	driver.switchTo().alert().dismiss();*/	//dismissing the alert
	
	//driver.navigate().to("https://selenium.qabible.in/");
	
	softassert.assertAll();
	}
@Test(priority = 2)
	public void tc02() throws InterruptedException {
	System.out.println("tc 02");
	//WINDOW HANDLING
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	driver.findElement(By.id("nav-search-submit-button")).click();
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));		//explicit wait
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']")));
		
	driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']")).click();
	String parent = driver.getWindowHandle();		//store the address of current window
	Set<String> s = driver.getWindowHandles();		//store the addresses of all windows in a set
	Iterator<String> i1 = s.iterator();
	while(i1.hasNext()){
		String childWindow = i1.next();
		if(!parent.equals(childWindow)) {
			driver.switchTo().window(childWindow);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span[@id='submit.add-to-cart'])[2]")).click();
		}
	}
	driver.switchTo().window(parent);
	Thread.sleep(2000);
	driver.navigate().refresh();
	//Handling Frames
	/*driver.navigate().to("https://demoqa.com/frames");
	driver.switchTo().frame("frame1");		//driver inside frame
	String text = driver.findElement(By.id("sampleHeading")).getText();
	System.out.println(text);
	driver.switchTo().defaultContent();	
	*/
	//TABLE HANDLING
	driver.navigate().to("https://selenium.qabible.in/table-sort-search.php");
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Bruno");
	String age = driver.findElement(By.xpath("(//tr[@class='odd']//td)[4]")).getText();
	System.out.println(age);
	driver.findElement(By.xpath("//input[@type='search']")).clear();
	driver.navigate().refresh();
	List<WebElement> data = driver.findElements(By.xpath("//tr[@class='odd' or @class ='even']//td"));
	ArrayList<String> value1 = new ArrayList<String>();
	for(int i=0; i<data.size(); i++) {
		//String elementText = data.get(i).getText();
		value1.add(data.get(i).getText());
		
		}
	//System.out.println(value1);
	String name = value1.get(5);
	System.out.println(name);
	System.out.println("...........");
	System.out.println(value1);
	
	ArrayList<String> value2 = new ArrayList<String>();

	value2.add("Airi Satou");
	value2.add("Accountant");
	value2.add("Tokyo");
	value2.add("33");
	value2.add("2008/11/28");
	value2.add("$162,700");
	
	value2.add("Angelica Ramos");
	value2.add("Chief Executive Officer (CEO)");
	value2.add("London");
	value2.add("47");
	value2.add("2009/10/09");
	value2.add("$1,200,000");

	value2.add("Ashton Cox");
	value2.add("Junior Technical Author");
	value2.add("San Francisco");
	value2.add("66");
	value2.add("2009/01/12");
	value2.add("$86,000");
	
	value2.add("Bradley Greer");
	value2.add("Software Engineer");
	value2.add("London");
	value2.add("41");
	value2.add("2012/10/13");
	value2.add("$132,000");
	
	value2.add("Brenden Wagner");
	value2.add("Software Engineer");
	value2.add("San Francisco");
	value2.add("28");
	value2.add("2011/06/07");
	value2.add("$206,850");
	
	value2.add("Brielle Williamson");
	value2.add("Integration Specialist");
	value2.add("New York");
	value2.add("61");
	value2.add("2012/12/02");
	value2.add("$372,000");
	
	value2.add("Bruno Nash");
	value2.add("Software Engineer");
	value2.add("London");
	value2.add("38");
	value2.add("2011/05/03");
	value2.add("$163,500");

	value2.add("Caesar Vance");
	value2.add("Pre-Sales Support");
	value2.add("New York");
	value2.add("21");
	value2.add("2011/12/12");
	value2.add("$106,450");

	value2.add("Cara Stevens");
	value2.add("Sales Assistant");
	value2.add("New York");
	value2.add("46");
	value2.add("2011/12/06");
	value2.add("$145,600");


	value2.add("Cedric Kelly");
	value2.add("Senior Javascript Developer");
	value2.add("Edinburgh");
	value2.add("22");
	value2.add("2012/03/29");
	value2.add("$433,060");	
	
	System.out.println(value2);
	
	boolean compareValue = value1.equals(value2);
	System.out.println(compareValue);
	
	}
@Test(priority = 1)
	public void tc03() {
	System.out.println("tc 03");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart tv");
	//driver.findElement(By.id("nav-search-submit-button")).click();
	WebElement element = driver.findElement(By.id("nav-search-submit-button"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	//page scrolling
	executor.executeScript("window.scrollBy(0,1000)", " ");
	
	List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	int productsize = products.size();
	System.out.println("No of Products = "+productsize);
	Assert.assertEquals(productsize, 24);		//hard assert
	
	}
@BeforeSuite
public void beforeSuiteExample() {
	System.out.println("Before Suite Example");
}
@AfterSuite
public void afterSuiteExample() {
	System.out.println("After Suite Example");
}
@BeforeTest
public void beforeTestExample() {
	System.out.println("Before Test Example");
}
@AfterTest
public void afterTestExample() {
	System.out.println("After Test Example");
}
@AfterMethod
public void afterMethodExample() {
	System.out.println("After Method Example");
	//driver.quit();
}
@BeforeClass
public void beforeClassExample() {
	System.out.println("Before Class Example");
}
@AfterClass
public void afterClassExample() {
	System.out.println("After Class Example");
}
//Using DATA PROVIDER
@Test(dataProvider = "testData")
public void tc04(String value1, String value2) {
	driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
	driver.findElement(By.id("value-a")).sendKeys(value1);
	driver.findElement(By.id("value-b")).sendKeys(value2);
	driver.findElement(By.id("button-two")).click();	
}
@DataProvider(name = "testData")
public Object[][] testDataFeed(){
	Object[][] dataSet = new Object[2][2];
	dataSet[0][0] = "5";
	dataSet[0][1] = "1";
	dataSet[1][0] = "6";
	dataSet[1][1] = "2";
	return dataSet;
}

}
