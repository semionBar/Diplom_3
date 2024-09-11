package org.example.screen;

import io.qameta.allure.Step;
import org.example.shared.SharedStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainScreenPage {
    private final WebDriver driver;

    public MainScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton =  By.xpath(".//a[@href='/account']");

    private final By enterInAccountButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    private final By makeBurgerLabel = By.xpath(".//h1[text()='Соберите бургер']");

    private final By bunListTitle = By.xpath(".//h2[text()='Булки']");

    private final By sauceListTitle = By.xpath(".//h2[text()='Соусы']");
    private final By fillingsListTitle = By.xpath(".//h2[text()='Начинки']");

    private final By bunListTab = By.xpath(".//span[contains(text(), 'Булки')]");
    private final By sauceListTab = By.xpath(".//span[contains(text(), 'Соусы')]");
    private final By fillingsListTab = By.xpath(".//span[contains(text(), 'Начинки')]");
    private final By image = By.xpath(".//img[3]");



    @Step("Перейти на экран \"Авторизации\", нажав на кнопку \"Личный кабинет\"")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Перейти на экран \"Авторизации\", нажав на кнопку \"Войти в аккаунт\"")
    public void clickEnterInAccountButton() {
        driver.findElement(enterInAccountButton).click();
    }

    @Step("Проверить, что заголовок \"Соберите бургер\" отображается")
    public void makeBurgerLabelIsDisplayed()  {
        SharedStep.waitForElementToBeVisible(driver, makeBurgerLabel);
        driver.findElement(makeBurgerLabel).isDisplayed();
    }

    @Step("Проверить, что главный экран отображается")
    public void mainScreenPageIsDisplayed() {
        SharedStep.wait(driver,3);
        makeBurgerLabelIsDisplayed();
    }
    @Step("Проверить, что заголовок \"Булки\" отображается")
    public void bunListTitleIsDisplayed() {
        driver.findElement(bunListTitle).isDisplayed();
    }

    @Step("Проверить, что заголовок \"Соусы\" отображается")
    public void sauceListTitleIsDisplayed() {
        driver.findElement(sauceListTitle).isDisplayed();
    }

    @Step("Проверить, что заголовок \"Начинки\" отображается")
    public void fillingsListTitleIsDisplayed() {
        driver.findElement(fillingsListTitle).isDisplayed();
    }

    @Step("Перейти на таб \"Булки\"")
    public void clickBunListTab() {
        driver.findElement(bunListTab).click();
    }
    @Step("Перейти на таб \"Соусы\"")
    public void clickSauceListTab() {
        driver.findElement(sauceListTab).click();
    }
    @Step("Перейти на таб \"Начинки\"")
    public void clickFillingsListTab() {
        driver.findElement(fillingsListTab).click();
    }
}
