package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBasic {

    protected WebDriver driver;

    public PageBasic(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <input extends PageBasic, output extends PageBasic> output run(Sceanrio<input, output> scenario) {
        return scenario.run((input) this);
    }


}
