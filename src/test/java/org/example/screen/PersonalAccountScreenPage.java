package org.example.screen;

import io.qameta.allure.Step;
import org.example.api.UserAPI;
import org.example.model.UserModel;
import org.example.shared.SharedStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountScreenPage {

    private final WebDriver driver;
    private final By profileLink = By.xpath(".//a[text()='Профиль']");
    private final By orderHistoryLink = By.xpath(".//a[text()='История заказов']");
    private final By quitLink = By.xpath(".//button[text()='Выход']");



    public PersonalAccountScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить, что экран \"Личный кабинет\" отображается")
    public void personalAccountScreenIsDisplayed() {
       profileLinkIsVisible();
       orderHistoryLinkIsVisible();
       quitLinkIsVisible();
    }
    @Step("Проверить, что отображается ссылка \"Профиль\"")
    public void profileLinkIsVisible() {
        SharedStep.waitForElementToBeVisible(driver, profileLink);
        driver.findElement(profileLink).isDisplayed();
    }

    @Step("Проверить, что отображается ссылка \"История заказов\"")
    public void orderHistoryLinkIsVisible() {
        SharedStep.waitForElementToBeVisible(driver, orderHistoryLink);
        driver.findElement(orderHistoryLink).isDisplayed();
    }

    @Step("Проверить, что отображается ссылка \"Выход\"")
    public void quitLinkIsVisible() {
        SharedStep.waitForElementToBeVisible(driver, quitLink);
        driver.findElement(quitLink).isDisplayed();
    }

    @Step("Нажать на кнопку \"Выход\"")
    public void clickQuitLink() {
        SharedStep.waitForElementToBeVisible(driver, quitLink);
        driver.findElement(quitLink).click();
    }
}
