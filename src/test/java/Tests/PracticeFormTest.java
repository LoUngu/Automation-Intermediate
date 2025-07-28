package Tests;

import HelperMethods.AssertMethods;
import ObjectData.PracticeFormObject;
import PropertyUtility.PropertyUtility;
import SharedData.BaseTest;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTest extends BaseTest {

    public HomePage homePage;
    public CommonPage commonPage;
    public AssertMethods assertMethods;
    public PracticeFormPage practiceFormPage;

    @Test
    public void fillInTheForm() {

        PropertyUtility propertyUtility = new PropertyUtility("PracticeFormTest");
        PracticeFormObject practiceFormObject = new PracticeFormObject(propertyUtility.getAllData());

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        assertMethods = new AssertMethods(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenuValue("Forms");
        commonPage.goToDesiredElement("Practice Form");

        practiceFormPage.fillInStudentRegistrationForm(practiceFormObject);

        practiceFormPage.selectGender(practiceFormObject);

        practiceFormPage.completeSubjectFiledWithList(practiceFormObject);

        practiceFormPage.selectHobbies(practiceFormObject);

        practiceFormPage.uploadPicture();

        practiceFormPage.selectState(practiceFormObject);
        practiceFormPage.selectCity(practiceFormObject);

        practiceFormPage.clickOnSubmit();

        assertMethods.verifyExpectedValueEqualsActualValue(practiceFormPage.getTableRowText(0), "Label Values");
        assertMethods.verifyExpectedValueEqualsActualValue(practiceFormPage.getTableRowText(1), "Student Name Ion Popescu");
        assertMethods.verifyExpectedValueEqualsActualValue(practiceFormPage.getTableRowText(2), "Student Email ion.popescu@email.com");
    }
}
