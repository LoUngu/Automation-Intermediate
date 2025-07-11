package SharedData.Browser.Service;

import Config.ConfigNode.DriverConfigNode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class EdgeBrowserService implements BrowserService{

    private WebDriver driver;

    @Override
    public void openBrowser(DriverConfigNode driverConfigNode) {
        EdgeOptions options = (EdgeOptions) getBrowserOptions(driverConfigNode);
        driver = new EdgeDriver(options);
        driver.get(driverConfigNode.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Override
    public Object getBrowserOptions(DriverConfigNode driverConfigNode) {
        EdgeOptions options = new EdgeOptions();

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
