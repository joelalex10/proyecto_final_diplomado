package testSuite;

import activities.AdminActivity;
import activities.LoginActivity;
import activities.UserActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

public class TestBase {

    protected LoginActivity loginActivity;
    protected AdminActivity adminActivity;
    protected UserActivity userActivity;

    @BeforeEach
    public void openApp(){
        loginActivity = new LoginActivity();
        adminActivity = new AdminActivity();
        userActivity = new UserActivity();
    }
    @AfterEach
    public void closeApp(){
        Session.getInstance().closeSession();
    }
    public void loginAsAdmin() {
        loginActivity.versionNameLabel.clickControl();
        loginActivity.versionNameLabel.clickControl();
        loginActivity.nameEditText.setText("admin");
        loginActivity.passwordEditText.setText("4dm1n.123");
        loginActivity.saveButton.clickControl();
    }
    public void loginAsUser(String tplNumber, String userName){
        String password = "1234";
        loginAsAdmin();
        adminActivity.tplEditText.setText(tplNumber);
        adminActivity.registerTplButton.clickControl();
        adminActivity.confirmTlp("ACEPTAR");
        adminActivity.overFlowMenu.clickControl();
        adminActivity.overFlowMenu.selectOptionByText("Salir");
        loginActivity.nameEditText.setText(userName);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(userActivity.isUserActivityDisplayed());
    }

}
