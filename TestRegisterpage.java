package parabank_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import essentials.Essentials;
import essentials.ListenerClass;

@Listeners(ListenerClass.class)
public class TestRegisterpage {

	WebDriver driver;
	RegisterPage rp;

	@BeforeClass
	void setup() {

		
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		  driver.manage().window().maximize();
		  driver.get("https://parabank.parasoft.com/parabank/index.htm");
		  rp = new RegisterPage(driver);
	}

	@Test(priority = 1)
	void VerifyPage() {
		Assert.assertEquals(rp.VerifyLogo(), true);

	}
	
	@Test(priority = 2, dataProvider = "registeration", dataProviderClass = Essentials.RegisterationDataProvider.class)
	
	void TestRegistrationPage(String firstname, String lastname, String address, String city, String state,
			String zipcode, String phone, String SSN, String username, String password, String conpassword)
			throws InterruptedException {

		rp.cleandata();
		rp.OpenRegisterationform();
		Assert.assertEquals(rp.verifysignuppage(), "Signing up is easy!");
		rp.SetFirstName(firstname);
		Essentials.HighLightElement(driver, rp.txtbox_FirstName);
		rp.SetLastName(lastname);
		Essentials.HighLightElement(driver, rp.txtbox_LastName);
		rp.SetAddress(address);
		Essentials.HighLightElement(driver, rp.txtbox_Address);
		rp.SetCity(city);
		Essentials.HighLightElement(driver, rp.txtbox_City);
		rp.SetState(state);
		Essentials.HighLightElement(driver, rp.txtbox_State);
		rp.SetZipCode(zipcode);
		Essentials.HighLightElement(driver, rp.txtbox_ZipCode);
		rp.SetPhoneNumber(phone);
		Essentials.HighLightElement(driver, rp.txtbox_Phonenumber);
		rp.SetSSN(SSN);
		Essentials.HighLightElement(driver, rp.txtbox_SSN);
		rp.SetUserName(username);
		Essentials.HighLightElement(driver, rp.txtbox_UserName);
		rp.SetPassword(password);
		Essentials.HighLightElement(driver, rp.txtbox_Password);
		rp.SetConfirmPassword(conpassword);
		Essentials.HighLightElement(driver, rp.txtbox_ConfirmPass);
		Essentials.takeScreenshot(driver);
		Essentials.HighLightElement(driver, rp.btn_signup);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.verifySignup(), "Your account was created successfully. You are now logged in.");
		Assert.assertEquals(rp.verifySignuptitle(), "Welcome " + firstname);
		Essentials.HighLightElement(driver, rp.txt_Signuptitle);
		Essentials.takeScreenshot(driver);
		System.out.println("Valid TestCase Passed");

	}

	@Test(priority = 3, dataProvider = "registeration", dataProviderClass = Essentials.RegisterationDataProvider.class)
	void TestRegisterationPageInvalid(String firstname, String lastname, String address, String city, String state,
			String zipcode, String phone, String SSN, String username, String password, String conpassword) {
		rp.ClickLogout();
		rp.cleandata();
		// rp.initializedatabase();
		rp.OpenRegisterationform();
		Assert.assertEquals(rp.verifysignuppage(), "Signing up is easy!");
		rp.ClickOnRegistersignup();
		Essentials.takeScreenshot(driver);
		Assert.assertEquals(rp.Verifyfnametxtbox(), "First name is required.");
		rp.SetFirstName(firstname);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifylnametxtbox(), "Last name is required.");
		rp.SetLastName(lastname);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifyaddresstxtbox(), "Address is required.");
		rp.SetAddress(address);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifycitytxtbox(), "City is required.");
		rp.SetCity(city);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifystatetxtbox(), "State is required.");
		rp.SetState(state);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifyzipcodetxtbox(), "Zip Code is required.");
		rp.SetZipCode(zipcode);
		rp.SetPhoneNumber(phone);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.VerifySSNtxtbox(), "Social Security Number is required.");
		rp.SetSSN(SSN);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifyusernametxtbox(), "Username is required.");
		rp.SetUserName(username);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifypasswordtxtbox(), "Password is required.");
		rp.SetPassword(password);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.Verifyconfirmpasstxtbox(), "Password confirmation is required.");
		rp.SetPassword(password);
		rp.SetConfirmPassword(conpassword);
		Essentials.takeScreenshot(driver);
		rp.ClickOnRegistersignup();
		Assert.assertEquals(rp.verifySignup(), "Your account was created successfully. You are now logged in.");
		Assert.assertEquals(rp.verifySignuptitle(), "Welcome " + firstname);
		Essentials.takeScreenshot(driver);
		System.out.println("Invalid TestCase Passed");

	}

	@Test(priority = 4, dataProvider = "registeration", dataProviderClass = Essentials.RegisterationDataProvider.class)
	void TestRegistrationPagewithExsistingUser(String firstname, String lastname, String address, String city,
			String state, String zipcode, String phone, String SSN, String username, String password,
			String conpassword) {
		
		rp.ClickLogout();
		rp.OpenRegisterationform();
		Assert.assertEquals(rp.verifysignuppage(), "Signing up is easy!");
		rp.SetFirstName(firstname);
		rp.SetLastName(lastname);
		rp.SetAddress(address);
		rp.SetCity(city);
		rp.SetState(state);
		rp.SetZipCode(zipcode);
		rp.SetPhoneNumber(phone);
		rp.SetSSN(SSN);
		rp.SetUserName(username);
		rp.SetPassword(password);
		rp.SetConfirmPassword(conpassword);
		Essentials.takeScreenshot(driver);
		rp.ClickOnRegistersignup();
		Essentials.takeScreenshot(driver);
		Assert.assertEquals(rp.Verifyusernametxtbox(), "This username already exists.");
		System.out.println("Invalid TestCase with Existing User Passed");

	}

	 @AfterClass
	void CloseBrowser() {
		driver.quit();
		System.out.println("Browser Closed");
	}

}