package com.tbiss.hroof.domain.competition.question;

import com.tbiss.hroof.domain.competition.Competition;
import com.tbiss.hroof.domain.question.Question;
import com.tbiss.hroof.domain.user.Competitor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class QuestionCompetitionId implements Serializable {


    @ManyToOne(cascade = CascadeType.ALL)
    private Question question ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competitor answerer ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Competition competition ;


}
