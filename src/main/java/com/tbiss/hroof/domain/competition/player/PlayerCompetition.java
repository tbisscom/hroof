package com.tbiss.hroof.domain.competition.player;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AssociationOverrides({ @AssociationOverride(name = "primaryKey.competitor",joinColumns = @JoinColumn(name = "USER_ID")) ,
@AssociationOverride(name = "primaryKey.competition" , joinColumns = @JoinColumn(name = "COMPETITION_ID")) })
public class PlayerCompetition {

     @EmbeddedId
     private PlayerCompetitionId primaryKey = new PlayerCompetitionId();

     private boolean test ;


}
