package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest extends TestBase{


    @Test
    public void checkDownloadLecturas(){
        String tplNumber = "20";
        String userName = "user20";
        String value = "0";
        String printerName = "endelp1";

        userActivity.downloadLecturas.clickControl();
        Assertions.assertTrue(userActivity.facturasLabel.checkChangeValueLabel(value));
    }
    @Test
    public void checkUploadLecturas(){
        String tplNumber = "20";
        String userName = "user20";
        String printerName = "endelp1";
        String value = "0";
        String nroConsumidor = "9981";
        String readingValue = "8000";
        String fecha = "22, sep. 2024";
        String userPassword = "1234";
        loginAsUser("admin","4dm1n.123",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.lecturaEditText.setText(readingValue);
        readingActivity.confirmarButton.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.haciaAtras.clickControl();
        userActivity.sendLecturas.clickControl();
        Assertions.assertTrue(userActivity.dateUploadLecturas.checkChangeValueLabel(fecha));
    }
    @Test
    public void checkUploadFotografias(){
        String tplNumber = "20";
        String userName = "user20";
        String printerName = "endelp1";
        String value = "0";
        String nroConsumidor = "826518";
        String valorFotografias = "1/1";
        String userPassword = "1234";
        loginAsUser("admin","4dm1n.123",tplNumber, userName, userPassword, printerName);
        userActivity.downloadLecturas.clickControl();
        userActivity.facturasLabel.checkChangeValueLabel(value);
        userActivity.empezarLecturas.clickControl();
        readingActivity.buscadorButton.clickControl();
        readingActivity.buscadorTextBox.setTextAndSubmit(nroConsumidor);
        readingActivity.tomarFotografia.clickControl();
        cameraActivity.tomarFotografia.clickControl();
        cameraActivity.confirmarFotografia.clickControl();
        readingActivity.haciaAtras.clickControl();
        userActivity.sendFotografias.clickControl();
        Assertions.assertTrue(userActivity.countPhotos.checkChangeValueLabel(valorFotografias));

    }
}
