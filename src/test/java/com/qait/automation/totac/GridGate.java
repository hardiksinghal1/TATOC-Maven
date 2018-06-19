package com.qait.automation.totac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GridGate {
	WebDriver driver;
	
	public GridGate(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnGreenBox() {
		driver.findElement(By.className("greenbox")).click();
	}
	
}
