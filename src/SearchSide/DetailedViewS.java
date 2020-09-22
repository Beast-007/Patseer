package SearchSide;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DetailedViewS extends BaseTest {
	static String patseerh;

	@Test
	public void Detailedview_Iconand_Link() throws Exception

	{

		System.out.println("Detailedview_Iconand_Link");
		GetDriver();

		WebDriverWait wait = new WebDriverWait(GetDriver(), 60);

		String command = "(ASN:google and PBC:DE) or  (pnc:(TW201005116A   or DE112013004585T8 or JP5841162B2 or US5796952A or DE102013106879A1 or TW201005116A or DE60313195T or US7605268B2 or US2017039363A1 or  GB0611990D0 or EP1465369A1 or DE112013004585T8 or DE102013106879A1 or  DE60313195T2 or DE60313195T2 or US7605268B2 or US7605268B2 or US2017039363A1 or US2017039363A1 or US2017039363A1 or JP5841162B2 or US5796952A or DE102013106879A1 or  DE112013004585T8   or EP1465369A1 or GB0611990D0 or US2017039363A  or US7605268B2))";

		cmd(command);

		patseerh = GetDriver().getWindowHandle().toString();
		Thread.sleep(3000);

		JavascriptExecutor js3 = (JavascriptExecutor) GetDriver();
		WebElement ClickonSearchWithin = GetDriver().findElement(
				By.xpath("//filterview[@name='searchresultFilter']//*[@filtertype='relevance']//child::span[1]"));
		js3.executeScript("arguments[0].click();", ClickonSearchWithin);
		int c = 0;

		GetDriver().findElement(By.xpath("//textarea[@id='SearchTerm']")).sendKeys(
				"pnc:(DE112013004585T8 or DE112013004585B4 or DE112013004585T8 or TW201005116A or DE60313195T2 or US2017039363A1 or JP5841162B2 or US5796952A or DE102013106879A1 or DE112013004585T8 or EP1465369A1 or GB0611990D0 or DE60313195T2)");

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lblText_DE102013106879A1']")));
		js.executeScript("arguments[0].click();",
				GetDriver().findElement(By.xpath("//label[@id='lblText_DE102013106879A1']")));
		Thread.sleep(500);
		Set<String> handle = GetDriver().getWindowHandles();

		for (String f : handle) {

			System.out.println(f);

		}

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				System.out.println(h);
				System.out.println(patseerh);
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				GetDriver().findElement(By.cssSelector("#claimsTab")).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_claimsCntrl_txtClaims']//p[contains(text(),'1. The jet engine ( 1 ) with at least one oil separator ( 17 )')]")));
				String claims = GetDriver().findElement(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_claimsCntrl_txtClaims']//p[contains(text(),'1. The jet engine ( 1 ) with at least one oil separator ( 17 )')]"))
						.getText();
				if (claims.contains("The jet engine ( 1 ) with at least one oil separator ( 17 )")) {

				} else {
					Assert.assertEquals(claims, "1. The jet engine ( 1 ) with at least one oil separator ( 17 )");
				}

				GetDriver().findElement(By.cssSelector("#ui-id-20")).click();
				Thread.sleep(1000);
				GetDriver().switchTo().frame(GetDriver().findElement(By.id("IfrMosic")));

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//img[@id='imagebox_DE102013106879A1_0']")));

				if (GetDriver().findElement(By.xpath("//img[@id='imagebox_DE102013106879A1_0']")).isDisplayed()) {

				} else {
					Assert.assertTrue(false);
				}

				GetDriver().switchTo().defaultContent();
				GetDriver().findElement(By.cssSelector("#ui-id-21")).click();
				Thread.sleep(1000);
				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamily")));

				if (GetDriver().findElement(By.xpath("//input[@id='chkAllCheckBox_DE102013106879A1_sFamCntnr']"))
						.isDisplayed()) {

				} else {
					Assert.assertTrue(false);
				}
				GetDriver().switchTo().defaultContent();

				GetDriver().findElement(By.cssSelector("#ui-id-22")).click();
				Thread.sleep(1000);

				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmBackCitation")));
				Thread.sleep(500);
				if (GetDriver().findElement(By.xpath("//input[@id='chkAllCheckBox_Backward']")).isDisplayed()) {
					try {
						if (GetDriver().findElement(By.xpath("//label[@id='lblText_US2012128466A1']")).isDisplayed()) {

						}
					} catch (Exception e) {
						System.out.println("second failed");
					}

				}

				else {
					Assert.assertTrue(false, "citations error");
				}

				GetDriver().switchTo().defaultContent();

				wait.until(
						ExpectedConditions.elementToBeClickable(GetDriver().findElement(By.cssSelector("#ui-id-24"))))
						.click();

				GetDriver().findElement(By.xpath("//a[@id='ui-id-25']")).click();
				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmBackCitation")));

				if (GetDriver()
						.findElement(By.xpath("//div[contains(@class,'ui-widget-content dummymaster_middlepanel')]"))
						.isDisplayed()) {

				} else {
					Assert.assertTrue(false, "error with coments tab");
				}
				GetDriver().switchTo().defaultContent();

				Thread.sleep(2000);
				GetDriver().findElement(By.xpath("//a[@id='ui-id-29']")).click();	
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='patent-title']/annot-title[@id='annotTitleID1' and contains(text(),'Jet')]")));
				if (GetDriver().findElement(By.xpath("//annot-title[contains(text(),'Jet engine with at least one oil separator')]")).getText().toString().contains("Jet engine")) {

				} 
				else {
					Assert.assertTrue(false, "detailed view eror");
				}

				GetDriver().findElement(By.cssSelector("#ui-id-27")).click();
				Thread.sleep(2000);
				if (GetDriver().findElement(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailsViewContainer']//span[@id='Span1']"))
						.isDisplayed()) {

				} else {
					Assert.assertTrue(false, "Summary error");
				}

			}
			if (!h.equals(patseerh)) {
				GetDriver().close();
			}
			GetDriver().switchTo().window(patseerh);

		}

		GetDriver().findElement(By.xpath(
				"//div[@id='trnumber_DE112013004585T8']//div[@class='floatLeft tbview-patent-title']//div//span[@id='lnkimgDetails']"))
				.click();
		Thread.sleep(1000);
		Set<String> handle4 = GetDriver().getWindowHandles();
		for (String h : handle4) {
			if (!h.equals(patseerh)) {
				System.out.println(h);
				System.out.println(patseerh);
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
			}
		}
		GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();

		GetDriver().switchTo().window(patseerh);

	}

	@Test
	public void subsidiary() throws Exception {

		WebDriverWait wait = new WebDriverWait(GetDriver(), 60);

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		GetDriver().switchTo().defaultContent();

		String patseerh = GetDriver().getWindowHandle();

		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		js.executeScript("arguments[0].click();",
				GetDriver().findElement(By.xpath("//label[@id='lblText_DE112013004585T8']")));

		String dhandle1 = "GOOGLE AIRWAVES INC";
		Set<String> handle = GetDriver().getWindowHandles();
		for (String h : handle) {
			if (!h.equals(patseerh)) {
				dhandle1 = h;
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
			}

		}
		GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();
		GetDriver().findElement(By.xpath(
				"//div[@class='topSpacer wordwrapping ng-scope']//span[@class='patseer_Secondary_Button ng-binding'][contains(text(),'ALPHABET INC')]"))
				.click();

		GetDriver().findElement(By.xpath("//input[@placeholder='Search Subsidiary by name']"))
				.sendKeys("GOOGLE AIRWAVES INC");
		GetDriver().findElement(By.xpath("//input[@placeholder='Search Subsidiary by name']")).sendKeys(Keys.ENTER);

		if (dhandle1.equals(
				(GetDriver().findElement(By.xpath("//div[@class='pasnfont pasnwrap ng-binding']"))).getText())) {

			GetDriver().switchTo().window(patseerh);
			Assert.assertEquals(
					GetDriver().findElement(By.xpath("//div[@class='pasnfont pasnwrap ng-binding']")).getText(),
					"GOOGLE AIRWAVES INC");

		}

		else {
			Assert.assertEquals(
					GetDriver().findElement(By.xpath("//div[@class='pasnfont pasnwrap ng-binding']")).getText(),
					"GOOGLE AIRWAVES INC");

		}

	}

	@Test
	public void CopyClassDefinition() throws Exception {

		Actions a = new Actions(GetDriver());

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		WebDriverWait wait = new WebDriverWait(GetDriver(), 60);

		String patseerh = GetDriver().getWindowHandle();

		Thread.sleep(3000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE112013004585B4 ");
		Thread.sleep(3000);
		Robot r = new Robot();

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lblText_DE112013004585B4']")));

		js.executeScript("arguments[0].click();",
				GetDriver().findElement(By.xpath("//label[@id='lblText_DE112013004585B4']")));
		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				Thread.sleep(1000);
				a.moveToElement(GetDriver().findElement(By.xpath(
						"//body[contains(@class,'pageBody ui-widget ng-scope')]/form[@id='form2']/div[@id='divDisplay']/div[contains(@class,'ui-widget-content dummymaster_middlepanel')]/div/div[@id='ContentPlaceHolder1_divpageMainControler']/div[@id='ContentPlaceHolder1_divDetailsViewNGMain']/div[@id='ContentPlaceHolder1_divdetailsViewNGContainer']/div[@id='ContentPlaceHolder1_divdetailsViewControlpage']/div[@id='ContentPlaceHolder1_detailsViewCntrl_detailsViewContainer']/div[@id='biblioPanel']/div[@id='divpatno']/div[@id='divIPc']/span[2]/span[1]")))
						.perform();
				Thread.sleep(1000);
				GetDriver().findElement(By.xpath(
						"//span[@id='IC0']//span[contains(@class,'mdi mdi-content-copy middle floatRight handPointer')]"))
						.click();

			}

		}

		GetDriver().switchTo().window(patseerh);

		js.executeScript("arguments[0].click();",
				GetDriver().findElement(By.xpath("//div[@id='divCommentText_DE112013004585B4']")));
		Thread.sleep(1000);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.delay(100);
		r.keyPress(KeyEvent.VK_V);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.delay(100);
		r.keyRelease(KeyEvent.VK_V);

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//input[@id='chkRecordID_DE112013004585B4']")).click();
		GetDriver().findElement(By.xpath("//input[@id='chkRecordID_DE112013004585B4']")).click();

		GetDriver().switchTo().defaultContent();
		String Val = GetDriver().findElement(By.xpath("//input[@id='chkRecordID_DE112013004585B4']")).getText();
		System.out.println(Val);
		System.out.println();

		if (Val.contains("Class: G06F3/048")) {

			Assert.assertTrue(true);

		}

	}

	@Test
	public void Key_concepts_Browse_Classes() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lblText_DE112013004585T8']")))
				.click();

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {

			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				Thread.sleep(1000);
				GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailViewDataNg_classDef_classDefShow']")));
				GetDriver().findElement(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailViewDataNg_classDef_classDefShow']"))
						.click();
				Thread.sleep(1000);

				if (GetDriver().findElement(By.xpath(
						"//div[@id='ipcPanel']//div[contains(@class,'mainClassName ng-binding')][contains(text(),'G06F')]"))
						.isDisplayed()) {

				} else {

					Assert.assertTrue(false, "error with browse classes");
				}

				Assert.assertEquals(GetDriver().findElement(By.xpath("//span[contains(text(),'Computer Apparatus')]"))
						.getText().toString(), "Computer Apparatus   ");

			}

		}

		GetDriver().switchTo().window(patseerh);

	}

	@Test
	public void Check_Family_Member_Status() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lblText_DE112013004585T8']")));
		js.executeScript("arguments[0].click();",
				GetDriver().findElement(By.xpath("//label[@id='lblText_DE112013004585T8']")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.xpath("//a[@id='ui-id-21']")).click();
				Thread.sleep(1000);

				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamily")));
				Thread.sleep(2000);

				if ((GetDriver()
						.findElement(By.xpath(
								"//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[1]//i[1]"))
						.isDisplayed()
						&& GetDriver().findElement(By.xpath(
								"//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[1]//i[1]"))
								.getAttribute("title").contains("Alive"))
						|| ((GetDriver().findElement(By.xpath(
								"//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[1]//i[1]"))
								.isDisplayed()
								&& GetDriver().findElement(By.xpath(
										"//div[@id='sFamCntnr']//div[@class='ng-scope']//div[1]//div[1]//div[1]//div[1]//i[1]"))
										.getAttribute("title").contains("Dead")))) {

					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);
				}

			}

		}
	}

	@Test
	public void Hitmap() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		Actions a = new Actions(GetDriver());

		String patseerh = GetDriver().getWindowHandle();

		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();
		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE112013004585T8 and T:Keyboard decoding ");

		Thread.sleep(1000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();
		Thread.sleep(1000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_DE112013004585T8"))).click();

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.xpath("//a[@id='ui-id-26']")).click();
				Thread.sleep(1000);
				GetDriver().findElement(By.xpath("//span[@class='rotateTool d-hm-btn']")).click();

				if (GetDriver().findElement(By.cssSelector(
						"body.pageBody.ui-widget.ng-scope:nth-child(2) form.ng-pristine.ng-valid:nth-child(1) div.master_resultContainer.ui-widget-content:nth-child(10) div.master_middlepanel.ui-widget-content.dummymaster_middlepanel:nth-child(3) div.dv-right-cont div.DocMapContainer.ng-scope div.DocMapHolder.ng-scope div.highlight-informer.width100 div.floatLeft.width100.ng-scope:nth-child(2) > span.floatLeft.ng-binding:nth-child(3)"))
						.isDisplayed()
						&& GetDriver().findElement(By.cssSelector(
								"body.pageBody.ui-widget.ng-scope:nth-child(2) form.ng-pristine.ng-valid:nth-child(1) div.master_resultContainer.ui-widget-content:nth-child(10) div.master_middlepanel.ui-widget-content.dummymaster_middlepanel:nth-child(3) div.dv-right-cont div.DocMapContainer.ng-scope div.DocMapHolder.ng-scope div.DocMap > span.highlight_color1.handPointer:nth-child(2742)"))
								.getAttribute("style").toString().contains("rgb(230, 230, 0)")) {

					Assert.assertTrue(true);
				} else {

					Assert.assertTrue(false);
				}

			}

		}
	}

	@Test
	public void Family_Export() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		Actions a = new Actions(GetDriver());

		patseerh = GetDriver().getWindowHandle();
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		Date d = new Date();
		String dd = String.valueOf(d.getDay());

		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:TW201005116A ");
		Thread.sleep(3000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@id='lblText_TW201005116A']")));
		js.executeScript("arguments[0].click();",
				GetDriver().findElement(By.xpath("//label[@id='lblText_TW201005116A']")));
		Thread.sleep(2000);

		Set<String> handle = GetDriver().getWindowHandles();
		String conf = "";
		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.xpath("//a[@id='ui-id-21']")).click();
				Thread.sleep(1000);

				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamily")));
				Thread.sleep(2000);
				GetDriver().findElement(By.xpath("//a[@id='ui-id-1']")).click();
				GetDriver().findElement(By.xpath("//input[@id='chkAllCheckBox_TW201005116A_sFamCntnr']")).click();
				GetDriver().findElement(By.xpath("//div[@id='divAllData']//span[contains(text(),'Export')]")).click();
				Thread.sleep(2000);
				try {
					GetDriver().switchTo().defaultContent();
					conf = GetDriver().findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]")).getText().toString();
				} catch (Exception e) {
				}
				GetDriver().switchTo().window(patseerh);

				GetDriver().switchTo().defaultContent();
				GetDriver().findElement(By.xpath("//img[@id='headerCntrl_patseerLogoCntrl_logo']")).click();
				Thread.sleep(2000);

				List<WebElement> s1 = GetDriver().findElements(By.id("div8"));

				if (s1.get(0).getText().toString().contains("FAMID: (44826100)")
						&& s1.get(0).getText().toString().contains(dd)
						&& conf.contains("The export file requested is being generated")
						&& s1.get(0).getText().toString().contains("Download")
						|| s1.get(0).getText().toString().contains("In")
						|| s1.get(0).getText().toString().contains("in")) {

					Assert.assertTrue(true);
				} else {

					Assert.assertTrue(false);
				}

			}

		}

	}

	@Test
	public void Check_Family_coverage_map_and_Legal_status_timeline_tree() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		WebDriverWait wait = new WebDriverWait(GetDriver(), 80);
		String patseerh = GetDriver().getWindowHandle();

		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:TW201005116A ");

		Thread.sleep(3000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_TW201005116A")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_TW201005116A")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {

			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ui-id-21']"))).click();
				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamily")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ui-id-3']"))).click();
				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamilyTree")));

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='Family Tree For Record: TW201005116A']")));

				if (GetDriver().findElement(By.xpath("//div[@id='Family Tree For Record: TW201005116A']"))
						.isDisplayed()) {

				} else {

					Assert.assertTrue(false);
				}
				GetDriver().findElement(By.xpath("//*[@id='btnExportFamilyImage']")).click();

				GetDriver().switchTo().window(patseerh);

			}

		}

	}

	@Test
	public void doc_undoc() throws Exception {

		String patseerh = GetDriver().getWindowHandle();
		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		WebDriverWait wait = new WebDriverWait(GetDriver(), 80);

		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:TW201005116A ");

		Thread.sleep(3000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_TW201005116A")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_TW201005116A")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {

			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='ContentPlaceHolder1_divSplitView']"))).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@id='ContentPlaceHolder1_DetailsViewControl1_horizontalSplitDiv']"))).click();

			}

		}
		GetDriver().switchTo().window(patseerh);

	}

	@Test
	public void pdf() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		Actions a = new Actions(GetDriver());

		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();
		Thread.sleep(3000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE60313195T2 ");

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_DE60313195T2")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_DE60313195T2")));

		String patseerh = GetDriver().getWindowHandle();
		Thread.sleep(2000);

		GetDriver().findElement(By.xpath(
				"/html[1]/body[1]/form[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/span[2]/label[1]"))
				.click();

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.xpath("//a[@id='ui-id-24']")).click();
				Thread.sleep(1000);

				GetDriver().switchTo().frame(GetDriver().findElement(By.id("iframePdfPage")));
				Thread.sleep(2000);
				try {
					System.out.println(GetDriver().findElement(By.xpath("//*[@id='ink']")).isDisplayed());
				} catch (Exception e) {
					System.out.println(e);
				}
				Robot rob = new Robot();
				rob.keyPress(KeyEvent.VK_RIGHT);

				try {
					String ad = GetDriver().findElement(By.id("previous")).getAttribute("disabled");
				} catch (Exception e) {

					System.out.println(e);
					Assert.assertTrue(true);

				}

			}

		}

	}

	@Test
	public void Register() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		Actions a = new Actions(GetDriver());

		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE60313195T2 ");

		Thread.sleep(1000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		String patseerh = GetDriver().getWindowHandle();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#lblText_DE60313195T2")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_DE60313195T2")));

		Thread.sleep(2000);

		String l = "";

		Set<String> handle = GetDriver().getWindowHandles();
		String detail;
		System.out.println(handle.size());
		for (String h : handle) {
			if (!h.equals(patseerh)) {

				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				detail = h;
				Thread.sleep(1000);
				GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Register']"))).click();

			}

		}
		Thread.sleep(1000);
		Set<String> handle1 = GetDriver().getWindowHandles();
		Iterator<String> itr = handle1.iterator();

		while (itr.hasNext()) {
			l = itr.next();
			System.out.println(l);
		}

		GetDriver().switchTo().window(l);
		Thread.sleep(2000);

		if (GetDriver().getCurrentUrl().contains("register"))

		{
			System.out.println("ia am in ");

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void F8() throws Exception

	{

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		WebDriverWait wait = new WebDriverWait(GetDriver(), 60);

		String patseerh = GetDriver().getWindowHandle().toString();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE112013004585T8");

		Thread.sleep(3000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_DE112013004585T8")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_DE112013004585T8")));

		Thread.sleep(500);
		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {

				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ui-id-20"))).click();

				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_C);

				Thread.sleep(3000);
				if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_claimsCntrl_txtClaims']//p[contains(text(),'1. A method comprising: outputting, by means of a')]")))
						.isDisplayed()) {
				} else {
					Assert.assertTrue(false);
				}

			}
			if (!h.equals(patseerh)) {
				GetDriver().close();
			}
			GetDriver().switchTo().window(patseerh);

		}

	}

	@Test
	public void UnfoldImagesAnd_PlusIcon() throws Exception

	{

		WebDriverWait wait = new WebDriverWait(GetDriver(), 60);
		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		String patseerh = GetDriver().getWindowHandle().toString();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:(US7605268B2 or US2017039363A1)");
		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_US7605268B2")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_US7605268B2")));
		Thread.sleep(500);

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {

				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ui-id-26"))).click();

				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#loadimagesID"))).click();

				Thread.sleep(1000);
				if (wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@id='imagebox_US7605268B2_0']")))
						.isDisplayed()) {

				} else {
					Assert.assertTrue(false);
				}

				GetDriver().findElement(By.xpath(
						"//span[@class='ui-icon ui-icon-triangle-1-e handPointer floatLeft ng-binding ng-scope']"))
						.click();
				Thread.sleep(3000);
				if (wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@id='imagebox_US2017039363A1_0']")))
						.isDisplayed()) {
					Assert.assertTrue(true);
				} else {
					System.out.println("images are not unfolded");
					Assert.assertTrue(false);
				}

			}
			if (!h.equals(patseerh)) {
				GetDriver().close();
			}
			GetDriver().switchTo().window(patseerh);

		}

	}

	@Test
	public void Check_Family_member_openinnewTab_and_Pdficon_in_DetailedView() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		String patseerh = GetDriver().getWindowHandle();

		WebDriverWait wait = new WebDriverWait(GetDriver(), 80);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:US2017039363A1 ");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_US2017039363A1")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_US2017039363A1")));

		Set<String> handle = GetDriver().getWindowHandles();
		String h1 = "";

		for (String h : handle) {

			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ui-id-21']"))).click();
				h1 = h;
				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmFamily")));

				Thread.sleep(3000);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='divFamilyView_CN104978533B']"))).click();

			}

		}
		Thread.sleep(1000);

		Set<String> handle1 = GetDriver().getWindowHandles();

		if (handle1.size() > 2) {

		} else {

			Assert.assertTrue(false);
		}
		GetDriver().switchTo().window(h1);

		GetDriver().switchTo().window(patseerh);
	}

	@Test
	public void FI_Term_onDetailed_view_Tooltip() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();
		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:JP5841162B2 ");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_JP5841162B2")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_JP5841162B2")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {

			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();
				a.moveToElement(GetDriver().findElement(By.cssSelector(
						"body.pageBody.ui-widget.ng-scope:nth-child(2) form.ng-pristine.ng-valid:nth-child(1) div.master_resultContainer.ui-widget-content:nth-child(10) div.master_middlepanel.ui-widget-content.dummymaster_middlepanel:nth-child(3) div.A_979 div.recordInfoContainer.searchResultsInfoContainer.ng-scope.detailsView.ext1 div.forclear div.detailsContent div.floatLeft.detailsView.ui-tabs.ui-widget.ui-widget-content.ui-corner-all:nth-child(2) div.DataContainer.detailviewTabLoad.ui-tabs-panel.ui-widget-content.ui-corner-bottom:nth-child(2) div.patent-text.topSpacer.wordwrapping div.topSpacer.wordwrapping:nth-child(15) span.ng-scope:nth-child(2) > span.patseer_Secondary_Button.ng-binding")))
						.build().perform();
				Thread.sleep(3000);

				if (GetDriver().findElement(By.xpath("//b[contains(text(),'Class')]")).isDisplayed()) {
					Assert.assertTrue(true);
				} else {

					Assert.assertTrue(false);
				}

			}

		}

		GetDriver().switchTo().window(patseerh);

	}

	@Test
	public void US_Pair_ClickOn_LegalStatusIcon_OnDetailview() throws Exception {

		try {
			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();
		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:US5796952A");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_US5796952A")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_US5796952A")));

		String h1 = "";
		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {

			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);
				h1 = h;
				GetDriver().findElement(By.xpath("//a[@id='ui-id-19']")).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailViewDataNg_legalStatusDiv']//i[@class='mdi mdi-bank legal medium handPointer floatLeft']")))
						.click();

			}

		}

		Set<String> handle1 = GetDriver().getWindowHandles();

		for (String h2 : handle1) {

			if (!h2.equals(h1) && !h2.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h2);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='lnkShowRegisterInfoUS']")))
						.click();

			}

		}
		Thread.sleep(1000);
		Set<String> handle2 = GetDriver().getWindowHandles();
		if (handle2.size() > 3) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@Test
	public void check_citation_of_Self_SFAM_EFAM_on_DetailView() throws Exception {

		try {

			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		// GetDriver().switchTo().defaultContent();
		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE102013106879A1");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_DE102013106879A1")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_DE102013106879A1")));

		GetDriver().findElement(By.xpath("//label[@id='lblText_DE102013106879A1']")).click();

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.cssSelector("#ui-id-22")).click();

				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmBackCitation")));

				Thread.sleep(1000);
			}

		}

		String arr[] = GetDriver().findElement(By.cssSelector(
				"body.pageBody.ui-widget.ng-scope:nth-child(2) form.ng-pristine.ng-valid:nth-child(1) div.master_resultContainer.ui-widget-content:nth-child(10) div.master_middlepanel.ui-widget-content.dummymaster_middlepanel:nth-child(3) div.patseerSubTabs div.patseerSubTabs div.patseer_tabs.litabContainer.ui-tabs.ui-widget.ui-widget-content.ui-corner-all:nth-child(3) div.ui-tabs-panel.ui-widget-content.ui-corner-bottom.ng-scope:nth-child(3) div.iframeClass.ng-scope div.ng-scope div.gridHeader.floatLeft.citation-margineleft.citationHeaderWidth:nth-child(4) > span.ng-binding:nth-child(3)"))
				.getText().split(" ");

		Thread.sleep(500);

		int val = Integer.valueOf(arr[0]);

		if (val > 3) {

		} else {

			Assert.assertTrue(false);
		}

		Select sel = new Select(GetDriver().findElement(By.id("ContentPlaceHolder1_drpDataType")));
		sel.selectByVisibleText("Simple Family");
		Thread.sleep(4000);

		String arr1[] = GetDriver().findElement(By.cssSelector(
				"body.pageBody.ui-widget.ng-scope:nth-child(2) form.ng-pristine.ng-valid:nth-child(1) div.master_resultContainer.ui-widget-content:nth-child(10) div.master_middlepanel.ui-widget-content.dummymaster_middlepanel:nth-child(3) div.patseerSubTabs div.patseerSubTabs div.patseer_tabs.litabContainer.ui-tabs.ui-widget.ui-widget-content.ui-corner-all:nth-child(3) div.ui-tabs-panel.ui-widget-content.ui-corner-bottom.ng-scope:nth-child(3) div.iframeClass.ng-scope div.ng-scope div.gridHeader.floatLeft.citation-margineleft.citationHeaderWidth:nth-child(4) > span.ng-binding:nth-child(7)"))
				.getText().split(" ");

		val = Integer.valueOf(arr1[0]);

		if (val > 41) {
			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);
		}

		GetDriver().switchTo().window(patseerh);
	}

	@Test
	public void Translate_To_English() throws Exception {

		try {

			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}

		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		Thread.sleep(1000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:DE112013004585T8");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_DE112013004585T8")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_DE112013004585T8")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.cssSelector("#ui-id-25")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//div[@id='liveTranslateFullViewClaim']//div[@id='translationControl']"))).click();

			}

		}
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='txtTranslationFullView']//div[@id='divClose']")))
				.isDisplayed();

		if (GetDriver().findElement(By.xpath("//div[@id='translationContainerFullview']")).getText()
				.contains("The corresponding English translation")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		GetDriver().switchTo().window(patseerh);
	}

	@Test
	public void View_Category_Of_Citations_on_DetailView() throws Exception {

		try {

			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		// GetDriver().switchTo().defaultContent();
		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:EP1465369A1");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_EP1465369A1")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_EP1465369A1")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.cssSelector("#ui-id-22")).click();

				GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmBackCitation")));

				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(GetDriver().findElement(By.cssSelector("#ui-id-2"))))
						.click();

			}

		}

		a.moveToElement(
				GetDriver().findElement(By.xpath("//div[@id='trnumber_CN103959859B']//label[@id='lblTypeCategory']")))
				.build().perform();

		if (GetDriver().findElement(By.xpath("//div[@id='trnumber_CN103959859B']//label[@id='lblTypeCategory']"))
				.getAttribute("title")
				.contains("Particularly relevant if combined with another Y-document Objection")) {
			Assert.assertTrue(true);

		} else {

			Assert.assertTrue(false);
		}

		GetDriver().switchTo().window(patseerh);
	}

	@Test
	public void Claims_Fallback() throws Exception {

		try {

			Set<String> handle1 = GetDriver().getWindowHandles();

			for (String h : handle1) {
				if (!h.equals(patseerh)) {
					GetDriver().switchTo().window(h);
					GetDriver().close();

				}
			}

			GetDriver().switchTo().window(patseerh);

		} catch (Exception e) {
		}
		// GetDriver().switchTo().defaultContent();
		Actions a = new Actions(GetDriver());
		WebDriverWait wait = new WebDriverWait(GetDriver(), 50);

		String patseerh = GetDriver().getWindowHandle();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.clear();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']")))
				.sendKeys("pnc:GB0611990D0");

		Thread.sleep(2000);

		GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click();

		JavascriptExecutor js = (JavascriptExecutor) GetDriver();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lblText_GB0611990D0")));
		js.executeScript("arguments[0].click();", GetDriver().findElement(By.cssSelector("#lblText_GB0611990D0")));

		Set<String> handle = GetDriver().getWindowHandles();

		for (String h : handle) {
			if (!h.equals(patseerh)) {
				GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				GetDriver().switchTo().window(h);

				GetDriver().findElement(By.cssSelector("#ui-id-26")).click();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailsViewContainer']//div[@id='divFullView']//div//div[@id='divClmmssg']")));

			}

		}

		if (GetDriver().findElement(By.xpath(
				"//div[@id='ContentPlaceHolder1_detailsViewCntrl_detailsViewContainer']//div[@id='divFullView']//div//div[@id='divClmmssg']"))
				.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		GetDriver().switchTo().window(patseerh);
	}

	/*
	 * 
	 * @Test public void DetailedView_citation_AddtoProject() throws Exception {
	 * System.out.println("DetailedView_citation_AddtoProject");
	 * 
	 * 
	 * String s=" ASN:google and PBC:DE"; try{
	 * 
	 * Set<String> handle1 = GetDriver().getWindowHandles();
	 * 
	 * for (String h : handle1) { if (!h.equals(patseerh)) {
	 * GetDriver().switchTo().window(h); GetDriver().close();
	 * 
	 * } }
	 * 
	 * 
	 * GetDriver().switchTo().window(patseerh);
	 * 
	 * } catch(Exception e) {} //GetDriver().switchTo().defaultContent(); Actions
	 * a=new Actions(GetDriver()); WebDriverWait wait=new
	 * WebDriverWait(GetDriver(),50); cmd(s); String
	 * patseerh=GetDriver().getWindowHandle();
	 * 
	 * GetDriver().findElement(By .xpath("//label[@id='lblText_DE112013004585B4']"))
	 * .click();
	 * 
	 * Set<String> handle = GetDriver().getWindowHandles();
	 * 
	 * for (String h : handle) { if (!h.equals(patseerh)) {
	 * GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 * GetDriver().switchTo().window(h);
	 * 
	 * GetDriver().findElement(By.cssSelector("#ui-id-22")).click();
	 * 
	 * GetDriver().switchTo().frame(GetDriver().findElement(By.id("frmBackCitation")
	 * ));
	 * 
	 * GetDriver().findElement(By.xpath("//input[@id='chkAllCheckBox_Backward']")).
	 * click();
	 * GetDriver().findElement(By.xpath("//div[@id='divAddToProject']")).click();
	 * GetDriver().switchTo().defaultContent(); Thread.sleep(500);
	 * GetDriver().findElement(By.xpath(
	 * "//input[@id='token-input-txtProjectNameRecent']")).sendKeys("BckAutomate");
	 * Thread.sleep(1000);
	 * 
	 * GetDriver().findElement(By.xpath(
	 * "//input[@id='token-input-txtProjectNameRecent']")).sendKeys(Keys.ENTER);
	 * Thread.sleep(1000);
	 * 
	 * WebElement save = wait
	 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//button[@id='divAPQ']"))); save.click();
	 * 
	 * }
	 * 
	 * } GetDriver().switchTo().window(patseerh); Thread.sleep(3000); WebElement pr
	 * = GetDriver().findElement(By.linkText("Project"));
	 * a.moveToElement(pr).perform();
	 * 
	 * GetDriver().findElement(By.xpath("//a[@class='m_5_s_2']")).click();
	 * Thread.sleep(3000); GetDriver().manage().timeouts().implicitlyWait(20,
	 * TimeUnit.SECONDS); Thread.sleep(2000); JavascriptExecutor js =
	 * (JavascriptExecutor) GetDriver();
	 * 
	 * js.executeScript("arguments[0].click();", GetDriver().findElement(By.
	 * xpath("//table[@class='projectTabIndex_2']//a[@class='patseer_Secondary_Button leftSpacer'][contains(text(),'BckAutomate')]"
	 * ))); //
	 * GetDriver().findElement(By.xpath("//a[contains(text(),'BckAutomate')]")).
	 * click(); Thread.sleep(2000); GetDriver().navigate().refresh();
	 * 
	 * String rec[] = GetDriver() .findElement(By .xpath(
	 * "/html[1]/body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[3]/div[1]/span[3]"
	 * )) .getText().split(" "); try{ int records = Integer.valueOf(rec[0]);
	 * 
	 * if (records > 0) {
	 * GetDriver().findElement(By.xpath("//input[@id='chkAllCheckBox']")).click();
	 * a.moveToElement(GetDriver().findElement(By
	 * .xpath("//li[@id='ContentPlaceHolder1_tabCntrl_ctl02_liRemove']//i[@class='mdi mdi-chevron-down']"
	 * ))) .perform(); GetDriver().findElement(By.xpath(
	 * "//div[@id='ContentPlaceHolder1_tabCntrl_ctl02_divRemoveProject']")).click();
	 * 
	 * GetDriver().findElement(By.xpath("//a[@id='btnPromptYes']")).click();
	 * 
	 * GetDriver().findElement(By.xpath("//button[@id='btnMergeOk']")).click();
	 * 
	 * Assert.assertTrue(true); } } catch(Exception e) {}
	 * 
	 * }
	 * 
	 * 
	 * @Test public void Similar_RecordTab_AddTOPROJECT_FromDetailedView() throws
	 * Exception {
	 * 
	 * System.out.println("Similar_RecordTab_AddTOPROJECT_FromDetailedView");
	 * 
	 * String s=" ASN:google and PBC:DE";
	 * 
	 * try{ Set<String> handle1 = GetDriver().getWindowHandles();
	 * 
	 * for (String h : handle1) { if (!h.equals(patseerh)) {
	 * GetDriver().switchTo().window(h); GetDriver().close();
	 * 
	 * } }
	 * 
	 * 
	 * GetDriver().switchTo().window(patseerh);
	 * 
	 * } catch(Exception e) {}
	 * 
	 * Actions a=new Actions(GetDriver()); cmd(s); String
	 * patseerh=GetDriver().getWindowHandle(); WebDriverWait wait=new
	 * WebDriverWait(GetDriver(),50);
	 * 
	 * GetDriver().findElement(By .xpath("//label[@id='lblText_DE112013004585B4']"))
	 * .click(); Thread.sleep(2000);
	 * 
	 * Set<String> handle = GetDriver().getWindowHandles();
	 * 
	 * for (String h : handle) { if (!h.equals(patseerh)) {
	 * GetDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 * GetDriver().switchTo().window(h);
	 * 
	 * GetDriver().findElement(By.cssSelector("#ui-id-23")).click();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * // wait.until(ExpectedConditions.visibilityOf(GetDriver().findElement(By.
	 * cssSelector("#chkAllCheckBox"))));
	 * GetDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 * GetDriver().findElement(By.cssSelector("#chkAllCheckBox")).click();
	 * 
	 * a.moveToElement(GetDriver().findElement(By .xpath(
	 * "//li[@id='ContentPlaceHolder1_detailsViewCntrl_SearchResultsControlNGview_liAdd']//span[contains(text(),'Add')]"
	 * ))) .perform();
	 * 
	 * GetDriver().findElement(By .xpath(
	 * "//div[@id='ContentPlaceHolder1_detailsViewCntrl_SearchResultsControlNGview_divAddToProject']//span[contains(text(),'Project')]"
	 * )) .click();
	 * 
	 * GetDriver().findElement(By.xpath(
	 * "//input[@id='token-input-txtProjectNameRecent']")).sendKeys("BckAutomate");
	 * 
	 * Thread.sleep(1000); GetDriver().findElement(By.xpath(
	 * "//input[@id='token-input-txtProjectNameRecent']")).sendKeys(Keys.ENTER);
	 * Thread.sleep(1000);
	 * 
	 * WebElement save =
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//button[@id='divAPQ']"))); save.click();
	 * 
	 * Thread.sleep(3000); GetDriver().switchTo().window(patseerh);
	 * 
	 * WebElement pr = GetDriver().findElement(By.linkText("Project"));
	 * a.moveToElement(pr).perform();
	 * 
	 * GetDriver().findElement(By.xpath("//a[@class='m_5_s_2']")).click();
	 * Thread.sleep(3000); GetDriver().manage().timeouts().implicitlyWait(20,
	 * TimeUnit.SECONDS); JavascriptExecutor js = (JavascriptExecutor) GetDriver();
	 * js.executeScript("arguments[0].click();", GetDriver().findElement(By.
	 * xpath("//table[@class='projectTabIndex_2']//a[@class='patseer_Secondary_Button leftSpacer'][contains(text(),'BckAutomate')]"
	 * ))); //
	 * GetDriver().findElement(By.xpath("//a[contains(text(),'BckAutomate')]")).
	 * click();
	 * 
	 * Thread.sleep(3000); String rec[] = GetDriver() .findElement(By .xpath(
	 * "/html[1]/body[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[3]/div[1]/span[3]"
	 * )) .getText().split(" "); int records = Integer.valueOf(rec[0]);
	 * GetDriver().navigate().refresh(); if (records > 0) {
	 * 
	 * GetDriver().findElement(By.xpath("//input[@id='chkAllCheckBox']")).click();
	 * a.moveToElement(GetDriver().findElement(By
	 * .xpath("//li[@id='ContentPlaceHolder1_tabCntrl_ctl02_liRemove']//i[@class='mdi mdi-chevron-down']"
	 * ))) .perform(); GetDriver().findElement(By.xpath(
	 * "//div[@id='ContentPlaceHolder1_tabCntrl_ctl02_divRemoveProject']")).click();
	 * 
	 * GetDriver().findElement(By.xpath("//a[@id='btnPromptYes']")).click();
	 * 
	 * try {
	 * GetDriver().findElement(By.xpath("//button[@id='btnMergeOk']")).click();
	 * 
	 * Assert.assertTrue(true); } catch (Exception e) {
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * @Test public void IgnoreRecord() throws Exception {
	 * System.out.println("IgnoreRecord");
	 * 
	 * String s=" ASN:google and PBC:DE";
	 * 
	 * try{ Set<String> handle1 = GetDriver().getWindowHandles();
	 * 
	 * for (String h : handle1) { if (!h.equals(patseerh)) {
	 * GetDriver().switchTo().window(h); GetDriver().close();
	 * 
	 * } }
	 * 
	 * 
	 * GetDriver().switchTo().window(patseerh);
	 * 
	 * } catch(Exception e) {}
	 * 
	 * 
	 * WebDriverWait wait=new WebDriverWait(GetDriver(),50); Actions a = new
	 * Actions(GetDriver()); WebElement se =
	 * GetDriver().findElement(By.linkText("Search"));
	 * a.moveToElement(se).perform();
	 * 
	 * GetDriver().findElement(By.linkText("Command Line Search")).click();
	 * 
	 * GetDriver().findElement(By.xpath("//label[@class='onoffswitch-label']")).
	 * click(); Thread.sleep(500);
	 * GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).clear();
	 * GetDriver().findElement(By.xpath("//textarea[@id='txtSpellCheck']")).sendKeys
	 * (s); Thread.sleep(2000); a.moveToElement(GetDriver().findElement(By.
	 * xpath("//div[@class='floatLeft width90 topSpacer']//input[@id='Checkbox1']"))
	 * ).perform();
	 * 
	 * JavascriptExecutor js = (JavascriptExecutor) GetDriver();
	 * 
	 * js.executeScript("arguments[0].click();", GetDriver().findElement(By.
	 * xpath("//div[@class='floatLeft width90 topSpacer']//input[@id='Checkbox1']"))
	 * );
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * GetDriver().findElement(By.xpath("//a[@id='searchId']")).click();
	 * Thread.sleep(5000);
	 * 
	 * 
	 * 
	 * GetDriver().findElement(By
	 * .xpath("//div[@id='leftUpperPanel_SearchSummaryContainer_filterContainer']//span[@class='floatLeft ng-binding'][contains(text(),'Search within Records')]"
	 * )) .click();
	 * 
	 * GetDriver().findElement(By.
	 * xpath("//div[@class='width100 ng-scope']//textarea[@id='SearchTerm']"))
	 * .sendKeys("pnc:DE112013004585B4 "); Thread.sleep(1000);
	 * GetDriver().findElement(By.xpath("//button[@id='applydivID']")).click(); int
	 * e1 = 0; Thread.sleep(2000);
	 * 
	 * 
	 * GetDriver().findElement(By.xpath(
	 * "//i[@id='disableSeachScriptRecord_DE112013004585B4']")).click();
	 * Thread.sleep(2000);
	 * 
	 * 
	 * // GetDriver().findElement(By.xpath(
	 * "//i[@id='disableSeachScriptRecord_DE112013004585B4']")).click();
	 * 
	 * 
	 * try { GetDriver().findElement(By.xpath(
	 * "//i[@id='enableSeachScriptRecord_DE112013004585B4']")); } catch (Exception
	 * e) { System.out.println(e); Assert.assertTrue(false);
	 * 
	 * }
	 * 
	 * }
	 */

}
