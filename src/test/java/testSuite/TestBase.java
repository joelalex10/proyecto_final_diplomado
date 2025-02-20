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
    protected ReadingGranDemandaActivity readingGranDemandaActivity;

    @BeforeEach
    public void openApp(){
        loginActivity = new LoginActivity();
        adminActivity = new AdminActivity();
        userActivity = new UserActivity();
        readingActivity = new ReadingActivity();
        cameraActivity = new CameraActivity();
        readingGranDemandaActivity = new ReadingGranDemandaActivity();
    }
    @AfterEach
    public void closeApp(){
        Session.getInstance().closeSession();
    }
    public void loginAsAdmin(String username, String password) {
        //loginActivity.versionNameLabel.clickControl();
        //loginActivity.versionNameLabel.clickControl();
        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
    }
    public void loginAsUser(String adminUserName, String adminpassword, String tplNumber, String userName, String userPassword, String printerName){

        loginAsAdmin(adminUserName,adminpassword);

        adminActivity.registeruRLButton.clickControl();
        adminActivity.registerPrintButton.clickControl();
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
        loginActivity.passwordEditText.setText(userPassword);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(userActivity.isUserActivityDisplayed());
    }

}
