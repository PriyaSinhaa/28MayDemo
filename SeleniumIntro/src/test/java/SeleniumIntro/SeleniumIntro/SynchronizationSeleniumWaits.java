package SeleniumIntro.SeleniumIntro;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SynchronizationSeleniumWaits {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("Priya")).click();
		
		driver.quit();
		
		
        
        
		
	}

}
