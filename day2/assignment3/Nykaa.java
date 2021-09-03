package week4.day2.assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
//		1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		2) Mouseover on Brands and Mouseover on Popular
WebElement brand=driver.findElement(By.xpath("//a[text()='brands']"));
Actions builder=new Actions(driver);
builder.moveToElement(brand).perform();

WebElement popular=driver.findElement(By.xpath("//a[text()='Popular']"));
Actions builder1=new Actions(driver);
builder1.moveToElement(popular).perform();

//3) Click L'Oreal Paris
driver.findElement(By.xpath("//ul[@class='l-vertical-list']//li[5]//a//img")).click();
Set<String> windowHandleSet= driver.getWindowHandles();
List<String> windowHandleList=new ArrayList<String>(windowHandleSet);
driver.switchTo().window(windowHandleList.get(1));

//Get the number of windows
System.out.println("Number of windows: " + windowHandleList.size());

//4) Go to the newly opened window and check the title contains L'Oreal Paris
String title=driver.getTitle();
System.out.println("The title contains L'Oreal Paris : " + title);
String title2=title;

if(title2.equals(title))
System.out.println("Page title has verified");
else
	System.out.println("Page title has not verified");


//5) Click sort By and select customer top rated
driver.findElement(By.xpath("//span[text()='popularity']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

//6) Click Category and click Shampoo
Thread.sleep(5000);
driver.findElement(By.xpath("//div[text()='Category']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//span[text()='Hair']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
String titlePage1= driver.getTitle();
System.out.println("Title of the current page: " +titlePage1);

//7) check whether the Filter is applied with Shampoo
String titlePage=titlePage1;

if(titlePage.equals(titlePage))
{
	System.out.println("Filter applied");
}
else
{
	System.out.println("Filter not applied");

}

//8) Click on L'Oreal Paris Colour Protect Shampoo
Thread.sleep(2000);
driver.findElement(By.xpath("(//div[@class='m-content__product-list__title'])[12]")).click();
Thread.sleep(2000);

Set<String> windowHandleSet2= driver.getWindowHandles();
List<String> windowHandleList2=new ArrayList<String>(windowHandleSet2);
driver.switchTo().window(windowHandleList2.get(2));
Thread.sleep(2000);

//9) GO to the new window and select size as 175ml

driver.findElement(By.xpath("//span[text()='175ml']")).click();

//10) Print the MRP of the product
String mrp=driver.findElement(By.xpath("//div[@class='price-info']")).getText();
String string=mrp.replaceAll("[^0-9]", "");
int mrp1=Integer.parseInt(string);
System.out.println("MRP of the product: " +mrp1);

//11) Click on ADD to BAG
Thread.sleep(2000);
driver.findElement(By.xpath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']")).click();

//12) Go to Shopping Bag 
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
Thread.sleep(2000);
WebElement shopping=driver.findElement(By.xpath("//span[text()='Shopping Bag']"));
Actions bag=new Actions(driver);
bag.moveToElement(shopping).perform();

//13) Print the Grand Total amount
String grandTotal=driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
String str=grandTotal.replaceAll("[^0-9]", "");
int grandTotal1=Integer.parseInt(str);
System.out.println("Grand Total amount : " + grandTotal1);

//14) Click Proceed
driver.findElement(By.xpath("//span[text()='Proceed']")).click();

//15) Click on Continue as Guest
Thread.sleep(2000);
driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

//16) Check if this grand total is the same in step 13
Thread.sleep(2000);
String grandTotal2=driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
String str2=grandTotal2.replaceAll("[^0-9]", "");
int grandTotal3=Integer.parseInt(str2);
System.out.println("Check Grand total of the product: " + grandTotal2);

if(grandTotal1==grandTotal3)
{
	System.out.println("Grand totals are same");
}
else
{
	System.out.println("Grand totals are not same");
}


//17) Close all windows

//driver.quit();

}

}
