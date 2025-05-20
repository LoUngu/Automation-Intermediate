package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends CommonPage{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "userEmail")
    private WebElement userEmailField;

    @FindBy(xpath = "//label[starts-with(@for, 'gender-radio-')]")
    private List<WebElement> genderRadioButtons;

    @FindBy(css = "input[placeholder='Mobile Number']")
    private WebElement phoneField;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    private WebElement subjectField;

    @FindBy(id = "subjectsInput")
    private WebElement subjectFieldById;


    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement sportHobbyCheckbox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    private WebElement readingHobbyCheckbox;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    private WebElement musicHobbyCheckbox;

    @FindBy(id = "uploadPicture")
    private WebElement chooseFileButton;

    @FindBy(id = "currentAddress")
    private WebElement addressField;

    @FindBy(id = "react-select-3-input")
    private WebElement stateDropdown;

    @FindBy(id = "react-select-4-input")
    private WebElement cityDropdown;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//tr")
    private List<WebElement> table2Rows;


    public String getTableRowText(Integer index){
        elementsMethods.explicitlyWaitElementVisibility(table2Rows.get(index));
        return table2Rows.get(index).getText();
    }

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

