package controls;

import controls.Control;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class OverflowMenu extends Control {
    public OverflowMenu(By locator) {
        super(locator);
    }
    public boolean waitForMenuOptionsToAppear() {
        try {
            WebDriverWait wait = new WebDriverWait(Session.getInstance().getDevice(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void selectOptionByText(String optionText) {
        // Busca la opción del menú por texto (usamos un XPath para localizar la opción)
        By optionLocator = By.xpath("//android.widget.TextView[@text='" + optionText + "']");
        WebElement option = Session.getInstance().getDevice().findElement(optionLocator);
        option.click();
    }
}
