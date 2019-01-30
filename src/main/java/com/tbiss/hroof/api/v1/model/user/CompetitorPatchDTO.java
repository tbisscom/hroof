package com.tbiss.hroof.api.v1.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompetitorPatchDTO {

    private String name ;
    private String email ;
    private String password;
}
