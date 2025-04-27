package parabank_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import essentials.Essentials;

public class TestLoginPage {

	WebDriver driver;
	LoginPage lp;

	@BeforeClass
	void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		lp = new LoginPage(driver);
	}

	// Verify page
	@Test(priority = 1)
	void verifyPage() {
		Assert.assertEquals(lp.VerifyCusLogintitle(), "Customer Login");
	}

	@Test(priority = 2, dataProvider = "Login", dataProviderClass = Essentials.LoginDataProvider.class)
	void TestLogin(String username, String password, String lastname) throws InterruptedException {

		Assert.assertEquals(lp.VerifyCusLogintitle(), "Customer Login");
		lp.SetUsername(username);
		Essentials.HighLightElement(driver, lp.txtbox_Usename);
		lp.SetPassword(password);
		Essentials.HighLightElement(driver, lp.txtbox_Password);
		Essentials.takeScreenshot(driver);
		lp.ClickLoginBTN();
		Essentials.takeScreenshot(driver);
		Assert.assertEquals(lp.VerifyAccHolderName(), "Welcome " + username + " " + lastname);
		Assert.assertEquals(lp.VerifyAccOverviewpage(), "Accounts Overview");
		Assert.assertEquals(lp.txt_AccOverviewContent_account.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_accountVal.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_availableamt.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_availableamtVal.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_balance.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_balanceVal.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_Total.isDisplayed(), true);
		Assert.assertEquals(lp.txt_AccOverviewContent_TotalVal.isDisplayed(), true);
		Essentials.HighLightElementwithbox(driver, lp.AccOverviewContent_Table);
		Essentials.takeScreenshot(driver);
		System.out.println("LoginPage Valid Test Case Passed");

	}

	@Test(priority = 3, dataProvider = "LoginPageInvalid", dataProviderClass = Essentials.LoginInvalidDataProvider.class)
	void TestLoginInvalidTestCase(String username, String password) throws InterruptedException {

		lp.ClickLogoutBtn();
		Assert.assertEquals(lp.VerifyCusLogintitle(), "Customer Login");
		lp.SetUsername(username);
		Essentials.HighLightElement(driver, lp.txtbox_Usename);
		lp.SetPassword(password);
		Essentials.HighLightElement(driver, lp.txtbox_Password);
		Essentials.takeScreenshot(driver);
		lp.ClickLoginBTN();
		//Assert.assertEquals(lp.LoginPageError(), "An internal error has occurred and has been logged.");
		//Assert.assertEquals(lp.LoginPageError(), "The username and password could not be verified.");
		Essentials.takeScreenshot(driver);
		System.out.println("LoginPage Valid Test Case Passed");
	}

	@AfterClass
	void CloseBrowser() {

		driver.quit();
		System.out.println("Browser Closed");
	}

}
