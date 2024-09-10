package org.example.test;

import org.checkerframework.checker.units.qual.A;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;
import org.example.screen.PersonalAccountScreenPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PersonalAccountTest {

    WebDriver driver;

    UserModel userModel;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        userModel = new UserModel("user12345678@gmail.com", "user", "1245768");

        new UserAPI().createNewUser(userModel);

        new MainScreenPage(driver).clickPersonalAccountButton();

        new LoginScreenPage(driver).setAllFieldsAndClickLoginButton(userModel);
    }

    @Test
    public void getToPersonalAccountTest() {

        new MainScreenPage(driver).clickPersonalAccountButton();

        new PersonalAccountScreenPage(driver).personalAccountScreenIsDisplayed();

    }

    @Test
    public void quitTest() {
        new MainScreenPage(driver).clickPersonalAccountButton();

        new PersonalAccountScreenPage(driver).clickQuitLink();

        new LoginScreenPage(driver).checkLoginScreenPageIsDisplayed();

    }

    @After
    public void postConditions() {

        new UserAPI().clearUser(userModel);

        driver.quit();
    }

}
