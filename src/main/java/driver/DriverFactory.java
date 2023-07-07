package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    // Using ThreadLocal allow me to run test in parallel, that's why is used.
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private static WebDriver createDriver() {

        // Create the variable driver to fill it later
        WebDriver driver = null;

        // Switch control to select kind of browser
        switch (getBrowserType()) {
            case "chrome" -> {
                // Set the CHROME property and its options needed
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--remote-allow-origins=*");
                // Assign the chrome driver
                driver = new ChromeDriver(chromeOptions);
                break;
            }

            case "firefox" -> {
                // Set the FIREFOX property and its options needed
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                // Assign the chrome driver
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    // This method value will be used within switch control to select which browser use to run tests.
    private static String getBrowserType() {
        String browserType = null;
        // Getting this from jenkins
        String browserTypeRemoteValue = System.getProperty("browserType");

        try {
            if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
                // This is created because we have properties file that read 'browser' value from there
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            } else {
                browserType = browserTypeRemoteValue;
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return browserType;
    }

    public static void cleanUpDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());

        }
        return webDriver.get();
    }
}
