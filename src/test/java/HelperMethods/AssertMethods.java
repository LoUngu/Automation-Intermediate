package HelperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AssertMethods {

    WebDriver driver;

    public AssertMethods(WebDriver driver){
        this.driver = driver;
    }

    public <T> void verifyExpectedValueEqualsActualValue(T actualValue, T expectedValue){
        Assert.assertEquals(actualValue, expectedValue);
    }

    public void verifyTextContainsSpecificValue(String text, String value){
        Assert.assertTrue(text.contains(value));
    }

    public void verifyElementNameIs(WebElement element, String value){
        Assert.assertEquals(element.getText(), value);
    }


}
