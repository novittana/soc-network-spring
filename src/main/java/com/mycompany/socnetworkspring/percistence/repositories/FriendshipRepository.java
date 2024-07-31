package com.mycompany.socnetworkspring.percistence.repositories;

import com.mycompany.socnetworkspring.percistence.enteties.Friendship;
import com.mycompany.socnetworkspring.percistence.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
//  Optional<Friendship> findByUser1AndUser2(User user1, User user2);
}
