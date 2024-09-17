package testSuite;

import activities.AdminActivity;
import activities.LoginActivity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import singletonSession.Session;

public class TestBase {

    protected LoginActivity loginActivity;
    protected AdminActivity adminActivity;

    @BeforeEach
    public void openApp(){
        loginActivity = new LoginActivity();
        adminActivity = new AdminActivity();
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

}
