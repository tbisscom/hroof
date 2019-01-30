package com.tbiss.hroof.repository.user;

import com.tbiss.hroof.domain.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
