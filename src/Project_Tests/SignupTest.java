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

public class SignupTest {


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
	
	@Test(priority = 10)
	public void visitsTheSignupPage() {
		navPage.getsignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
		
	}
	
	@Test (priority = 20)
	public void ChecksInputTypes() {
		navPage.getsignUpButton().click();
		String actEmail = signupPage.getEmailInput().getAttribute("type");
		String expEmail = "email";
		Assert.assertEquals(actEmail, expEmail, "Type should contain text email");
		String actPass = signupPage.getPasswordInput().getAttribute("type");
		String expPass = "password";
		Assert.assertEquals(actPass, expPass, "Type should contain text password");
		String actConfPass = signupPage.getConfirmPasswordInput().getAttribute("type");
		String expConfPass = "password";
		Assert.assertEquals(actConfPass, expConfPass, "Type should contain text password");
	}
	
	@Test (priority = 30)
	public void DisplaysErrorsWhenUserAlreadyExists() throws InterruptedException {
		navPage.getsignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
		signupPage.getNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpButton().click();
		Thread.sleep(2000);
		messagePopUpPage.getWaitUntilPopUpIsVisibile();
		messagePopUpPage.getElementContainsMessagesTextsInPopUp()
		.getText().contains("E-mail already exists");
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
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
