package com.mycompany.socnetworkspring.springdata;

import com.mycompany.socnetworkspring.percistence.IDAOUser;
import com.mycompany.socnetworkspring.percistence.enteties.User;
import com.mycompany.socnetworkspring.percistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserImpl implements IDAOUser {

    private final UserRepository userRepository;

    @Override
    public User create(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public User update(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }
}
