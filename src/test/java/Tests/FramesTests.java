package Tests;

import HelperMethods.AssertMethods;
import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JSHelper;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.FramesPage;
import pages.HomePage;

public class FramesTests extends BaseTest{

    public ElementsMethods elementsMethods;
    public FramesMethods framesMethods;
    public JSHelper jsHelper;
    public HomePage homePage;
    public CommonPage commonPage;
    public FramesPage framesPage;
    public AssertMethods assertMethods;

    @Test
    public void framesTests() {

        elementsMethods = new ElementsMethods(driver);
        framesMethods = new FramesMethods(driver);
        jsHelper = new JSHelper(driver);
        homePage = new HomePage(driver);
        commonPage = new CommonPage(driver);
        framesPage = new FramesPage(driver);
        assertMethods = new AssertMethods(driver);

        homePage.goToDesiredMenuValue("Alerts, Frame & Windows");
        commonPage.goToDesiredElement("Frames");

        framesPage.switchToFirstFrameElement();
        assertMethods.verifyExpectedValueEqualsActualValue(framesPage.getTextFromHeading(), "This is a sample page");

        framesMethods.switchToDefaultWindow();

        framesPage.switchToSecondFrameElementAndScroll();
        assertMethods.verifyExpectedValueEqualsActualValue(framesPage.getTextFromHeading(), "This is a sample page");
    }
}
