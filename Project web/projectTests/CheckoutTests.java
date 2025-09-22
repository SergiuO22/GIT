package projectTests;

import projectPages.*;
import testData.files.Reader;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CheckoutTests extends BaseTest {
	
    @Test @Ignore
    public void completeInfoWithInvalidData() {
        JSONObject user = Reader.getUser("standard_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());

        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        JSONObject badInfo = Reader.getCheckoutUser("invalidUser");
        checkoutPage.enterUserInfo(
            badInfo.get("firstName").toString(),
            badInfo.get("lastName").toString(),
            badInfo.get("zip").toString()
        );

        Assert.assertTrue(checkoutPage.getError().contains("Error"));
    }

    @Test @Ignore
    public void completeOrderForOneProduct() {
    	
        JSONObject user = Reader.getUser("standard_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());
        
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        String productName = "Sauce Labs Backpack";
        productPage.addProductToCart(productName);

        cartPage.openCart();
        Assert.assertTrue(cartPage.isProductInCart(productName));
        cartPage.clickCheckout();

        JSONObject goodUser = Reader.getCheckoutUser("validUser");
        checkoutPage.enterUserInfo(
            goodUser.get("firstName").toString(),
            goodUser.get("lastName").toString(),
            goodUser.get("zip").toString()
        );

        Assert.assertTrue(confirmationPage.isOrderSummaryDisplayed());
        confirmationPage.finishOrder();
        Assert.assertEquals("Thank you for your order!", confirmationPage.getCompleteHeader());
    }

    @Test @Ignore
    public void filterProductsAllOptions() {
        JSONObject user = Reader.getUser("standard_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.selectSortOption("Name (A to Z)");
        inventoryPage.selectSortOption("Name (Z to A)");
        inventoryPage.selectSortOption("Price (low to high)");
        inventoryPage.selectSortOption("Price (high to low)");

    }
}
