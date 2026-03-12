package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JobPage {

    WebDriver driver;

    public JobPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickApplyForThisJobButton() {
        WebElement applyButton = WaitUtils.waitForElement(driver,
                By.cssSelector("a[href*='/apply']"));
        applyButton.click();
    }

    public boolean isApplicationFormVisible() {
        return  WaitUtils.waitForElement(driver,
                    By.cssSelector("input[name='nameee']")).isDisplayed() && 
                WaitUtils.waitForElement(driver,
                    By.cssSelector("input[name='email']")).isDisplayed();
    }

}