package Tests;

import HelperMethods.AssertMethods;
import HelperMethods.BrowserWindowsMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.testng.annotations.Test;
import pages.BrowserWindowsAndTabsPage;
import pages.CommonPage;
import pages.HomePage;
import java.util.List;

public class BrowserWindowsAndTabsTests extends BaseTest{

    public HomePage homePage;
    public CommonPage commonPage;
    public BrowserWindowsAndTabsPage browserWindowsAndTabsPage;
    public AssertMethods assertMethods;

    @Test
    public void browserWindowsTests() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        browserWindowsAndTabsPage = new BrowserWindowsAndTabsPage(getDriver());
        assertMethods = new AssertMethods(getDriver());

        homePage.goToDesiredMenuValue("Alerts, Frame & Windows");
        commonPage.goToDesiredElement("Browser Windows");

        //navigate to new tab
        browserWindowsAndTabsPage.clickOnTabButton();
        browserWindowsAndTabsPage.navigateToGivenTabOrWindow(1);
        assertMethods.verifyExpectedValueEqualsActualValue(browserWindowsAndTabsPage.getTextFromHeading(), "This is a sample page");
        getDriver().close();

        //navigate back to previous tab
        browserWindowsAndTabsPage.navigateToGivenTabOrWindow(0);

        //navigate to new window
        browserWindowsAndTabsPage.clickOnWindowsButton();
        browserWindowsAndTabsPage.navigateToGivenTabOrWindow(1);
        assertMethods.verifyExpectedValueEqualsActualValue(browserWindowsAndTabsPage.getTextFromHeading(), "This is a sample page");
    }
}
