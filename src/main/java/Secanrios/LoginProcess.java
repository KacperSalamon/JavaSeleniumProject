package Secanrios;

import Helpers.Sceanrio;
import Tabs.HomePage;
import Tabs.LoginPage;
import Tabs.RegisterPage;

public class LoginProcess implements Sceanrio<LoginPage, HomePage>{

    String emial;
    String password;

    public LoginProcess(String email, String password) {
        this.emial = email;
        this.password = password;
    }

    @Override
    public HomePage run(LoginPage page) {
        return page
                .providedEmail(emial)
                .providedPass(password)
                .loginClick();
    }


}
