package Config.ConfigNode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DriverConfigNode {

    @XmlElement(name = "LocalBrowser")
    public String localBrowser;

    @XmlElement(name = "Url")
    public String url;

    @XmlElement(name = "Headless")
    public String headless;

    @XmlElement(name = "Resolution")
    public String resolution;

    @XmlElement(name = "Gpu")
    public String gpu;

    @XmlElement(name = "Extensions")
    public String extensions;
}
