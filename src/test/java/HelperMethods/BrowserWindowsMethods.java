package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsMethods {

    WebDriver driver;

    public BrowserWindowsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToWindow(List<String> windowList, int windowNumber){
        driver.switchTo().window(windowList.get(windowNumber));
    }

    public List<String> getCurrentWindowsOrTabSituation(){
        List<String> tabAndWindowsList = new ArrayList<>(driver.getWindowHandles());
        return tabAndWindowsList;
    }
}
