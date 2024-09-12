package org.example.test;

import org.example.screen.MainScreenPage;
import org.example.shared.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class MainScreenTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new Browser().getWebDriver("Chrome");

        driver.get("https://stellarburgers.nomoreparties.site/");

    }

    @Test
    public void sauceTabClickTest()  {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.mainScreenPageIsDisplayed();

        mainScreenPage.clickSauceListTab();

        mainScreenPage.sauceListTitleIsDisplayed();

    }

    @Test
    public void fillingsTabClickTest()  {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.mainScreenPageIsDisplayed();

        mainScreenPage.clickFillingsListTab();

        mainScreenPage.fillingsListTitleIsDisplayed();

    }

    @Test
    public void bunTabClickTest()  {
        MainScreenPage mainScreenPage = new MainScreenPage(driver);

        mainScreenPage.mainScreenPageIsDisplayed();

        mainScreenPage.clickFillingsListTab();

        mainScreenPage.clickBunListTab();

        mainScreenPage.bunListTitleIsDisplayed();

    }

    @After
    public void postConditions() {
        driver.quit();
    }
}
