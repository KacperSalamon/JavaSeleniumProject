package Tabs;

import Helpers.PageBasic;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProcessesPage extends PageBasic {

    public ProcessesPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a")
    private WebElement proccessTabButton;

    @FindBy(css = "[class='btn btn-success']")
    private WebElement addNewProcess;

    @FindBy(name = "Name")
    private WebElement provideName;

    @FindBy(name = "Description")
    private WebElement provideDescription;

    @FindBy(name = "Notes")
    private WebElement provideNotes;

    @FindBy(xpath = "/html/body/div/div/div[3]/div[2]/div[4]/div/div/div[2]/div[2]/div/table/tbody/tr/td[1]")
    private WebElement correctAddProcess;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[3]/div/div/div[2]/div/form/div[5]/div/input")
    private WebElement creationButton;

    @FindBy(css = "[class='text-danger field-validation-error']")
    private WebElement incorrectAddProcess;


    public ProcessesPage name(String name) {
        provideName.clear();
        provideName.sendKeys(name);
        return this;
    }

    public ProcessesPage description(String description) {
        provideDescription.clear();
        provideDescription.sendKeys(description);
        return this;
    }

    public ProcessesPage notes(String notes) {
        provideNotes.clear();
        provideNotes.sendKeys(notes);
        return this;
    }

    public ProcessesPage processTab() {
        proccessTabButton.click();
        return new ProcessesPage(driver);
    }

    public ProcessesPage processAdd() {
        addNewProcess.click();
        return new ProcessesPage(driver);
    }

    public ProcessesPage creationButton() {
        creationButton.click();
        return new ProcessesPage(driver);
    }

    public ProcessesPage checkCorrectAddProcess(String processName){
        Assert.assertTrue(correctAddProcess.getText().contains(processName)); //Here, provide name of your process
        return this;
    }

    public ProcessesPage checkIncorrectAddProcess(String errorMessage) {
        Assert.assertTrue(incorrectAddProcess.getText().contains(errorMessage));
        return this;
    }

}
