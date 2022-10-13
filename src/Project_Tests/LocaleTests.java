package Project_Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class LocaleTests {
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
	public void SetLocaleToES() {
		navPage.getlanguageLink().click();
		navPage.getEspLanguageFromLanguageLink().click();
		navPage.getHeaderText().getText().contains("Página de aterrizaje");
	}
	
	@Test(priority = 20)
	public void SetLocaleToEN() {
		navPage.getlanguageLink().click();
		navPage.getEngLanguageFromLanguageLink().click();
		navPage.getHeaderText().getText().contains("Landing");
	}
	
	@Test(priority = 30)
	public void SetLocaleToCN() {
		navPage.getlanguageLink().click();
		navPage.getCnLanguageFromLanguageLink().click();
		navPage.getHeaderText().getText().contains("首页");
	}
	
	@Test(priority = 40)
	public void SetLocaleToFR() {
		navPage.getlanguageLink().click();
		navPage.getFrLanguageFromLanguageLink().click();
		navPage.getHeaderText().getText().contains("Page d'atterrissage");
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
