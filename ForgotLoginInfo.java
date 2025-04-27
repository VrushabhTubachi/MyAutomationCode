package parabank_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotLoginInfo {

	public WebDriver driver;

	// Constructor
	ForgotLoginInfo(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElements

	// Page Title text
	@FindBy(xpath = "//h2[normalize-space()='Customer Login']")
	WebElement txt_cuslogintitle;

	// Forgot Login Info link
	@FindBy(linkText = "Forgot login info?")
	WebElement link_ForgotLoginInfo;

	// First Name Text Box
	@FindBy(id = "firstName")
	WebElement txtbox_CLfirstname;

	// Last Name Text Box
	@FindBy(id = "lastName")
	WebElement txtbox_CLlastname;

	// Address Text Box
	@FindBy(id = "address.street")
	WebElement txtbox_CLaddress;

	// City Text Box
	@FindBy(id = "address.city")
	WebElement txtbox_CLcity;

	// State Text Box
	@FindBy(id = "address.state")
	WebElement txtbox_CLstate;

	// Zip Code Text Box
	@FindBy(id = "address.zipCode")
	WebElement txtbox_CLzipcode;

	// SSN Text Box
	@FindBy(id = "ssn")
	WebElement txtbox_CLSSN;

	// Find My Login Info Button
	@FindBy(xpath = "//input[@value='Find My Login Info']")
	WebElement btn_CLfindlogininfo;

	// Customer Lookup Login Information found Successfully
	@FindBy(xpath = "//p[contains(text(),'Your login information was located successfully. Y')]")
	WebElement txt_loginInfoFound;

	// User Name found
	@FindBy(xpath = "//b[normalize-space()='Username']")
	WebElement usernamefound;

	// Login Details Found
	@FindBy(xpath = "//div[@id='rightPanel']//p[1]")
	WebElement foundlogininfo;

	// WebElements for Invalid TestCase

	// Error Text for Invalid Credentials
	@FindBy(xpath = "//p[@class='error']")
	WebElement err_frgloginInfo;

	// Error Text for First Name textbox
	@FindBy(id = "firstName")
	WebElement errtxt_clfirstname;

	// Error Text for Last Name textbox
	@FindBy(id = "lastName")
	WebElement errtxt_cllastname;

	// Error Text for Address textbox
	@FindBy(id = "address.street")
	WebElement errtxt_claddress;

	// Error Text for City textbox
	@FindBy(id = "address.city")
	WebElement errtxt_clcity;

	// Error Text for State textbox
	@FindBy(id = "address.state")
	WebElement errtxt_clstate;

	// Error Text for Zip Code textbox
	@FindBy(id = "address.zipCode")
	WebElement errtxt_clzipcode;

	// Error Text for SSN textbox
	@FindBy(id = "ssn")
	WebElement errtxt_clSSN;

	// Log Out Button
	@FindBy(linkText = "Log Out")
	WebElement btn_logout;

	// Action Methods for Valid Testcase

	// Click Forgot Login Info
	public void ClickForgotloginInfo() {
		link_ForgotLoginInfo.click();
	}

	// Verify Customer Lookup Page is Opened
	public boolean VerifyCusLookupPage() {
		boolean cuslookuptitle = txt_cuslogintitle.isDisplayed();
		return cuslookuptitle;
	}

	// Enter First Name
	public void CLSetFirstName(String clfirstname) {
		txtbox_CLfirstname.sendKeys(clfirstname);
	}

	// Enter Last Name
	public void CLSetLastName(String cllastname) {
		txtbox_CLlastname.sendKeys(cllastname);
	}

	// Enter Address
	public void CLSetAddress(String cladress) {
		txtbox_CLaddress.sendKeys(cladress);
	}

	// Enter City
	public void CLSetCity(String clcity) {
		txtbox_CLcity.sendKeys(clcity);
	}

	// Enter State
	public void CLSetState(String clstate) {
		txtbox_CLstate.sendKeys(clstate);
	}

	// Enter Zip Code
	public void CLSetZipCode(String clzipcode) {
		txtbox_CLzipcode.sendKeys(clzipcode);
	}

	// Enter SSN
	public void CLSetSSN(String clssn) {
		txtbox_CLSSN.sendKeys(clssn);
	}

	// Click Find My Login Info
	public void CLClickFindLoginInfo() {
		btn_CLfindlogininfo.click();
	}

	// verify Login Info is found
	public String VerifyLoginInfoFound() {
		String txtfound = txt_loginInfoFound.getText();
		return txtfound;
	}
	
	public boolean VerifyloginInfoDisplayed() {

		boolean infodisplayed = usernamefound.isDisplayed();
		return infodisplayed;
	}

	public boolean VerifyloginInfoDisplayed1() {

		boolean infodisplayed1 = usernamefound.isDisplayed();
		return infodisplayed1;
	}

	// Action Methods for Invalid TestCase

	public boolean Verifyclfnametxtbox() {
		boolean fnameerr = errtxt_clfirstname.isDisplayed();
		return fnameerr;
	}

	public boolean Verifycllnametxtbox() {
		boolean lnameerr = errtxt_cllastname.isDisplayed();
		return lnameerr;
	}

	public boolean Verifycladdresstxtbox() {
		boolean addresserr = errtxt_claddress.isDisplayed();
		return addresserr;
	}

	public boolean Verifyclcitytxtbox() {
		boolean cityerr = errtxt_clcity.isDisplayed();
		return cityerr;
	}

	public boolean Verifyclstatetxtbox() {
		boolean stateerr = errtxt_clstate.isDisplayed();
		return stateerr;
	}

	public boolean Verifyclzipcodetxtbox() {
		boolean zipcodeerr = errtxt_clzipcode.isDisplayed();
		return zipcodeerr;
	}

	public boolean VerifyclSSNtxtbox() {
		boolean SSNerr = errtxt_clSSN.isDisplayed();
		return SSNerr;
	}

	public String Verifyerrtext() {
		String frgloginInfo = err_frgloginInfo.getText();
		return frgloginInfo;
	}

	public void ClickLogout() {
		btn_logout.click();
	}
	
}
