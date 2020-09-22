package PatseerQueries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PatseerQueries.BaseTest;


	public class Login extends BaseTest{
		
		@Test
		@Parameters({"URL","UName","Password"})
		public void login(String Url,String Uname,String Pass) throws Exception
		 {
			System.out.println("logging in***************************************************************");
			
		GetDriver().get(Url);
		GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    
		GetDriver().findElement(By.id("LoginForm:loginName")).sendKeys(Uname);
		GetDriver().findElement(By.id("LoginForm:password")).sendKeys(Pass);
		GetDriver().findElement(By.id("LoginForm:submitButton")).click();
		Thread.sleep(1000);

		String title = GetDriver().getTitle();
		try {
			if (title !="https://app.patseer.com/Home")
			{
				GetDriver().findElement(By.id("LoginForm:submitButton")).click();

			}
		} catch (Exception e) 
		{

		}

		
	   }
	

}
