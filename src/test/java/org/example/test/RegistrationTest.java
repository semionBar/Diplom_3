package org.example.test;

import org.example.model.UserModel;
import org.junit.After;
import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.screen.RegistrationScreenPage;

public class RegistrationTest {

    private WebDriver driver;

    UserModel userModel;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
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

        new MainScreenPage(driver).mainScreenPageIsDisplayed();



    }



    @After
    public void clearData() {
        driver.quit();
    }

}
