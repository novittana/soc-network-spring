package com.mycompany.socnetworkspring.percistence.repositories;

import com.mycompany.socnetworkspring.percistence.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
}
