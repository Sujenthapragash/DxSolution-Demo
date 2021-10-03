package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private WebDriver driver;
    private By continueShoppingButton = By.xpath("//button[contains (text() , 'Continue Shopping')]");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method for click continue shopping from order confirmation page
    public HomePage clickContinueShopping(){
        driver.findElement(continueShoppingButton).click();
        return new HomePage(driver);
    }
}
