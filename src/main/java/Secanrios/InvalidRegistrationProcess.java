package Secanrios;

import Helpers.Sceanrio;
import Tabs.RegisterPage;

public class InvalidRegistrationProcess implements Sceanrio<RegisterPage, RegisterPage>{

    String emial;
    String password;

    String invalidPassword;

    public InvalidRegistrationProcess(String email, String password, String invalidPassword) {
        this.emial = email;
        this.password = password;
        this.invalidPassword = invalidPassword;
    }

    @Override
    public RegisterPage run(RegisterPage page) {
        return page
                .providedEmail(emial)
                .providedPass(password)
                .confirmPass(invalidPassword);
    }


}
