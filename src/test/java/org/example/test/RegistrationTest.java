package org.example.test;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.model.UserTokenModel;
import org.junit.After;
import screen.LoginScreenPage;
import screen.MainScreenPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import screen.RegistrationScreenPage;

public class RegistrationTest {

    private WebDriver driver;

    UserModel userModel;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        new MainScreenPage(driver).getToLoginScreen();

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





    @After
    public void clearData() {
        driver.quit();
    }

}
