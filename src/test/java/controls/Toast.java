package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Toast extends Control{
    public Toast(By locator) {
        super(locator);
    }
    public boolean waitForToastVisibility() {
        try {
            WebDriverWait wait = new WebDriverWait(Session.getInstance().getDevice(), Duration.ofSeconds(10), Duration.ofMillis(100));
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public String getToastMessage() {
        try {
            this.findControl();
            return control.getText();
        } catch (Exception e) {
            return null;
        }
    }
    public boolean isToastDisplayed(String expectedMessage) {
        if (waitForToastVisibility()) {
            String actualMessage = getToastMessage();
            if (actualMessage != null) {
                System.out.println("(1 - expected): " + expectedMessage);
                System.out.println("(2 - actual): " + actualMessage);
                return actualMessage.equals(expectedMessage);
            }
        }
        return false;
    }

}
