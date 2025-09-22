package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    private By cartIcon = By.className("shopping_cart_link");
    private By removeButton = By.xpath("//button[contains(text(),'Remove')]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }
    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    public boolean isProductInCart(String productName) {
        return driver.getPageSource().contains(productName);
    }
}
