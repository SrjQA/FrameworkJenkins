package scts.FrameworkOrangeHRM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import scts.PageObjects.LandingPage;

public class E2E_test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String userName = "Admin";
		String passWord = "admin123";
        
	    WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Admin Login
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//div[contains(@class,'orangehrm-login-action')]/button")).click();
     
		// 1.Add New Employee
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//child::li[2]")).click();
		driver.findElement(By.cssSelector("div.orangehrm-paper-container>div>button")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Ezio Auditore");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Da Firenze");
		// add a pic
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\Users\\ASUS\\Downloads\\demopic.png");
		driver.findElement(By.xpath("//div[@class=\"oxd-form-actions\"]/button[2]")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class=\"orangehrm-edit-employee-name\"]/h6")));

		// 2.Search Employee by ID -0492
		// Steps: PIM > Employee List → Enter a valid Employee ID → Click Search.
		// Expected Result: Matching employee record is shown.
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//child::li[2]")).click();
		driver.findElement(By.xpath("//div[@class='oxd-form-row']/div/div[1]//descendant::input"))
				.sendKeys("Ezio Auditore");
		driver.findElement(By.xpath("//div[@class='oxd-form-actions']/button[2]")).click();
		// 3.Update Employee Job Details
		// Expected Result: Job details are updated successfully.
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".oxd-table-card")).click();
		driver.findElement(By.xpath("//a[text()='Job']")).click();
		Thread.sleep(3000);
		WebElement jobDate = w
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-date-input input")));
		jobDate.sendKeys("2022-09-24");

		// Steps: PIM > Employee List → Select employee → Job tab → Edit job
		// title/department → Save.
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Job Title']//following::div[@class='oxd-select-text-input'][1]"))
				.click();

		WebElement option = w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='Finance Manager']")));
		option.click();
		Thread.sleep(1000);
		// save
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

		// LEAVE MODULE
		// Apply for Leave
		// Steps: Leave > Apply → Select leave type, date, reason → Click Apply.
		// Expected Result: Leave application is submitted and visible in My Leave.
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//child::li[3]")).click();
		driver.findElement(By.xpath("//a[text()='Assign Leave']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("ezio");

		List<WebElement> options = w
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='listbox']//span")));

		// 3. Iterate through options and click the one that matches
		for (WebElement o : options) {
			if (o.getText().equals("Ezio Auditore Da Firenze")) {
				o.click();
				break;
			}
		}

		driver.findElement(By.xpath("//div[text()='-- Select --'][1]")).click();
		driver.findElement(By.xpath("//div[@role='option']//span[text()='CAN - Personal']")).click();

		// from date
		driver.findElement(By.xpath("//label[text()='From Date']//following::div[1]")).click();
		driver.findElement(By.xpath("//p[text()='July']")).click();
		driver.findElement(By.xpath("//li[@class='oxd-calendar-dropdown--option' and text()='August']")).click();
		driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and text()='25']")).click();
		Thread.sleep(5000);
		// to date-- Auto Selected
		// save
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Assign ']")).click();
		driver.findElement(By.xpath("//button[text()=' Ok ']")).click();
		Thread.sleep(2000);

		// return to dashboard
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();

		driver.quit();
	}

}
