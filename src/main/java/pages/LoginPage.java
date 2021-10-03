package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private WebDriver driver;
    private By  userNameField = By.id("react-select-2-input");
    private By passwordField = By.id("react-select-3-input");
    private By loginButton = By.id("login-btn");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    // Method for enter a username in username field
    public void setUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(userNameField).sendKeys(Keys.ENTER);
    }

    // Method for enter a password in password field
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordField).sendKeys(Keys.ENTER);
    }

    // Method for submit a login
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
