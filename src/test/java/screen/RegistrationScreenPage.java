package screen;

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

    private final By registerButton = By.xpath(".//form[contains(@class,'Auth_form')]//button");


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

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void registerNewUser() {
        setNameInput();
        setEmailInput();
        setPasswordInput();
        clickRegisterButton();
    }

    public void clearUser() {

        UserAPI userAPI = new UserAPI();

        userAPI.setBaseURI();

        userAPI.sendLoginRequest(userModel);

        userTokenModel = userAPI.getAccessToken();

        userAPI.sendDeleteRequest(userTokenModel);
    }

    public void getNewUser() {
        userModel = new UserModel(0);
    }

}
