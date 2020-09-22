package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
private static WebDriver driver;
	
	public static WebDriver GetDriver()
	{
		DesiredCapabilities dc =DesiredCapabilities.chrome();
		
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions co=new ChromeOptions();
		co.merge(dc);
		System.setProperty("webdriver.chrome.driver","E:\\Automation_softwares _and_jar_files\\chrome\\chromedriver.exe");
		
		if(driver == null){
			
			driver = new ChromeDriver(co);
			
		}
		return driver;
		
	}
	
	
	
	
	public void cmd(String sendKeys) throws Exception
	{
		
	   WebDriverWait wait=new WebDriverWait(driver,60);
      
		String sk=sendKeys;
		Actions a = new Actions(driver);
		WebElement se = driver.findElement(By.linkText("Search"));
		a.moveToElement(se).perform();

		driver.findElement(By.linkText("Command Line Search")).click();
		driver.navigate().refresh();
         
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='onoffswitch-label']")));
		 driver.findElement(By.xpath("//label[@class='onoffswitch-label']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//textarea[@id='txtSpellCheck']")).clear();
		driver.findElement(By.xpath("//textarea[@id='txtSpellCheck']")).sendKeys(sk);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='searchId']")).click();
		
	}
	
	public void quick()
	{
		
	}

}
