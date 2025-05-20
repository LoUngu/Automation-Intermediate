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

    public HomePage homePage;
    public CommonPage commonPage;
    public FramesPage framesPage;
    public AssertMethods assertMethods;

    @Test
    public void framesTests() {

        homePage = new HomePage(getDriver());
        commonPage = new CommonPage(getDriver());
        framesPage = new FramesPage(getDriver());
        assertMethods = new AssertMethods(getDriver());

        homePage.goToDesiredMenuValue("Alerts, Frame & Windows");
        commonPage.goToDesiredElement("Frames");

        framesPage.switchToFirstFrameElement();
        assertMethods.verifyExpectedValueEqualsActualValue(framesPage.getTextFromHeading(), "This is a sample page");

        framesPage.switchToDefaultWindow();

        framesPage.switchToSecondFrameElementAndScroll();
        assertMethods.verifyExpectedValueEqualsActualValue(framesPage.getTextFromHeading(), "This is a sample page");
    }
}
