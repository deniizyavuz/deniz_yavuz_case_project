package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CareersPage {

    WebDriver driver;

    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExploreOpenRoles() {

        By exploreOpenRoles = By.cssSelector("a[href='#open-roles']");

        WaitUtils.waitForElement(driver, exploreOpenRoles).click();
    }

    public void clickSeeAllTeams() {
    
        WebElement element = WaitUtils.waitForElement(driver,
                By.linkText("See all teams"));
    
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    
        element.click();
    }

    public void openQaPage() {
        By openQaLever = By.cssSelector("a[href='https://jobs.lever.co/insiderone?team=Quality%20Assurance']");
        WaitUtils.waitForElement(driver, openQaLever).click();
    }
}