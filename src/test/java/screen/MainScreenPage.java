package screen;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainScreenPage {
    private final WebDriver driver;

    public MainScreenPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By personalAccountButton =  By.xpath(".//a[@href='/account']");

    @Step("Перейти на экран \"Авторизации\", нажав на кнопку \"Личный кабинет\"")
    public void getToLoginScreen() {
        driver.findElement(personalAccountButton).click();
    }
}
