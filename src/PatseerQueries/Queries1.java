package PatseerQueries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Queries1 extends BaseTest{
	
	
	WebDriverWait wait=new WebDriverWait(GetDriver(),60);
	Actions a=new Actions(GetDriver());
	 int get=1;
	 int c=0;
	@Test(dataProvider="querydata")
	public void test_Queries(String sk) throws Exception
	{
		GetDriver().navigate().refresh();
		if(!GetDriver().getCurrentUrl().contains("command"))
		{
		Thread.sleep(1000);
		WebElement se = GetDriver().findElement(By.linkText("Search"));
		 a.moveToElement(se).perform();
		 GetDriver().findElement(By.linkText("Command Line Search")).click();
		 GetDriver().navigate().refresh();
		}
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='onoffswitch-label']")));
		 GetDriver().findElement(By.xpath("//label[@class='onoffswitch-label']")).click();
		 GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).clear();
		 GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).sendKeys(sk);
		 System.out.println(sk);
		 Thread.sleep(1000);
		 GetDriver().findElement(By.xpath("//a[contains(text(),'Get Count')]")).click();
		 Thread.sleep(500);
		 try
		 {
			 GetDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).isDisplayed())
		 {
			 c=1;
		 }
		   GetDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }catch (Exception e)
	{
		c=0;
	}
		 if(c!=1)
		 {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ContentPlaceHolder1_lblCntrl_lblSearchCount']")));
		  String getcount=GetDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_lblCntrl_lblSearchCount']")).getText();
		  String ar[]=getcount.split(" ");
		  get=Integer.parseInt(ar[0]);
		  c=0;
		 }
		
		  if(get>1)
		 {
			  get=1;
			 Assert.assertTrue(true);
		 }
		 else if(get==0)
			{
				Thread.sleep(500);
				
					c=0;
					System.out.println("######################################## in 0th loop");
					get=10010101;
					System.out.println(sk);
					System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
					a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
					GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
					Assert.assertTrue(false,"this query is giving 0 records ");
					System.out.println("######################################## in 0th loop");
				
			}
			
			else if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).isDisplayed() || c==1)
			{
						if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().contains("Field Code Missing"))
						{
							c=0;
						System.out.println("########################################### in field code Missing");
						
						System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
						a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
						GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
						Assert.assertTrue(false);
						System.out.println("########################################### in field code Missing");
						}
						else if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().contains("Invalid search query!"))
						{
							c=0;
							System.out.println("########################################### in Invalid Search Query");
							
							System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
							a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
							GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
							Assert.assertTrue(false);
							System.out.println("########################################### in Invalid Search Query");
							
							
						}
						else if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().contains("Invalid field code"))
						{
							c=0;
							System.out.println("########################################### in invalid field code ");
							
							System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
							a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
							GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
							Assert.assertTrue(false);
							System.out.println("########################################### in invalid field code ");
							
		
						}
			}
			
			

		 
	}
	
	
	
	
	@DataProvider(name="querydata")
	public Iterator<Object[]> testdata() throws Exception
	{
		FetchData fetchd=new FetchData();
		ArrayList<Object[]> al=fetchd.fetch();
		return al.iterator();
		
	}

}
