package HelperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSHelper {
    public WebDriver driver;
    public JavascriptExecutor js;


    public JSHelper(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollOnPage(int x, int y){
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void clickOnElementWithJS(WebElement element){
        js.executeScript("arguments[0].click();", element);

    }
}
