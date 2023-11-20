package methodTesting;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassTest2 {
	
	@Test
	public void testOne()throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("munna bhai",Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "munna bhai - Google Search";
		assertEquals(actualTitle, expectedTitle,"title miss matched");
		driver.quit();
	}
	@BeforeClass
	public void testClass() {
		System.out.println("BeforeClass...");
	}
	@AfterClass
	public void testClass1() {
		System.out.println("afterClass...");
	}
	@BeforeMethod
	public void testClass2() {
		System.out.println("BeforeMethod...");
	}
	@AfterClass
	public void testClass3() {
		System.out.println("AfterMethod...");
	}
	@BeforeSuite
	public void testClass4() {
		System.out.println("BeforeSuite...");
	}
	@AfterSuite
	public void testClass5() {
		System.out.println("AfterSuite...");
	}
	
	
	
}
