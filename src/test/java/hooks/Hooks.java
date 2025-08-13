package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {


	public static WebDriver driver;
	public static ConfigReader reader = new ConfigReader();

	// Run before every Scenario
	@Before
	public void setup() {
		String browser = reader.getBrowser();
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	// Run after every Scenario
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
