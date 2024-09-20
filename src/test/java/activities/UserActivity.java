package activities;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class UserActivity {
    public Button downloadLecturas = new Button(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]"));
    public Button sendLecturas = new Button(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.solunes.endeapp:id/layout_send_reading\"]"));
    public Button sendFotografias = new Button(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.solunes.endeapp:id/layout_send_reading_pictures\"]"));
    public Label facturasLabel = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.solunes.endeapp:id/state_performed\"]"));

    public boolean isUserActivityDisplayed() {
        Label appBarTitle = new Label(By.xpath("//android.widget.TextView[@text=\"Lefimovil LP\"]"));
        return appBarTitle.waitForVisibility();
    }

}
