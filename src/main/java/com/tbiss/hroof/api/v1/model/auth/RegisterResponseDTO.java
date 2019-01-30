package com.tbiss.hroof.api.v1.model.auth;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterResponseDTO {

    private String email ;

    private String name;

    private int score ;


}
