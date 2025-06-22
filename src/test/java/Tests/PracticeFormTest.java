package Tests;

import HelperMethods.AssertMethods;
import SharedData.BaseTest;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends BaseTest {

    public HomePage homePage;
    public CommonPage commonPage;
    public AssertMethods assertMethods;
    public PracticeFormPage practiceFormPage;

    @Test
    public void fillInTheForm() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        assertMethods = new AssertMethods(getDriver());
        practiceFormPage = new PracticeFormPage(getDriver());

        homePage.goToDesiredMenuValue("Forms");
        commonPage.goToDesiredElement("Practice Form");

        practiceFormPage.fillInStudentRegistrationForm("Ion", "Popescu", "ion.popescu@email.com", "Str. Strada, Nr. 1", "0720000000");

        practiceFormPage.selectGender("Male");

//        practiceFormPage.fillInSubjectField("Maths");
        List<String> subjectValues = Arrays.asList("Maths", "English");
        practiceFormPage.completeSubjectFiledWithList(subjectValues);

        List<String> hobbieslist = Arrays.asList("Sports", "reading");
        practiceFormPage.selectHobbies(hobbieslist);

        practiceFormPage.uploadPicture();

        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");

        practiceFormPage.clickOnSubmit();

        assertMethods.verifyExpectedValueEqualsActualValue(practiceFormPage.getTableRowText(0), "Label Values");
        assertMethods.verifyExpectedValueEqualsActualValue(practiceFormPage.getTableRowText(1), "Student Name Ion Popescu");
        assertMethods.verifyExpectedValueEqualsActualValue(practiceFormPage.getTableRowText(2), "Student Email ion.popescu@email.com");
    }
}
