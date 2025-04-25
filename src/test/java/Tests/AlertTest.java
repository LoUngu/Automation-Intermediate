package Tests;

import HelperMethods.AlertsMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;

import java.time.Duration;

public class AlertTest extends BaseTest{

    public ElementsMethods elementsMethods;
    public AlertsMethods alertsMethods;
    public JSHelper jsHelper;
    public HomePage homePage;
    public CommonPage commonPage;

    @Test
    public void fillInTheForm() {

        elementsMethods = new ElementsMethods(driver);
        alertsMethods = new AlertsMethods(driver);
        jsHelper = new JSHelper(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);

        homePage.goToDesiredMenuValue("Alerts, Frame & Windows");
        commonPage.goToDesiredElement("Alerts");

        WebElement alertOkElement = driver.findElement(By.id("alertButton"));
        elementsMethods.clickOnElement(alertOkElement);

        alertsMethods.interractWithAlertsOk();

        WebElement alertDelayElement = driver.findElement(By.id("timerAlertButton"));
        elementsMethods.clickOnElement(alertDelayElement);

        alertsMethods.interractWithDelayAlert();

        WebElement alertConfirmationElement = driver.findElement(By.id("confirmButton"));
        elementsMethods.clickOnElement(alertConfirmationElement);

        alertsMethods.dismissAlert();

        WebElement alertPromptElement = driver.findElement(By.id("promtButton"));
        elementsMethods.clickOnElement(alertPromptElement);

        alertsMethods.interractWithPromptAlert("Automation test");
        driver.close();
    }
}