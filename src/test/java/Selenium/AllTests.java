package Selenium;

import Secanrios.*;
import Tabs.LoginPage;
import Tabs.RegisterPage;
import org.testng.annotations.*;
import java.util.Random;
import java.util.UUID;

public class AllTests extends SeleniumBaseTest {
    @Test
    public void correctRegistration_test01() {
        String email = generateUniqueEmail();
        String password = generateRandomPass(8, 79);


        new RegisterPage(driver)
                .changeLink()
                .run(new RegistrationProcess(email, password))
                .registerClick()
                .correctRegistration(email);

    }

    @Parameters("errorMessage")
    @Test
    public void wrongPassRegistration_test02(@Optional String errorMessage) {
        String email = generateUniqueEmail();
        String password = generateRandomPass(6,70);
        String invalidPassword = password + "invalid";

        new RegisterPage(driver)
                .changeLink()
                .run(new InvalidRegistrationProcess(email, password, invalidPassword))
                .validationClick()
                .wrongPassword(errorMessage);
    }

    @DataProvider
    public Object [][] invalidPasswordProvided() {
        return new Object[][] {
                {"test123", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"Testtest!", "Passwords must have at least one digit ('0'-'9')."},
                {"Test123", "Passwords must have at least one non alphanumeric character."},
        };
    }

    @Test(dataProvider = "invalidPasswordProvided")
    public void validatationRegistrationProcess_test03(String passwords, String errorMessage) {
        String email = generateUniqueEmail();
        new RegisterPage(driver)
                .changeLink()
                .run(new RegistrationProcess(email, passwords))
                .validationClick()
                .incorrectRegister(errorMessage);

    }


    @Test
    public void loginSuccess_test04() {
        String loginEmail = "test@test1221.com"; //Here, please provide ANY existing email!
        String loginPassword = "Ada_0507"; //Here, please provide pass for above email!

        new LoginPage(driver)
                .run(new LoginProcess(loginEmail, loginPassword))
                .correctRegistration(loginEmail);

    }
    @Parameters("processName")
    @Test
    public void correctProcess_test06() {
        String loginEmail = "test@test1221.com"; //Here, please provide ANY existing email!
        String loginPassword = "Ada_0507"; //Here, please provide pass for above email!
        String processName = "randomName"; //use to create random name - you can change it for any name if you want :)
        String description = "My first process";
        String notes = "My second love is coding :)";

        new LoginPage(driver)
                .run(new LoginProcess(loginEmail, loginPassword))
                .goToProcesses()
                .processTab()
                .processAdd()
                .run(new AddNewProcess(processName, description, notes))
                .creationButton()
                .checkCorrectAddProcess(processName);
    }

    @Test
    public void checkProcessIsDisplayedOnDashboard_test07() {
        String loginEmail = "test@test1221.com"; //Here, please provide ANY existing email!
        String loginPassword = "Ada_0507"; //Here, please provide pass for above email!
        String processName = "randomName";

        new LoginPage(driver)
                .run(new LoginProcess(loginEmail, loginPassword))
                .processDashobard(processName);
    }

    @Test
    public void incorrectAddProcess_test08(@Optional String errorMessage) {
        String loginEmail = "test@test12345.com"; //Here, please provide ANY existing email!
        String loginPassword = "Test_1234"; //Here, please provide pass for above email!
        String processName = ""; //use to create random name - you can change it for any name if you want :)
        String description = "description";
        String notes = "notes";


        new LoginPage(driver)
                .run(new LoginProcess(loginEmail, loginPassword))
                .goToProcesses()
                .processTab()
                .processAdd()
                .run(new AddNewProcess(processName, description, notes))
                .creationButton()
                .checkIncorrectAddProcess(errorMessage);
    }

    @Test
    public void addNewCharacteristic_test09(@Optional String charName) {
        String loginEmail = "test@test12345.com"; //Here, please provide ANY existing email!
        String loginPassword = "Test_1234"; //Here, please provide pass for above email!
        String processName = "name";
        String characterName = "charName";
        String lsl = "8";
        String usl = "10";
        String histogram = "9";

        new LoginPage(driver)
                .run(new LoginProcess(loginEmail, loginPassword))
                .goToCharacteristics()
                .clickAddCharButton()
                .run(new AddNewCharacteristics(processName, characterName, lsl, usl, histogram))
                .createButton()
                .assertion(characterName, processName, lsl);
    }



    //Below are methods to generate email & password for new user


    public static final String generateUniqueEmail() {
        String uuid = UUID.randomUUID().toString();
        String domain = "example.com";
        String email = "user_" + uuid + "@" + domain;
        return email;
    }

    public static final String generateRandomPass(int minLength, int maxLength) {
        if (minLength < 6 || maxLength > 100 || minLength > maxLength) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        String Characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String DIGITS = "0123456789";
        String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]|,./?><";

        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        stringBuilder.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        stringBuilder.append(DIGITS.charAt(random.nextInt(DIGITS.length())));

        int rLength = random.nextInt(maxLength - minLength + 1) + minLength - 2;
        for (int i =0; i < rLength; i++) {
            stringBuilder.append(Characters.charAt(random.nextInt(Characters.length())));
        }

        char[] Array = stringBuilder.toString().toCharArray();
        for (int i = Array.length - 1; i > 0 ; i--) {
            int index = random.nextInt(i + 1);
            char temp = Array[index];
            Array[index] = Array[i];
            Array[i] = temp;
        }

        return new String(Array);
    }

}

