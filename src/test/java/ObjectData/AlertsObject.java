package ObjectData;

import java.util.HashMap;

public class AlertsObject {

    private String textToSend;

    public AlertsObject(HashMap<String, String> testData) {
        populateData(testData);
    }

    public void populateData(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "textToSend":
                    setTextToSend(testData.get(key));
                    break;
            }
        }
    }

    public String getTextToSend() {
        return textToSend;
    }

    public void setTextToSend(String textToSend) {
        this.textToSend = textToSend;
    }
}
