package org.simple;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

public class BlockNetworkRequest {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\subas\\eclipse-workspace\\SampleJavaProject\\Browser Launch\\Driver\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		// log file ->

		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));
		long startTime = System.currentTimeMillis();
		driver.get("https://flipkart.com");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// 1793 2033

	}

}
