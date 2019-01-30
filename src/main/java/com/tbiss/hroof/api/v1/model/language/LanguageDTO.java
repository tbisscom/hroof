package com.tbiss.hroof.api.v1.model.language;

import com.tbiss.hroof.domain.language.LanguageDirection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LanguageDTO {

    private Long id ;
    private String code ;
    private String name  ;
    private LanguageDirection direction ;

}
