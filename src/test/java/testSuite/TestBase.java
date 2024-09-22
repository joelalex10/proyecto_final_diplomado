package testSuite;

import activities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

public class TestBase {

    protected LoginActivity loginActivity;
    protected AdminActivity adminActivity;
    protected UserActivity userActivity;
    protected ReadingActivity readingActivity;
    protected CameraActivity cameraActivity;

    @BeforeEach
    public void openApp(){
        loginActivity = new LoginActivity();
        adminActivity = new AdminActivity();
        userActivity = new UserActivity();
        readingActivity = new ReadingActivity();
        cameraActivity = new CameraActivity();
    }
    @AfterEach
    public void closeApp(){
        Session.getInstance().closeSession();
    }
    public void loginAsAdmin() {
        //loginActivity.versionNameLabel.clickControl();
        //loginActivity.versionNameLabel.clickControl();
        loginActivity.nameEditText.setText("admin");
        loginActivity.passwordEditText.setText("4dm1n.123");
        loginActivity.saveButton.clickControl();
    }
    public void loginAsUser(String tplNumber, String userName, String printerName){
        String password = "1234";
        loginAsAdmin();
        adminActivity.printerEditText.setText(printerName);
        adminActivity.registerPrintButton.clickControl();
        adminActivity.tplEditText.setText(tplNumber);
        adminActivity.registerTplButton.clickControl();
        adminActivity.confirmTlp("ACEPTAR");

        adminActivity.downloadFixedParametersButton.clickControl();
        adminActivity.isConfirmFixedParameters();
        adminActivity.alertDialogConfirmFixedParameters.clickAlertDialogButton("ACEPTAR");

        adminActivity.overFlowMenu.clickControl();
        adminActivity.overFlowMenu.selectOptionByText("Salir");
        loginActivity.nameEditText.setText(userName);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(userActivity.isUserActivityDisplayed());
    }

}
