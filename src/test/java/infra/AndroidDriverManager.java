package infra;

import io.appium.java_client.android.AndroidDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidDriverManager {
    public static AndroidDriver createAndroidDriver() {
        JSONObject appiumConfig = AppConfigReader.readAppiumConfig();

        if (appiumConfig != null) {
            try {
                // Extract desired capabilities and Appium server URL from the JSON.
                JSONObject desiredCapabilities = appiumConfig.getJSONObject("desiredCapabilities");
                String appiumServerURL = appiumConfig.getString("appiumServerURL");

                // Create a DesiredCapabilities instance and set capabilities from JSON.
                DesiredCapabilities caps = new DesiredCapabilities();
                for (String key : desiredCapabilities.keySet()) {
                    caps.setCapability(key, desiredCapabilities.get(key));
                }

                // Initialize and return an AndroidDriver instance.
                return new AndroidDriver(new URL(appiumServerURL), caps);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exceptions here if needed.
            }
        }
        return null;
    }
    public static void quitDriver(AndroidDriver driver){
        if (driver!=null)
            driver.quit();
    }

}
