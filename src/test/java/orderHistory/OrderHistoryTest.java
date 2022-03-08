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
        // Add a product by clicking the add to card button
        homePage.addToCardById(1);
        // Click check out button from check out card
        CheckOutPage checkOutPage = homePage.clickCheckOut();
        // Get the total order value from order checkout
        String orderTotal = checkOutPage.getTotal();
        // Get the number of items from order checkout
        int numberOfItemsInOrder = checkOutPage.getNumberOfItems();
        // Enter the firstname for order checkout
        checkOutPage.setFirstName("Dx");
        // Enter the lastname for order checkout
        checkOutPage.setLastName("Solution");
        // Enter the address for order checkout
        checkOutPage.setAddress("Sydney");
        // Enter the stata for order checkout
        checkOutPage.setStateProvince("NSW");
        // Enter the postcode for order checkout
        checkOutPage.setPostaCode("2000");
        // Click Submit button from order checkout page
        OrderConfirmationPage orderConfirmationPage = checkOutPage.clickSubmit();
        // Click continue shopping from order confirmation page
        orderConfirmationPage.clickContinueShopping();
        // Click orders from homepage
        OrdersPage ordersPage = homePage.clickOrders();
        // Assert the last order total from checkout and orders
        Assert.assertEquals(ordersPage.getLastOrderTotal(),orderTotal,"Order Total is not matched");
        // Assert the number of items from checkout and orders
        Assert.assertEquals(ordersPage.getNumberOfProductInOrder(), numberOfItemsInOrder,"Number of product in order is not matched");
        // Assert the date of the order from checkout and orders
        Assert.assertEquals(ordersPage.getLastOrderDate(), CurreentDate.dateMMMMDYYYYFormat(),"Order date is not matched");

    }

}
