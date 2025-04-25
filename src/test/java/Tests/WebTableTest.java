package Tests;

import HelperMethods.AssertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.WebTablePage;

import java.util.List;

public class WebTableTest extends BaseTest {

    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;
    public HomePage homePage;
    public CommonPage commonPage;
    public WebTablePage webTablePage;
    public AssertMethods assertMethods;

    @Test
    public void automationMethod() {

        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        webTablePage = new WebTablePage(driver);
        assertMethods = new AssertMethods(driver);

        homePage.goToDesiredMenuValue("Elements");
        commonPage.goToDesiredElement("Web Tables");

        Integer initialTableSize = webTablePage.getTableSize();

        webTablePage.fillInRegistrationFormAndClickOnSubmit("Ion", "Popescu", "ion.popescu@email.com", "18", "10000", "IT");

        Integer expectedTableSize = initialTableSize + 1;
        Integer actualTableSize = webTablePage.getTableSize();
        assertMethods.verifyExpectedValueEqualsActualValue(actualTableSize, expectedTableSize);
        driver.close();
    }
}
