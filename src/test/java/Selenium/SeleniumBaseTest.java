package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.util.concurrent.TimeUnit;

public class SeleniumBaseTest {
    protected WebDriver driver;


    @BeforeSuite
    public void baseSuiteMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void baseMethodBefore() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:4444");
    }

    @AfterSuite
    public void baseMethodAfter() {
        driver.quit();
    }


}
