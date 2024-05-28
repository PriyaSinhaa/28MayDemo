package SeleniumIntro.SeleniumIntro;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args)throws InvalidArgumentException, InterruptedException
	{
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
		Actions ac=new Actions(driver);
		/*for(int a=1;a<=5;a++)
		{
			ac.sendKeys(Keys.TAB).perform();
			Thread.sleep(2000);
			
		}*/
		
	WebElement e=driver.findElement(By.linkText("Forgotten password?"));
	ac.keyDown(Keys.CONTROL).click(e).keyUp(Keys.CONTROL).build().perform(); //Ctrl+click on forgotten password
	
	String currentWindow=driver.getWindowHandle();
	System.out.println("Before switching url is     "+driver.getCurrentUrl());
	
	
	Set<String> all=driver.getWindowHandles();	
	System.out.println("Total tabs     "+all.size());
	
	for(String s: all)
	{
		driver.switchTo().window(s);
	}
	
	System.out.println("After switching url is       "+driver.getCurrentUrl());
	
	driver.switchTo().window(currentWindow);
	System.out.println("Final url is     "+driver.getCurrentUrl());
	
	
	
	}
	

}
