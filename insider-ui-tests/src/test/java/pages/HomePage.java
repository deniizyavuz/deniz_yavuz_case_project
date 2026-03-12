package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By header = By.id("navigation");
    private By hero = By.className("homepage-hero");
    private By socialProof = By.className("homepage-social-proof");
    private By coreDifferantiators = By.className("homepage-core-differentiators");
    private By capabilities = By.className("homepage-capabilities");
    private By insiderOneAi = By.className("homepage-insider-one-ai");
    private By channels = By.className("homepage-channels");
    private By caseStudy = By.className("homepage-case-study");
    private By analyst = By.className("homepage-analyst");
    private By integrations = By.className("homepage-integrations");
    private By resources = By.className("homepage-resources");
    private By callToAction = By.className("homepage-call-to-action");
    private By footer = By.id("footer");

    public void open() {
        driver.get("https://insiderone.com/");
    }

    public boolean isHomePageOpened() {
        return driver.getCurrentUrl().contains("insiderone.com");
    }

    public void acceptCookies() {
    try {
        WebElement cookieAcceptButton = WaitUtils.waitForElement(driver,
                By.id("wt-cli-accept-all-btn"));
        cookieAcceptButton.click();
    } catch (Exception e) {
        // may cookie accept button not exists, then ignore it.
    }
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean mainBlocksLoaded() {
        return WaitUtils.waitForElement(driver, header).isDisplayed()
                && WaitUtils.waitForElement(driver, hero).isDisplayed()
                && WaitUtils.waitForElement(driver, socialProof).isDisplayed()
                && WaitUtils.waitForElement(driver, coreDifferantiators).isDisplayed()
                && WaitUtils.waitForElement(driver, capabilities).isDisplayed()
                && WaitUtils.waitForElement(driver, insiderOneAi).isDisplayed()
                && WaitUtils.waitForElement(driver, channels).isDisplayed()
                && WaitUtils.waitForElement(driver, caseStudy).isDisplayed()
                && WaitUtils.waitForElement(driver, analyst).isDisplayed()
                && WaitUtils.waitForElement(driver, integrations).isDisplayed()
                && WaitUtils.waitForElement(driver, resources).isDisplayed()
                && WaitUtils.waitForElement(driver, callToAction).isDisplayed()
                && WaitUtils.waitForElement(driver, footer).isDisplayed();
    }

    public void goToCareers() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        By weAreHiring = By.cssSelector("a[href='/careers/']");

        WaitUtils.waitForElement(driver, weAreHiring).click();
    }
}