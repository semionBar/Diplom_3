package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.N;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenModel {

    private boolean success;

    private String accessToken;

    private String refreshToken;

    private UserModel user;
}
