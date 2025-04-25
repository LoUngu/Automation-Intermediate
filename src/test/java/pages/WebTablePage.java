package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePage {

    WebDriver driver;
    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"rt-tbody\"]/div/div[@class=\"rt-tr -odd\" or @class=\"rt-tr -even\"]")
    List<WebElement> tableRows;

    @FindBy(id ="addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "age")
    WebElement ageField;

    @FindBy(id = "salary")
    WebElement salaryField;

    @FindBy(id = "department")
    WebElement departmentField;

    @FindBy(id = "submit")
    WebElement submitButton;

    public Integer getTableSize(){
        return elementsMethods.getElementsListSize(tableRows);
    }

    public void clickOnAddButton(){
        elementsMethods.clickOnElement(addButton);
    }

    public void clickOnSubmitButton(){
        elementsMethods.clickOnElement(submitButton);
    }

    public void fillInRegistrationFormAndClickOnSubmit(String fname, String lname, String email, String age, String salary, String department){
        clickOnAddButton();
        elementsMethods.fillElement(firstNameField, fname);
        elementsMethods.fillElement(lastNameField, lname);
        elementsMethods.fillElement(userEmailField, email);
        elementsMethods.fillElement(ageField, age);
        elementsMethods.fillElement(salaryField, salary);
        elementsMethods.fillElement(departmentField, department);
        clickOnSubmitButton();
    }
}
