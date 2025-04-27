package parabank_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	// Constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements
	
	// UserName
	@FindBy(name = "username")
	WebElement txtbox_Usename;
	
	//Password
	@FindBy(name = "password")
	WebElement txtbox_Password;
	
	//Login Button
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement btn_Login;
	
	// Logout Button
	@FindBy(linkText = "Log Out")
	WebElement btn_Logout;
	
	//Account Overview page verification
	@FindBy(xpath = "//p[@class='smallText']")
	WebElement txt_name;
	
	//Account Overview Page Verification
	@FindBy(xpath = "//h1[normalize-space()='Accounts Overview']")
	WebElement txt_title;
	
	@FindBy(xpath = "//p[@class='smallText']")
	WebElement txt_AccOverviewContent_account;
	
	@FindBy(xpath = "//th[normalize-space()='Balance*']")
	WebElement txt_AccOverviewContent_balance;
	
	@FindBy(xpath = "//th[normalize-space()='Available Amount']")
	WebElement txt_AccOverviewContent_availableamt;
	
	@FindBy(xpath = "//a[normalize-space()='13455']")
	WebElement txt_AccOverviewContent_accountVal;
	
	@FindBy(xpath = "//tr[@class='ng-scope']//td[1]")
	WebElement txt_AccOverviewContent_balanceVal;
	
	@FindBy(xpath = "//tr[@class='ng-scope']//td[1]")
	WebElement txt_AccOverviewContent_availableamtVal;
	
	@FindBy(xpath = "//b[normalize-space()='Total']")
	WebElement txt_AccOverviewContent_Total;
	
	@FindBy(xpath = "//b[@class='ng-binding']")
	WebElement txt_AccOverviewContent_TotalVal;
	
	@FindBy(id = "accountTable")
	WebElement AccOverviewContent_Table;
	
	//Customer Login Page Title
	@FindBy(xpath = "//h2[normalize-space()='Customer Login']")
	WebElement txt_cuslogintitle;
	
	// Customer Login Error
	@FindBy(xpath = "//p[@class='error']")
	WebElement txt_loginpageerror;
	
	
	// Action Methods
	
	public void SetUsername(String username) {
		txtbox_Usename.sendKeys(username);
	}
	
	public void SetPassword(String password) {
		txtbox_Password.sendKeys(password);
	}

	public void ClickLoginBTN() {
		btn_Login.click();
	}
	
	public String VerifyAccHolderName() {
		String name = txt_name.getText();
		return name;
	}
	
	public String VerifyAccOverviewpage() {
		String title = txt_title.getText();
		return title;
	}
	
	public String VerifyCusLogintitle() {
		String logintitle = txt_cuslogintitle.getText();
		return logintitle;
	}
	
	public void ClickLogoutBtn() {
		btn_Logout.click();
	}
	
	public String LoginPageError() {
		String loginerror = txt_loginpageerror.getText();
		return loginerror;
	}
}
