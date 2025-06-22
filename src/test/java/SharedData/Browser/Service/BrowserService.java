package SharedData.Browser.Service;

import Config.ConfigNode.DriverConfigNode;

public interface BrowserService {

    void openBrowser(DriverConfigNode driverConfigNode);
    Object getBrowserOptions(DriverConfigNode driverConfigNode);
}
