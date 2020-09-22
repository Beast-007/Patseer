package SearchSide;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultPage extends BaseTest{
	
	Properties prop;
	FileInputStream fis;
	
	@Test
	public void configure() throws Exception
	{
		prop=new Properties();
		fis=new FileInputStream("E:\\Automation_softwares _and_jar_files\\eclipse-workspace\\PatseerS\\src\\SearchSide\\PatseerConfig.properties");
		prop.load(fis);
	}
	
	
	
	
	@Test
	public void Check_Full_text_filter() throws Exception
	{
		GetDriver();
		GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		cmd(prop.getProperty("query"));
		GetDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(GetDriver(), 100);
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("addnewfiltericon"))));
		
			JavascriptExecutor js=(JavascriptExecutor) GetDriver();	
			js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath(prop.getProperty("addnewfiltericon"))));	
			Actions a=new Actions(GetDriver());
			Thread.sleep(2000);
			
		WebElement f=GetDriver().findElement(By.xpath("//a[@class='dropdown-item col-xs-12 col-sm-12 col-md-12 col-lg-12 combine_menu combineMenuPadding bg_textEng']"));
		
		a.moveToElement(f).perform();
		Thread.sleep(1000);
		GetDriver().findElement(By.xpath("//span[contains(text(),'FullText (TACD)')]")).click();
			
			GetDriver().findElement(By.xpath("//span[@id='ResultQueryPreview']")).click();
			
			GetDriver().findElement(By.xpath(prop.getProperty("fulltextfilter"))).click();
			Thread.sleep(2000);
			
			GetDriver().findElement(By.xpath("//label[contains(text(),'contains')]//input[@name='optText_1']")).click();
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_TAB);
			r.delay(100);
			a.sendKeys(Keys.chord("jet")).build().perform();
			
			GetDriver().findElement(By.xpath(prop.getProperty("apply_filter"))).click();
			
			Thread.sleep(3000);
			
			if(GetDriver().findElement(By.xpath("//div[@class='div-result-action-NoPointer dra-buttons']//span[@class='ng-binding'][contains(text(),'3')]")).getText().contains("3"))
			{
				//Assert.assertTrue(true);
			}
			
			else
			{
				Assert.assertTrue(false,"tacd filter not working properly");
			}
			
			GetDriver().findElement(By.xpath("//label[contains(text(),\"doesn't contain\")]//input[@name='optText_1']")).click();
			r.keyPress(KeyEvent.VK_TAB);
			r.delay(100);
			r.keyRelease(KeyEvent.VK_TAB);
			r.delay(100);
			a.sendKeys(Keys.chord("jet")).build().perform();
			
			GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();
			GetDriver().findElement(By.xpath("//span[contains(@class,'ng-binding')][contains(text(),'FullText')]")).click();
			
			if(GetDriver().findElement(By.xpath("//div[@class='div-result-action-NoPointer dra-buttons']//span[@class='ng-binding'][contains(text(),'7')]")).getText().contains("7"))
			{
				Assert.assertTrue(true);
			}
			
			else
			{
				Assert.assertTrue(false,"tacd filter not working properly");
			}
		

			
		
	}
	
	@Test
	public void Check_Current_Owner_Filter() throws Exception
	{
		GetDriver().navigate().refresh();
		GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		JavascriptExecutor js=(JavascriptExecutor) GetDriver();	
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//span[@class='patseer_Secondary_Button filterClearBtn ng-scope']")));	
		
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//span[contains(@class,'mdi mdi-filter-plus')]")));	
		Actions a=new Actions(GetDriver());
		Thread.sleep(2000);
		
		
	WebElement f=GetDriver().findElement(By.xpath("//a[@class='dropdown-item col-xs-12 col-sm-12 col-md-12 col-lg-12 combine_menu combineMenuPadding bg_parties']"));
	
	 a.moveToElement(f).perform();
	Thread.sleep(1000);
	GetDriver().findElement(By.xpath("//span[contains(text(),'Current Owner (PASN)')]")).click();
		
		GetDriver().findElement(By.xpath("//span[@id='ResultQueryPreview']")).click();
		GetDriver().findElement(By.xpath("//div[contains(@class,'summaryHeader sr_backColor')]//span[contains(@class,'ng-binding')][contains(text(),'Current Owner')]")).click();
		Thread.sleep(1000);
	
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.SPACE).build().perform();
	
		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();
		
		if(GetDriver().findElement(By.xpath("//div[contains(@class,'div-result-action-NoPointer dra-buttons')]//span[contains(@class,'ng-binding')][contains(text(),'2')]")).getText().contains("2"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(false,"current assignee filter not working properly");
		}
	
		
	}
	
	@Test
	public void Check_CPC_Filter() throws Exception
	{
		GetDriver();
		GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		JavascriptExecutor js=(JavascriptExecutor) GetDriver();	
		GetDriver().navigate().refresh();

	js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//span[@class='patseer_Secondary_Button filterClearBtn ng-scope']")));	
		
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//span[contains(@class,'mdi mdi-filter-plus')]")));	
		Actions a=new Actions(GetDriver());
		Thread.sleep(2000);
		
		
	WebElement f=GetDriver().findElement(By.xpath("//a[@class='dropdown-item col-xs-12 col-sm-12 col-md-12 col-lg-12 combine_menu combineMenuPadding bg_classes']"));
	
	 a.moveToElement(f).perform();
	Thread.sleep(1000);
	GetDriver().findElement(By.xpath("//span[contains(text(),'CPC Full (CPC)')]")).click();
		
		GetDriver().findElement(By.xpath("//span[@id='ResultQueryPreview']")).click();
		GetDriver().findElement(By.xpath("//span[@class='floatLeft combineEllipsis fl_width65 ng-binding'][contains(text(),'CPC Full')]")).click();
		Thread.sleep(1000);
	
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		a.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.SPACE).build().perform();
		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();
		if(GetDriver().findElement(By.xpath("//div[@class='div-result-action-NoPointer dra-buttons']//span[@class='ng-binding'][contains(text(),'2')]")).getText().contains("2"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(false,"CPC filter not working properly");
		}
	
		
	}
	@Test
	public void Check_LimitBy_In_Quick_Search() throws Exception
	{
		GetDriver().navigate().refresh();
		GetDriver().findElement(By.xpath("//body[@id='MASTERPAGEBODYID']/form[@id='form1']/div[@id='patseerHeader']/div[@id='headerCntrl_jquerylogoeffecthide']/div[@class='patseer_logo floatLeft patseerLogoMenuHeight patseerLogoMenuHeightGPS']/div[@id='headerCntrl_patseerLogoCntrl_divMenuCntrl']/ul[@class='dropdown homemenu floatLeft']/li[@id='headerCntrl_patseerLogoCntrl_liSearch']/a[1]")).click();
		WebDriverWait wait= new WebDriverWait(GetDriver(),80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtPatApp_0']")));
		GetDriver().findElement(By.xpath("//textarea[@id='txtPatApp_0']")).sendKeys("motor");
		GetDriver().findElement(By.xpath("//div[contains(@class,'floatLeft combinepadding combineBtnLimitAndAdd col-lg-2 row width18 SF_paddingLeft1')]//span[@id='btnPromptCancel']")).click();
		Thread.sleep(2000);
		GetDriver().findElement(By.xpath("//div[@id='currentStatFilterID']//h4[@class='modal-title'][contains(text(),'Limit By')]")).click();
		Thread.sleep(1000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.delay(100);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.delay(100);
		r.keyPress(KeyEvent.VK_SPACE);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.delay(200);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_TAB);
		r.delay(200);
		r.keyPress(KeyEvent.VK_A);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_A);
		Thread.sleep(4000);
		
		r.delay(100);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyPress(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_TAB);
		r.delay(100);
		r.keyPress(KeyEvent.VK_SPACE);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.delay(100);
		Thread.sleep(4000);
		GetDriver().findElement(By.xpath("//div[@id='currentStatFilterID']//div[contains(@class,'btn btn-primary patentFieldBtn1')][contains(text(),'Apply')]")).click();
		Thread.sleep(4000);
		String q=GetDriver().findElement(By.xpath("//body[@id='MASTERPAGEBODYID']/form[@id='form1']/div[contains(@class,'ui-widget')]/div[@id='divDisplay']/div[contains(@class,'master_middlepanel ui-widget-content patseermaster_middlepanel forclear')]/div[@id='search-ng-con-id']/div[@id='allSearchFormContainer']/div/div[contains(@class,'floatLeft width100 searchFormContjq CombineSearch')]/div[contains(@class,'floatLeft topSpacer p-searchform-container col-lg-9')]/div[@id='queryPreviewContainer']/div[@id='queryPreviewNG']/div[contains(@class,'CodeMirror cm-s-default CodeMirror-wrap')]/div[contains(@class,'CodeMirror-scroll')]/div[contains(@class,'CodeMirror-sizer')]/div/div[contains(@class,'CodeMirror-lines')]/div/div[contains(@class,'CodeMirror-code')]/pre[contains(@class,'CodeMirror-line')]/span[1]")).getText();
	
	if(q.contains("MITSUBISHI ELECTRIC CORP"))	
	{
		
		Assert.assertTrue(true);
		
	}
	else
	{
		Assert.assertTrue(false,"query not formed properly");
	}
	GetDriver().findElement(By.xpath("//a[contains(text(),'Get Count')]")).click();
		
		
	}
	
	@Test 
	public void check_Synonyms_Quick_Search() throws Exception
	{
		GetDriver();
		
		
		Robot r=new Robot();
		WebDriverWait wait= new WebDriverWait(GetDriver(),80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='MASTERPAGEBODYID']/form[@id='form1']/div[@id='patseerHeader']/div[@id='headerCntrl_jquerylogoeffecthide']/div[@class='patseer_logo floatLeft patseerLogoMenuHeight patseerLogoMenuHeightGPS']/div[@id='headerCntrl_patseerLogoCntrl_divMenuCntrl']/ul[@class='dropdown homemenu floatLeft']/li[@id='headerCntrl_patseerLogoCntrl_liSearch']/a[1]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtPatApp_0']")));
		GetDriver().findElement(By.xpath("//textarea[@id='txtPatApp_0']")).sendKeys("motor");
		Thread.sleep(1000);
		
		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(1000);
		Thread.sleep(1000);
		Actions a=new Actions(GetDriver());	
	
	a.moveToElement(GetDriver().findElement(By.xpath("//div[@class='textCls width100'][contains(text(),'vehicle')]"))).build().perform();
	Thread.sleep(1000);
		try{
			
			GetDriver().findElement(By.xpath("//div[@class='ss_div mainContCls loadSubItem_motorvehicle CS_SuggTooltip qs_synonymborder']//div[@id='div_0']//input[@class='synonymcls1 floatLeft qs_snonymhover']")).click();
			
		}
				catch(Exception e)
				{
					System.out.println("in dddd");
					GetDriver().findElement(By.cssSelector("body.pageBody.ui-widget.body:nth-child(2) ul.ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content.auto-sugg.tooltipWidth62:nth-child(40) li.ui-menu-item.auto-sugg-li:nth-child(2) div.ss_div.mainContCls.loadSubItem_motorvehicle.CS_SuggTooltip.qs_synonymborder div.qs_synonym_first div.combineEllipsis1.width801.synonymcls:nth-child(1) > input.synonymcls1.floatLeft.qs_snonymhover")).click();
				
				}
		
		
		
		
		if(GetDriver().findElement(By.xpath("//span[@class='cm-string'][contains(text(),'automotive vehicle')]")).isDisplayed() )
				{
			
					Assert.assertTrue(true);
				
				}
		     else
		     	{
			
		    	 	Assert.assertTrue(false,"synonyms generation or selection failed ");
		          
		     	}
		
	}
	@Test
	public void check_Template() throws Exception
	{
		GetDriver().navigate().refresh();
		WebDriverWait wait= new WebDriverWait(GetDriver(),80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@id='MASTERPAGEBODYID']/form[@id='form1']/div[@id='patseerHeader']/div[@id='headerCntrl_jquerylogoeffecthide']/div[@class='patseer_logo floatLeft patseerLogoMenuHeight patseerLogoMenuHeightGPS']/div[@id='headerCntrl_patseerLogoCntrl_divMenuCntrl']/ul[@class='dropdown homemenu floatLeft']/li[@id='headerCntrl_patseerLogoCntrl_liSearch']/a[1]"))).click();
		
		Actions a = new Actions(GetDriver());
		GetDriver().findElement(By.xpath("//button[contains(text(),'Assignee Orig & Norm (ASN)')]")).click();
		Date d=new Date();
		String temp="Test"+String.valueOf(d.getTime());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main_1']//a[@class='dropdown-item col-xs-12 col-sm-12 col-md-12 col-lg-12 combine_menu combineMenuPadding bg_biblio'][contains(text(),'BIBLIO')]")));
		a.moveToElement(GetDriver().findElement(By.xpath("//div[@id='main_1']//a[@class='dropdown-item col-xs-12 col-sm-12 col-md-12 col-lg-12 combine_menu combineMenuPadding bg_biblio'][contains(text(),'BIBLIO')]"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main_1']//span[@class='col-xs-12 col-sm-12 col-md-12 col-lg-12 combineSubmenu'][contains(text(),'Publication No (PNC)')]"))).click();
		
		GetDriver().findElement(By.xpath("//input[@id='txtTemplateIdJQ ']")).sendKeys(temp);
		GetDriver().findElement(By.xpath("//li[contains(@class,'list-inline col-xs-5 col-sm-5 col-md-5 col-lg-5')]//span[contains(@class,'mdi mdi-content-save')]")).click();
		Thread.sleep(1000);
		
		if(GetDriver().findElement(By.xpath("//div[contains(@class,'ui-pnotify-text')]")).getText().contains("Saved"))
		{
			
		}
		else
		{
			
			Assert.assertTrue(false);
		}
		
		GetDriver().navigate().refresh();
		
		
		GetDriver().findElement(By.xpath("//span[contains(@class,'input-group-addon dropdown-toggle CS_dropdwnTobtn')]")).click();
		GetDriver().findElement(By.linkText(temp)).click();
		
		
		
		if( GetDriver().findElement(By.xpath("//button[contains(text(),'Publication No (PNC)')]")).isDisplayed())
		{
			Assert.assertTrue(true);
			
		}
        else
      	{
	
    	   	Assert.assertTrue(false);

     	}
		
	}
		

	
				@Test
				public void custom_View() throws InterruptedException
				{
					Random r=new Random();
					String val=String.valueOf(r.nextInt(1000));
					String customname="cust "+val;
					GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					WebDriverWait wait=new WebDriverWait(GetDriver(),60);
					GetDriver().get("https://app.patseer.com/Search#/quick");
					GetDriver().findElement(By.xpath("//textarea[@id='txtPatApp_0']")).clear();
					GetDriver().findElement(By.xpath("//textarea[@id='txtPatApp_0']")).sendKeys("Motor and Engine and shaft");
					GetDriver().findElement(By.xpath("//a[@id='searchId']")).click();
					Thread.sleep(4000);
					GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
					JavascriptExecutor js=(JavascriptExecutor) GetDriver();	
					js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@class='placeholder']")));	
					
					GetDriver().findElement(By.xpath("//div[@class='optgroup']")).click();
					GetDriver().findElement(By.xpath("//span[contains(text(),'Custom View Settings')]")).click();
					GetDriver().switchTo().frame(GetDriver().findElement(By.id("ContentPlaceHolder1_SearchResultsControl_customViewFrm")));
					Select s0=new Select(GetDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_customOptionCntrl_lstCustomViews']")));
					s0.selectByVisibleText("--Add New--");
					Thread.sleep(2000);
					
					
				    Select s=new Select(GetDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_customOptionCntrl_userCustomViewControl_lstOption']")));
				    s.selectByVisibleText("Abstract");
				    GetDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_customOptionCntrl_userCustomViewControl_btnRight']")).click();
				    s.selectByVisibleText("Pub. Date");
				    GetDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_customOptionCntrl_userCustomViewControl_btnRight']")).click();
				    Select s2=new Select(GetDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_customOptionCntrl_lstCustomViews']")));
				    String cst=s2.getFirstSelectedOption().getText();
				    GetDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_customOptionCntrl_txtCustomViewName']")).sendKeys(customname);
				    
				    
				    GetDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_customOptionCntrl_btnSave']")).click();
				    Thread.sleep(2000);
					
					GetDriver().switchTo().defaultContent();
					
					try
					{
						GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
					}
					catch(Exception e)
					{}
					
					
					if(GetDriver().findElement(By.xpath("//div[contains(text(),'Abstract')]")).isDisplayed() )
					{
						
						
						
						}
					else
					{
						
						Assert.assertTrue(false,"custom view not generated cross-check manually");
						
					}
				 
				    
				}
				
				@Test
				public void check_WrongLID_Message() throws Exception
				{
					  GetDriver().navigate().refresh();
					GetDriver().findElement(By.xpath("//span[@class='floatLeft']//input[@id='Checkbox1']")).click();
	                Thread.sleep(1000);
	                  cmd("L9999");
	                  WebDriverWait wait=new WebDriverWait(GetDriver(),60);
	                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-pnotify-text']")));
	                  String LID=GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().toString();
	                  if(LID.contains("L9999 does not exist in the search script"))
		            	{
		            		
		            	}
		            	else
		            	{
		            		
		            		Assert.assertTrue(false, "L9999 does not exist in the search script-message not found");
		            	}			
				
				}
				
				
				
				
				
				@Test
				public void check_Wrong_Fieldcode_YellowMessage() throws Exception
				{
		             GetDriver().navigate().refresh();
	                GetDriver().findElement(By.xpath("//span[@class='floatLeft']//input[@id='Checkbox1']")).click();
	                Thread.sleep(1000);
	                 cmd("TACN: Reusable rockets");
	                  WebDriverWait wait=new WebDriverWait(GetDriver(),60);
	                  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-pnotify-text']")));
	            	String Fcode=GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().toString();
	            	Thread.sleep(2000);
	    
	            	if(Fcode.contains("Invalid field code `TACN:`. Please rectify"))
	            	{
	            		
	            	}
	            	else
	            	{
	            		Assert.assertTrue(false, "Invalid field code `TACN:`. Please rectify-message not found");
	            		System.out.println(Fcode);
	            		
	            	}
	            		
	            
				}
				/*
				@Test
				public void check_show_hide_filters_and_more_option() throws Exception
				{
					GetDriver();
					
				
					WebDriverWait wait=new WebDriverWait(GetDriver(),60);
					GetDriver().findElement(By.xpath("//textarea[@id='txtPatApp_0']")).clear();
					GetDriver().findElement(By.xpath("//textarea[@id='txtPatApp_0']")).sendKeys("Motor and Engine and shaft");
					GetDriver().findElement(By.xpath("//a[@id='searchId']")).click();
					Thread.sleep(4000);
					GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
					GetDriver().findElement(By.xpath("//div[@id='leftUpperPanel_SearchSummaryContainer_filterContainer']//span[@class='floatLeft ng-binding'][contains(text(),'Current Assignee(s)')]")).click();
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatLeft width100 filterKeyValue__CASN']//div//span[@class='floatLeft facetText checkBoxTextFix ng-scope'][contains(text(),'HONDA MOTOR CO LTD')]")));
					if(GetDriver().findElement(By.xpath("//div[@class='floatLeft width100 filterKeyValue__CASN']//div//span[@class='floatLeft facetText checkBoxTextFix ng-scope'][contains(text(),'HONDA MOTOR CO LTD')]")).isDisplayed())
					{
						
					}
					else
					{
						Assert.assertTrue(false, "filetr is not getting expanded properly");
					}
					
					Thread.sleep(500);
					GetDriver().findElement(By.xpath("//i[@class='mdi mdi-settings']")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatLeft width100 item']//input")));
					GetDriver().findElement(By.xpath("//div[@class='floatLeft width100 item']//input")).click();
					GetDriver().findElement(By.xpath("//input[@id='leftUpperPanel_SelectFilterItemsControl_Save']")).click();
					
					
					    if(GetDriver().findElement(By.xpath("//div[@id='leftUpperPanel_SearchSummaryContainer_filterContainer']//span[@class='floatLeft ng-binding'][contains(text(),'Search within Records')]")).isDisplayed())
					    {
					    	
					    	Assert.assertTrue(false, "functionality of show and hide filter icon failed ");
					    	
					    }
					    else
					    {
					    	
					    	Assert.assertTrue(true);
					    }
					    GetDriver().findElement(By.xpath("//i[@class='mdi mdi-settings']")).click();
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='floatLeft width100 item']//input")));
						GetDriver().findElement(By.xpath("//div[@class='floatLeft width100 item']//input")).click();
						GetDriver().findElement(By.xpath("//input[@id='leftUpperPanel_SelectFilterItemsControl_Save']")).click();

				}
				*/
				@Test
				public void checkRegisterLink_on_searchResultPage_inSTD_FamilyView_And_PDF_MOsaic_Icon() throws Exception
				{
					String patseerh=GetDriver().getWindowHandle();
					GetDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					JavascriptExecutor js=(JavascriptExecutor) GetDriver();	
					js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@class='placeholder']")));	
					GetDriver().findElement(By.xpath("//div[@class='option'][contains(text(),'Standard + Family')]")).click();
					Actions a=new Actions(GetDriver());
					WebDriverWait wait=new WebDriverWait(GetDriver(),60);
					Thread.sleep(3000);
					
					GetDriver().findElement(By.xpath("//tbody[@id='trnumber_EA005267B1']//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[2]//div[2]//i[1]")).click();
					
					Set <String> h=GetDriver().getWindowHandles();
					for(String s: h)
					{
						if(!s.equals(patseerh))
						{
							GetDriver().switchTo().window(s);
							GetDriver().close();
							GetDriver().switchTo().window(patseerh);
						}
						
					}
					
					GetDriver().switchTo().defaultContent();
					GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
					GetDriver().findElement(By.xpath("//tbody[@id='trnumber_EA005267B1']//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[2]//div[2]//i[2]")).click();
					Thread.sleep(1000);
					Set <String> h1=GetDriver().getWindowHandles();
					for(String s1: h1)
					{
						if(!s1.equals(patseerh))
						{
							GetDriver().switchTo().window(s1);
							if(GetDriver().findElement(By.xpath("//img[@id='imagebox_CA2445081C_0']")).isDisplayed())
							{
								GetDriver().close();
								GetDriver().switchTo().window(patseerh);
								Assert.assertTrue(true);
								
							}
							else
							 {
								Assert.assertTrue(false,"mosaic not loading");
								
							 }
						}
						
					}
					
					
					GetDriver().switchTo().defaultContent();
					GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
					GetDriver().findElement(By.xpath("//tbody[@id='trnumber_EA005267B1']//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[7]//span[1]")).click();
					Thread.sleep(1000);
					Set <String> h2=GetDriver().getWindowHandles();
					for(String s1: h2)
					{
						if(!s1.equals(patseerh))
						{
							GetDriver().switchTo().window(s1);
							Thread.sleep(520);
							if(GetDriver().getCurrentUrl().contains("https://brevets-patents.ic.gc.ca/opic-cipo/cpd/eng/patent/2445081/summary.html?type=number_search#Details"))
							{
								GetDriver().close();
								GetDriver().switchTo().window(patseerh);
								GetDriver().switchTo().defaultContent();
								
								
							}
							else
							 {
								Assert.assertTrue(false,"Register link not redirecting to valid page");
								
							 }
						}
						
					}
					GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
					WebElement e=GetDriver().findElement(By.xpath("//td[@class='sortsfam bottomBorder sr-selected']//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[1]//i[1]"));
					a.moveToElement(e).build().perform();
					Thread.sleep(1000);
					
					if(e.getAttribute("title").contains("Alive") || e.getAttribute("title").contains("Dead"))
					{
						GetDriver().switchTo().defaultContent();
						Assert.assertTrue(true);
					}
					
					else
					{
						
						Assert.assertTrue(false," family member status Tooltip not loading properly ");
					}
					
				}
				/*
				@Test
				public void F8() throws Exception
				{
					
					String patseerh=GetDriver().getWindowHandle();
					WebDriverWait wait=new WebDriverWait(GetDriver(),60);
										
						JavascriptExecutor js = (JavascriptExecutor) GetDriver();	

						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));	
						js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));					
						js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));
						Thread.sleep(500);			
						
						Robot r=new Robot();
						r.keyPress(KeyEvent.VK_M);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_M);
						Thread.sleep(2000);
						Set <String> h2=GetDriver().getWindowHandles();
						System.out.println(h2.size());
						
						for(String s : h2)
						{
							if(!s.equals(patseerh))
							{
								System.out.println("i am on mosaic tab");
								GetDriver().switchTo().window(s);
								Thread.sleep(2000);
								
								if(GetDriver().findElement(By.xpath("//img[@id='imagebox_EA005267B1_0']")).isDisplayed())
								{
									
									GetDriver().close();
									GetDriver().switchTo().window(patseerh);
									
								}
								else
								{    GetDriver().close();
									Assert.assertTrue(false, "mosaic shortcut error");
								}
								
							}
							
						}

						Thread.sleep(2000);
						
						
							try{
						GetDriver().switchTo().defaultContent();
						GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
							}
							catch(Exception e)
							{}
						js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));					
						js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));					
						
						r.delay(500);
						r.keyPress(KeyEvent.VK_P);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_P);
							
						
						
						Thread.sleep(2000);
						Set <String> h3=GetDriver().getWindowHandles();
						
						for(String s : h3)
						{
							if(!s.equals(patseerh))
							{
								GetDriver().switchTo().window(s);
								Thread.sleep(1000);
								if(GetDriver().getCurrentUrl().contains("app.patseer.com/Pdf?pnkc=EA005267B1&kindCode=&ProjectId=0&ApplicationNumber=EA20030001157&target=&IsShowF8=true&familyID=25286364"))
								{
									GetDriver().close();
									GetDriver().switchTo().window(patseerh);
								}
								else
								{    GetDriver().close();
								    GetDriver().switchTo().window(patseerh);
									Assert.assertTrue(false, "PDF shortcut error");
								}
								
							}
							
						}
						
						
				

						Thread.sleep(2000);
						
						
							try{
						GetDriver().switchTo().defaultContent();
						GetDriver().switchTo().frame(GetDriver().findElement(By.id("resultFrameID")));
							}
							catch(Exception e)
							{}
						js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));					
						js.executeScript("arguments[0].click();", GetDriver().findElement(By.xpath("//div[@id='trnumber_EA005267B1']//div[@class='floatLeft tbview-patent-title']//div//i[@id='LSCcolor']")));					
						
						
						r.delay(500);
						r.keyPress(KeyEvent.VK_K);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_K);
						Thread.sleep(2000);
						
						GetDriver().findElement(By.xpath("//div[@id='kwicHeader']//div[@id='imgClose']")).click();
						
						Thread.sleep(1000);
						

						Thread.sleep(2000);
						
						
							
						
						
						r.delay(500);
						r.keyPress(KeyEvent.VK_SHIFT);
						r.delay(100);
						r.keyPress(KeyEvent.VK_J);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_J);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_SHIFT);
						Thread.sleep(1000);
						if(GetDriver().findElement(By.xpath("//input[@id='token-input-txtProjectNameRecent']")).isDisplayed())
						{
							GetDriver().findElement(By.xpath("//div[@class='modal-content modal-dialog']//button[@class='close'][contains(text(),'×')]")).click();
						}
						else
						{
							Assert.assertTrue(false, "Add to project shortcut not working");
						}
						Thread.sleep(1000);
						r.delay(500);
						r.keyPress(KeyEvent.VK_SHIFT);
						r.delay(100);
						r.keyPress(KeyEvent.VK_Q);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_Q);
						r.delay(100);
						r.keyRelease(KeyEvent.VK_SHIFT);
						
						if(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).isDisplayed())
						{
							Assert.assertEquals(GetDriver().findElement(By.xpath("//div[@class='ui-pnotify-text']")).getText().toString(), "Record(s) have been added to Quick List");
						}
						else
						{
							Assert.assertTrue(false, "Add to Quicklist shortcut not working");
						}
														
					
					
					
				}
				*/
				@Test
				public void Select_some_records_and_check_the_count_of_selected_records_displayed() throws Exception
				{
					cmd("pnc:(TW201005116A   or DE112013004585T8 or JP5841162B2 or US5796952A or DE102013106879A1 or TW201005116A or DE60313195T or US7605268B2 or US2017039363A1 or  GB0611990D0 or EP1465369A1 or DE112013004585T8 or DE102013106879A1 or  DE60313195T2 or DE60313195T2 or US7605268B2 or US7605268B2 or US2017039363A1 or US2017039363A1 or US2017039363A1 or JP5841162B2 or US5796952A or DE102013106879A1 or  DE112013004585T8   or EP1465369A1 or GB0611990D0 or US2017039363A  or US7605268B2)");
					GetDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					WebDriverWait wait=new WebDriverWait(GetDriver(),100);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"chkRecordID_TW201005116A\"]"))).click();	
					
					int num=Integer.parseInt(GetDriver().findElement(By.xpath("//span[@id='CheckCount']")).getText().toString());
					if(num==1)
					{
					
					Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false,"count miss-match expected count 1 but found "+num);
					}
				}
				
				@Test
				public void Check_all_sorting_types () throws Exception
				{
					GetDriver();
					cmd("pnc:(TW201005116A   or DE112013004585T8 or JP5841162B2 or US5796952A or DE102013106879A1 or TW201005116A or DE60313195T or US7605268B2 or US2017039363A1 or  GB0611990D0 or EP1465369A1 or DE112013004585T8 or DE102013106879A1 or  DE60313195T2 or DE60313195T2 or US7605268B2 or US7605268B2 or US2017039363A1 or US2017039363A1 or US2017039363A1 or JP5841162B2 or US5796952A or DE102013106879A1 or  DE112013004585T8   or EP1465369A1 or GB0611990D0 or US2017039363A  or US7605268B2)");
					GetDriver().manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
					WebDriverWait wait = new WebDriverWait(GetDriver(), 100);
				   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Relevance')]"))).click();
				   
				   GetDriver().findElement(By.xpath("//a[contains(text(),'App. Date ↓')]")).click();
				   
				   if(GetDriver().findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]/div[1]/div[1]/asp:panel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText().contains("US2017039363A1"))
				   {
					   Assert.assertTrue(true);
				   
				   }
				   else
				   {
					   Assert.assertTrue(false,"App date sorting order not working properly");   
				   }
				   
				   GetDriver().findElement(By.xpath("//button[contains(text(),'App. Date')]")).click();
				   GetDriver().findElement(By.xpath("//a[contains(text(),'Relevance ↓')]")).click();
					 
				   if(GetDriver().findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]/div[1]/div[1]/asp:panel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/span[2]/label[1]")).getText().contains("TW201005116A"))
				   {
					   Assert.assertTrue(true);
				   
				   }
				   else
				   {
					   Assert.assertTrue(false,"Revelance sorting order not working properly");   
				   }
				   
				   GetDriver().findElement(By.xpath("//button[contains(text(),'Relevance')]")).click();
				   GetDriver().findElement(By.xpath("//a[contains(text(),'Pub. Date ↓')]")).click();
					 
				   if(GetDriver().findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]/div[1]/div[1]/asp:panel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/span[2]/label[1]")).getText().contains("US2017039363A1"))
				   {
					   Assert.assertTrue(true);
				   
				   }
				   else
				   {
					   Assert.assertTrue(false,"Pub date sorting order not working properly");   
				   }
				   
				   GetDriver().findElement(By.xpath("//button[contains(text(),'Pub. Date')]")).click();
				   GetDriver().findElement(By.xpath("//a[contains(text(),'Document No ↓')]")).click();
					 
				   if(GetDriver().findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[6]/div[1]/div[3]/div[1]/div[1]/asp:panel[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/span[2]/label[1]")).getText().contains("US2017039363A1"))
				   {
					   Assert.assertTrue(true);
				   
				   }
				   {
					   Assert.assertTrue(false,"document no sorting order not working properly");   
				   }
				   
				}
				
				
			


}
