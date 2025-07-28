package HelperMethods;

import ObjectData.AlertsObject;
import ObjectData.PracticeFormObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsMethods {

    WebDriver driver;

    public AlertsMethods(WebDriver driver){
        this.driver = driver;
    }

    public void interractWithAlertsOk(){
        Alert alertOk = driver.switchTo().alert();
        alertOk.accept();
    }

    public void explicitAlertWait(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void interractWithDelayAlert(){
        explicitAlertWait();
        Alert alertDelayOk = driver.switchTo().alert();
        alertDelayOk.accept();
    }

    public void dismissAlert(){
        Alert alertConfirmation = driver.switchTo().alert();
        alertConfirmation.dismiss();
    }

    public void interractWithPromptAlert(String textToSend){
        Alert alertPrompt = driver.switchTo().alert();
        alertPrompt.sendKeys(textToSend);
        alertPrompt.accept();
    }

}
