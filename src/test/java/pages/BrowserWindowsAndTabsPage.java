package pages;

import HelperMethods.BrowserWindowsMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrowserWindowsAndTabsPage {

    WebDriver driver;
    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;
    public BrowserWindowsMethods browserWindowsMethods;

    public BrowserWindowsAndTabsPage(WebDriver driver) {
        this.driver = driver;
        browserWindowsMethods = new BrowserWindowsMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    WebElement tabButtonElement;

    @FindBy(id = "windowButton")
    WebElement windowButtonElement;

    @FindBy(id = "sampleHeading")
    WebElement tabSampleHeadingElement;

    public String getTextFromHeading() {
        return elementsMethods.retrieveElementText(tabSampleHeadingElement);
    }

    public void clickOnTabButton(){
        elementsMethods.clickOnElement(tabButtonElement);
    }

    public void clickOnWindowsButton(){
        elementsMethods.clickOnElement(windowButtonElement);
    }
    public void navigateToGivenWindow(List<String> windowsList, Integer index){
        browserWindowsMethods.navigateToWindow(windowsList, index);
    }

}
