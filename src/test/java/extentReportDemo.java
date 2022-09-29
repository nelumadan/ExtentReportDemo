import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportDemo
{
	ExtentReports extent;
	ExtentSparkReporter sparkReporter;
	
	@BeforeSuite
	public void BeforeSuite()
	{
		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("report.html");
		extent.attachReporter(sparkReporter);
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		extent.flush();
	}
	
	@Test
	public void extentReport1()
	{
		ExtentTest test = extent.createTest("TC1_extentReport1");
		System.setProperty("webdriver.chrome.driver", "/Users/Neelam/eclipse-workspace/ExtentReportDemo/chromedriver");
		test.log(Status.INFO, "Launching Chrome Browser");
		WebDriver driver = new ChromeDriver();
		test.info("Opening URL in Browser");
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test.pass("GoogleSearch successfull");
		test.info("Closing the Browser");
		driver.close();
		test.info("Quitting the session");
		driver.quit();
		
	}
	
	@Test
	public void extentReport2()
	{
		ExtentTest test = extent.createTest("TC2_extentReport2");
		System.setProperty("webdriver.chrome.driver", "/Users/Neelam/eclipse-workspace/ExtentReportDemo/chromedriver");
		test.log(Status.INFO, "Launching Chrome Browser");
		WebDriver driver = new ChromeDriver();
		test.info("Opening URL in Browser");
		driver.get("https://www.google.com");
		try
		{
			driver.findElement(By.name("p")).sendKeys("abcd");
		}
		catch(NoSuchElementException e)
		{
			test.fail("Unable to enter searchtext");
		}
		test.pass("GoogleSearch successfull");
		test.info("Closing the Browser");
		driver.close();
		test.info("Quitting the session");
		driver.quit();

	}
	

}
