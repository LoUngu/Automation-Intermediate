package SharedData.Browser;

import Config.ConfigFile;
import Config.ConfigNode.ConfigNode;
import SharedData.Browser.Service.ChromeBrowserService;
import SharedData.Browser.Service.EdgeBrowserService;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class BrowserFactory {

    public WebDriver getBrowserFactory(){

        String ciCd = System.getProperty("ciCd");
        String browser = System.getProperty("browser").toLowerCase(Locale.ROOT);

        ConfigNode configNode = ConfigFile.createConfigNode(ConfigNode.class);

        if (Boolean.parseBoolean(ciCd)){
            configNode.driverConfigNode.headless = "--headless";
        }
        else {
            browser = configNode.driverConfigNode.localBrowser;
        }

        switch (browser){
            case BrowserType.BROWSER_CHROME:
                ChromeBrowserService chromeBrowserService = new ChromeBrowserService();
                chromeBrowserService.openBrowser(configNode.driverConfigNode);
                return chromeBrowserService.getDriver();
            case BrowserType.BROWSER_EDGE:
                EdgeBrowserService edgeBrowserService = new EdgeBrowserService();
                edgeBrowserService.openBrowser(configNode.driverConfigNode);
                return edgeBrowserService.getDriver();
        }

        return null;
    }
}
