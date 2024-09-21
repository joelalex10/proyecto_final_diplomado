package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    }
    @Test
    public void checkAddObservaciones(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String observacion = "3 - MEDIDOR SUCIO";
        loginAsUser(tplNumber, userName, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.tabBarControl.selectTabByIndex(2);
        readingActivity.observacionesButton.clickControl();
        readingActivity.defineObservacion(observacion);
    }

    @Test
    public void checkBuscadorLecturas(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";
        String nroConsumidor = "6385";
        loginAsUser(tplNumber, userName, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        Assertions.assertTrue(readingActivity.checkNroConsumidor(nroConsumidor));
    }
    // TODO: Gestion de pantalla de lecturas
    // - Lectura Normal
    // - Consumo elevado
    // - Calculo fuera de rango
    // - Funcionalidad buscador
    // - Lecturas gran demanda
}
