package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.Acceleration;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private String email;

    private String name;

    private String password;

    public UserModel(int seed) {

        int randomValue = 10000000 + seed + (int) (Math.random() * 90000000 + seed);

        email = String.format("email%s@yandex.ru", randomValue);

        password = String.format("%s", randomValue);

        name = String.format("John%s", randomValue);

    }


}
