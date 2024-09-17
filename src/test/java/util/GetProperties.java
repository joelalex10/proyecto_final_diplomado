package util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static GetProperties getInstance = null;
    private String device;

    public GetProperties() {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream input = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (input != null) {
            try {
                prop.load(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            device = prop.getProperty("device");
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetProperties getInstance(){
        if (getInstance == null)
            getInstance = new GetProperties();
        return getInstance;
    }
    public String getDevice() {
        return device;
    }
}
