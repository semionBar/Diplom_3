package org.example.screen;

import io.qameta.allure.Step;
import org.example.shared.Wait;
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
        Wait.waitForElementToBeVisible(driver, profileLink);
        driver.findElement(profileLink).isDisplayed();
    }

    @Step("Проверить, что отображается ссылка \"История заказов\"")
    public void orderHistoryLinkIsVisible() {
        Wait.waitForElementToBeVisible(driver, orderHistoryLink);
        driver.findElement(orderHistoryLink).isDisplayed();
    }

    @Step("Проверить, что отображается ссылка \"Выход\"")
    public void quitLinkIsVisible() {
        Wait.waitForElementToBeVisible(driver, quitLink);
        driver.findElement(quitLink).isDisplayed();
    }

    @Step("Нажать на кнопку \"Выход\"")
    public void clickQuitLink() {
        personalAccountScreenIsDisplayed();

        try {
            driver.findElement(quitLink).click();
        } catch (Throwable throwable) {
            //Было решено обернуть поиск кнопки в блок try и дать драйверу еще один шанс, так как на Firefox проиходят рандомные падения
            Wait.waitForModalToDisappear(driver);
            driver.findElement(quitLink).click();
        }

    }
}
