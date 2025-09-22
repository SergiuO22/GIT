package projectTests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import projectPages.LoginPage;
import testData.files.Reader;

public class BaseTest {
    protected static WebDriver driver;
    protected static LoginPage loginPage;

    @BeforeClass
    public static void beforeAll() {
    	System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
    	ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		chromeOption.addArguments("disable-infobars"); // Disable infobars
		chromeOption.addArguments("disable-popup-blocking"); // Disable popup blocking
		chromeOption.addArguments("disable-default-apps"); // Disable default apps
		chromeOption.addArguments("no-first-run"); // Skip first run wizards
		chromeOption.addArguments("no-default-browser-check"); // Skip default browser check
		chromeOption.addArguments("--disable-search-engine-choice-screen");
		
		chromeOption.addArguments("start-maximized"); // Open browser in maximized mode
		chromeOption.addArguments("disable-notifications"); // Disable notifications
		chromeOption.addArguments("disable-extensions"); // Disable extensions
		chromeOption.addArguments("guest"); // Disable change password popup
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
    }

    @Before
    public void before() {
        driver.get(Reader.getUrl());
    }

    @AfterClass
    public static void afterAll() {
        driver.quit();
    }
}
