package com.mycompany.socnetworkspring.springdata;

import com.mycompany.socnetworkspring.percistence.enteties.UsersType;
import com.mycompany.socnetworkspring.percistence.IDAOUsersType;
import com.mycompany.socnetworkspring.percistence.repositories.UsersTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UsersTypeImpl implements IDAOUsersType {
    private final UsersTypeRepository usersTypeRepository;

    @Override
    public UsersType create(UsersType obj) {
        return usersTypeRepository.save(obj);
    }

    @Override
    public UsersType update(UsersType obj) {
        return usersTypeRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        usersTypeRepository.deleteById(id);
    }

    @Override
    public List<UsersType> findAll() {
        return usersTypeRepository.findAll();
    }

    @Override
    public Optional<UsersType> findById(Long id) {
        return usersTypeRepository.findById(id);
    }
}
