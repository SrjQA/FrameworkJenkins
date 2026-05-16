package scts.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scts.AbstractComponents.AbstractComponent;

public class Leave extends AbstractComponent {
	WebDriver driver;

	public Leave(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Assign Leave']")
	WebElement assign;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement searchName;

	@FindBy(xpath = "//div[@role='listbox']//span")
	List<WebElement> searchResults;

	By searchResultsBy = By.xpath("//div[@role='listbox']//span");

	@FindBy(xpath = "//div[text()='-- Select --'][1]")
	WebElement leaveTypeSelect;

	@FindBy(xpath = "//div[@role='option']//span[text()='CAN - Personal']")
	WebElement leaveType;

	@FindBy(xpath = "//label[text()='From Date']//following::div[1]")
	WebElement fromDate;

	@FindBy(xpath = "//p[text()='August']")
	WebElement monthField;

	@FindBy(xpath = "//li[@class='oxd-calendar-dropdown--option' and text()='September']")
	WebElement selectmonth;

	@FindBy(xpath = "//div[@class='oxd-calendar-date' and text()='25']")
	WebElement selectdate;

	@FindBy(xpath = "//button[text()=' Assign ']")
	WebElement assignBtn;

	By byAssignBtn = By.xpath("//button[text()=' Assign ']");

	@FindBy(xpath = "//button[text()=' Ok ']")
	WebElement okBtn;

	public void assignLeave() {
		assign.click();
	}

	public void search() {
		searchName.sendKeys("ezio");
	}

	public void selectResultEmployee() {
		waitForElementToBeVisible(searchResultsBy);

		for (WebElement option : searchResults) {
			if (option.getText().equals("Ezio Auditore Da Firenze")) {
				option.click();
				break;
			}
		}
		;
	}

	public void selectDropdown() {
		leaveTypeSelect.click();
	}

	public void selectLeaveType() {
		leaveType.click();
	}

	public void selectFromdate() {
		fromDate.click();
		monthField.click();
		selectmonth.click();
		selectdate.click();

	}

	public void saveleave() {

		waitForElementToBeClickable(byAssignBtn, 7);
		assignBtn.click();
		okBtn.click();

	}
}
