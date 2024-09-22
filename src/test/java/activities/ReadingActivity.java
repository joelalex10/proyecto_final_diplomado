package activities;

import controls.*;
import org.openqa.selenium.By;

public class ReadingActivity {
    public TextBox lecturaEditText = new TextBox(By.xpath("//android.widget.EditText[@resource-id=\"com.solunes.endeapp:id/input_reading\"]"));
    public Button confirmarButton = new Button(By.xpath("//android.widget.Button[@resource-id=\"com.solunes.endeapp:id/button_confirm\"]"));
    public Button observacionesButton = new Button(By.xpath("//android.widget.Button[@resource-id=\"com.solunes.endeapp:id/button_obs\"]"));
    public Button obervacionesImpedimentoButton = new Button(By.id("com.solunes.endeapp:id/button_obs_imped"));
    public TabBarControl tabBarControl = new TabBarControl(By.xpath("//android.widget.HorizontalScrollView[@resource-id=\"com.solunes.endeapp:id/sliding_tabs\"]/android.widget.LinearLayout"));
    public Button buscadorButton = new Button(By.id("com.solunes.endeapp:id/action_search"));
    public TextBox buscadorTextBox = new TextBox(By.xpath("//android.widget.EditText[@resource-id=\"com.solunes.endeapp:id/search_src_text\"]"));
    public AlertDialog observacionesAlertDilaog = new AlertDialog(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.solunes.endeapp:id/parentPanel\"]"));
    public AlertDialog consumoElevadoAlertDilaog = new AlertDialog(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.solunes.endeapp:id/parentPanel\"]"));
    public AlertDialog consumoElevadoPostAlertDilaog = new AlertDialog(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.solunes.endeapp:id/contentPanel\"]"));
    public AlertDialog observacionesImpedimentoAlertDilaog = new AlertDialog(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.solunes.endeapp:id/parentPanel\"]"));
    public Button haciaAtras = new Button(By.xpath("//android.widget.ImageButton[@content-desc=\"Navegar hacia arriba\"]"));
    public Button tomarFotografia = new Button(By.xpath("//android.widget.ImageButton[@resource-id=\"com.solunes.endeapp:id/button_camera\"]"));

    //android.widget.TextView[@resource-id="com.solunes.endeapp:id/item_title" and @text="MEDIDOR CON INSECTOS"]
    //android.widget.TextView[@resource-id="com.solunes.endeapp:id/item_title" and @text="CAJA DE MEDIDOR ENERGIZADO"]
    //android.widget.TextView[@resource-id="com.solunes.endeapp:id/item_title" and @text="MEDIDOR SUCIO"]
    //android.widget.TextView[@resource-id="com.solunes.endeapp:id/item_title" and @text="CAJA DE MEDIDOR ENERGIZADO"]

    public boolean isObservacionDisplayed(String nameObservations){
        Label obsLabel = new Label(By.xpath("//android.widget.TextView[@text='"+nameObservations+"']"));
        return obsLabel.isControlDisplayed();
    }
    //Button selectedObs=new Button(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"3 - MEDIDOR SUCIO\"]"));

    public void defineObservacion(String observacion){
        if(observacionesAlertDilaog.waitForAlertDialogVisibility()){

            Button selectedObs = new Button(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and contains(@text,'" + observacion + "')]"));
            selectedObs.clickControl();
            Button aceptar = new Button(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
            aceptar.clickControl();
        }else{
            System.out.println("No se desplego el alertDialog de observaciones");
        }
    }
    public void defineObservacionImpedimento(String observacion){
        if(observacionesImpedimentoAlertDilaog.waitForAlertDialogVisibility()){
            //android.widget.TextView[@resource-id="com.solunes.endeapp:id/item_title" and @text="CASA DESHABITADA"]
            //android.widget.TextView[@resource-id="com.solunes.endeapp:id/item_title" and @text="CASA CERRADA"]
            Button selectedObs = new Button(By.xpath("//android.widget.TextView[@resource-id=\"com.solunes.endeapp:id/item_title\" and @text=\"" + observacion + "\"]"));
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

    public void confimarConsumoElevado() {
        consumoElevadoAlertDilaog.waitForAlertDialogVisibility();
        consumoElevadoAlertDilaog.clickAlertDialogButton("ACEPTAR");
    }
    public void confimarPostConsumoElevado() {
        consumoElevadoAlertDilaog.waitForAlertDialogVisibility();
        consumoElevadoAlertDilaog.clickAlertDialogButton("ACEPTAR");
    }
}
