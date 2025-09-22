package projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ConfirmationPage {
    WebDriver driver;

    private By finishButton = By.id("finish");
    private By completeHeader = By.className("complete-header");
    private By orderSummary = By.className("summary_info");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

    public String getCompleteHeader() {
        return driver.findElement(completeHeader).getText();
    }

    public boolean isOrderSummaryDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement summary = wait.until(ExpectedConditions.visibilityOfElementLocated(orderSummary));
            return summary.isDisplayed();
        } catch (Exception e) {
            System.out.println("Order summary not found: " + e.getMessage());
            return false;
        }
    }
}
