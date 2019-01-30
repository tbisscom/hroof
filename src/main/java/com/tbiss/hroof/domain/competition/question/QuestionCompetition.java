package com.tbiss.hroof.domain.competition.question;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.answerer",joinColumns = @JoinColumn(name = "USER_ID")) ,
        @AssociationOverride(name = "primaryKey.question" , joinColumns = @JoinColumn(name = "QUESTION_ID")) ,
        @AssociationOverride(name = "primaryKey.competition" , joinColumns = @JoinColumn(name = "COMPETITION_ID")) ,
})
public class QuestionCompetition {

     @EmbeddedId
     private QuestionCompetitionId primaryKey = new QuestionCompetitionId();


     @Enumerated(EnumType.STRING)
     private QuestionResponseType status ;


}
