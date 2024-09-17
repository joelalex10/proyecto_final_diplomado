package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevices{
    @Override
    public AppiumDriver createAppiumDriver() {
        System.out.println("Iniciando la prueba");
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName", "TECNO POVA");
        config.setCapability("appium:platformVersion", "10.0");
        config.setCapability("appium:appPackage", "com.solunes.endeapp");
        config.setCapability("appium:appActivity", "com.solunes.endeapp.activities.LoginActivity");
        config.setCapability("platformName", "Android");
        config.setCapability("appium:automationName", "uiautomator2");
        config.setCapability("appium:unicodeKeyboard", false);
        config.setCapability("appium:resetKeyboard", false);
        config.setCapability("appium:disablePopup", true);
        config.setCapability("appium:hideKeyboard", true);
        config.setCapability("appium:autoGrantPermissions", true);
        AndroidDriver driver = null;
        try{
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), config);
        }catch (MalformedURLException e){
            throw new RuntimeException();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
