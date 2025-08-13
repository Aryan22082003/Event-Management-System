package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	WebDriver driver;

	// Constructor
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//a[normalize-space()='Contact Us']")
	WebElement contactUsButtonElement;

	@FindBy(id = "contact_name")
	WebElement contactNameElement;

	@FindBy(id = "contact_email")
	WebElement contactEmailElement;

	@FindBy(id = "contact_subject")
	WebElement contactSubjectElement;

	@FindBy(id = "contact_message")
	WebElement contactMessageElement;

	@FindBy(id = "message")
	WebElement messageButtonElement;

	@FindBy(id = "mesgtab")
	WebElement successMessageElement;

	// Action Methods
	public void clickContactUsButton() {
		contactUsButtonElement.click();
	}

	public void setContactName(String contactName) {
		contactNameElement.clear();
		contactNameElement.sendKeys(contactName);
	}

	public void setContactEmail(String contactEmail) {
		contactEmailElement.clear();
		contactEmailElement.sendKeys(contactEmail);
	}

	public void setContactSubject(String contactSubject) {
		contactSubjectElement.clear();
		contactSubjectElement.sendKeys(contactSubject);
	}

	public void setContactMessage(String contactMessage) {
		contactMessageElement.clear();
		contactMessageElement.sendKeys(contactMessage);
	}

	public void clickMessageBtn() {
		messageButtonElement.click();
	}

	public String getSuccessMessage() {
		return successMessageElement.getText();
	}

}
