package Tests;

import HelperMethods.AlertsMethods;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.CommonPage;
import pages.HomePage;

public class AlertTest extends BaseTest{

    public HomePage homePage;
    public CommonPage commonPage;
    public AlertsPage alertsPage;

    @Test
    public void fillInTheForm() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        alertsPage = new AlertsPage(getDriver());

        homePage.goToDesiredMenuValue("Alerts, Frame & Windows");
        commonPage.goToDesiredElement("Alerts");

        alertsPage.dismissSimpleAlert();
        alertsPage.dismissDelayAlert();
        alertsPage.dismissPromptAlert();
    }
}