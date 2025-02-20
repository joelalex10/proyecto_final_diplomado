package activities;

import controls.Button;
import controls.Label;
import controls.SnackbarControl;
import controls.Toast;
import org.openqa.selenium.By;

public class UserActivity {
    public Button downloadLecturas = new Button(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.LinearLayout"));
    public Button sendLecturas = new Button(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.solunes.endeapp:id/layout_send_reading\"]"));

    public Button sendFotografias = new Button(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.solunes.endeapp:id/layout_send_reading_pictures\"]"));
    public Label facturasLabel = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.solunes.endeapp:id/state_performed\"]"));
    public Label countPhotos = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.solunes.endeapp:id/text_count_photos\"]"));
    public Label dateUploadLecturas = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.solunes.endeapp:id/text_date_send\"]"));


    public Button empezarLecturas = new Button(By.xpath("//android.widget.Button[@text=\"EMPEZAR\"]"));


    public boolean isUserActivityDisplayed() {
        Label appBarTitle = new Label(By.xpath("//android.widget.TextView[@text=\"Lefimovil EDO\"]"));
        return appBarTitle.waitForVisibility();
    }


    public boolean isSnackbarDisplayed() {
        String expectedMessage = "Datos enviados";
        SnackbarControl snackbar = new SnackbarControl(By.xpath("//com.google.android.material.snackbar.SnackbarContentLayout[@id='snackbar_text']"));

        if (snackbar.waitForSnackbarVisibility()) {
            return snackbar.isSnackbarDisplayed(expectedMessage);
        } else {
            return false;
        }
    }

}
