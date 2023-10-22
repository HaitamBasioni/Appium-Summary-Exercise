package infra;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManger {
    protected static AndroidDriver<MobileElement> driver;
    public static AndroidDriver<MobileElement> getDriver(String url, DesiredCapabilities capabilities) throws MalformedURLException {
        if (driver == null)
            return new AndroidDriver<MobileElement>( new URL(url), capabilities);
        else  return driver;

    }
    public static void quitDriver(){
        if (driver!=null)
            driver.quit();
    }

}
