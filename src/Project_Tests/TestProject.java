package Project_Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Project_Pages.CitiesPage;
import Project_Pages.LoginPage;
import Project_Pages.MessagePopUpPage;
import Project_Pages.NavPage;
import Project_Pages.SignupPage;


public class TestProject {

	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	private LoginPage loginPage;
	private NavPage navPage;
	private SignupPage signupPage;
	private CitiesPage citiesPage;
	private MessagePopUpPage messagePopUpPage;
	
	
	
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		loginPage = new LoginPage(driver, wait);
		navPage = new NavPage(driver, wait);
		signupPage = new SignupPage(driver, wait);
		citiesPage = new CitiesPage(driver, wait);
		messagePopUpPage = new MessagePopUpPage(driver, wait);
		
	}
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 10)
	public void visitsTheLoginPage() {
		navPage.getlanguageLink().click();
		navPage.getEngLanguageFromLanguageLink().click();
		navPage.getloginButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
		
	}
	
	@Test (priority = 20)
	public void ChecksInputTypes(){
		navPage.getloginButton().click();
		String actualResemail = loginPage.getemailLoginInput().getAttribute("type");
		String expectedemail = "email";
		Assert.assertEquals(actualResemail, expectedemail, "Attribute type should contains text email");
		String actualResPass = loginPage.getpasswordLoginInput().getAttribute("type");
		String expectedPass = "password";
		Assert.assertEquals(actualResPass, expectedPass, "Attribute type should contains text password");
	}
	
	@Test(priority = 30)
	public void DisplaysErrorsWhenUserDoesNotExist() {
		navPage.getloginButton().click();
		loginPage.getemailLoginInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getpasswordLoginInput().sendKeys("password123");
		loginPage.getloginButton().click();
		messagePopUpPage.getWaitUntilPopUpIsVisibile();
		messagePopUpPage.getElementContainsMessagesTextsInPopUp()
		.getText().contains("User does not exists");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
	}
	
	@Test (priority = 40)
	public void DisplaysErrorsWhenPasswordIsWrong() {
		navPage.getloginButton().click();
		loginPage.getemailLoginInput().sendKeys("admin@admin.com");
		loginPage.getpasswordLoginInput().sendKeys("password123");
		loginPage.getloginButton().click();
		messagePopUpPage.getWaitUntilPopUpIsVisibile();
		messagePopUpPage.getElementContainsMessagesTextsInPopUp()
		.getText().contains("Wrrong password");
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
	}
	
	@Test (priority = 50)
	public void login() throws InterruptedException {
		navPage.getloginButton().click();
		loginPage.getemailLoginInput().sendKeys("admin@admin.com");
		loginPage.getpasswordLoginInput().sendKeys("12345");
		loginPage.getloginButton().click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
		
	}
	
	@Test (priority = 60)
		public void logOut() {
		navPage.getlogoutLink().isDisplayed();
		navPage.getlogoutLink().click();
	}
	
	
	
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
