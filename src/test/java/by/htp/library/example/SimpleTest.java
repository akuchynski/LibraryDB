package by.htp.library.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SimpleTest {
	
  @Test
  public void f() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://oz.by/search/?q=java");
	  Thread.sleep(2000);
	  
	  List<WebElement> listElements = driver.findElements(By.className("item-type-card__title"));
	  
		for (WebElement elem : listElements) {
			System.out.println(elem.getText());
		}
	  
	  System.out.println(listElements.size());
	
  }
  
}
