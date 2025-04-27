package parabank_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import essentials.Essentials;

public class TestForgotLoginInfo {

	WebDriver driver;
	ForgotLoginInfo fl;

	@BeforeClass
	void setup() {
		
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		  driver.manage().window().maximize();
		  driver.get("https://parabank.parasoft.com/parabank/index.htm");
		 
		fl = new ForgotLoginInfo(driver);

	}

	@Test(priority = 1)
	void verifyclpage() {

		Assert.assertEquals(fl.VerifyCusLookupPage(), true);
	}

	// Valid Test Case Scenario

	@Test(priority = 2, dataProvider = "ForgotLogin", dataProviderClass = Essentials.ForgotInfoDataProvider.class)
	void ForgotLoginInfoValidTestCase(String clfirstname, String cllastname, String claddress, String clcity,
			String clstate, String clzipcode, String clphone, String clSSN, String logininfofound) {

		fl.ClickForgotloginInfo();
		fl.CLSetFirstName(clfirstname);
		fl.CLSetLastName(cllastname);
		fl.CLSetAddress(claddress);
		fl.CLSetCity(clcity);
		fl.CLSetState(clstate);
		fl.CLSetZipCode(clzipcode);
		fl.CLSetSSN(clSSN);
		Essentials.takeScreenshot(driver);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.VerifyLoginInfoFound(), logininfofound);
		Assert.assertEquals(fl.VerifyloginInfoDisplayed(), true);
		Assert.assertEquals(fl.VerifyloginInfoDisplayed1(), true);
		Essentials.takeScreenshot(driver);
		System.out.println("Valid Test Case Passed");

	}

	// Invalid Test Case Scenario with blank textbox

	@Test(priority = 3, dataProvider = "ForgotLogin", dataProviderClass = Essentials.ForgotInfoDataProvider.class)
	void ForgotLoginInfoInvalidTestCase(String clfirstname, String cllastname, String claddress, String clcity,
			String clstate, String clzipcode, String clphone, String clSSN, String logininfofound) {

		fl.ClickLogout();
		fl.ClickForgotloginInfo();
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifyclfnametxtbox(), true);
		Essentials.takeScreenshot(driver);
		fl.CLSetFirstName(clfirstname);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifycllnametxtbox(), true);
		fl.CLSetLastName(cllastname);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifycladdresstxtbox(), true);
		fl.CLSetAddress(claddress);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifyclcitytxtbox(), true);
		fl.CLSetCity(clcity);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifyclstatetxtbox(), true);
		fl.CLSetState(clstate);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifyclzipcodetxtbox(), true);
		fl.CLSetZipCode(clzipcode);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.VerifyclSSNtxtbox(), true);
		fl.CLSetSSN(clSSN);
		Essentials.takeScreenshot(driver);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.VerifyLoginInfoFound(), logininfofound);
		Assert.assertEquals(fl.VerifyloginInfoDisplayed(), true);
		Assert.assertEquals(fl.VerifyloginInfoDisplayed1(), true);
		Essentials.takeScreenshot(driver);
		System.out.println("Invalid Test Case with Blank TextBoxes Passed");
	}

	// Invalid Test Case Scenario with Invalid Credentials

	@Test(priority = 4, dataProvider = "InvalidLogin", dataProviderClass = Essentials.InvalidForgotInfoDataProvider.class)
	void ForgotLoginInfoInvalidcredTestCase(String clfirstname, String cllastname, String claddress, String clcity,
			String clstate, String clzipcode, String clphone, String clSSN, String errortxt) {

		fl.ClickLogout();
		fl.ClickForgotloginInfo();
		fl.CLSetFirstName(clfirstname);
		fl.CLSetLastName(cllastname);
		fl.CLSetAddress(claddress);
		fl.CLSetCity(clcity);
		fl.CLSetState(clstate);
		fl.CLSetZipCode(clzipcode);
		fl.CLSetSSN(clSSN);
		Essentials.takeScreenshot(driver);
		fl.CLClickFindLoginInfo();
		Assert.assertEquals(fl.Verifyerrtext(), errortxt);
		Essentials.takeScreenshot(driver);
		System.out.println("Invalid Test Case with Invalid Credentials Passed");

	}

	 @AfterClass
	void CloseBrowser() {
		driver.quit();
		System.out.println("Browser Closed");
	}

}
