package pages;

import ObjectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebTablePage extends CommonPage{

    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"rt-tbody\"]/div/div[@class=\"rt-tr -odd\" or @class=\"rt-tr -even\"]")
    private List<WebElement> tableRows;

    @FindBy(id ="addNewRecordButton")
    private WebElement addButton;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(id = "age")
    private WebElement ageField;

    @FindBy(id = "salary")
    private WebElement salaryField;

    @FindBy(id = "department")
    private WebElement departmentField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public Integer getTableSize(){
        return elementsMethods.getElementsListSize(tableRows);
    }

    public void clickOnAddButton(){
        elementsMethods.clickOnElement(addButton);
    }

    public void clickOnSubmitButton(){
        elementsMethods.clickOnElement(submitButton);
    }

    public void fillInRegistrationFormAndClickOnSubmit(WebTableObject webTableObject){
        clickOnAddButton();
        elementsMethods.fillElement(firstNameField, webTableObject.getFirstName());
        elementsMethods.fillElement(lastNameField, webTableObject.getLastName());
        elementsMethods.fillElement(userEmailField, webTableObject.getEmail());
        elementsMethods.fillElement(ageField, webTableObject.getAge());
        elementsMethods.fillElement(salaryField, webTableObject.getSalary());
        elementsMethods.fillElement(departmentField, webTableObject.getDepartment());
        clickOnSubmitButton();
    }
}
