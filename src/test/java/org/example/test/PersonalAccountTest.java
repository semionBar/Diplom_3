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

        UserAPI userAPI = new UserAPI();

        userAPI.createNewUser(userModel);

        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickPersonalAccountButton();

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);
    }

    @Test
    public void getToPersonalAccountTest() {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickPersonalAccountButton();

        PersonalAccountScreenPage personalAccountScreenPage = new PersonalAccountScreenPage(driver);

        personalAccountScreenPage.personalAccountScreenIsDisplayed();

        personalAccountScreenPage.clearUser(userModel);
    }

    @Test
    public void quitTest() {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickPersonalAccountButton();

        PersonalAccountScreenPage personalAccountScreenPage = new PersonalAccountScreenPage(driver);

        personalAccountScreenPage.clickQuitLink();

        new LoginScreenPage(driver).checkLoginScreenPageIsDisplayed();

        personalAccountScreenPage.clearUser(userModel);

    }

    @After
    public void postConditions() {
        driver.quit();
    }

}
