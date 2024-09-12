package org.example.screen;

import io.qameta.allure.Step;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.shared.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreenPage {
    private final WebDriver driver;

    private final By registrationButton = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");

    private final By emailInput = By.xpath(".//form[contains(@class, 'Auth_form')]//input[contains(@name, 'name')]");

    private final By passwordInput = By.xpath(".//form[contains(@class, 'Auth_form')]//input[contains(@name, 'Пароль')]");

    private final By loginButton = By.xpath(".//form[contains(@class, 'Auth_form')]//button");

    public LoginScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти на экран регистрации, нажав на кнопку \"Зарегистрироваться\"")
    public void getToRegistrationScreen() {
        driver.findElement(registrationButton).click();
    }


    @Step("Проверить, что кнопка \"Войти\" видима")
    public void checkLoginButtonIsVisible() {
        Wait.waitForElementToBeVisible(driver, loginButton);
        driver.findElement(loginButton).isDisplayed();
    }

    @Step("Проверить, что поле \"Email\" видимо")
    public void checkEmailInputIsVisible() {
        Wait.waitForElementToBeVisible(driver, emailInput);
        driver.findElement(emailInput).isDisplayed();
    }

    @Step("Проверить, что поле \"Пароль\" видимо")
    public void checkPasswordInputIsVisible() {
        Wait.waitForElementToBeVisible(driver, passwordInput);
        driver.findElement(passwordInput).isDisplayed();
    }

    @Step("Проверить, что отображаются все поля экрана логина")
    public void checkLoginScreenPageIsDisplayed() {
        checkEmailInputIsVisible();
        checkPasswordInputIsVisible();
        checkLoginButtonIsVisible();
    }

    @Step("Заполнить поле email")
    public void setEmailInput(UserModel userModel) {
        Wait.waitForElementToBeVisible(driver, passwordInput);
        driver.findElement(emailInput).sendKeys(userModel.getEmail());
    }

    @Step("Заполнить поле пароля")
    public void setPasswordInput(UserModel userModel) {
        Wait.waitForElementToBeVisible(driver, passwordInput);
        driver.findElement(passwordInput).sendKeys(userModel.getPassword());
    }


    @Step("Нажать на кнопку \"Войти\"")
    public void clickLoginButton() {
        Wait.waitForElementToBeVisible(driver, passwordInput);
        driver.findElement(loginButton).click();
    }

    @Step("Заполнить все поля")
    public void setAllFields(UserModel userModel) {
        setEmailInput(userModel);
        setPasswordInput(userModel);
    }

    @Step("Заполнить все поля и нажать на кнопку \"Войти\"")
    public void setAllFieldsAndClickLoginButton(UserModel userModel) {
        setAllFields(userModel);
        clickLoginButton();
    }

    @Step("Удалить юзера")
    public void clearUser(UserModel userModel) {
        new UserAPI().clearUser(userModel);
    }

}
