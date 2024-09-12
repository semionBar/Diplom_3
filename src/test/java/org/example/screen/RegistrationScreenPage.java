package org.example.screen;

import io.qameta.allure.Step;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.shared.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationScreenPage {

    private final WebDriver driver;

    private UserModel userModel;


    private final By nameInput =  By.xpath(".//label[text()='Имя']/../input");
    private final By emailInput =  By.xpath(".//label[text()='Email']/../input");
    private final By passwordInput =  By.xpath(".//label[text()='Пароль']/../input");
    private final By wrongPasswordHint =  By.xpath(".//p[text()='Некорректный пароль']");
    private final By registerButton = By.xpath(".//form[contains(@class,'Auth_form')]//button");
    private final By loginButton = By.xpath(".//a[text()='Войти']");


    public RegistrationScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнить поле \"Имя\"")
    public void setNameInput() {
        driver.findElement(nameInput).sendKeys(userModel.getName());
    }

    @Step("Заполнить поле \"Email\"")
    public void setEmailInput() {
        driver.findElement(emailInput).sendKeys(userModel.getEmail());
    }
    @Step("Заполнить поле \"Пароль\"")
    public void setPasswordInput() {
        driver.findElement(passwordInput).sendKeys(userModel.getPassword());
    }

    @Step("Заполнить поле \"Пароль\"")
    public void setPasswordInput(String passwordInputValue) {
        driver.findElement(passwordInput).sendKeys(passwordInputValue);
    }

    @Step("Нажать на кнопку \"Зарегистрироваться\" ")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Зарегистрировать нового юзера")
    public void registerNewUser() {
        setNameInput();
        setEmailInput();
        setPasswordInput();
        clickRegisterButton();
    }

    @Step("Зарегистрировать нового юзера")
    public void setRegisterNewUserWithExactPassword(String password) {
        setNameInput();
        setEmailInput();
        setPasswordInput(password);
        clickRegisterButton();
    }

    @Step("Зарегистрировать нового юзера")
    public void clearUser() {
        new UserAPI().clearUser(userModel);
    }

    @Step("Создать модель нового юзера")
    public void getNewUser() {
        userModel = new UserModel(0);
    }

    @Step("Проверить, что поле \"Имя\" отображается")
    public void nameInputIsVisible() {
        Wait.waitForElementToBeVisible(driver, nameInput);
        driver.findElement(nameInput).isDisplayed();
    }

    @Step("Проверить, что поле \"Email\" отображается")
    public void emailInputIsVisible() {
        Wait.waitForElementToBeVisible(driver, emailInput);
        driver.findElement(emailInput).isDisplayed();
    }
    @Step("Проверить, что поле \"Пароль\" отображается")
    public void passwordInputIsVisible() {
        Wait.waitForElementToBeVisible(driver, passwordInput);
        driver.findElement(passwordInput).isDisplayed();
    }
    @Step("Проверить, что кнпока \"Зарегистрироваться\" отображается")
    public void registerButtonIsVisible() {
        Wait.waitForElementToBeClickable(driver, registerButton);
        driver.findElement(registerButton).isDisplayed();
    }
    @Step("Проверить, что экран регистрации отображается")
    public void registrationScreenPageIsDisplayed() {
        nameInputIsVisible();
        emailInputIsVisible();
        passwordInputIsVisible();
        registerButtonIsVisible();
    }

    @Step("Проверить, что отображается подсказка о неверном пароле")
    public void wrongPasswordHintIsDisplayed() {
        Wait.waitForElementToBeVisible(driver, wrongPasswordHint);
        driver.findElement(wrongPasswordHint).isDisplayed();
    }

    @Step("Перейти на экран авторизации")
    public void getToLoginButton() {
        registrationScreenPageIsDisplayed();
        Wait.waitForModalToDisappear(driver);
        driver.findElement(loginButton).click();
    }

}
