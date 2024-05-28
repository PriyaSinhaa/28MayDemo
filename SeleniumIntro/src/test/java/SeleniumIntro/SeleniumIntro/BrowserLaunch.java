package SeleniumIntro.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException
	{
			
      WebDriverManager.chromedriver().setup();
      ChromeDriver driver=new ChromeDriver();
      driver.get("https://www.facebook.com/");
      Options op = driver.manage();
      Window w = op.window();
      w.maximize(); // driver.manage().window().maximize();
      
    /*  WebElement username=driver.findElement(By.cssSelector("input#email")); // identify the webelement 
      username.sendKeys("dipsasinha@12345"); // perform action on the webemelemt 
      
      
      WebElement password=driver.findElement(By.id("pass"));
      password.sendKeys("Hanuman");*/
      
      WebElement createAccount=driver.findElement(By.linkText("Create new account"));
      createAccount.click();
      Thread.sleep(1000);
      
      WebElement fname=driver.findElement(By.name("firstname"));
      fname.sendKeys("test");
      Thread.sleep(1000);
      WebElement sname=driver.findElement(By.name("lastname"));
      sname.sendKeys("account");
      
      WebElement emaill=driver.findElement(By.name("reg_email__"));
      emaill.sendKeys("testing@gmail.com");
      Thread.sleep(1000);
      
      WebElement reemaill=driver.findElement(By.name("reg_email_confirmation__"));
      reemaill.sendKeys("testing@gmail.com");
      Thread.sleep(1000);
      
      WebElement pw=driver.findElement(By.id("password_step_input"));
      pw.sendKeys("Hanuman@123");
      Thread.sleep(1000);
      
      WebElement day=driver.findElement(By.name("birthday_day")); //locate the element
      Select daySelect = new Select(day); //Select class and pass the webelement 
      String day1="9";
      daySelect.selectByVisibleText(day1);
      
      WebElement month=driver.findElement(By.name("birthday_month"));
      Select monthSelect=new Select(month);
      String month1="Nov";
      monthSelect.selectByVisibleText(month1);
      
      WebElement year=driver.findElement(By.name("birthday_year"));
      Select yearSelect=new Select(year);
      String year1="1993";
      yearSelect.selectByVisibleText(year1);
      
      
      WebElement radioButton=driver.findElement(By.xpath("//input[@type='radio' or @value='1']"));
      radioButton.click();
      
      Thread.sleep(1000);
      WebElement b=driver.findElement(By.name("websubmit"));
      b.click();
      
      
      
     
      
     
		
		
	}

}
