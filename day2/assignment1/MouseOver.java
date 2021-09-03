package week4.day2.assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		5.http://www.leafground.com/pages/mouseOver.html

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		1. Mouse hover on Testleaf Courses and print all the following links
		driver.findElement(By.xpath("//a[text()='TestLeaf Courses']")).click();
		WebElement selenium=driver.findElement(By.xpath("//a[text()='Selenium']"));
		Actions click1=new Actions(driver);
		click1.moveToElement(selenium).perform();
		WebElement rpa=driver.findElement(By.xpath("//a[text()='RPA']"));
		Actions click2=new Actions(driver);
		click2.moveToElement(rpa).perform();
		WebElement webService=driver.findElement(By.xpath("//a[text()='WebServices']"));
		Actions click3=new Actions(driver);
		click3.moveToElement(webService).perform();
		String text1=driver.findElement(By.xpath("//a[@class='listener']")).getText();
		String text2=driver.findElement(By.xpath("(//a[@class='listener'])[2]")).getText();
String text3=driver.findElement(By.xpath("(//a[@class='listener'])[3]")).getText();
		System.out.println("Testleaf Course: ");
		System.out.println(text1);
		System.out.println(text2);
 	System.out.println(text3);

		
		
//		2. Mouse hover on Testleaf Courses and click on any course and handle the alert

	driver.findElement(By.xpath("//a[text()='TestLeaf Courses']")).click();
	WebElement selenium1=driver.findElement(By.xpath("//a[text()='Selenium']"));
	Actions click4=new Actions(driver);
	click4.moveToElement(selenium1).perform();
	driver.findElement(By.xpath("//a[text()='Selenium']")).click();
	
	//handle the alert
	
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	alert.accept();
	}

}
