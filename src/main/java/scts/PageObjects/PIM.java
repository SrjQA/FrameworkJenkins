package scts.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import scts.AbstractComponents.AbstractComponent;

public class PIM extends AbstractComponent {
	WebDriver driver;

	public PIM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.orangehrm-paper-container>div>button")
	WebElement add;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement LastName;

	@FindBy(css = "input[type='file']")
	WebElement addPicBtn;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
	WebElement save;

	By name = By.xpath("//div[@class='orangehrm-edit-employee-name']/h6");

	@FindBy(xpath = "//div[@class='oxd-form-row']/div/div[1]//descendant::input")
	WebElement searchHints;

	@FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
	WebElement searchBtn;

	@FindBy(css = ".oxd-table-card")
	WebElement resultEmp;

	By byResultEmp = By.cssSelector(".oxd-table-card");

	@FindBy(xpath = "//a[text()='Job']")
	WebElement job;

	By joinedDate = By.cssSelector(".oxd-date-input input");

	@FindBy(xpath = "//label[text()='Job Title']//following::div[@class='oxd-select-text-input'][1]")
	WebElement jobTitle;

	By byJobTitle = By.xpath("//label[text()='Job Title']//following::div[@class='oxd-select-text-input'][1]");
	By jobOption = By.xpath("//div[@role='listbox']//span[text()='Finance Manager']");

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveJobDetails;

	public void addEmployee() {
		add.click();
		FirstName.sendKeys("Ezio Auditore");
		LastName.sendKeys("Da Firenze");
		addPicBtn.sendKeys("C:\\Users\\ASUS\\Downloads\\demopic.png");
		save.click();
		waitForElement(name);

	}

	public void searchEmployee() {
		searchHints.sendKeys("Ezio Auditore");
		searchBtn.click();

	}

	public void updateJob() {
		waitForElement(byResultEmp, 5);
		resultEmp.click();
		job.click();

		WebElement jobDate = waitForElement(joinedDate,5);
		jobDate.sendKeys("2022-09-24");

		waitForElementToBeClickable(byJobTitle,5);
		jobTitle.click();
		WebElement option = waitForElementToBeVisible(jobOption);
		option.click();

		saveJobDetails.click();
	}

}
