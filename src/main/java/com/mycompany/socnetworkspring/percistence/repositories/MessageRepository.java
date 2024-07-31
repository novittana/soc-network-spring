package com.mycompany.socnetworkspring.percistence.repositories;

import com.mycompany.socnetworkspring.percistence.enteties.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
