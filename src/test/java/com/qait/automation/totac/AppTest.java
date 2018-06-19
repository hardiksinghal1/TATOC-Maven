package com.qait.automation.totac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;
import org.testng.Assert;


public class AppTest 
{
	WebDriver driver;
	String title;
    
    @Test(description="Testing first page")
    public void firstPage() {
    	GridGate gridgate = new GridGate(driver);
    	gridgate.clickOnGreenBox();
    	title = driver.getTitle();
    	Assert.assertTrue(title.contains("Frame Dungeon"));
    }
    
    @Test(dependsOnMethods = { "firstPage" })
    public void secondPage() {
    	FrameDungeon framedungeon = new FrameDungeon(driver);
    	framedungeon.getSolution();
		title = driver.getTitle();
    	Assert.assertTrue(title.contains("Drag"));
    }
    
    @Test(dependsOnMethods = { "secondPage" })
    public void thirdPage() {
    	DragAround dragaround = new DragAround(driver);
    	dragaround.dragTheBox();
		title = driver.getTitle();
    	Assert.assertTrue(title.contains("Windows"));
    }
    
    @Test(dependsOnMethods = { "thirdPage" })
    public void fourthPage() {
    	PopupWindows popup = new PopupWindows(driver);
    	popup.performOperations();
		title = driver.getTitle();
    	Assert.assertTrue(title.contains("Cookie Handling"));
    }
    
    @Test(dependsOnMethods = { "fourthPage" })
    public void fifthPage() {
    	CookieHandling cookiehandle = new CookieHandling(driver);
    	cookiehandle.resolve();
    	title = driver.getTitle();
    	Assert.assertTrue(title.contains("End"));
    }
    
    @BeforeClass()
    public void openHomePage() {
    	driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
    }
    
    @AfterClass()
    public void closeHomePage() {
    	driver.quit();
    } 

}
