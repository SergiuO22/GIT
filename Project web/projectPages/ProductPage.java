package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        By addButton = By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button");
        driver.findElement(addButton).click();
    }
}
