package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class AlertDialog extends Control{

    public AlertDialog(By locator) {
        super(locator);
    }
    public boolean waitForAlertDialogVisibility() {
        try {
            WebDriverWait wait = new WebDriverWait(Session.getInstance().getDevice(), Duration.ofSeconds(10), Duration.ofMillis(100));
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator()));
            return true;
        } catch (Exception e) {
            return false; // Si el AlertDialog no aparece o hay algún error
        }
    }
    public String getAlertDialogMessage() {
        try {
            this.findControl(); // Asegurarse de que el control esté localizado
            return control.getText(); // Obtener el texto del mensaje del AlertDialog
        } catch (Exception e) {
            return null; // Si no se puede obtener el mensaje
        }
    }
    public void clickAlertDialogButton(String buttonText) {
        try {
            // Busca el botón del AlertDialog por su texto
            By buttonLocator = By.xpath("//android.widget.Button[@text='" + buttonText + "']");
            WebElement button = Session.getInstance().getDevice().findElement(buttonLocator);
            button.click();
        } catch (Exception e) {
            System.out.println("Error al hacer clic en el botón: " + buttonText);
        }
    }

    public boolean isAlertDialogMessageDisplayed(String expectedMessage) {
        if (waitForAlertDialogVisibility()) {
            String actualMessage = getAlertDialogMessage();
            if (actualMessage != null) {
                System.out.println("(1 - expected): " + expectedMessage);
                System.out.println("(2 - actual): " + actualMessage);
                return actualMessage.contains(expectedMessage);
            }
        }
        return false;
    }

}
