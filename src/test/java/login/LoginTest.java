package login;

import base.BaseTest;
import com.sun.prism.shader.Solid_ImagePattern_Loader;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testSucessfulLogin()  {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.setUserName("demouser");
        loginPage.setPassword("testingisfun99");
        HomePage homePage = loginPage.clickLoginButton();
    }
}
