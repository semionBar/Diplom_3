package screen;

import io.qameta.allure.Step;
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
        driver.findElement(loginButton).isDisplayed();
    }

    @Step("Проверить, что поле \"Email\" видимо")
    public void checkEmailInputIsVisible() {
        driver.findElement(emailInput).isDisplayed();
    }

    @Step("Проверить, что поле \"Пароль\" видимо")
    public void checkPasswordInputIsVisible() {
        driver.findElement(passwordInput).isDisplayed();
    }

    @Step
    public void checkLoginScreenPageIsDisplayed() {
        checkEmailInputIsVisible();
        checkPasswordInputIsVisible();
        checkLoginButtonIsVisible();
    }

}
