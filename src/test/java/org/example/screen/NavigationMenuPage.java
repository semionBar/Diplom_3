package org.example.screen;

import io.qameta.allure.Step;
import org.example.shared.SharedStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenuPage {

    private final WebDriver driver;
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']/..");
    private final By mainLogoLink = By.xpath(".//div[contains(@class, 'logo')]/a");


    public NavigationMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на ссылку \"Конструктор\"")
    public void clickConstructorLink() {
        SharedStep.waitForElementToBeClickable(driver, constructorLink);

        try {
            driver.findElement(constructorLink).click();
        } catch (Throwable throwable) {
            new PersonalAccountScreenPage(driver).personalAccountScreenIsDisplayed();
            SharedStep.waitForModalToDisappear(driver);
            driver.findElement(constructorLink).click();
        }
    }
    @Step("Нажать на лого сайта")
    public void clickMainLogoLink() {
        SharedStep.waitForElementToBeClickable(driver, mainLogoLink);

        try {
            driver.findElement(mainLogoLink).click();
        } catch (Throwable throwable) {
            new PersonalAccountScreenPage(driver).personalAccountScreenIsDisplayed();
            SharedStep.waitForModalToDisappear(driver);
            driver.findElement(mainLogoLink).click();
        }
    }
}
