package com.tbiss.hroof.api.v1.model.auth;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthenticationRequestDTO {

    private String email ;
    private String password;
}
