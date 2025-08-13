package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;
import utils.ConfigReader;

public class BookingSteps {

	private WebDriver driver;
	BookingPage bookObj;
	private Scenario scenario;
	public static Logger log;
	ConfigReader reader = new ConfigReader();

	// Initializing scenario to get its name
	@Before
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	// Driver navigation, initializing objects
	@Given("The user is on the Event Management System booking page")
	public void the_user_is_on_the_event_management_system_booking_page() {
		log = LogManager.getLogger("BookingSteps");
		log.info("Application Launched........");
		this.driver = Hooks.driver;
		log.info("Opening Booking Form........");
		String url = reader.getBaseUrl();
		driver.get(url);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("eventDetail"))).perform();
		bookObj = new BookingPage(driver);
	}

	// Method for entering details using feature file Scenario DataTable
	@When("The user enters invalid details")
	public void user_enters_invalid_details(
			io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMaps().get(0);
		log.info("Entering Invalid Booking Details........");
		log.info("Implementing negative scenario using DataType........");
		bookObj.setFirstName(data.get("FirstName"));
		bookObj.setLastName(data.get("LastName"));
		bookObj.setPhoneNo(data.get("Phone"));
		bookObj.setEmailId(data.get("Email"));
		bookObj.setEventType(data.get("EventType"));
		bookObj.setEventDate(data.get("EventDate"));
		bookObj.setEventTime(data.get("EventTime"));
		bookObj.setGuestCount(data.get("GuestCount"));
		bookObj.setCateringService(data.get("Catering"));
		bookObj.setAddress(data.get("Address"));
		bookObj.setCity(data.get("City"));
		bookObj.setPincode(data.get("Pincode"));
	}

	// Method for entering details using feature file Scenario Outline
	@When("the user enters the details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_enters_valid_details(String firstName, String lastName, String phone, String email,
			String eventType, String eventDate, String eventTime, String guestCount, String catering, String address,
			String city, String pincode) {
		log.info("Entering Valid Booking Details........");
		log.info("Implementing positive scenario using Scenario Outline........");
		bookObj.setFirstName(firstName);
		bookObj.setLastName(lastName);
		bookObj.setPhoneNo(phone);
		bookObj.setEmailId(email);
		bookObj.setEventType(eventType);
		bookObj.setEventDate(eventDate);
		bookObj.setEventTime(eventTime);
		bookObj.setGuestCount(guestCount);
		bookObj.setCateringService(catering);
		bookObj.setAddress(address);
		bookObj.setCity(city);
		bookObj.setPincode(pincode);
		String expectedName = "^[a-zA-Z ]+$";
		Assert.assertTrue(firstName.matches(expectedName));
		String expectedEmail = "^[\\w.-]+@[\\w.-]+\\.com$";
		Assert.assertTrue(email.matches(expectedEmail));
	}

	@Then("The user clicks the Book Now button")
	public void the_user_clicks_the_book_now_button() {
		log.info("Clicking Book Now Button........");
		bookObj.clickBookNow();
	}

	@Then("Take Screenshot Scnario 1")
	public void take_screenshotScenario1() throws IOException {
		log.info("Taking Screenshots of negative scenario........");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("src/test/resources/screenshotsBooking/negative.png"));
	}

	@Then("Take Screenshot Scnario 2")
	public void take_screenshotScenario2() throws IOException {
		log.info("Taking Screenshots of positive scenario........");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenshotName = "positive_" + scenario.getLine() + ".png";
		FileUtils.copyFile(src, new File("src/test/resources/screenshotsBooking/" + screenshotName));
	}

	@Then("Take Screenshot Invalid Scnario")
	public void take_screenshot_invalid_scnario() throws IOException {
		log.info("Taking Screenshots of positive scenario........");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenshotName = scenario.getName() + ".png";
		FileUtils.copyFile(src, new File("src/test/resources/screenshotsBooking/" + screenshotName));
	}

	@When("Close the browser")
	public void close_the_browser() {
		log.info("Closing Browser........");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
