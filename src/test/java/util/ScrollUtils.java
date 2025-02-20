package util;

import controls.Control;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class ScrollUtils {
    private final AppiumDriver driver;

    public ScrollUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public void scrollToControl(Control control) {
        try {
            control.findControl(); // Encuentra el control antes de interactuar con él
            RemoteWebElement remoteElement = (RemoteWebElement) control.control;

            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, Object> scrollParams = new HashMap<>();
            scrollParams.put("element", remoteElement.getId());
            scrollParams.put("direction", "down");

            if (driver instanceof AndroidDriver) {
                scrollParams.put("strategy", "accessibility id"); // Opcional para Android
            } else if (driver instanceof IOSDriver) {
                scrollParams.put("toVisible", true); // iOS usa `toVisible`
            }

            js.executeScript("arguments[0].scrollIntoView(true);", control);
            System.out.println("✅ Scroll realizado con éxito al elemento: " + control.getLocator());

        } catch (Exception e) {
            System.err.println("❌ Error al hacer scroll al control: " + control.getLocator());
            e.printStackTrace();
        }
    }
}