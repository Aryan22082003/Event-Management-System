package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions; // Import for Firefox

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {

	public static WebDriver driver;
	public static ConfigReader reader;

	@Before
	public void setup() {
		reader = new ConfigReader();
		String browser = reader.getBrowser();

		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless");
			driver = new FirefoxDriver(firefoxOptions);

		} else {
			ChromeOptions chromeOptions = new ChromeOptions();

			// Add the essential arguments for running in Docker
			chromeOptions.addArguments("--headless=new");
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");

			// Set window size because .maximize() is not effective in headless mode
			chromeOptions.addArguments("--window-size=1920,1080");

			// Pass the options object to the ChromeDriver constructor
			driver = new ChromeDriver(chromeOptions);
			
			
			
			
//			driver = new ChromeDriver();
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}