package Config.ConfigNode;

import javax.xml.bind.annotation.XmlElement;

public class DatabaseConfigNode {

    @XmlElement(name = "Port")
    public String port;

    @XmlElement(name = "DatabaseName")
    public String dbName;

    @XmlElement(name = "Username")
    public String username;

    @XmlElement(name = "Password")
    public String password;

}
