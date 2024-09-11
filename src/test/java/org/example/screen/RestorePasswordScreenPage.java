package org.example.screen;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordScreenPage {

    private final WebDriver driver;
    private final By enterButton = By.xpath(".//a[text()='Войти']");

    public RestorePasswordScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку \"Войти\"")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

}
