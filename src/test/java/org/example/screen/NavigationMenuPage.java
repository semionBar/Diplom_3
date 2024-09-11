package org.example.screen;

import io.qameta.allure.Step;
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
        driver.findElement(constructorLink).click();
    }
    @Step("Нажать на лого сайта")
    public void clickMainLogoLink() {
        driver.findElement(mainLogoLink).click();
    }
}
