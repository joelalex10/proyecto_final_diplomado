package testSuite;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class RegistroLecturasTest extends TestBase {
    @Test
    public void checkRegisterLecturaNormal(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        loginAsUser(tplNumber, userName, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.lecturaEditText.setText("13000");
        readingActivity.confirmarButton.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed("LECTURA NORMAL"));
    }
    @Test
    public void checkBuscadorLecturas(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "505648";
        loginAsUser(tplNumber, userName, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.checkNroConsumidor(nroConsumidor));
    }
    @Test
    public void checkRegisterLecturaConsumoElevado(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "285979";
        int registroLectura = 99000;

        loginAsUser(tplNumber, userName, printerName);

        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.lecturaEditText.setText(String.valueOf(registroLectura));
        readingActivity.confirmarButton.clickControl();
        readingActivity.confimarConsumoElevado();
        cameraActivity.tomarFotografia.clickControl();
        cameraActivity.confirmarFotografia.clickControl();
        readingActivity.confimarPostConsumoElevado();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed("CONSUMO ELEVADO"));

    }
    @Test
    public void checkRegisterLecturaCalculoFueraDeRango(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "478864";
        int registroLectura = 9;

        loginAsUser(tplNumber, userName, printerName);

        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.lecturaEditText.setText(String.valueOf(registroLectura));
        readingActivity.confirmarButton.clickControl();
        readingActivity.confimarConsumoElevado();
        cameraActivity.tomarFotografia.clickControl();
        cameraActivity.confirmarFotografia.clickControl();
        readingActivity.confimarPostConsumoElevado();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed("CALCULO FUERA DE RANGO"));
    }
    @Test
    public void checkAddObservaciones(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String observacion = "CAJA DE MEDIDOR ENERGIZADO";
        loginAsUser(tplNumber, userName, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.observacionesButton.clickControl();
        readingActivity.defineObservacion(observacion);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed(observacion));
    }
    @Test
    public void checkAddObservacionesImpedimento(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String observacion = "CASA DESHABITADA";
        loginAsUser(tplNumber, userName, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.obervacionesImpedimentoButton.clickControl();
        readingActivity.defineObservacionImpedimento(observacion);
        readingActivity.tabBarControl.selectTabByIndex(2);
        Assertions.assertTrue(readingActivity.isObservacionDisplayed(observacion));
    }

}
