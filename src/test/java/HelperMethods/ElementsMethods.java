package HelperMethods;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {

    WebDriver driver;
    Actions actions;
    JSHelper jsHelper;

    public ElementsMethods(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        this.jsHelper = new JSHelper(driver);
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public void clickOnElementWithKeyboard(WebElement element){
        element.sendKeys(Keys.ENTER);
    }
    public void fillElement(WebElement element, String text){
        element.sendKeys(text);
    }

    public String retrieveElementText(WebElement element){
        return element.getText();
    }

    public void uploadPicture(WebElement element){
        File file = new File("src/test/resources/fileToUpload.png");
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value){
        for(WebElement element : elementsList){
            if (element.getText().equals(value)){
                clickOnElement(element);
                break;
            }
        }
    }

    public void printText(WebElement element){
        System.out.println("WebElements text is: " + element.getText());
    }

    public void checkTableSize(List<WebElement> list1, List<WebElement> list2){
        Integer actualTableSize = list1.size();
        Assert.assertEquals(list2.size(), actualTableSize + 1);
    }

    public void ImplicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void explicitlyWaitElementVisibility(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void changeElements(List<WebElement> list){

        for (int index = 0; index < list.size(); index++){
            WebElement webElement = list.get(index);
            WebElement nextElement = list.get(index++);
            printText(webElement);
            actions.clickAndHold(webElement)
                    .moveToElement(nextElement)
                    .release()
                    .build()
                    .perform();
        }
        try{
            Thread.sleep(10000000);
        } catch (
                InterruptedException e){
            e.printStackTrace();
        }
    }


    public void fillInFieldWithActions(WebElement webElement, String subjectValue){
        actions.sendKeys(subjectValue).perform();
        explicitlyWaitElementVisibility(webElement);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void fillMultipleValues(WebElement webElement, List<String> list){
        for(String value : list){
            webElement.sendKeys(value);
            webElement.sendKeys(Keys.ENTER);
        }
    }

    public void clickMultipleElements(List<WebElement> webElements, List<String> list){
        for (String value : list){
            for (WebElement webElement : webElements){
                if(webElement.getText().equals(value)){
                    webElement.click();
                }
            }
        }
    }

    public void selectGivenDropdownValue(WebElement dropdownElement, String dropdownValue){
        jsHelper.clickOnElementWithJS(dropdownElement);
        fillElement(dropdownElement, dropdownValue);
        clickOnElementWithKeyboard(dropdownElement);
    }

    public Integer getElementsListSize(List<WebElement> elementsList){
        return elementsList.size();
    }
}
