package org.example.test;

import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.screen.RegistrationScreenPage;
import org.example.screen.RestorePasswordScreenPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;

public class LoginTest {

    private WebDriver driver;

    UserModel userModel;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        userModel = new UserModel("user12345678@gmail.com", "user", "1245768");

        UserAPI userAPI = new UserAPI();

        userAPI.createNewUser(userModel);

    }

    @Test
    public void personalAccountButtonLoginTest() {

        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.getToLoginScreenByPersonalAccountButton();

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);

        mainScreenPage.mainScreenPageIsDisplayed();

        loginScreenPage.clearUser(userModel);
    }

    @Test
    public void enterInAccountButtonLoginTest() {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.getToLoginScreenByEnterInAccountButton();

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);

        mainScreenPage.mainScreenPageIsDisplayed();

        loginScreenPage.clearUser(userModel);
    }

    @Test
    public void forgotPasswordEnterButtonLoginTest() {

        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        new RestorePasswordScreenPage(driver).clickEnterButton();

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);

        new MainScreenPage(driver).mainScreenPageIsDisplayed();

        loginScreenPage.clearUser(userModel);
    }


    @Test
    public void registrationEnterButtonLoginTest() {

        driver.get("https://stellarburgers.nomoreparties.site/register");

        new RegistrationScreenPage(driver).getToLoginButton();

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);

        new MainScreenPage(driver).mainScreenPageIsDisplayed();

        loginScreenPage.clearUser(userModel);

    }


    @After
    public void postConditions() {
        driver.quit();
    }

}