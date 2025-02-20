package activities;

import controls.AlertDialog;
import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;
import controls.OverflowMenu;

public class AdminActivity {
    public Button registeruRLButton = new Button(By.id("com.solunes.endeapp:id/btn_save_domain"));
    public TextBox printerEditText = new TextBox(By.id("com.solunes.endeapp:id/edit_print_name"));
    public TextBox tplEditText = new TextBox(By.id("com.solunes.endeapp:id/edit_nro_tpl"));
    public Button registerPrintButton = new Button(By.id("com.solunes.endeapp:id/btn_print_name"));
    public Button registerTplButton = new Button(By.id("com.solunes.endeapp:id/btn_nro_tpl"));
    public AlertDialog alertDialogConfirmTpl = new AlertDialog(By.id("com.solunes.endeapp:id/parentPanel"));
    public Button downloadFixedParametersButton = new Button(By.id("com.solunes.endeapp:id/btn_fix_params"));
    public AlertDialog alertDialogConfirmFixedParameters = new AlertDialog(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.solunes.endeapp:id/parentPanel\"]"));
    public OverflowMenu overFlowMenu = new OverflowMenu(By.xpath("//android.widget.ImageView[@content-desc=\"Más opciones\"]"));

    public boolean isAlertDisplayed() {
        return alertDialogConfirmTpl.waitForAlertDialogVisibility();
    }

    public boolean isAdminActivityDisplayed() {
        Label appBarTitle = new Label(By.xpath("//android.widget.TextView[@text=\"Administrador\"]"));
        return appBarTitle.waitForVisibility();
    }

    public boolean isPrinterRegistered(String expectedResult) {
        Label labelPrintName = new Label(By.id("com.solunes.endeapp:id/label_print_name"));
        if (labelPrintName.waitForVisibility()) {
            String resultado = labelPrintName.getTextControl();
            System.out.println("EL RESULTADO ES: " + resultado);
            return labelPrintName.getTextControl().equals(expectedResult);
        } else {
            System.out.println("NO SE ENCONTRO");
            return false;
        }
    }

    public boolean isTplRegistered(String expectedResult) {
        Label labelPrintName = new Label(By.id("com.solunes.endeapp:id/label_nro_tpl"));
        if (labelPrintName.waitForVisibility()) {
            String resultado = labelPrintName.getTextControl();
            System.out.println("LO ESPERADO ES: " + expectedResult);
            System.out.println("LO OBTENIDO ES: " + resultado);
            return labelPrintName.getTextControl().equals(expectedResult);
        } else {
            System.out.println("NO SE ENCONTRO");
            return false;
        }
    }


    public void confirmTlp(String aceptar) {
        alertDialogConfirmTpl.waitForAlertDialogVisibility();
        alertDialogConfirmTpl.clickAlertDialogButton(aceptar);
    }

    public boolean isConfirmFixedParameters() {
        if(alertDialogConfirmFixedParameters.waitForAlertDialogVisibility()){
            System.out.println("SE DESPLEGO EL ALERT DIALOG DE PARAMETROS FIJOS");
            return true;
        }else{
            System.out.println("NO SE DESPLEGO EL ALERT DIALOG");

            return false;
        }
    }
}
