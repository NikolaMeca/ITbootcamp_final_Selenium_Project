package Project_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	
	
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement gethomeLink() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[1]"));
	}
	
	public WebElement getaboutLink() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
	}
	
	public WebElement getmyProfileLink() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[3]"));
	}
	
	public WebElement getadminButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnAdmin')]"));
	}
	
	public WebElement getcitiesLinkFromSubAdminMenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnAdminCities')]"));
	}
	
	public WebElement getusersLinkFromSubAdminMenu() {
		return driver.findElement(By.xpath("//*[contains(@class, 'btnAdminUsers')]"));
	}
	
	public WebElement getsignUpButton() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
	}
	
	public WebElement getloginButton () {
		return driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')][1]"));
	}
	
	public WebElement getlogoutLink() {
		return driver.findElement(By.className("btnLogout"));
	}
	
	public WebElement getlanguageLink() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
	}
	
	public WebElement getEngLanguageFromLanguageLink() {
		return driver.findElement(By.id("list-item-73"));
	}
	
	public WebElement getEspLanguageFromLanguageLink() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[2]"));
	}
	
	public WebElement getFrLanguageFromLanguageLink() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[3]"));
	}
	
	public WebElement getCnLanguageFromLanguageLink() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-menu__content')]/div/div[4]"));
	}
	
	public WebElement getHeaderText() {
		return driver.findElement(By.className("display-2"));
	}
	
	
	
	
}
