package org.simple;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	@Test
	public void getLink() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://fb.com");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int brokencount=0;
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement element = allLinks.get(i);
			String attribute = element.getAttribute("href");

			URL url = new URL(attribute);
			URLConnection openConnection = url.openConnection();
			HttpsURLConnection connection=(HttpsURLConnection) openConnection;
			int responseCode = connection.getResponseCode();
			if (responseCode!=200) {
				brokencount++;
				System.out.println("broken links are:"+attribute);
				
			}
			
	}
		System.out.println("number of broken links are:"+brokencount);

	}
	

}
