package Project_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	
	public WebElement getemailLoginInput() {
		return driver.findElement(By.id("email"));
	}
	public WebElement getpasswordLoginInput() {
		return driver.findElement(By.id("password"));
	}
	public WebElement getloginButton () {
		return driver.findElement(By.xpath("//*[contains(@class, 'flex ')]//div/button"));
	}
	
	
	
	
}
