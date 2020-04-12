package com.gsmserver;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public abstract class BaseTest {

    static {
        Configuration.baseUrl = "https://gsmserver.com";
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.assertionMode = AssertionMode.STRICT;
        Configuration.fastSetValue = true;
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 50;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

}
