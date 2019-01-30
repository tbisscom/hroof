package com.tbiss.hroof.api.v1.model.competition;

import com.tbiss.hroof.api.v1.model.user.CompetitorDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompetitionCreateDTO {

    private Long id ;
    private CompetitorDTO player2 ;

}
