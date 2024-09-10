package org.example.test;

import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainScreenTest {

    WebDriver driver;
    UserModel userModel;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        UserAPI userAPI = new UserAPI();

        userModel = new UserModel("user12345678@gmail.com", "user", "1245768");

        userAPI.createNewUser(userModel);

        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickPersonalAccountButton();

        LoginScreenPage loginScreenPage = new LoginScreenPage(driver);

        loginScreenPage.setAllFieldsAndClickLoginButton(userModel);

        mainScreenPage.clickPersonalAccountButton();

    }

    @Test
    public void getToMainScreenPage() {

    }
}
