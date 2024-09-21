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
        loginAsUser(tplNumber, userName,printerName);
        userActivity.downloadLecturas.clickControl();
        Assertions.assertTrue(userActivity.facturasLabel.checkChangeValueLabel(value));
    }
    @Test
    public void checkUploadLecturas(){
        String tplNumber = "20";
        String userName = "user20";
        String printerName = "endelp1";
        loginAsUser(tplNumber, userName, printerName);

    }
    @Test
    public void checkUploadFotografias(){
        String tplNumber = "20";
        String userName = "user20";
        String printerName = "endelp1";
        loginAsUser(tplNumber, userName, printerName);

    }

    // TODO: Desarrollar los siguientes metodos
    // - Descarga de lecturas
    // - Descarga de parametros fijos
    // - Ir a pantalla de gestion de lecturas


}
