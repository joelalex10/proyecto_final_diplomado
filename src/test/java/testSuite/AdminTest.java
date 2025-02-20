package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdminTest extends TestBase{
    @Test
    public void checkRegisterPrinterName(){

        String printerName = "endelp1";

        loginAsAdmin("admin","4dm1n.123");

        adminActivity.printerEditText.setText(printerName);
        adminActivity.registerPrintButton.clickControl();
        Assertions.assertTrue(adminActivity.isPrinterRegistered("Impresora: "+printerName));
    }

    @Test
    public void checkRegisterTpl(){

        String tplName = "20";

        loginAsAdmin("admin","4dm1n.123");

        adminActivity.tplEditText.setText(tplName);
        adminActivity.registerTplButton.clickControl();
        adminActivity.confirmTlp("ACEPTAR");

        Assertions.assertTrue(adminActivity.isTplRegistered("Nro Tpl: "+tplName));
    }
    @Test
    public void checkDownloadFixedParameters(){
        loginAsAdmin("admin","4dm1n.123");
        adminActivity.downloadFixedParametersButton.clickControl();
        //adminActivity
        Assertions.assertTrue(adminActivity.isConfirmFixedParameters());
    }
}
