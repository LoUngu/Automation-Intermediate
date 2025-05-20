package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends CommonPage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
     private WebElement alertOkElement;

    @FindBy(id = "timerAlertButton")
    private WebElement alertDelayElement;

    @FindBy(id = "confirmButton")
    private WebElement alertConfirmationElement;

    @FindBy(id = "promtButton")
    private WebElement alertPromptElement;

    public void clickOkOnAlertButton(){
        elementsMethods.clickOnElement(alertOkElement);
    }

    public void clickOkOnTimerAlertButton(){
        elementsMethods.clickOnElement(alertDelayElement);
    }

    public void clickConfirmOnAlertButton(){
        elementsMethods.clickOnElement(alertConfirmationElement);
    }

    public void clickOnPromptAlertButton(){
        elementsMethods.clickOnElement(alertPromptElement);
    }

    public void dismissSimpleAlert(){
        clickOkOnAlertButton();
        alertsMethods.interractWithAlertsOk();
    }

    public void dismissDelayAlert(){
        clickOkOnTimerAlertButton();
        alertsMethods.interractWithDelayAlert();
    }

    public void dismissPromptAlert(){
        clickOnPromptAlertButton();
        alertsMethods.interractWithPromptAlert("Automation test");
    }
}
