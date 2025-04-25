package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesMethods {

    WebDriver driver;

    public FramesMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame(WebElement frame){
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultWindow(){
        driver.switchTo().defaultContent();
    }
}
