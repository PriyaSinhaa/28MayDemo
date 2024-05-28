package SeleniumIntro.SeleniumIntro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Youtube Video Link for reference : https://www.youtube.com/watch?v=LywLnI7hHhw&t=1998s

public class EbayXpathConcepts {

	public static void main(String[] args) 
	{
       ChromeDriver driver=new ChromeDriver(); // launch chrome
       driver.manage().window().maximize();//maximize window
       driver.manage().deleteAllCookies(); //delete all the cookies
       
       driver.get("https://www.ebay.com/");
       
       driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("JAVA");
       
		// 1. Get total count of links on the page 
       List<WebElement> listOfElements = driver.findElements(By.tagName("a"));
       
       //size of List
       System.out.println("Total count of links on page"+"="+listOfElements.size());
       
       
       //2. get the text of each link on the page 
       for(int i=0;i<listOfElements.size();i++)
       {
    	 System.out.println(listOfElements.get(i).getText());  
       }
       
		
	}

}
