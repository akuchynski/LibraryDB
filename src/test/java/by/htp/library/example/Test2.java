package by.htp.library.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test2 {
	
	  @Test
	  public void f2() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.google.by/");
		  Thread.sleep(2000);
		  
		  WebElement someElement = driver.findElement(By.className("gsfi"));
		  someElement.sendKeys("Java");
		  someElement.submit();
		  
		  Thread.sleep(5000);
		  
		  List<WebElement> listElements = driver.findElements(By.className("r"));
		  
			for (WebElement elem : listElements) {

				System.out.println(elem.getText().contains("Java"));
			}
		  
		  System.out.println(listElements.size());
		  
		  Thread.sleep(3000);
		  
		  driver.close();
	  }

}
