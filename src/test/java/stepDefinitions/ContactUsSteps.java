package stepDefinitions;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;
import utils.ConfigReader;
import utils.ExcelReader;

public class ContactUsSteps {

	private WebDriver driver;
	ContactUsPage contactObj;
	private ExcelReader excelReader = new ExcelReader();
	private String excelPath = "src/test/resources/testData/TestData.xlsx";
	public static Logger log;
	ConfigReader reader = new ConfigReader();
	private Scenario scenario;

	// Initializing scenario to get its name
	@Before
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	// Driver navigation, initializing objects
	@Given("the user is on the Event Management System homepage")
	public void the_user_is_on_the_event_management_system_homepage() {
		log = LogManager.getLogger("ContactUsSteps");
		this.driver = Hooks.driver;
		log.info("Application Launcehd............................");
		String url = reader.getBaseUrl();
		driver.get(url);
		contactObj = new ContactUsPage(driver);
	}

	// Navigate to contact us form
	@When("the user navigates to the Contact Us form")
	public void the_user_navigates_to_the_contact_us_form() {
		log.info("Navigating to Contact Us Form............................");
		contactObj.clickContactUsButton();
	}

	// Getting the data from excel and
	@When("fills and submits the form for each row of data from the {string} sheet")
	public void fills_and_submits_the_form_for_each_row_of_data_from_the_sheet(String sheetName) {
		List<Map<String, String>> testData = excelReader.getData(excelPath, sheetName);
		for (Map<String, String> data : testData) {
			log.info("Entering Details from Excecl Sheet............................");
			contactObj.setContactName(data.get("Name"));
			contactObj.setContactEmail(data.get("Email"));
			contactObj.setContactSubject(data.get("Subject"));
			contactObj.setContactMessage(data.get("Message"));
			contactObj.clickMessageBtn();
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				String screenshotName = scenario.getName() + ".png";
				FileUtils.copyFile(src, new File("src/test/resources/screenshotsContactUs/" + screenshotName));
				TimeUnit.SECONDS.sleep(4);
			} catch (Exception e) {
				e.printStackTrace();
			}
			String expectedName = "^[a-zA-Z ]+$";
			String expectedEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$";
			Assert.assertTrue(data.get("Name").matches(expectedName),
					"Test case failed: The name '" + data.get("Name") + "' is invalid.");
			Assert.assertTrue(data.get("Email").matches(expectedEmail),
					"Test case failed: The email '" + data.get("Email") + "' is invalid.");
		}
	}

	@Then("a success message should be displayed after each submission")
	public void a_success_message_should_be_displayed_after_each_submission() {
		log.info("Getting success message............................");
		log.info(contactObj.getSuccessMessage());
	}
}
