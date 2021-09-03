package week4.day2.assignment4;

import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//2. Go to Mens Fashion
		WebElement menFash=driver.findElement(By.xpath("//li[@class='navlink lnHeight']"));
		Actions click=new Actions(driver);
		click.moveToElement(menFash).perform();
		
		
//3. Go to Sports Shoes
driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
	
//4. Get the count of the sports shoes
String  sportsShoesCount=driver.findElement(By.xpath("//span[@class='category-count']")).getText();
String str=sportsShoesCount.replaceAll("[^0-9]", "");
int count=Integer.parseInt(str);
System.out.println("The count of the sports shoes: " +count);
		
//5. Click Training shoes
driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

//6. Sort by Low to High
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
WebElement ele=driver.findElement(By.xpath("//ul[@class='sort-value']//li[2]"));
String sorted=ele.getText();
ele.click();
Thread.sleep(2000);
System.out.println(sorted);

//7. Check if the items displayed are sorted correctly
String sorted1 ="Price Low To High";

if(sorted.equals(sorted1)) {
	System.out.println("The items are displayed sorted correctly");
}
else {

	System.out.println("The items are not displayed sorted correctly");
}


//8. Mouse Hover on puma Blue Training shoes

WebElement blue=driver.findElement(By.xpath("(//p[text()='VSS Blue Training Shoes'])[1]"));
Actions act=new Actions(driver);
act.moveToElement(blue).perform();
Thread.sleep(2000);


//9. click QuickView button
driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[17]")).click();

//10. Print the cost and the discount percentage
String price = driver.findElement(By.className("payBlkBig")).getText();
System.out.println("Price: " + price);
String discount = driver.findElement(By.className("percent-desc")).getText();
System.out.println("Discount percentage: " + discount);

//11. Take the snapshot of the shoes.
File src1=driver.getScreenshotAs(OutputType.FILE);
File dst=new File("./snaps/snapdeal.png");
FileUtils.copyFile(src1, dst);	

//12. Close the current window
driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
//13. Close the main window
driver.close();
//14. select the brand Puma

	}

}
