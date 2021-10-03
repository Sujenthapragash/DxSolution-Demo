package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckOutPage {
    private WebDriver driver;
    private By firstNameField = By.id("firstNameInput");
    private By lastNameField = By.id("lastNameInput");
    private By addressField = By.id("addressLine1Input");
    private By stateProvinceField = By.id("provinceInput");
    private By postaCodeFiels = By.id("postCodeInput");
    private By submitButton = By.id("checkout-shipping-continue");
    private By orderTotalLabel = By.xpath("//*[@class = 'cart-priceItem-value']/span");
    private By itemsList = By.xpath(".//*[@class =\"productList\"]/child :: li");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method for enter a first name in checkout page
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    // Method for enter a last name in checkout page
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // Method for enter an address in checkout page
    public void setAddress(String address){
        driver.findElement(addressField).sendKeys(address);
    }

    // Method for enter a state in checkout page
    public void setStateProvince(String stateProvince){
        driver.findElement(stateProvinceField).sendKeys(stateProvince);
    }

    // Method for enter a postal code in checkout page
    public void setPostaCode(String postaCode){
        driver.findElement(postaCodeFiels).sendKeys(postaCode);
    }

    // Method for click submit button from check out page
    public OrderConfirmationPage clickSubmit (){
        driver.findElement(submitButton).click();
        return new OrderConfirmationPage(driver);
    }

    // Method for get number of items at checkout
    public int getNumberOfItems(){
        List<WebElement> items = driver.findElements(itemsList);
        return items.size();
    }

    //Method for get the total value at checkout
    public String getTotal(){
        WebElement totalElement = driver.findElement(orderTotalLabel);
        return totalElement.getText();
    }
}
