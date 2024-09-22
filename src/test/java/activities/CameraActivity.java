package activities;

import controls.Button;
import org.openqa.selenium.By;

public class CameraActivity {
    public Button tomarFotografia = new Button(By.xpath("//android.widget.ImageView[@resource-id=\"com.transsion.camera:id/shutter_button\"]"));
    public Button confirmarFotografia = new Button(By.xpath("//android.widget.ImageView[@resource-id=\"com.transsion.camera:id/done_button\"]"));

}
