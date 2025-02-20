package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase{
    @Test
    public void checkLoginAsAdminValidCredentials(){

        String username = "admin.prueba";
        String password = "ZXCVB";

        loginActivity.versionNameLabel.clickControl();
        loginActivity.versionNameLabel.clickControl();
        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(adminActivity.isAdminActivityDisplayed());
    }
    @Test
    public void checkLoginAsAdminInvaliCredentials(){

        String username = "admin";
        String password = "1234";

        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(loginActivity.isToastDisplayed());
    }
    @Test
    public void checkLoginAsUserValidCredentials(){
        String username = "user250";
        String password = "1234";

        String tplName = "250";

        loginAsAdmin("admin","1234");
        adminActivity.tplEditText.setText(tplName);
        adminActivity.registerTplButton.clickControl();
        adminActivity.confirmTlp("ACEPTAR");
        adminActivity.overFlowMenu.clickControl();
        adminActivity.overFlowMenu.selectOptionByText("Salir");
        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(userActivity.isUserActivityDisplayed());
    }

    @Test
    public void checkLoginAsUserInvalidCredentials(){
        String username = "user201";
        String password = "1234";

        String tplName = "20";

        loginAsAdmin("admin","4dm1n.123");
        adminActivity.tplEditText.setText(tplName);
        adminActivity.registerTplButton.clickControl();
        adminActivity.confirmTlp("ACEPTAR");
        adminActivity.overFlowMenu.clickControl();
        adminActivity.overFlowMenu.selectOptionByText("Salir");
        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(loginActivity.isMessageDisplayed());
    }
}
