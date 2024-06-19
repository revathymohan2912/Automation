package AmazonTestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.BaseClass;

public class NewTestCasesGroup extends BaseClass{
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browzer")
	public void initialization(String browzer) throws Exception {
		
		driver = browzerInitialization(browzer);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("Before Method Example");
	}
@Test(groups = {"RegressionTest"})
public void tc001() {
	System.out.println("TC001");
}
@Test(groups = {"RegressionTest"})
public void tc002() {
	System.out.println("TC002");
}
@Test(groups = {"RegressionTest"})
public void tc003() {
	System.out.println("TC003");
}
@Test(groups = {"SmokeTest"})
public void tc004() {
	System.out.println("TC004");
}
@Test(groups = {"SmokeTest"})
public void tc005() {
	System.out.println("TC005");
}
@BeforeGroups(groups = "SmokeTest")
public void beforeGroupExample() {
	System.out.println("Before GRoup Example");
}
@AfterGroups(groups = "SmokeTest")
public void afterGroupExample() {
	System.out.println("After Group Example");
}
}
