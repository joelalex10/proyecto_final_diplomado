package activities;

import controls.Button;
import controls.Label;
import controls.TextBox;
import controls.Toast;
import factoryDevices.Android;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

public class LoginActivity {
    public TextBox nameEditText = new TextBox(By.id("com.solunes.endeapp:id/edit_user"));
    public TextBox passwordEditText = new TextBox(By.id("com.solunes.endeapp:id/edit_pass"));
    public Button saveButton = new Button(By.id("com.solunes.endeapp:id/btn_signup"));
    public Label versionNameLabel = new Label(By.id("com.solunes.endeapp:id/label_version_name"));


    public boolean isToastDisplayed() {
        String expectedMessage = "Usuario o contraseña incorrectos";
        Toast toast = new Toast(By.xpath("//android.widget.Toast"));
        if (toast.waitForToastVisibility()){
            return toast.isToastDisplayed(expectedMessage);
        }else{
            return false;
        }
    }



}
