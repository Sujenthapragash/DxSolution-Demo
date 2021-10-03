package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.id("signin");
    private By checkOutLink = By.xpath("//*[@class = 'buy-btn' and text() = 'Checkout']");
    private By ordersLink = By.id("orders");



    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method for navigate to login page from home page
    public LoginPage clickLogin(){
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    // Method for add a product to card by id from home page
    public void addToCardById(int id){
        driver.findElement(By.xpath("//*[@id=\""+id+"\"]/div[4]")).click();

    }

    // Method for go to check out page from popup checkout card in home page
    public CheckOutPage clickCheckOut(){
        driver.findElement(checkOutLink).click();
        return new CheckOutPage(driver);
    }

    //Method for go to Orders page
    public OrdersPage clickOrders(){
        driver.findElement(ordersLink).click();
        return new OrdersPage(driver);
    }


}
