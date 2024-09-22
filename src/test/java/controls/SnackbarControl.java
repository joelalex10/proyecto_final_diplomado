package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class SnackbarControl extends Control {
    public SnackbarControl(By locator) {
        super(locator);
    }

    public boolean waitForSnackbarVisibility() {
        try {
            WebDriverWait wait = new WebDriverWait(Session.getInstance().getDevice(), Duration.ofSeconds(10), Duration.ofMillis(100));
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getSnackbarMessage() {
        try {
            this.findControl();
            return control.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isSnackbarDisplayed(String expectedMessage) {
        if (waitForSnackbarVisibility()) {
            String actualMessage = getSnackbarMessage();
            if (actualMessage != null) {
                System.out.println("(1 - expected): " + expectedMessage);
                System.out.println("(2 - actual): " + actualMessage);
                return actualMessage.equals(expectedMessage);
            }
        }
        return false;
    }
}