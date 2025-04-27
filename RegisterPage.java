package parabank_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;

	// Constructor

	RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElements

	// Logo
	@FindBy(xpath = "//img[@title='ParaBank']")
	WebElement img_logo;

	// Register Button
	@FindBy(linkText = "Register")
	WebElement link_register;

	// First Name
	@FindBy(id = "customer.firstName")
	WebElement txtbox_FirstName;

	// Last Name
	@FindBy(id = "customer.lastName")
	WebElement txtbox_LastName;

	// Address
	@FindBy(id = "customer.address.street")
	WebElement txtbox_Address;

	// City
	@FindBy(id = "customer.address.city")
	WebElement txtbox_City;

	// State
	@FindBy(id = "customer.address.state")
	WebElement txtbox_State;

	// ZipCode
	@FindBy(id = "customer.address.zipCode")
	WebElement txtbox_ZipCode;

	// Phone number
	@FindBy(id = "customer.phoneNumber")
	WebElement txtbox_Phonenumber;

	// SSN#
	@FindBy(id = "customer.ssn")
	WebElement txtbox_SSN;

	// UserName
	@FindBy(id = "customer.username")
	WebElement txtbox_UserName;

	// Password
	@FindBy(id = "customer.password")
	WebElement txtbox_Password;

	// Confirm Password
	@FindBy(id = "repeatedPassword")
	WebElement txtbox_ConfirmPass;

	// Click On Register
	@FindBy(xpath = "//input[@value='Register']")
	WebElement btn_signup;

	// Verify Sign-up page title
	@FindBy(xpath = "//h1[normalize-space()='Signing up is easy!']")
	WebElement txt_PageTitle;

	// Verify Sign-Up Successful status
	@FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now')]")
	WebElement txt_Signupsuccessmsg;

	// Verify Sign-Up Successful status
	@FindBy(xpath = "//*[@id=\"rightPanel\"]/h1")
	WebElement txt_Signuptitle;

	// Admin Page
	@FindBy(linkText = "Admin Page")
	WebElement btn_AdminPage;

	// Clean Database
	@FindBy(xpath = "//button[normalize-space()='Clean']")
	WebElement btn_clean;
	
	// Initialize Database
	@FindBy(xpath = "//button[normalize-space()='Initialize']")
	WebElement btn_initialize;

	// WebElements for Invalid Test Cases

	// First Name TextBox Error
	@FindBy(id = "customer.firstName.errors")
	WebElement errtxt_firstname;

	//LastName TextBox Error
	@FindBy(id = "customer.lastName.errors")
	WebElement errtxt_lastname;

	//Address TextBox Error
	@FindBy(id = "customer.address.street.errors")
	WebElement errtxt_address;

	//City TextBox Error
	@FindBy(id = "customer.address.city.errors")
	WebElement errtxt_city;

	//State TextBox Error
	@FindBy(id = "customer.address.state.errors")
	WebElement errtxt_state;

	//zip code TextBox Error
	@FindBy(id = "customer.address.zipCode.errors")
	WebElement errtxt_zipcode;

	//SSN TextBox Error
	@FindBy(id = "customer.ssn.errors")
	WebElement errtxt_SSN;

	//User Name TextBox Error
	@FindBy(id = "customer.username.errors")
	WebElement errtxt_username;

	//Password TextBox Error
	@FindBy(id = "customer.password.errors")
	WebElement errtxt_password;

	//Confirm Password TextBox Error
	@FindBy(id = "repeatedPassword.errors")
	WebElement errtxt_confirmpass;
	
	//Log Out Button
	@FindBy(linkText = "Log Out")
	WebElement btn_logout;

	

	// Action Methods

	public boolean VerifyLogo() {
		boolean logo = img_logo.isDisplayed();
		return logo;
	}

	public void OpenRegisterationform() {
		link_register.click();
	}

	// Verify Sign-up Page Title
	public String verifysignuppage() {
		String SPtitle = txt_PageTitle.getText();
		return SPtitle;
	}

	public void SetFirstName(String firstname) {
		txtbox_FirstName.sendKeys(firstname);
	}

	public void SetLastName(String lastname) {
		txtbox_LastName.sendKeys(lastname);
	}

	public void SetAddress(String address) {
		txtbox_Address.sendKeys(address);
	}

	public void SetCity(String city) {
		txtbox_City.sendKeys(city);
	}

	public void SetState(String state) {
		txtbox_State.sendKeys(state);
	}

	public void SetZipCode(String zipcode) {
		txtbox_ZipCode.sendKeys(zipcode);
	}

	public void SetPhoneNumber(String phone) {
		txtbox_Phonenumber.sendKeys(phone);
	}

	public void SetSSN(String SSN) {
		txtbox_SSN.sendKeys(SSN);
	}

	public void SetUserName(String username) {
		txtbox_UserName.sendKeys(username);
	}

	public void SetPassword(String password) {
		txtbox_Password.sendKeys(password);
	}

	public void SetConfirmPassword(String conpassword) {
		txtbox_ConfirmPass.sendKeys(conpassword);
	}

	public void ClickOnRegistersignup() {
		btn_signup.click();
	}

	public String verifySignup() {
		String signupmsg = txt_Signupsuccessmsg.getText();
		return signupmsg;
	}

	public String verifySignuptitle() {
		String signuptitle = txt_Signuptitle.getText();
		return signuptitle;
	}

	public void cleandata() {
		btn_AdminPage.click();
		btn_clean.click();
	}
	
	public void initializedatabase() {
		btn_initialize.click();
	}
	
	
	// Action Methods for Invalid TestCase
	
	public String Verifyfnametxtbox() {
		String fnameerr = errtxt_firstname.getText();
		return fnameerr;
	}
	
	public String Verifylnametxtbox() {
		String lnameerr = errtxt_lastname.getText();
		return lnameerr;
	}
	
	public String Verifyaddresstxtbox() {
		String addresserr = errtxt_address.getText();
		return addresserr;
	}
	
	public String Verifycitytxtbox() {
		String cityerr = errtxt_city.getText();
		return cityerr;
	}
	
	public String Verifystatetxtbox() {
		String stateerr = errtxt_state.getText();
		return stateerr;
	}
	
	public String Verifyzipcodetxtbox() {
		String zipcodeerr = errtxt_zipcode.getText();
		return zipcodeerr;
	}
	
	public String VerifySSNtxtbox() {
		String SSNerr = errtxt_SSN.getText();
		return SSNerr;
	}
	
	public String Verifyusernametxtbox() {
		String usernameerr = errtxt_username.getText();
		return usernameerr;
	}
	
	public String Verifypasswordtxtbox() {
		String passworderr = errtxt_password.getText();
		return passworderr;
	}
	
	public String Verifyconfirmpasstxtbox() {
		String confirmpasserr = errtxt_confirmpass.getText();
		return confirmpasserr;
	}
	
	public void ClickLogout() {
		btn_logout.click();
	}
	
}
