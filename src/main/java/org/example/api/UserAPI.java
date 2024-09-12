package org.example.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.model.UserModel;
import org.example.model.UserTokenModel;

import static io.restassured.RestAssured.given;

public class UserAPI {

    Response response;

    @Step("Отправить запрос на логин юзера")
    public void sendLoginRequest(UserModel userModel) {


        response = given()
                .header("Content-type", "application/json")
                //.auth().oauth2("подставь_сюда_свой_токен")
                .and()
                .body(userModel)
                .when()
                .post("api/auth/login");

    }

    @Step("Отправить запрос на логин юзера")
    public void sendRegistrationRequest(UserModel userModel) {


        response = given()
                .header("Content-type", "application/json")
                //.auth().oauth2("подставь_сюда_свой_токен")
                .and()
                .body(userModel)
                .when()
                .post("/api/auth/register");

    }


    @Step("Получить токен")
    public UserTokenModel getAccessToken() {
        UserTokenModel userTokenModel = new UserTokenModel();

        userTokenModel = response.as(UserTokenModel.class);

        return userTokenModel;
    }

    @Step("Отправить запрос на удаление юзера")
    public void sendDeleteRequest(UserTokenModel userTokenModel) {
        if (userTokenModel != null) {
            if (userTokenModel.getAccessToken() != null) {
                response = given()
                        .header("Content-type", "application/json")
                        .header("Authorization", userTokenModel.getAccessToken())
                        //.auth().oauth2("подставь_сюда_свой_токен")
                        .when()
                        .delete("api/auth/user");

            }
        }
    }


    @Step
    public void setBaseURI() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }


    @Step("Удалить юзера")
    public void clearUser(UserModel userModel) {
        setBaseURI();
        sendLoginRequest(userModel);
        sendDeleteRequest(getAccessToken());
    }

    @Step("Сделать нового юзера")
    public void createNewUser(UserModel userModel) {
        setBaseURI();
        sendRegistrationRequest(userModel);
    }
}
