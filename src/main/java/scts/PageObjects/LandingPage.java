package scts.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordEle;
	
	@FindBy(xpath="//div[contains(@class,'orangehrm-login-action')]/button")
	WebElement submit ;
	
	@FindBy(css=".oxd-alert-content--error p")
	WebElement errorMessage;
	public void goTo() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	public void loginApplication(String userid, String password) {
		userId.sendKeys(userid);
		passwordEle.sendKeys(password);
		submit.click();
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	
}
