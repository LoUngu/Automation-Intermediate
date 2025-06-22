package Tests;

import HelperMethods.AssertMethods;
import SharedData.BaseTest;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.WebTablePage;

public class WebTableTest extends BaseTest {

    public HomePage homePage;
    public CommonPage commonPage;
    public WebTablePage webTablePage;
    public AssertMethods assertMethods;

    @Test
    public void automationMethod() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        webTablePage = new WebTablePage(getDriver());
        assertMethods = new AssertMethods(getDriver());

        homePage.goToDesiredMenuValue("Elements");
        commonPage.goToDesiredElement("Web Tables");

        Integer initialTableSize = webTablePage.getTableSize();

        webTablePage.fillInRegistrationFormAndClickOnSubmit("Ion", "Popescu", "ion.popescu@email.com", "18", "10000", "IT");

        Integer expectedTableSize = initialTableSize + 1;
        Integer actualTableSize = webTablePage.getTableSize();
        assertMethods.verifyExpectedValueEqualsActualValue(actualTableSize, expectedTableSize);
    }
}
