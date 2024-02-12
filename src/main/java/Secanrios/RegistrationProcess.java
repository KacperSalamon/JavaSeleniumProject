package Secanrios;

import Tabs.RegisterPage;
import Helpers.Sceanrio;

public class RegistrationProcess implements Sceanrio<RegisterPage, RegisterPage>{

    String emial;
    String password;

    public RegistrationProcess(String email, String password) {
        this.emial = email;
        this.password = password;
    }

    @Override
    public RegisterPage run(RegisterPage page) {
        return page
                .providedEmail(emial)
                .providedPass(password)
                .confirmPass(password);
    }


}
