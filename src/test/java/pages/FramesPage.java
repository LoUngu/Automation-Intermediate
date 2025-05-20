package pages;

import HelperMethods.ElementsMethods;
import HelperMethods.FramesMethods;
import HelperMethods.JSHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends CommonPage{

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    private WebElement firstFrameElement;

    @FindBy(id = "frame2")
    private WebElement secondFrameElement;

    @FindBy(id = "sampleHeading")
    private WebElement frameSampleHeadingElement;

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

    public void switchToDefaultWindow(){
        framesMethods.switchToDefaultWindow();
    }

}
