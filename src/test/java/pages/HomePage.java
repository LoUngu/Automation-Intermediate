package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;
    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5")
    List<WebElement> headers;

    public void goToDesiredMenuValue(String text){
        jsHelper.scrollOnPage(0, 400);
        elementsMethods.selectElementFromListByText(headers, text);
    }
}
