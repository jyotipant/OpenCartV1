package baseClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
//import java.util.logging.LogManager;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException 
	{
		p=new Properties();
		FileReader file= new FileReader("./src//test//resources//config.properties");
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
			case "chrome" :driver = new ChromeDriver();
			break;
			case "edge" :driver = new EdgeDriver();
			break;
			case "firefox" :driver = new FirefoxDriver();
			break;
			default : System.out.println("invalid browser");
			return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.navigate().refresh();
		//to get the current url on which user is working
		System.out.println(driver.getCurrentUrl());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
	public String randomString()
	{
		String s = RandomStringUtils.randomAlphabetic(8); 
		return s;
	}
	
	public String randomNumber()
	{
		String r = RandomStringUtils.randomNumeric(10);
		return r;
	}
	
	public String randomAlphaNumeric()
	{
		String s = RandomStringUtils.randomAlphabetic(8); 
		String r = RandomStringUtils.randomNumeric(10);
		return (s+"@"+r);
	}

}
