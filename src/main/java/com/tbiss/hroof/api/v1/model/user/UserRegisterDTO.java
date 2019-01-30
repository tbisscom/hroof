package com.tbiss.hroof.api.v1.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    private String name ;
    private String email ;
    private String password ;


}
