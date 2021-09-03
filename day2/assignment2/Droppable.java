package week4.day2.assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(0);

		WebElement source1=driver.findElement(By.id("draggable"));
		WebElement target1=driver.findElement(By.id("droppable"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder1=new Actions(driver);
		builder1.dragAndDrop(source1, target1).perform();
	}

}
