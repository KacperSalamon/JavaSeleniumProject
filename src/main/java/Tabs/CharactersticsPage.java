package Tabs;

import Helpers.PageBasic;
import com.sun.source.tree.AssertTree;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;


public class CharactersticsPage extends HomePage {

    public CharactersticsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[class='btn btn-success']")
    private WebElement addCharacteristicsButton;

    @FindBy(css = "[class='btn btn-success']")
    private WebElement createButton;

    @FindBy(id = "ProjectId")
    private WebElement projectId;

    @FindBy(id = "Name")
    private WebElement charName;

    @FindBy(id = "LowerSpecificationLimit")
    private WebElement lowerSpec;

    @FindBy(id = "UpperSpecificationLimit")
    private WebElement upperSpec;

    @FindBy(id = "HistogramBinCount")
    private WebElement histogramInput;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[4]/div/div/div[2]/div[2]/div/table/tbody/tr/td[1]")
    private WebElement verifyAddNewChar;

    @FindBy(css = "[class='fa fa-chevron-down']")
    private WebElement homeNav;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[4]/div/ul/li[1]/ul/li/a")
    private WebElement dashoboardNav;

    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//tbody//td[text()='%s']/..";

    public DashBoardPage goToDash() {
        if(!isParentExpanded(homeNav)){
            homeNav.click();
        }

        dashoboardNav.click();
        return new DashBoardPage(driver);
    }
    public CharactersticsPage clickAddCharButton() {
        addCharacteristicsButton.click();
        return this;
    }

    public CharactersticsPage createButton() {
        createButton.click();
        return this;
    }

    public CharactersticsPage selectProcess(String processName) {
        new Select(projectId).selectByVisibleText(processName);
        return this;
    }

    public CharactersticsPage provideName(String name) {
        charName.clear();
        charName.sendKeys(name);
        return this;
    }

    public CharactersticsPage provideLowerLimit(String lSpec) {
        lowerSpec.clear();
        lowerSpec.sendKeys(lSpec);
        return this;
    }

    public CharactersticsPage provideUpperLimit(String uSpec) {
        upperSpec.clear();
        upperSpec.sendKeys(uSpec);
        return this;
    }

    public CharactersticsPage provideHistogram(String histogram) {
        histogramInput.clear();
        histogramInput.sendKeys(histogram);
        return this;
    }

    public CharactersticsPage verifyChar(String charName) {
        Assert.assertTrue(verifyAddNewChar.getText().contains(charName));
        return this;
    }

    public CharactersticsPage assertion(String name, String prcoessName, String lsl) {
        String xpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, name);
        WebElement charRow = driver.findElement(By.xpath(xpath));

        String actualProcessName = charRow.findElement(By.xpath("./td[1]")).getText();
        String actualLsl = charRow.findElement(By.xpath("./td[3]")).getText();

        Assert.assertEquals(actualProcessName, prcoessName);
        Assert.assertEquals(actualLsl, lsl);
        return this;
    }

}
