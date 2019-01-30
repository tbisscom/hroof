package com.tbiss.hroof.domain.user;

import com.tbiss.hroof.domain.competition.Competition;
import com.tbiss.hroof.domain.competition.player.PlayerCompetition;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Competitor extends User {

    private int score;



    @OneToMany(mappedBy = "winner")
    private List<Competition> winningCompetitions ;

    @OneToMany(mappedBy = "primaryKey.competition",
            cascade = CascadeType.ALL)
    private Set<PlayerCompetition> competitions = new HashSet<PlayerCompetition>();

    public Competitor(String name, String email, String password) {
        super(name, email, password, UserType.USER);
        this.setRoles(Arrays.asList( "ROLE_USER"));

    }
}
