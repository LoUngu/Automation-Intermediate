package Tests;

import HelperMethods.AssertMethods;
import HelperMethods.BrowserWindowsMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowsAndTabsPage;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsAndTabsTests extends BaseTest{

    public ElementsMethods elementsMethods;
    public BrowserWindowsMethods browserWindowsMethods;
    public JSHelper jsHelper;
    public HomePage homePage;
    public CommonPage commonPage;
    public BrowserWindowsAndTabsPage browserWindowsAndTabsPage;
    public AssertMethods assertMethods;

    @Test
    public void browserWindowsTests() {

        elementsMethods = new ElementsMethods(driver);
        browserWindowsMethods = new BrowserWindowsMethods(driver);
        jsHelper = new JSHelper(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        browserWindowsAndTabsPage = new BrowserWindowsAndTabsPage(driver);
        assertMethods = new AssertMethods(driver);

        homePage.goToDesiredMenuValue("Alerts, Frame & Windows");
        commonPage.goToDesiredElement("Browser Windows");

        browserWindowsAndTabsPage.clickOnTabButton();

        List<String> tabList = new ArrayList<>(driver.getWindowHandles());
        browserWindowsAndTabsPage.navigateToGivenWindow(tabList, 1);
        assertMethods.verifyExpectedValueEqualsActualValue(browserWindowsAndTabsPage.getTextFromHeading(), "This is a sample page");
        driver.close();

        browserWindowsAndTabsPage.navigateToGivenWindow(tabList, 0);

        browserWindowsAndTabsPage.clickOnWindowsButton();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        browserWindowsMethods.navigateToWindow(windowList, 1);
        assertMethods.verifyExpectedValueEqualsActualValue(browserWindowsAndTabsPage.getTextFromHeading(), "This is a sample page");
        driver.close();
    }
}
