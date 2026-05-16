package scts.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Module {
	WebDriver driver;
	public Module(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//ul[@class='oxd-main-menu']//child::li[2]")
    WebElement PIM;
	
    @FindBy(xpath="//ul[@class='oxd-main-menu']//child::li[3]")
    WebElement leave;
    
    @FindBy(xpath="//span[text()='Dashboard']")
    WebElement dashboard;
    
    public void goToPIM() {
    	PIM.click();
    }
    
    public void goToLeave() {
    	leave.click();
    }
    
    public void goToDashboard() {
    	dashboard.click();
    }
}
