package org.example.test;

import org.checkerframework.checker.units.qual.A;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.screen.LoginScreenPage;
import org.example.screen.MainScreenPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainScreenTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    public void sauceTabClickTest() throws Exception {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickSauceListTab();

        mainScreenPage.sauceListTitleIsDisplayed();

    }

    @Test
    public void fillingsTabClickTest() throws Exception {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickFillingsListTab();

        mainScreenPage.fillingsListTitleIsDisplayed();

    }

    @Test
    public void bunTabClickTest() throws Exception {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.clickFillingsListTab();

        mainScreenPage.clickBunListTab();

        mainScreenPage.bunListTitleIsDisplayed();

    }

    @After
    public void postConditions() {
        driver.quit();
    }
}
