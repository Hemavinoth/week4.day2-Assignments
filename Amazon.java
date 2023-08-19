package week4day2Assignemtn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");

		Thread.sleep(2000);
		WebElement mover = driver.findElement(By.xpath("//div[@aria-label='oneplus 9 pro']"));

		Actions act = new Actions(driver);

		act.moveToElement(mover).build().perform();

		// Thread.sleep(3000);

		WebElement click = driver.findElement(By.xpath("(//div[text()='oneplus 9 pro'])[1]"));

		driver.executeScript("arguments[0].click();", click);

		WebElement amount1 = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		
		String amt = amount1.getText();

		Thread.sleep(2000);

		/*
		 * WebElement rate =
		 * driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]"));
		 * 
		 * String text = rate.getText();
		 * 
		 * System.out.println(text);
		 */

		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> newone = new ArrayList<String>(windowHandles);

		WebDriver newwindow = driver.switchTo().window(newone.get(1));

		System.out.println(newwindow.getTitle());

		Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@class='a-dynamic-image a-stretch-horizontal']")).click();

		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);

		File storeSS = new File(".amazon/mobile/oneplus/pic.jpg");

		FileUtils.copyFile(screenshotAs, storeSS);

		driver.findElement(By.xpath("//i[@class='a-icon a-icon-close']")).click();

		driver.findElement(
				By.xpath("//span[@class='a-button a-spacing-small a-button-primary a-button-icon natc-enabled']"))
				.click();

		// WebElement carttotal =
		// driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-price
		// a-text-bold']//span"));

		Thread.sleep(5000);

		WebElement findElement = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));

		System.out.println(findElement.getText());
		
		if(findElement.getText().contains(amt))
		{
			
			System.out.println("subtotal verified");
		}

		driver.switchTo().window(newone.get(1)).close();
		
		driver.switchTo().window(newone.get(0)).close();

	}

}
