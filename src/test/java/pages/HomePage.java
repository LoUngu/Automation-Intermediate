package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonPage{

    @FindBy(xpath = "//h5")
    private List<WebElement> headers;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToDesiredMenuValue(String text){
        jsHelper.scrollOnPage(0, 400);
        elementsMethods.selectElementFromListByText(headers, text);
    }
}
