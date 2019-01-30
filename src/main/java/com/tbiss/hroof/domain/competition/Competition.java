package com.tbiss.hroof.domain.competition;


import com.tbiss.hroof.domain.BaseEntity;
import com.tbiss.hroof.domain.competition.player.PlayerCompetition;
import com.tbiss.hroof.domain.competition.question.QuestionCompetition;
import com.tbiss.hroof.domain.user.Competitor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Competition extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPETITION_ID")

    private Long id;


    @Enumerated(EnumType.STRING)
    private CompetitionStatus status ;

    @ManyToOne()
    @JoinColumn(name = "WINNER_ID")
    private Competitor winner ;



    @OneToMany(mappedBy = "primaryKey.competition",
            cascade = CascadeType.ALL)
    private Set<PlayerCompetition> players = new HashSet<PlayerCompetition>();


    @OneToMany(mappedBy = "primaryKey.competition",
            cascade = CascadeType.ALL)
    private Set<QuestionCompetition> questions = new HashSet<QuestionCompetition>();



}
