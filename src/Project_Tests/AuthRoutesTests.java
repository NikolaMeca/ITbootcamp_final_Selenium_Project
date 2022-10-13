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

public class AuthRoutesTests {
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
	public void ForbidsVisitsToHomeUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/home");
		String jedan = driver.getCurrentUrl();
		Assert.assertTrue(jedan.contains("/login"));
	}
	
	@Test (priority = 20)
	public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/profile");
		String jedan = driver.getCurrentUrl();
		Assert.assertTrue(jedan.contains("/login"));
	}
	
	@Test (priority = 30)
	public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/cities");
		String jedan = driver.getCurrentUrl();
		Assert.assertTrue(jedan.contains("/login"));
	}
	
	@Test (priority = 40)
	public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
		driver.get(baseUrl + "/admin/users");
		String jedan = driver.getCurrentUrl();
		Assert.assertTrue(jedan.contains("/login"));
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
