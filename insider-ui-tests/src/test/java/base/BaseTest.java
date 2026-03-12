package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setup() {
        driver = DriverFactory.createDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown(TestInfo testInfo) {

        if (driver != null) {

            ScreenshotUtil.takeScreenshot(driver, testInfo.getDisplayName());

            driver.quit();
        }
    }
}