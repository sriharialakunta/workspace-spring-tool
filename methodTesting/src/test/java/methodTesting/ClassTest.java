package methodTesting;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassTest {
	
	@Test
	public void testOne()throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		
		driver.findElement(By.name("search_query")).sendKeys("munna");
		driver.findElement(By.id("search-icon-legacy")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "munna - YouTube";
		assertEquals(actualTitle, expectedTitle,"title miss matched");
		driver.quit();
	}
	
	@DataProvider
	public Object[][] data() {
		return new Object[][] {{"6"}};
		
	}
	
	@Test(dataProvider = "data")
	public void printData(String content) {
		for(int i=1; i<11; i++) {
		System.out.println(
				i+" * "+content+" = "+i*Integer.parseInt(content)
				);
		
		}
	}
	
	
	
}
