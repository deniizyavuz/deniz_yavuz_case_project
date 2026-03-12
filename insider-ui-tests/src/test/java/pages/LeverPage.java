package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

import java.util.List;
import java.util.ArrayList;

import utils.WaitUtils;

public class LeverPage {

    WebDriver driver;

    public LeverPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLeverPage() {
        return driver.getCurrentUrl().contains("lever.co");
    }

    public void openLocationFilter() {
        WaitUtils.waitForElement(driver,
                By.cssSelector("[aria-label='Filter by Location: All']")).click();
    }

    public void selectIstanbul() {
        WebElement element = WaitUtils.waitForElement(driver,
                By.linkText("Istanbul, Turkiye"));

        Actions actions = new Actions(driver);

        actions.moveToElement(element)
               .pause(Duration.ofMillis(300))
               .click()
               .perform();
    }

    public boolean isQaFilterSelected() {
        return WaitUtils.waitForElement(driver,
            By.cssSelector("[aria-label='Filter by Team: Quality Assurance']")).isDisplayed();
    }

    public boolean isJobListPresent() {
           return WaitUtils.waitForElement(driver,
               By.cssSelector(".posting")).isDisplayed();
    }

    public void validateJobs() {
        List<WebElement> jobs = driver.findElements(By.className("position-list-item"));

        for (WebElement job : jobs) {

            String position = job.findElement(By.className("position-title")).getText();
            String department = job.findElement(By.className("position-department")).getText();
            String location = job.findElement(By.className("position-location")).getText();

            if (!position.contains("Quality Assurance"))
                throw new AssertionError("Position filter failed: " + position);

            if (!department.contains("Quality Assurance"))
                throw new AssertionError("Department filter failed: " + department);

            if (!location.contains("Istanbul"))
                throw new AssertionError("Location filter failed: " + location);
        }
    }

    public void clickApplyButton() {
        WebElement job = driver.findElements(By.className("posting-btn-submit")).get(0);
        job.click();
    }

}