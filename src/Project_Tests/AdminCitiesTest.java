package Project_Tests;

import java.time.Duration;

import org.openqa.selenium.Keys;
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

public class AdminCitiesTest {

	
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
	
	@Test (priority=10)
	public void VisitsTheAdminCitiesPageAndListCities() {
		navPage.getloginButton().click();
		loginPage.getemailLoginInput().sendKeys("admin@admin.com");
		loginPage.getpasswordLoginInput().sendKeys("12345");
		loginPage.getloginButton().click();
		navPage.getadminButton().click();
		navPage.getcitiesLinkFromSubAdminMenu().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
	}
	
	@Test (priority = 20)
	public void ChecksInputTypesForCreatedEditNewCity() throws InterruptedException {
		navPage.getadminButton().click();
		navPage.getcitiesLinkFromSubAdminMenu().click();
		citiesPage.getNewItemButton().click();
		Thread.sleep(2000);
		citiesPage.getWaitDialogForEditAndCreateIsVisible();
		String actName = citiesPage.getSearchInput().getAttribute("type");
		String expName = "text";
		Assert.assertEquals(actName, expName, "Attribut type should contains text text");
	}
	
	@Test(priority = 30)
	public void createNewCity() throws InterruptedException {
		navPage.getadminButton().click();
		navPage.getcitiesLinkFromSubAdminMenu().click();
		citiesPage.getNewItemButton().click();
		Thread.sleep(2000);
		citiesPage.getWaitDialogForEditAndCreateIsVisible();
		citiesPage.getSearchInputInCreatePopUp().sendKeys("gard1");
		citiesPage.getSaveButtonInDialogNewItem().click();
		messagePopUpPage.getCloseButtonFromMessage().isDisplayed();	
	
	}
	
	@Test (priority = 40)
	public void editCity() throws InterruptedException {
		navPage.getadminButton().click();
		navPage.getcitiesLinkFromSubAdminMenu().click();
		citiesPage.getSearchInput().sendKeys("grad1");
		citiesPage.getWaitUntilNumberOfRows(1);
		citiesPage.getEditButtonFromTabelRow(1).click();
		Thread.sleep(1000);
		citiesPage.getInputEditCities().click();
		citiesPage.getInputEditCities().sendKeys(Keys.CONTROL, "a");
		citiesPage.getInputEditCities().sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		citiesPage.getInputEditCities().sendKeys("grad2");
		citiesPage.getSaveButtonInDialogNewItem().click();
		messagePopUpPage.getWaiterPopUpEdit();
		messagePopUpPage.getCloseButtonFromMessage().isDisplayed();	
	}
	
	@Test(priority = 50)
	public void  searchCity() {
		navPage.getadminButton().click();
		navPage.getcitiesLinkFromSubAdminMenu().click();
		citiesPage.getSearchInput().sendKeys("grad2");
		citiesPage.getWaitUntilNumberOfRows(1);
		String nameSearch = citiesPage.getSearchInput().getAttribute("value");
		String nameTabel = citiesPage.getCellFromTabelRow(1, 2).getText();
		Assert.assertEquals(nameSearch, nameTabel);
		
	}
	
	@Test (priority = 60)
	public void deleteCity() {
		navPage.getadminButton().click();
		navPage.getcitiesLinkFromSubAdminMenu().click();
		citiesPage.getSearchInput().sendKeys("grad2");
		citiesPage.getWaitUntilNumberOfRows(1);
		String nameSearch = citiesPage.getSearchInput().getAttribute("value");
		String nameTabel = citiesPage.getCellFromTabelRow(1, 2).getText();
		Assert.assertEquals(nameSearch, nameTabel, "Text in Tabel name should be same like text in search ZUC");
		citiesPage.getDeleteButtonFromTabelRow(1);
		citiesPage.dELETEFROMPOPUP().click();
		wait.until(webDriver -> messagePopUpPage.getElementContainsMessagesTextsInPopUp().isDisplayed());
		String actRes = messagePopUpPage.getElementContainsMessagesTextsInPopUp().getText();
		String expRes = "Deleted successfully";
		Assert.assertTrue(actRes.contains(expRes));
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
