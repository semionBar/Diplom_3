package org.example.test;

import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;
import org.example.screen.RegistrationScreenPage;
import org.example.shared.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegistrationTest {

    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new Browser().getWebDriver("Chrome");

        driver.get("https://stellarburgers.nomoreparties.site/");

        new MainScreenPage(driver).clickPersonalAccountButton();

        new LoginScreenPage(driver).getToRegistrationScreen();
    }

    @Test
    public void successfulRegistrationTest() {

        RegistrationScreenPage registrationScreenPage = new RegistrationScreenPage(driver);

        registrationScreenPage.getNewUser();

        registrationScreenPage.registerNewUser();

        registrationScreenPage.clearUser();

        new LoginScreenPage(driver).checkLoginScreenPageIsDisplayed();

    }

    @Test
    public void passwordHasLessThanSixSymbolsError() {

        RegistrationScreenPage registrationScreenPage = new RegistrationScreenPage(driver);

        registrationScreenPage.getNewUser();

        registrationScreenPage.setRegisterNewUserWithExactPassword("12345");

        registrationScreenPage.registrationScreenPageIsDisplayed();

        registrationScreenPage.wrongPasswordHintIsDisplayed();

    }



    @After
    public void clearData() {
        driver.quit();
    }

}
