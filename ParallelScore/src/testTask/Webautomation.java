package testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Webautomation {
	WebDriver driver;
	String driverPath="C:\\ParallelScore\\driver\\chromedriver.exe";
	
	
	@BeforeMethod
	public void initialize() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//launch browser
		driver = new ChromeDriver();
		
		//open parallelscore website
		driver.get("https://parallelscore.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"PopupSignupForm_0\"]/div[2]/div[1]")).click();
		
		//To check that the correct website is displayed
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	    
	@Test(priority=1)
	public void careers() throws InterruptedException {
		//click on Careers
		driver.findElement(By.xpath("//*[@id=\"menu-item-6309\"]")).click();
		Thread.sleep(5000);
		
		//Select Category type
		driver.findElement(By.id("category")).click();
		driver.findElement(By.id("category")).sendKeys("full time");
		Thread.sleep(1000);
		
		//Select Location
		driver.findElement(By.id("location")).click();
		driver.findElement(By.id("location")).sendKeys("lagos");
		
		//Click on the search button
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div[1]/div[2]/div/div[2]/div/div/div/div/div[1]/form/div/div[5]/input")).click();
		
		//Validate the Results
		Assert.assertEquals(driver.findElement(By.xpath("//body[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/header[1]/div[1]/div[2]/div[1]/div[3]/div[1]")).getText(), "Lagos, Nigeria");
							
	}
	
	@AfterMethod
	public void terminate() {

		driver.quit();
		System.out.println("close browser");
	}

}
