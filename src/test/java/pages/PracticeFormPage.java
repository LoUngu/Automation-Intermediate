package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class PracticeFormPage {
    WebDriver driver;
    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(xpath = "//label[starts-with(@for, 'gender-radio-')]")
    List<WebElement> genderRadioButtons;

    @FindBy(css = "input[placeholder='Mobile Number']")
    WebElement phoneField;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    WebElement subjectField;

    @FindBy(id = "subjectsInput")
    WebElement subjectFieldById;


    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sportHobbyCheckbox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement readingHobbyCheckbox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement musicHobbyCheckbox;

    @FindBy(id = "uploadPicture")
    WebElement chooseFileButton;

    @FindBy(id = "currentAddress")
    WebElement addressField;

    @FindBy(id = "react-select-3-input")
    WebElement stateDropdown;

    @FindBy(id = "react-select-4-input")
    WebElement cityDropdown;

    @FindBy(id = "submit")
    WebElement submitButton;

    public void fillInStudentRegistrationForm(String firstName, String lastName, String email, String address, String phoneNumber){
        elementsMethods.fillElement(firstNameField, firstName);
        elementsMethods.fillElement(lastNameField, lastName);
        elementsMethods.fillElement(userEmailField, email);
        elementsMethods.fillElement(addressField, address);
        elementsMethods.fillElement(phoneField, phoneNumber);
    }

    public void selectGender(String genderValue){
        elementsMethods.selectElementFromListByText(genderRadioButtons, genderValue);
    }

    public void fillInSubjectField(String subjectText){
        elementsMethods.clickOnElement(subjectField);
        elementsMethods.fillInFieldWithActions(subjectField, subjectText);
    }

    public void completeSubjectFiledWithList(List<String> list){
        elementsMethods.clickOnElement(subjectFieldById);
        elementsMethods.fillMultipleValues(subjectFieldById, list);
    }

    public void selectHobbies(List<String> hobbiesList){
        List<WebElement> hobbieElements = Arrays.asList(sportHobbyCheckbox, readingHobbyCheckbox, musicHobbyCheckbox);
        elementsMethods.clickMultipleElements(hobbieElements, hobbiesList);
    }

    public void clickOnSubmit(){
        jsHelper.clickOnElementWithJS(submitButton);
    }

    public void uploadPicture(){
        elementsMethods.uploadPicture(chooseFileButton);

    }

    public void selectState(String stateValue){
        elementsMethods.selectGivenDropdownValue(stateDropdown, stateValue);
    }

    public void selectCity(String cityValue){
        elementsMethods.selectGivenDropdownValue(cityDropdown, cityValue);
    }
}

