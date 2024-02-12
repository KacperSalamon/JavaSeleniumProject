package Tabs;

import Helpers.PageBasic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

public class RegisterPage extends PageBasic {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private static final String pageUrl = "http://localhost:4444";
    @FindBy(xpath = "/html/body/div/div/div/section/form/div[2]/input")
    private WebElement email;

    @FindBy(id = "Password")
    private WebElement password;

    @FindBy(xpath = "/html/body/div/div/div/section/form/div[4]/input")
    private WebElement confirmPassword;

    @FindBy(xpath = "/html/body/div/div/div/section/form/div[5]/button")
    private WebElement regButton;

    @FindBy(xpath = "/html/body/div/div/div/section/form/div[7]/p/a")
    private WebElement changeLink;

    @FindBy(xpath= "/html/body/div/div/div/section/form/div[1]/ul/li")
    private WebElement passErrors;

    @FindBy(xpath = "/html/body/div/div/div/section/form/div[4]/span/span")
    private WebElement incorrectPassword;

    public RegisterPage providedEmail(String mail) {
        email.clear();
        email.sendKeys(mail);
        return this;
    }

    public RegisterPage providedPass(String pass) {
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    public RegisterPage confirmPass(String pass) {
        confirmPassword.clear();
        confirmPassword.sendKeys(pass);
        return this;
    }

    public RegisterPage changeLink(){
        changeLink.click();
        return new RegisterPage(driver);
    }

    public HomePage registerClick(){
        regButton.click();
        return new HomePage(driver);
    }

    public RegisterPage validationClick() {
        regButton.click();
        return new RegisterPage(driver);
    }

    public RegisterPage incorrectRegister(String errorMessage){
        Assert.assertTrue(passErrors.getText().contains(errorMessage));
        return this;
    }

    public RegisterPage wrongPassword(String errorMessage) {
        Assert.assertTrue(incorrectPassword.getText().contains(errorMessage));
        return this;
    }

}
