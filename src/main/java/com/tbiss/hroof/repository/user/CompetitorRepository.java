package com.tbiss.hroof.repository.user;

import com.tbiss.hroof.domain.user.Competitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetitorRepository extends JpaRepository<Competitor,Long> {

    Optional<Competitor> findByEmail(String email);
    boolean findByEmailNot(String email);

}
