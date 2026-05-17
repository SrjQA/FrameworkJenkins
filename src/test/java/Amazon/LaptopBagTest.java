package Amazon;

import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

public class LaptopBagTest {
	
	Logger log = LoggerFactory.getLogger(LaptopBagTest.class);
	@Test
	public void  amazonTest() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		log.info("Launching Browser");
		driver.get("https://www.amazon.in/");
		log.info("Opening Amazon");
		driver.manage().window().maximize();
		log.info("Browser window maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		Actions action = new Actions(driver);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop bag");
		action.sendKeys(Keys.ENTER).perform();
		log.info("Search for Laptop Bags");
		//driver.findElement(By.xpath("//span[text()='Skybags']")).click();
		driver.findElement(By.xpath("//span[text()='American Tourister']")).click();
		Thread.sleep(3000);
		log.info("Filter on Amazon");
		driver.findElement(By.xpath("//span[@data-action='a-dropdown-button']")).click();
		driver.findElement(By.xpath("//a[text()='Price: Low to High']")).click();
		Thread.sleep(3000);
		log.info("Filter on price low to high");
		driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]//a/h2")).click();
		log.info("First reuslt selected");

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);
		log.info("Switched to product window");
		String Title = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
		log.info(Title);
		//System.out.println(Title);
		driver.quit();
		
	}

}
