package environment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import configReader.ReadPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

	public static Duration DEFAULT_WAIT = Duration.ofSeconds(20);
	protected static WebDriver driver;
	static String browser="";

	public static WebDriver getDefaultDriver() {
		if (driver != null) {
			return driver;
		}

		browser = ReadPropertyFile.getProperty("browserName");
		String headless = ReadPropertyFile.getProperty("headless");
		switch(browser.toLowerCase()) {

		case "chrome":
			final ChromeOptions chOptions = new ChromeOptions();
			if(headless.equalsIgnoreCase("true")) {
				chOptions.addArguments("--headless");
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chOptions);
			driver.manage().timeouts().scriptTimeout(DEFAULT_WAIT);
			driver.manage().window().maximize();
			
		}
		return driver;
	}



}
