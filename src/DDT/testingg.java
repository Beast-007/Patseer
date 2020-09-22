package DDT;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class testingg extends BaseTest
{
	
    
	
		@Test(dataProvider="loginData")
		public void getlogin(String un,String pass,String city,String pin,String area,String country) throws Exception
		{
			GetDriver().navigate().refresh();
		    		
			GetDriver().get("https://acc.patseer.com");
			GetDriver().findElement((By.xpath("//input[@id='LoginForm:loginName']"))).sendKeys(un.toString());
			GetDriver().findElement(By.xpath("//input[@id='LoginForm:password']")).sendKeys(pass.toString());
			GetDriver().findElement(By.xpath("//a[@id='LoginForm:submitButton']")).click();
				
		}
		@DataProvider(name="loginData")
		public Iterator<Object[]> data() throws Exception
		{
			ArrayList<Object[]> alist=FetchData.login();
			
			return alist.iterator();
		}
		
		
		
		
		

}
