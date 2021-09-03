package week4.day2.assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
// 3.http://www.leafground.com/pages/drag.html
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions builder=new Actions(driver);
		WebElement source=driver.findElement(By.id("draggable"));
//		WebElement target=driver.findElement(By.id("mydiv"));
//		builder.dragAndDrop(source, target).perform();
		builder.dragAndDropBy(source, 100, 100).perform();


	}

}
