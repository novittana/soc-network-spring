package com.mycompany.socnetworkspring.percistence;

import com.mycompany.socnetworkspring.percistence.enteties.User;

public interface IDAOUser extends IGenericDAO<User> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);
}
