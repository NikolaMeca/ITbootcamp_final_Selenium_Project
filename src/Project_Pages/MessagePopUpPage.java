package Project_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void getWaitUntilPopUpIsVisibile() {
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement
			  (By.xpath("//div[contains(@class, 'v-snack__wrapper')]"))));
	}
	
	public void getWaiterPopUpEdit() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
				("//div[contains(@class, 'success')]"))));
	}
	
	public WebElement getElementContainsMessagesTextsInPopUp() {
		return driver.findElement(By.xpath("//div[contains(@class, 'error')]/div/ul/li"));
	}
	
	public WebElement getCloseButtonFromMessage() {
		return driver.findElement(By.xpath("//div[contains(@class, 'error')]/div/button"));
	}
	
	public void getVerifyYourAccountPopUp() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement
				(By.xpath("//div[contains(@class, 'v-card')]//"
						+ "div[contains(@class, 'dlgVerifyAccount')]"))));
	}
	
	public WebElement getElementContainsMessageTextInPopUp() {
		return driver.findElement(By.xpath
				("//div[contains(@class, 'v-card')]//div[contains(@class, 'dlgVerifyAccount')]"));
	}
	
	
	public WebElement getCloseButtonFromPopUp() {
		return driver.findElement(By.xpath
				("//div[contains(@class, 'v-card')]/button[contains(@class, 'btnClose')]"));
	}
	
	
	
	
	
	
	
}
