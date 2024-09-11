package org.example.screen;

import io.qameta.allure.Step;
import org.example.shared.SharedStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordScreenPage {

    private final WebDriver driver;
    private final By enterButton = By.xpath(".//a[text()='Войти']");
    private final By restoreAccountButton = By.xpath(".//button[text()='Восстановить']");
    private final By inputEmailField = By.xpath(".//input[@name='name']");



    public RestorePasswordScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку \"Войти\"")
    public void clickEnterButton() {
        RestorePasswordScreenIsDisplayed();
        try { //Было решено обернуть поиск кнопки в блок try и дать драйверу еще один шанс, так как на Firefox проиходят рандомные падения
            driver.findElement(enterButton).click();
        } catch (Throwable throwable) {
            SharedStep.waitForModalToDisappear(driver);
            driver.findElement(enterButton).click();
        }
    }

    @Step("Экран восстановления пароля отображается")
    public void RestorePasswordScreenIsDisplayed() {
        inputEmailFieldIsDisplayed();
        restoreAccountButtonIsDisplayed();
        restoreAccountButtonIsClickable();
    }

    @Step("Поле для ввода email отображается")
    public void inputEmailFieldIsDisplayed() {
        SharedStep.waitForElementToBeVisible(driver, inputEmailField);
        driver.findElement(inputEmailField).isDisplayed();
    }
    @Step("Поле для ввода email отображается")
    public void restoreAccountButtonIsDisplayed() {
        SharedStep.waitForElementToBeVisible(driver, restoreAccountButton);
        driver.findElement(restoreAccountButton).isDisplayed();
    }
    @Step("Ссылка \"Войти\" отображается")
    public void restoreAccountButtonIsClickable() {
        SharedStep.waitForElementToBeClickable(driver, enterButton);
        driver.findElement(enterButton).isDisplayed();
    }

}
