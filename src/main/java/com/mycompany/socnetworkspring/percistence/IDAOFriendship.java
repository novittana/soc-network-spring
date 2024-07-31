package com.mycompany.socnetworkspring.percistence;

import com.mycompany.socnetworkspring.percistence.enteties.Friendship;
import com.mycompany.socnetworkspring.percistence.enteties.User;

import java.util.List;
import java.util.Optional;

public interface IDAOFriendship extends IGenericDAO<Friendship>{
    Optional<Friendship> findByUser1AndUser2(User user1, User user2);

    long countByUser1OrUser2(User user, User user1);
}
