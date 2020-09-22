package PatseerQueries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Queries extends BaseTest{
	
	int get;
	int get2=1100110011;
	int c=1;
	
	@Test(dataProvider="querydata")
	public void test_Queries(String sk) throws Exception
	{	
		System.out.println("*************************************************InQueries***************************************************************");
		
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(GetDriver(),60);
		Actions a=new Actions(GetDriver());
		  if(!GetDriver().getCurrentUrl().contains("command"))
	  {
		 
			System.out.println(GetDriver().getCurrentUrl());
			
			WebElement se = GetDriver().findElement(By.linkText("Search"));
			a.moveToElement(se).perform();

			 GetDriver().findElement(By.linkText("Command Line Search")).click();
			 GetDriver().navigate().refresh();
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@class='onoffswitch-label']")));
			 GetDriver().findElement(By.xpath("//label[@class='onoffswitch-label']")).click();
			 GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).clear();
			 GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).sendKeys("T:motor and engine and shaft");
			 System.out.println(sk);
				Thread.sleep(1000);
			 GetDriver().findElement(By.xpath("//a[contains(text(),'Get Count')]")).click();
				Thread.sleep(2000);
								
	 }
		
	else{
			
			Thread.sleep(100);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='ContentPlaceHolder1_lblCntrl_lblSearchCount']")));
					while(1>0)
					{
						String getcount=GetDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_lblCntrl_lblSearchCount']")).getText();
						String ar[]=getcount.split(" ");
						if(c==1)
						{
						get=Integer.parseInt(ar[0]);
						c=1;
						}
						else
						{
							get=10010101;
							c=1;
						}
								if(get!=get2 || get==0)
								{
									Thread.sleep(500);
									if(get==0)
									{
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
									break;
									 
								}
								
								else if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).isDisplayed() && GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().contains("Field Code Missing"))
								{
									System.out.println("########################################### in field code Missing");
									get2=1100110011;
									System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
									a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
									GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
									Assert.assertTrue(false);
									System.out.println("########################################### in field code Missing");
									break;
								}
								else if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).isDisplayed() && GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().contains("Invalid search query!"))
								{
									System.out.println("########################################### in Invalid Search Query");
									get2=1100110011;
									System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
									a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
									GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
									Assert.assertTrue(false);
									System.out.println("########################################### in Invalid Search Query");
									break;
									
								}
								else if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).isDisplayed() && GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().contains("Invalid field code"))
								{
									System.out.println("########################################### in invalid field code ");
									get2=1100110011;
									System.out.println(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText());
									a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']"))).build().perform();
									GetDriver().findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
									Assert.assertTrue(false);
									System.out.println("########################################### in invalid field code ");
									break;

								}
								
								
								
								
								
					Thread.sleep(500);
					}
					
				    get2=get;
					
			GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).clear();
			GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).sendKeys(sk);
			System.out.println(sk);
			Thread.sleep(500);
			GetDriver().findElement(By.xpath("//a[contains(text(),'Get Count')]")).click();
			
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
