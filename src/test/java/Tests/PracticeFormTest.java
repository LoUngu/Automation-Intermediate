package Tests;

import HelperMethods.AssertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends BaseTest {

    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;
    public HomePage homePage;
    public CommonPage commonPage;
    public AssertMethods assertMethods;
    public PracticeFormPage practiceFormPage;

    @Test
    public void fillInTheForm() {

        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        assertMethods = new AssertMethods(driver);
        practiceFormPage = new PracticeFormPage(driver);

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

        List<WebElement> table2 = driver.findElements(By.xpath("//tr"));

        elementsMethods.explicitlyWaitElementVisibility(table2.get(0));
        assertMethods.verifyExpectedValueEqualsActualValue(table2.get(0).getText(), "Label Values");
        assertMethods.verifyExpectedValueEqualsActualValue(table2.get(1).getText(), "Student Name Ion Popescu");
        assertMethods.verifyExpectedValueEqualsActualValue(table2.get(2).getText(), "Student Email ion.popescu@email.com");


    }
}
