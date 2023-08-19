package week4day2Assignemtn;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		WebElement mensFashionhover = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(mensFashionhover).build().perform();

		driver.navigate().refresh();

		WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='linkTest'])[1]"));

		driver.executeScript("arguments[0].click();", findElement2);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		List<WebElement> papularitylist = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		for (WebElement webElement : papularitylist) {

			System.out.print(webElement.getText());

		}

		driver.findElement(By.xpath("(//div[contains(text(),'Popularity')])[1]")).click();

		driver.navigate().refresh();

		WebElement findElement = driver.findElement(By.xpath("//li[@data-sorttype='plth']"));

		driver.executeScript("arguments[0].click();", findElement);

		driver.navigate().refresh();

		List<WebElement> sortlowtoHigh = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));

		for (WebElement webElement1 : sortlowtoHigh) {

			String text = webElement1.getText();

			System.out.println(text);
		}

		WebElement from = driver.findElement(By.xpath("//input[@name='fromVal']"));
		from.clear();

		Thread.sleep(500);
		from.sendKeys("400");

		WebElement torange = driver.findElement(By.xpath("//input[@name='toVal']"));
		torange.click();
		torange.clear();
		Thread.sleep(500);
		torange.sendKeys("900");
		// div[@class='price-go-arrow btn btn-line btn-theme-secondary']

		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();

		WebElement navycolour = driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[4]"));

		driver.executeScript("arguments[0].click();", navycolour);

		Thread.sleep(3000);
		WebElement filter1 = driver.findElement(By.xpath("//div[contains(text(),'Price:')]"));
		WebElement filter2 = driver.findElement(By.xpath("(//div[contains(text(),'Color: ')])[1]"));

		if (filter1.getText().contains("Price")) {

			System.out.println(filter1 + "Price filters are applied and verified");
		}

		if (filter2.getText().contains("Color")) {
			System.out.println(filter2 + " Colour filters are applied and verified");
		}

		Thread.sleep(3000);
		WebElement mousehover = driver.findElement(By.xpath("(//img[@title='Columbus Navy Training Shoes'])[1]"));

		Actions act1 = new Actions(driver);

		Thread.sleep(200);
		act1.moveToElement(mousehover).perform();

		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		Thread.sleep(2000);

		// 13. Print the cost and the discount percentage

		System.out.println(driver.findElement(By.xpath("(//span[@class='payBlkBig'])[1]")).getText());

		System.out.println(driver.findElement(By.xpath("(//span[@class='percent-desc '])[1]")).getText());

		WebElement Screenshotofshoes = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[2]"));

		// 14. Take the snapshot of the shoes.

		// to get the screenshot of a particular ele -->webElement.getScrenshotAs()

		Thread.sleep(2000);
		File snap = driver.getScreenshotAs(OutputType.FILE);
		// set the path to store the img file
		File shot = new File("./snap/pic1.jpg");

		FileUtils.copyFile(snap, shot);

		driver.findElement(By.xpath("(//div[@class='close close1 marR10'])[1]")).click();

		driver.quit();

	}

}
