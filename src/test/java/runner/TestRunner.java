package runner;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features/ContactUs.feature", "src/test/resources/features/Booking.feature" },
		glue = {"stepDefinitions","hooks"},
		tags = "@BookingForm", // scnearios you want to run
		dryRun = false,
		monochrome = true,
		plugin = { "pretty", "html:target/report.html" }
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
