package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

    WebDriver driver;
    public ElementsMethods elementsMethods;
    public JSHelper jsHelper;
    public FramesMethods framesMethods;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        framesMethods = new FramesMethods(driver);
        elementsMethods = new ElementsMethods(driver);
        jsHelper = new JSHelper(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frame1")
    WebElement firstFrameElement;

    @FindBy(id = "frame2")
    WebElement secondFrameElement;

    @FindBy(id = "sampleHeading")
    WebElement frameSampleHeadingElement;

    public String getTextFromHeading(){
        return elementsMethods.retrieveElementText(frameSampleHeadingElement);
    }

    public void printHeadingText(){
        elementsMethods.printText(frameSampleHeadingElement);
    }

    public void switchToFirstFrameElement(){
        framesMethods.switchToFrame(firstFrameElement);
    }

    public void switchToSecondFrameElementAndScroll(){
        framesMethods.switchToFrame(secondFrameElement);
        jsHelper.scrollOnPage(200, 200);
    }
}
