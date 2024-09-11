package org.example.test;

import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;
import org.example.screen.NavigationMenuPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMenuTest {

    WebDriver driver;
    UserModel userModel;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/login");

        UserAPI userAPI = new UserAPI();

        userModel = new UserModel("user12345678@gmail.com", "user", "1245768");

        userAPI.createNewUser(userModel);

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);

    }

    @Test
    public void getToMainScreenPageByConstructorLink() {

        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickPersonalAccountButton();

        new NavigationMenuPage(driver).clickConstructorLink();

        mainScreenPage.mainScreenPageIsDisplayed();
    }


    @Test
    public void getToMainScreenPageByMainLogoLink() {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickPersonalAccountButton();

        new NavigationMenuPage(driver).clickMainLogoLink();

        mainScreenPage.mainScreenPageIsDisplayed();
    }

    @After
    public void postConditions() {

        new UserAPI().clearUser(userModel);

        driver.quit();
    }
}