package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Logger logger; // For Logging
	public WebDriver driver;
	public ResourceBundle rb;
	public String browserName; 
	
	/*

	@BeforeClass(groups = {"master", "sanity", "regression", "smoke"})
	@Parameters({ "browser" })
	public void setup(String br) {
		if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			browserName= "Edge Browser"; 
		} else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			browserName = "Firefox Browser"; 
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			browserName = "Chrome Browser";
		}
		
		logger = LogManager.getLogger(this.getClass());// log
		// Load the properties file
		rb = ResourceBundle.getBundle("config");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	*/
	
	
	
	@BeforeClass(groups = {"master", "sanity", "regression", "smoke"})
	public void setup() {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			browserName = "Chrome Browser";
		
		logger = LogManager.getLogger(this.getClass());// log
		// Load the properties file
		rb = ResourceBundle.getBundle("config");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass(groups = {"master", "sanity", "regression", "smoke"})
	public void tearDown()
	{
	driver.quit();
	}

	public String generateRandomString(int length) {
		UUID random = UUID.randomUUID();
		return random.toString().replaceAll("-", "").substring(0, length);
	}

	public int generateRandomNumber(int length) {
		return Integer.parseInt(RandomStringUtils.randomNumeric(length));

	}
	

	
	
	public void  takeScreenShot(String mathodName, WebDriver driver) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String loc = System.getProperty("user.dir") + "//screenshots//" + mathodName + ".png";
		File target = new File(loc); 
		FileUtils.copyFile(source, target);
		
		
	}
	
	
	
	
	
	

	
	
}
