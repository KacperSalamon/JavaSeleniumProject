package Tabs;

import Helpers.PageBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class HomePage extends PageBasic {

    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div/nav/ul/li/a")
    private WebElement loggedUser;

    @FindBy(xpath= "/html/body/div/div/div[1]/div/div[4]/div/ul/li[2]/a")
    private WebElement workspaceNav;

    @FindBy(css="a[href$=Projects]")
    private WebElement processMenu;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[4]/div/ul/li[2]/a")
    private WebElement workspacesButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[3]/div/div/div[1]/h2")
    private WebElement processInDashboard;

    @FindBy(linkText = "Characteristics")
    private WebElement characteristicMenu;


    public boolean isParentExpanded(WebElement menuLink){
        WebElement parent = menuLink.findElement(By.xpath("./.."));
        return parent.getAttribute("class").contains("active");
    }

    public ProcessesPage goToProcesses(){
        if(!isParentExpanded(workspaceNav))
            workspaceNav.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(processMenu));

        processMenu.click();

        return new ProcessesPage(driver);
    }

    public CharactersticsPage goToCharacteristics() {
        if(!isParentExpanded(workspaceNav))
            workspaceNav.click();

        characteristicMenu.click();

        return new CharactersticsPage(driver);
    }

    public HomePage correctRegistration(String email){
        Assert.assertTrue(loggedUser.getText().contains(email));
        return this;
    }

    public HomePage processDashobard(String processName) {
        Assert.assertTrue(processInDashboard.getText().contains(processName));
        return this;
    }


}
