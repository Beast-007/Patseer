package SearchSide;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class testingg extends BaseTest
{
	
    
	
		@Test(dataProvider="testdata")
		public void getlogin(String un,String pass) throws Exception
		{
			GetDriver();
		    		
			GetDriver().get("https://acc.patseer.com");
			GetDriver().findElement((By.xpath("//input[@id='LoginForm:loginName']"))).sendKeys(un.toString());
			GetDriver().findElement(By.xpath("//input[@id='LoginForm:password']")).sendKeys(pass.toString());
			GetDriver().findElement(By.xpath("//a[@id='LoginForm:submitButton']")).click();
				
		}
		@DataProvider(name="testdata")
		public Object[][] data()
		{
			Object[][] ob=new Object[2][2];
			
			ob[0][0]="stephen";
			ob[0][1]="pass";
			ob[1][0]="stephen@patentinsightpro.com";
			ob[1][1]="771baner";
			
			return ob;
			
		}
		
		
		
		
		

}
