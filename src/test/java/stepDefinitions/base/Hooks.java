package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanUpDriver;
import static driver.DriverFactory.getDriver;

// Hooks are pieces of code to run before/after scenarios,suites, etc. that allow us to reduce code duplication
public class Hooks {

    protected WebDriver driver;

    // This code will run before each scenario
    @Before
    public void setUp() {
        getDriver();
    }

    // This code will run after each step, if fails will take a screenshot
    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMillisenconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", timeMillisenconds);
        }

    }

    // This code will run after each scenario
    @After
    public void tearDown() {
        cleanUpDriver();
    }
}
