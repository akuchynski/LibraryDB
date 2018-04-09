package by.htp.library.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test3 {
	
	  @Test
	  public void f2() throws InterruptedException {
		  
		  System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("http://www.quizful.net/");
		  Thread.sleep(2000);
		  
		  WebElement elemRegLink = driver.findElement(By.linkText("зарегистрироваться"));
		  elemRegLink.click();
		  Thread.sleep(4000);
		  
		  WebElement elemTextName = driver.findElement(By.name("registrationForm.login"));
		  elemTextName.sendKeys("sfjfsghhdjb123");
		  
		  WebElement elemTextPass = driver.findElement(By.name("registrationForm.password"));
		  elemTextPass.sendKeys("Test12345678");
		  
		  WebElement elemTextRePass = driver.findElement(By.name("registrationForm.repassword"));
		  elemTextRePass.sendKeys("Test12345678");
		  
		  WebElement elemTextMail = driver.findElement(By.name("registrationForm.email"));
		  elemTextMail.sendKeys("Test12546u89@gmail.com");
		  
		  WebElement elemCheckBox = driver.findElement(By.name("registrationForm.corporate"));
		  elemCheckBox.click();
		  
		  Thread.sleep(7000);
		  
		  WebElement elemOkBtn = driver.findElement(By.name("ok"));
		  elemOkBtn.click();
		  
		  WebElement elemSuccesReg = driver.findElement(By.className("content"));
		  
		  System.out.println(elemSuccesReg.getText().contains("Регистрация прошла успешно"));
		  
		  Thread.sleep(5000);
		  
		//  driver.close();
	  }

}
