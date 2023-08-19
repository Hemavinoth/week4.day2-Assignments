package week4day2Assignemtn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver", "C:\\Program
		// Files\\Google\\Chrome\\Application\\chrome.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		WebElement movetobrands = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(movetobrands).build().perform();
		Thread.sleep(2000);

		WebElement moveToLoreal = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		moveToLoreal.sendKeys("L'Oreal Paris");

		WebElement selectloreal = driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]"));

		selectloreal.click();

		String title = driver.getTitle();

		if (title.contains("L'Oreal Paris"))
			System.out.println(title);

		hover.scrollByAmount(200, 200);

		driver.findElement(By.xpath("//span[@class='sort-name']")).click();

		driver.findElement(By.xpath("//div[@class='control-indicator radio active']")).click();

		driver.findElement(By.xpath("//span[text()='Category']")).click();

		Thread.sleep(2000);

		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));

		driver.executeScript("arguments[0].click();", hair);

		Thread.sleep(2000);

		WebElement haircare = driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]"));

		driver.executeScript("arguments[0].click();", haircare);

		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();

		driver.findElement(By.xpath("//span[text()='Category']")).click();

		driver.findElement(By.xpath("//span[text()='Concern']")).click();

		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		WebElement verifyfilter = driver.findElement(By.xpath("//span[text()='Filters Applied']"));

		String text = verifyfilter.getText();

		System.out.println(text);

		String filter = "Shampoo";

		if (filter.contains(text)) {

			System.out.println(text + " " + "Verified filter has Shampoo");
		}

		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();

		Set<String> newwindow = driver.getWindowHandles();

		List<String> handlenewwindow = new ArrayList<String>(newwindow);

		driver.switchTo().window(handlenewwindow.get(1));

		System.out.println(driver.getTitle());

		WebElement selectsize = driver.findElement(By.xpath("//select[@title='SIZE']"));

		Select sizeIs = new Select(selectsize);

		sizeIs.selectByValue("0");

		WebElement valueOfMRP = driver.findElement(By.xpath("//div[@class='css-1d0jf8e']"));

		System.out.println(valueOfMRP.getText());

		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();

		// *[name()='svg']//*[local-name()='path']
		// *[name()='svg' and @class='']//*[local-name()='path']
		// *[name()='svg' and @data-key='add']//*[local-name()='path']
		// *[@data-key='add']

//		WebElement svgelemntToclickaddtobag = driver.findElement(By.xpath("(//*[name()='svg' and @fill='none']//*[local-name()='path'])[10]"));
//		
//		driver.executeScript("arguments[0].click();", svgelemntToclickaddtobag);

		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();

		Thread.sleep(3000);

		WebElement iframe = driver.findElement(By.xpath("(//iframe[@class='css-acpm4k'])[1]"));

		driver.switchTo().frame(iframe);

		WebElement grandTotal = driver.findElement(By.xpath("(//p[@class='css-6nd5ki eka6zu20'])[2]"));

		String GT = grandTotal.getText();

		System.out.println("GrandTotal is "+ GT);

		driver.findElement(By.xpath("//div[@class='css-ltzjhp e25lf6d7']//button")).click();

		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();

		driver.findElement(By.xpath("//div[@class='css-gecnnw eqr1d9n12']//span")).click();

		driver.findElement(By.xpath("(//img[@alt='Image'])[10]")).click();
		
		WebElement pricedetails = driver.findElement(By.xpath("//div[@class='css-vlqrtx e1d9ugpt3']//p[@class='css-masf0q eka6zu20']"));

		String pdetails = pricedetails.getText();
		
		System.out.println("price details is " + pdetails);
		
		Thread.sleep(3000);

		if (pdetails.contains(GT)) {

			System.out.println(pdetails + " " + "grand total is same as price details");
		}

		driver.quit();

	}

}
