package activities;

import controls.Label;
import org.openqa.selenium.By;

public class UserActivity {
    public boolean isUserActivityDisplayed() {
        Label appBarTitle = new Label(By.xpath("//android.widget.TextView[@text=\"Lefimovil LP\"]"));
        return appBarTitle.waitForVisibility();
    }
}
