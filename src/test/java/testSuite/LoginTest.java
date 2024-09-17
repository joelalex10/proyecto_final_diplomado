package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase{
    @Test
    public void checkValidCredentials(){

        String username = "admin";
        String password = "4dm1n.123";

        loginActivity.versionNameLabel.clickControl();
        loginActivity.versionNameLabel.clickControl();
        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(adminActivity.isAdminActivityDisplayed());
    }
    @Test
    public void checkInvaliCredentials(){

        String username = "admin";
        String password = "1234";

        loginActivity.nameEditText.setText(username);
        loginActivity.passwordEditText.setText(password);
        loginActivity.saveButton.clickControl();
        Assertions.assertTrue(loginActivity.isToastDisplayed());
    }
}
