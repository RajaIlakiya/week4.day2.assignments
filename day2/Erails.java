package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erails {
private static String text;

//	https://erail.in/
//		1. Enetr the from station as ms
//		2. Enetr the To stationa as mdu
//		3. Uncheck the Sort By date
//		4. Count the number of trains available
//		5. Get the names of all the train and store it in a list
//		6. Sort the train names 
//		   use Collections.sort()
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement txtStation = driver.findElement(By.id("txtStationFrom"));
		txtStation.clear();
		txtStation.sendKeys("ms",Keys.ENTER);
		
		//txtStationTo
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("mdu",Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(1000);
			
		WebElement webtable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> trainList = webtable.findElements(By.tagName("tr"));
		
		// Number of trains avilable
		System.out.println(trainList.size());
		
		List<String> nameList = new ArrayList<String>();
		// Names of the trains
		// second column
		for (int i = 0; i < trainList.size(); i++) {
			WebElement eachRow = trainList.get(i);
			List<WebElement> eachData = eachRow.findElements(By.tagName("td"));
			String text = eachData.get(1).getText();
			System.out.println(i + " " + text);
			
			// add to the empty list
			nameList.add(text);
		}
		
		Collections.sort(nameList);
		
		System.out.println("Sorted");
		System.out.println(nameList);
	}

	
	}


