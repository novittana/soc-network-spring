package com.mycompany.socnetworkspring.service;


import com.mycompany.socnetworkspring.exception.ResourceNotFoundException;
import com.mycompany.socnetworkspring.percistence.IDAOUsersType;
import com.mycompany.socnetworkspring.percistence.dto.UsersTypeDTO;
import com.mycompany.socnetworkspring.percistence.enteties.UsersType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UsersTypeService {
    public IDAOUsersType idaoUsersType;

    public List<UsersType> findAll() {
        return idaoUsersType.findAll();
    }

    public Optional<UsersType> findById(Long id) {
        return idaoUsersType.findById(id);
    }

    public UsersType createUsersType(UsersType usersType) {
       return idaoUsersType.create(usersType);
    }

    public void deleteUsersType(Long id) {
        idaoUsersType.delete(id);
    }


    public UsersType updateUsersType(Long id, UsersTypeDTO dto) {
        UsersType existingUserType = idaoUsersType.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("UsersType not found with ID: " + id);
                });

        existingUserType.setUsersType(dto.getUsersType());
        existingUserType.setRole(dto.getRole());

        return idaoUsersType.update(existingUserType);
    }


}
