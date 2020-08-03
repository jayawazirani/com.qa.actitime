package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverScript {
	public static WebDriver driver;
	public static Properties prop;

	public DriverScript() {
		try {

			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}

		catch (Exception e) {

			System.out.println("unable to load property file" + e.getMessage());
		}
	}

	//@Test
	public static void initBrowser() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("errrororor");
		}
		 driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		String url = prop.getProperty("url");
		System.out.println("url is" + url);
		driver.get(url);
	}

}
