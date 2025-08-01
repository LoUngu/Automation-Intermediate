package SharedData.Browser.Service;

import Config.ConfigNode.DriverConfigNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeBrowserService implements BrowserService{

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfigNode driverConfigNode) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(driverConfigNode);
        System.setProperty("webdriver.chrome.driver", "C:\\users\\loungureanu\\.cache\\selenium\\chromedriver\\win64\\137.0.7151.119\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get(driverConfigNode.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Override
    public Object getBrowserOptions(DriverConfigNode driverConfigNode) {
        ChromeOptions options = new ChromeOptions();

        if (!driverConfigNode.headless.isEmpty()){
            options.addArguments(driverConfigNode.headless);
        }
        options.addArguments(driverConfigNode.resolution);
        options.addArguments(driverConfigNode.gpu);
        options.addArguments(driverConfigNode.extensions);
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
