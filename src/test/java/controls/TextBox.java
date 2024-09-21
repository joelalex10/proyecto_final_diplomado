package controls;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import singletonSession.Session;

public class TextBox extends Control{
    public TextBox(By locator){
        super(locator);
    }
    public void setText(String value){
        this.findControl();
        this.control.sendKeys(value);
    }
    public void setTextAndSubmit(String value) {
        this.findControl();
        this.control.sendKeys(value);
        AndroidDriver driver = (AndroidDriver) Session.getInstance().getDevice();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }
    public void clearSetText(String value){
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value);
    }
}
