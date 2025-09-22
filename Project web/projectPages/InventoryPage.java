package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    WebDriver driver;

    private By sortDropdown = By.className("product_sort_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortOption(String value) {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText(value);
    }
}
