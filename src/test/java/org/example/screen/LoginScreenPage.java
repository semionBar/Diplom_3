package org.example.screen;

import io.qameta.allure.Step;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.shared.SharedStep;
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
        SharedStep.waitForElementToBeVisible(driver, loginButton);
        driver.findElement(loginButton).isDisplayed();
    }

    @Step("Проверить, что поле \"Email\" видимо")
    public void checkEmailInputIsVisible() {
        SharedStep.waitForElementToBeVisible(driver, emailInput);
        driver.findElement(emailInput).isDisplayed();
    }

    @Step("Проверить, что поле \"Пароль\" видимо")
    public void checkPasswordInputIsVisible() {
        SharedStep.waitForElementToBeVisible(driver, passwordInput);
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
        driver.findElement(emailInput).sendKeys(userModel.getEmail());
    }

    @Step("Заполнить поле пароля")
    public void setPasswordInput(UserModel userModel) {
        driver.findElement(passwordInput).sendKeys(userModel.getPassword());
    }



    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void setAllFields(UserModel userModel) {
        setEmailInput(userModel);
        setPasswordInput(userModel);
    }

    public void setAllFieldsAndClickLoginButton(UserModel userModel) {
        setAllFields(userModel);
        clickLoginButton();
    }

    public void clearUser(UserModel userModel) {
        new UserAPI().clearUser(userModel);
    }

}
