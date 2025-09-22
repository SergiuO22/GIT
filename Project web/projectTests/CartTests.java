package projectTests;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import testData.files.Reader;



public class CartTests extends BaseTest {

    @Test
    public void addAndRemoveProductFromCart() {
        JSONObject user = Reader.getUser("standard_user");
        loginPage.authenticate(user.get("username").toString(), user.get("password").toString());

        projectPages.ProductPage productPage = new projectPages.ProductPage(driver);
        projectPages.CartPage cartPage = new projectPages.CartPage(driver);
        
        String productName = "Sauce Labs Backpack";
        productPage.addProductToCart(productName);
       
        cartPage.openCart();
        Assert.assertTrue(cartPage.isProductInCart(productName));

        cartPage.removeProduct();
        Assert.assertFalse(cartPage.isProductInCart(productName));
    }
}
