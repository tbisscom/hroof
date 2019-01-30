package com.tbiss.hroof.domain.competition.player;

import com.tbiss.hroof.domain.competition.Competition;
import com.tbiss.hroof.domain.user.Competitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class PlayerCompetitionId implements Serializable {


    @ManyToOne(cascade = CascadeType.ALL)
    private Competitor competitor ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition ;

}
