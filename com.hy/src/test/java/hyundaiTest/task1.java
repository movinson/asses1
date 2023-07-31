package hyundaiTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class task1 {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://clicktobuy.hyundai.co.in/#/bookACar?modelCode=0Y");

		Select modelDropdown = new Select(driver.findElement(By.xpath("//select[@id='inputmodel-01']")));
		modelDropdown.selectByIndex(3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Select fuelTypeDropdown = new Select(driver.findElement(By.xpath("//select[@id='inputfuel-01']")));
		fuelTypeDropdown.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		Select variantDropdown = new Select(driver.findElement(By.xpath("//select[@id='inputvrnt-01']")));
		variantDropdown.selectByValue("4884");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		WebElement exteriorDropdown = driver.findElement(By.xpath("//select[@id='inputext-01']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js1.executeScript("arguments[0].scrollIntoView(true)",exteriorDropdown) ;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Select ext = new Select(exteriorDropdown);
		ext.selectByValue("A2B");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Select interiorDropdown = new Select(driver.findElement(By.xpath("//select[@id='inputinter-01']")));
		interiorDropdown.selectByValue("MCG");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state-01']")));
		stateDropdown.selectByValue("AN");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Select cityDropdown = new Select(driver.findElement(By.xpath("//select[@id='dealer-city-01']")));
		cityDropdown.selectByValue("S30");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Select dealerDropdown = new Select(driver.findElement(By.xpath("//select[@id='bookacardelar']")));
		dealerDropdown.selectByValue("S4228");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement dealerName = driver.findElement(By.xpath("//div[@class='tit ico-bullet']"));
		String dealer = dealerName.getText();
		System.out.println("The Available Dealer is : " +dealer);

		int dealerCount = dealerDropdown.getOptions().size();
		if (dealerCount > 1) {
			for (int i = 2; i < dealerCount; i++) {
				dealerDropdown.selectByIndex(i);
				dealerName = driver.findElement(By.xpath("//div[@class='tit ico-bullet']"));
				System.out.println(dealerName.getText());
			}
		} 

		System.out.println("--Test Passed--");

		driver.quit();
	}

}
