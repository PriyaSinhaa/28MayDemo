package SeleniumIntro.SeleniumIntro;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FBDataDriven {

	
	@Test(dataProvider ="datapro2")
	public  static void createAccount(String s1, String s2) throws InterruptedException
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
      fname.sendKeys(s1);
      Thread.sleep(1000);
      WebElement sname=driver.findElement(By.name("lastname"));
      sname.sendKeys(s2);
      
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
      daySelect.selectByVisibleText("9");
      
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
      
      
      
     driver.close();
      		
	}
	
	@DataProvider
	public Object[][] datapro1()
	{
		Object[][] ob=new Object[3][2];
		ob[0][0]="user1";
		ob[0][1]="lastname1";
		ob[1][0]="user2";
		ob[1][1]="lastname2";
		ob[2][0]="user3";
		ob[2][1]="lastname3";
		
		return ob;
		
	}
	
	@DataProvider
	public Object[][] datapro2() throws BiffException, IOException
	{
		File f=new File("C:\\Users\\dipsa\\Desktop\\KeywordDrivenData.xls");	
		Workbook wk=Workbook.getWorkbook(f);
		Sheet ws=wk.getSheet(1);
		
		//number of rows 
		int r=ws.getRows();
		int c=ws.getColumns();
		Object[][] ob=new Object[r][c];
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				Cell wc=ws.getCell(j,i);
				ob[i][j]=wc.getContents();
			}
		}
		
		return ob;				
	}

}
