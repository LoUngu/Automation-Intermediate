package pages;

import HelperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    protected WebDriver driver;
    protected ElementsMethods elementsMethods;
    protected JSHelper jsHelper;
    protected FramesMethods framesMethods;
    protected BrowserWindowsMethods browserWindowsMethods;
    protected AlertsMethods alertsMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        framesMethods = new FramesMethods(driver);
        browserWindowsMethods = new BrowserWindowsMethods(driver);
        alertsMethods = new AlertsMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span")
    List<WebElement> elementsTable;

    public void goToDesiredElement(String text){
        jsHelper.scrollOnPage(0, 1000);
        elementsMethods.selectElementFromListByText(elementsTable, text);
    }
}
