package pages;

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
