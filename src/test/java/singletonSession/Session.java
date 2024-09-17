package singletonSession;

import factoryDevices.FactoryDevice;
import io.appium.java_client.AppiumDriver;
import util.GetProperties;

public class Session {
    private static Session instance = null;
    private AppiumDriver device;
    private Session() {
        device = FactoryDevice.make(GetProperties.getInstance().getDevice()).createAppiumDriver();
    }
    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }
    public void closeSession(){
        device.quit();
        instance = null;
    }
    public AppiumDriver getDevice() {
        return device;
    }
}
