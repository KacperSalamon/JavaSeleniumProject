package Tabs;

import Helpers.PageBasic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBasic {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div/div/section/form/div[2]/input")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "/html/body/div/div/div/section/form/div[5]/button")
    private WebElement loginButton;

    public LoginPage providedEmail(String mail) {
        email.clear();
        email.sendKeys(mail);
        return this;
    }

    public LoginPage providedPass(String pass) {
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    public HomePage loginClick(){
        loginButton.click();
        return new HomePage(driver);
    }

}
