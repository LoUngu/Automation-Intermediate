package pages;

import HelperMethods.BrowserWindowsMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BrowserWindowsAndTabsPage extends CommonPage{

    public BrowserWindowsAndTabsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement tabButtonElement;

    @FindBy(id = "windowButton")
    private WebElement windowButtonElement;

    @FindBy(id = "sampleHeading")
    private WebElement tabSampleHeadingElement;

    public String getTextFromHeading() {
        return elementsMethods.retrieveElementText(tabSampleHeadingElement);
    }

    public void clickOnTabButton(){
        elementsMethods.clickOnElement(tabButtonElement);
    }

    public void clickOnWindowsButton(){
        elementsMethods.clickOnElement(windowButtonElement);
    }
    public void navigateToGivenTabOrWindow(Integer index){
        List<String> tabList = browserWindowsMethods.getCurrentWindowsOrTabSituation();
        browserWindowsMethods.navigateToWindow(tabList, index);
    }

}

