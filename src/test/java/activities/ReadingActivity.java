package activities;

import controls.*;
import org.openqa.selenium.By;

public class ReadingActivity {
    public TextBox lecturaEditText = new TextBox(By.xpath("//android.widget.EditText[@resource-id=\"com.solunes.endeapp:id/input_reading\"]"));
    public Button confirmarButton = new Button(By.xpath("//android.widget.Button[@resource-id=\"com.solunes.endeapp:id/button_confirm\"]"));
    public Button observacionesButton = new Button(By.xpath("//android.widget.Button[@resource-id=\"com.solunes.endeapp:id/button_obs\"]"));
    public TabBarControl tabBarControl = new TabBarControl(By.xpath("//android.widget.HorizontalScrollView[@resource-id=\"com.solunes.endeapp:id/sliding_tabs\"]/android.widget.LinearLayout"));
    public Button buscadorButton = new Button(By.id("com.solunes.endeapp:id/action_search"));
    public TextBox buscadorTextBox = new TextBox(By.xpath("//android.widget.EditText[@resource-id=\"com.solunes.endeapp:id/search_src_text\"]"));
    public AlertDialog observacionesAlertDilaog = new AlertDialog(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.solunes.endeapp:id/parentPanel\"]"));

    public void defineObservacion(String observacion){
        if(observacionesAlertDilaog.waitForAlertDialogVisibility()){
            Button selectedObs=new Button(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text="+observacion+"]"));
            selectedObs.clickControl();
        }else{
            System.out.println("No se desplego el alertDialog de observaciones");
        }
    }
    public boolean checkNroConsumidor(String expectedResult) {
        Label consumidorLabel = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.solunes.endeapp:id/data_client\"]"));
        if(consumidorLabel.waitForVisibility()){
            String resultado = consumidorLabel.getTextControl();
            System.out.println("El resultado es: " + resultado);
            return consumidorLabel.getTextControl().contains(expectedResult);
        }else{
            return false;
        }

    }
}
