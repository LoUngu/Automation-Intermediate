package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    WebDriver driver;
    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span")
    List<WebElement> elementsTable;

    public void goToDesiredElement(String text){
        jsHelper.scrollOnPage(0, 1000);
        elementsMethods.selectElementFromListByText(elementsTable, text);
    }
}
