package org.example.screen;

import io.qameta.allure.Step;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.model.UserTokenModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationScreenPage {

    private final WebDriver driver;

    private UserModel userModel;

    private UserTokenModel userTokenModel;


    private final By nameInput =  By.xpath(".//label[text()='Имя']/../input");
    private final By emailInput =  By.xpath(".//label[text()='Email']/../input");
    private final By passwordInput =  By.xpath(".//label[text()='Пароль']/../input");
    private final By wrongPasswordHint =  By.xpath(".//p[text()='Некорректный пароль']");
    private final By registerButton = By.xpath(".//form[contains(@class,'Auth_form')]//button");
    private final By loginButton = By.xpath(".//a[text()='Войти']");








    public RegistrationScreenPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setNameInput() {
        driver.findElement(nameInput).sendKeys(userModel.getName());
    }

    public void setEmailInput() {
        driver.findElement(emailInput).sendKeys(userModel.getEmail());
    }

    public void setPasswordInput() {
        driver.findElement(passwordInput).sendKeys(userModel.getPassword());
    }

    public void setPasswordInput(String passwordInputValue) {
        driver.findElement(passwordInput).sendKeys(passwordInputValue);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void registerNewUser() {
        setNameInput();
        setEmailInput();
        setPasswordInput();
        clickRegisterButton();
    }

    public void setRegisterNewUserWithExactPassword(String password) {
        setNameInput();
        setEmailInput();
        setPasswordInput(password);
        clickRegisterButton();
    }

    public void clearUser() {
        new UserAPI().clearUser(userModel);
    }

    public void getNewUser() {
        userModel = new UserModel(0);
    }

    public void nameInputIsVisible() {
        driver.findElement(nameInput).isDisplayed();
    }

    public void emailInputIsVisible() {
        driver.findElement(emailInput).isDisplayed();
    }

    public void passwordInputIsVisible() {
        driver.findElement(passwordInput).isDisplayed();
    }

    public void registerButtonIsVisible() {
        driver.findElement(registerButton).isDisplayed();
    }

    public void registrationScreenPageIsDisplayed() {
        nameInputIsVisible();
        emailInputIsVisible();
        passwordInputIsVisible();
        registerButtonIsVisible();
    }

    public void wrongPasswordHintIsDisplayed() {
        driver.findElement(wrongPasswordHint).isDisplayed();
    }

    public void getToLoginButton() {
        driver.findElement(loginButton).click();
    }

}
