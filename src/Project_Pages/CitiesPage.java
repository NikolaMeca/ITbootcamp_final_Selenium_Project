package Project_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {

	private WebDriver driver;
	private WebDriverWait wait;
	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	
	
	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}
	
	
	public WebElement getSearchInputInCreatePopUp() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}
	
	public WebElement getInputEditCities() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-text-field__slot')]/*[contains(@id, 'name')]"));
	}
	
	public void getWaitDialogForEditAndCreateIsVisible() {
	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath("//div[contains(@class, 'dlgNewEditItem')]/div"))));
	}
	
	public void getDeleteDialogIsVisible() {
	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
				("//div[contains(@class, 'v-dialog--active')]/div"))));
	}
	
	public WebElement getSaveButtonInDialogNewItem() {
		return driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
	}
	
	public WebElement getDeleteButtonInDialogDelete() {
		return driver.findElement(
				By.xpath("//div[contains(@class, 'v-dialog--active')]/div/div/button[2]"));
	}
	
	public void getWaitUntilNumberOfRows(int brojRedova) {
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
				("//div[contains(@class, 'v-data-table__wrapper')]"
				+ "/table/tbody/tr[" + brojRedova + "]"))));
	}
	
	public WebElement getCellFromTabelRow(int row, int cell) {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]"
				+ "/table/tbody/tr["+row+"]/td["+cell+"]"));
	}
	
	public WebElement getEditButtonFromTabelRow(int rowEdit) {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]"
				+ "/table/tbody/tr["+ rowEdit +"]/td[1]/div/button[1]"));
	}
	
	
	
	public WebElement getDeleteButtonFromTabelRow(int rowEdit) {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]"
				+ "/table/tbody/tr["+ rowEdit +"]/td[1]/div/button[2]"));
	}
	
	public void tableCellForEdit(int cell) {
		 driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]/table/tbody/tr/td["+cell+"]"));
	}
	
	public WebElement getDeleteFromTabel() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-data-table__wrapper')]/table/tbody/tr/td/div/button[2]"));
	}
	
	public WebElement dELETEFROMPOPUP() {
		return driver.findElement(By.xpath("//div[contains(@class, 'v-card__actions')]/button[2]"));
	}
	
}
