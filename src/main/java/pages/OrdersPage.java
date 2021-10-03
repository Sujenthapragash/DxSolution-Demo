package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrdersPage {
    private WebDriver driver;

    private By lastorder = By.xpath("//*[contains (@class , 'orders')]/div[last()]");
    private String orderId;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method for get the last order web element id from orders page
    private void setLastOrderId(){
        List<WebElement> ordersList = driver.findElements(lastorder);
        orderId = ordersList.get(ordersList.size()-1).getAttribute("id");
    }

    // Method for get the last order date from orders page
   public String getLastOrderDate(){
        setLastOrderId();
        By orderDateLabel = By.xpath("(//*[@id=\""+orderId+"\"]//child :: span[contains (@class, \"value\")])[1]");
        WebElement orderDate = driver.findElement(orderDateLabel);
        return orderDate.getText();
    }

    // Method for get the number of products in last order from order page
   public int getNumberOfProductInOrder(){
        setLastOrderId();
        By productsInOrder = By.xpath("//*[@id=\""+orderId+"\"]//child :: div[contains (@id, '"+orderId+"')]");
        List<WebElement> productListInOrder = driver.findElements(productsInOrder);
        return productListInOrder.size();
   }

   // Method for get the total value of last order from orders page
   public String getLastOrderTotal(){
        setLastOrderId();
        By orderTotalLabel = By.xpath("(//*[@id=\""+orderId+"\"]//child :: span[contains (@class, \"value\")])[2]");
        WebElement orderTotal = driver.findElement(orderTotalLabel);
        return orderTotal.getText()+".00";
   }


}
