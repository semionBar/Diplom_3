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

    @Step("Перейти на экран \"Авторизации\", нажав на кнопку \"Личный кабинет\"")
    public void getToLoginScreenByPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Перейти на экран \"Авторизации\", нажав на кнопку \"Войти в аккаунт\"")
    public void getToLoginScreenByEnterInAccountButton() {
        driver.findElement(enterInAccountButton).click();
    }

    public void makeBurgerLabelIsDisplayed()  {
        SharedStep.waitForElementToBeVisible(driver, makeBurgerLabel);
        driver.findElement(makeBurgerLabel).isDisplayed();
    }
    public void mainScreenPageIsDisplayed() {
        makeBurgerLabelIsDisplayed();
    }
}
