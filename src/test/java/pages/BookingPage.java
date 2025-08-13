package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {

	WebDriver driver;

	// Constructor
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(id = "firstName")
	WebElement firstNameElement;

	@FindBy(id = "lastName")
	WebElement lastNameElement;

	@FindBy(id = "phoneNo")
	WebElement phoneNoElement;

	@FindBy(id = "emaiId")
	WebElement emailIdElement;

	@FindBy(id = "eventType")
	WebElement eventTypeElement;

	@FindBy(id = "eventDate")
	WebElement eventDateElement;

	@FindBy(id = "eventTime")
	WebElement eventTimeElement;

	@FindBy(id = "guestCount")
	WebElement guestCountElement;

	@FindBy(id = "vegFood")
	WebElement vegFoodElement;

	@FindBy(id = "nonVegFood")
	WebElement nonVegFoodElement;

	@FindBy(id = "address")
	WebElement addressElement;

	@FindBy(id = "city")
	WebElement cityElement;

	@FindBy(id = "pincode")
	WebElement pincodeElement;

	@FindBy(id = "eventDetail")
	WebElement eventDetailElement;

	@FindBy(id = "book-now")
	WebElement btnElement;

	// Action Methods
	public void setFirstName(String firstName) {
		firstNameElement.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		lastNameElement.sendKeys(lastName);
	}

	public void setPhoneNo(String phoneNo) {
		phoneNoElement.sendKeys(phoneNo);
	}

	public void setEmailId(String email) {
		emailIdElement.sendKeys(email);
	}

	public void setEventType(String eventType) {
		Select options = new Select(eventTypeElement);
		options.selectByVisibleText(eventType);
	}

	public void setEventDate(String eventDate) {
		eventDateElement.sendKeys(eventDate);
	}

	public void setEventTime(String eventTime) {
		eventTimeElement.sendKeys(eventTime);
	}

	public void setGuestCount(String guestCount) {
		guestCountElement.sendKeys(guestCount);
	}

	public void setCateringService(String cateringService) {
		if (cateringService.equals("Veg")) {
			vegFoodElement.click();
		} else {
			nonVegFoodElement.click();
		}
	}

	public void setAddress(String address) {
		addressElement.sendKeys(address);
	}

	public void setCity(String city) {
		Select options = new Select(cityElement);
		options.selectByVisibleText(city);
	}

	public void setPincode(String pincode) {
		pincodeElement.sendKeys(pincode);
	}

	public void setEventDetails(String eventDetails) {
		eventDetailElement.sendKeys(eventDetails);
	}

	public void clickBookNow() {
		btnElement.click();
	}
}
