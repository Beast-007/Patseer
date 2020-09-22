package SearchSide;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectSide extends BaseTest{
	 String patseerh="";
	@Test
	public void checkFamilyMemberStatus() throws Exception
	
	{
		GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		GetDriver().findElement(By.xpath("//*[@id='token-input-txtProjectNameHomeClientId']")).sendKeys("ProjectSideAutomation");
		Thread.sleep(500);
		GetDriver().findElement(By.xpath("//*[@id='token-input-txtProjectNameHomeClientId']")).sendKeys(Keys.ENTER);
		
          WebDriverWait wait=new WebDriverWait(GetDriver(),60);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='lblText_US6000000A']")));
         patseerh=GetDriver().getWindowHandle();
          GetDriver().findElement(By.xpath("//*[@id='lblText_US6000000A']")).click();
		Set <String> l=GetDriver().getWindowHandles();
		
		
		for (String i : l) {																	
			if (!i.equals(patseerh)) {		
			
			GetDriver().switchTo().window(i);
			
			}
			
			}
		//biblio
		GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();
		if(GetDriver().findElement(By.xpath("//span[@class='ignoreP ng-binding']//p[contains(text(),'Computers (110,150) are connected by a data commun')]")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"looking for -Computers (110,150) are connected by a data communication link.-dint find");
			}
		
		//claims
		GetDriver().findElement(By.cssSelector("#claimsTab")).click();
		if(GetDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_detailsViewCntrl_claimsCntrl_txtClaims']//p[contains(text(),'1. A method of sharing information on a first comp')]")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"looking for -1. A method of sharing information on a first comp.-dint find");
			}
		
		//mosaic
		GetDriver().findElement(By.xpath("//a[@id='ui-id-20']")).click();
		GetDriver().switchTo().frame(GetDriver().findElement(By.id("IfrMosic")));
		if(GetDriver().findElement(By.xpath("//img[@id='imagebox_US6000000A_0']")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"Mosaic not loaded");
			}
		GetDriver().switchTo().defaultContent();
		//family
		
		GetDriver().findElement(By.xpath("//a[@id='ui-id-21']")).click();
		GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamily")));
		if(GetDriver().findElement(By.xpath("//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[1]//i[1]")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"family member status not loading ");
			}
		GetDriver().switchTo().defaultContent();
		//citations
		GetDriver().findElement(By.xpath("//a[@id='ui-id-22']")).click();
		GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmBackCitation")));
		if(GetDriver().findElement(By.xpath("//label[@id='lblText_US5867821A']")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"Citations not loading ");
			}
		GetDriver().switchTo().defaultContent();
		
		//similar records
		GetDriver().findElement(By.xpath("//a[@id='ui-id-23']")).click();
		
		if(GetDriver().findElement(By.xpath("//label[@id='lblText_US7620584B2']")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"similar records not loading ");
			}
		
		//comments
		GetDriver().findElement(By.xpath("//a[@id='ui-id-25']")).click();
		if(GetDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailsViewContainer']//div[@id='commentsPanel']//h5[contains(@class,'chat-bold ng-binding')][contains(text(),'Existing Comments')]")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"comments not loading ");
			}
		
		//fullview
		
		GetDriver().findElement(By.xpath("//a[@id='ui-id-26']")).click();
		if(GetDriver().findElement(By.xpath("//annot-title[contains(text(),'Extendible method and apparatus for synchronizing')]")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"fullview not loading ");
			}
		
		//summary
		GetDriver().findElement(By.xpath("//a[@id='ui-id-27']")).click();
		if(GetDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailsViewContainer']//span[contains(@class,'subTitle')][contains(text(),'Object of Invention:')]")).isDisplayed())
		{
			
			
		}
		else {
			Assert.assertTrue(false,"Summary not loading ");
			}
		
		
		
		
		
	}
	
	

}
