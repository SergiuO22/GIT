package projectTests;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import testData.files.Reader;

import org.json.simple.JSONObject;

public class LoginTest extends BaseTest {

    @Test @Ignore
    public void loginWithValidData() {
        JSONObject user = Reader.getUser("standard_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test @Ignore
    public void loginWithInvalidData() {
        JSONObject user = Reader.getUser("wrong_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }

    @Test @Ignore
    public void loginWithLockedOutUser() {
        JSONObject user = Reader.getUser("locked_out_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());

        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"));
    }
}
