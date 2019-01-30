package com.tbiss.hroof.repository.user;

import com.tbiss.hroof.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByEmailEndsWith(String end);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
