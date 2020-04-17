package com.gsmserver;

import com.gsmserver.pages.HomePage;
import com.gsmserver.pages.LoginPopup;
import org.junit.jupiter.api.Test;

public class LoginPopupTests {

    @Test
    void openLoginPopupTest() {
        new HomePage.DropdownAccount()
                .openDropDownPopup()
                .openLoginPopup();

        new LoginPopup()
                .fillLogin()
                .fillPassword()
                .clickOnLogin();
    }
}
