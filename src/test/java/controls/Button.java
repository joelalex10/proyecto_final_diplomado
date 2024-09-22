package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Button extends Control{
    public Button(By locator){
        super(locator);
    }
    public boolean waitForVisibility() {
        try {
            WebDriverWait wait = new WebDriverWait(Session.getInstance().getDevice(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
