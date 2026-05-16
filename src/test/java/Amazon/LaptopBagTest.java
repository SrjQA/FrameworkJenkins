package Amazon;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LaptopBagTest {
	@Test
	public void  amazonTest() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Actions action = new Actions(driver);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop bag");
		action.sendKeys(Keys.ENTER).perform();
		//driver.findElement(By.xpath("//span[text()='Skybags']")).click();
		driver.findElement(By.xpath("//span[text()='American Tourister']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']")).click();
		driver.findElement(By.xpath("//a[text()='Price: Low to High']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]//a/h2")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		String Title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();

		System.out.println(Title);
		driver.quit();
		
	}

}
