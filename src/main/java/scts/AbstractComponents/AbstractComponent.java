package scts.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	

	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

	public void waitForElement(By findBy) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public WebElement waitForElementToBeVisible(By findBy) {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public WebElement waitForElement(By findBy, int seconds) {
		WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return customWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public WebElement waitForElementToBeClickable(By findBy, int seconds) {
		WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return customWait.until(ExpectedConditions.elementToBeClickable(findBy));

	}

}
