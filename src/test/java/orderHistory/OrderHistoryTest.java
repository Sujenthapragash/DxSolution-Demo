package orderHistory;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.OrderConfirmationPage;
import pages.OrdersPage;
import utilities.CurreentDate;

public class OrderHistoryTest extends BaseTest {

    @BeforeMethod
    public void userLogin(){
        LoginPage loginPage = homePage.clickLogin(); // Click login button from home page
        loginPage.setUserName("demouser"); // enter username for login
        loginPage.setPassword("testingisfun99"); // enter password for login
        loginPage.clickLoginButton(); // click login button
    }
    @Test
    public void testOrderHistory() {
        homePage.addToCardById(1); // Add a product by clicking the add to card button
        CheckOutPage checkOutPage = homePage.clickCheckOut(); // Click check out button from check out card
        String orderTotal = checkOutPage.getTotal(); // Get the total order value from order checkout
        int numberOfItemsInOrder = checkOutPage.getNumberOfItems(); // Get the number of items from order checkout
        checkOutPage.setFirstName("Dx"); // Enter the firstname for order checkout
        checkOutPage.setLastName("Solution"); // Enter the lastname for order checkout
        checkOutPage.setAddress("Sydney");// Enter the address for order checkout
        checkOutPage.setStateProvince("NSW"); // Enter the stata for order checkout
        checkOutPage.setPostaCode("2000"); // Enter the postcode for order checkout
        OrderConfirmationPage orderConfirmationPage = checkOutPage.clickSubmit(); // Click Submit button from order checkout page
        orderConfirmationPage.clickContinueShopping(); // Click continue shopping from order confirmation page
        OrdersPage ordersPage = homePage.clickOrders(); // Click orders from homepage
        Assert.assertEquals(ordersPage.getLastOrderTotal(),orderTotal,"Order Total is not matched"); // Assert the last order total from checkout and orders
        Assert.assertEquals(ordersPage.getNumberOfProductInOrder(), numberOfItemsInOrder,"Number of product in order is not matched"); // Assert the number of items from checkout and orders
        Assert.assertEquals(ordersPage.getLastOrderDate(), CurreentDate.dateMMMMDYYYYFormat(),"Order date is not matched"); // Assert the date of the order from checkout and orders

    }

}
