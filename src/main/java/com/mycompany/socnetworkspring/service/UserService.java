package com.mycompany.socnetworkspring.service;
import com.mycompany.socnetworkspring.percistence.IDAOUser;
import com.mycompany.socnetworkspring.percistence.IDAOUsersType;
import com.mycompany.socnetworkspring.percistence.dto.UserDTO;
import com.mycompany.socnetworkspring.percistence.dto.UsersTypeDTO;
import com.mycompany.socnetworkspring.percistence.enteties.User;
import com.mycompany.socnetworkspring.percistence.enteties.UsersType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    public IDAOUser idaoUser;
    public IDAOUsersType idaoUsersType;


    public List<UserDTO> getAllUsers() {
        List<User> users = idaoUser.findAll();
        return users.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public UserDTO findUserById(Long id) {
        Optional<User> user = idaoUser.findById(id);
        return convertToDTO(user.get());
    }
//    public User createUser(UserDTO userDTO) {
//        User newUser = idaoUser.create(userDTO);
//        return newUser;
//    }


    public User createUser (User user) {
        // Ensure UsersType is saved before saving User
        UsersType userType = user.getUserType();
        if (userType != null && userType.getId() == null) {
            userType = idaoUsersType.create(userType);
            user.setUserType(userType);
        }
        return idaoUser.create(user);
    }

    public User updateUser(Long id, UserDTO updatedUser) {
        Optional<User> optionalUser = idaoUser.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPasswordHash(updatedUser.getPasswordHash());
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
            existingUser.setBio(updatedUser.getBio());
            existingUser.setProfilePictureUrl(updatedUser.getProfilePictureUrl());
            existingUser.setEditedAt(updatedUser.getEditedAt());
            existingUser.setIsBlocked(updatedUser.getIsBlocked());

            // Ensure UsersType is saved before updating User
            UsersType userType = updatedUser.getUserType();
            if (userType != null) {
                if (userType.getId() == null) {
                    userType = idaoUsersType.update(userType);
                }
                existingUser.setUserType(userType);
            }

            return idaoUser.update(existingUser);
        } else {
            return null; // або киньте виключення, якщо користувач не знайдений
        }
    }

    public void deleteUser(Long id) {
        idaoUser.delete(id);
    }



    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPasswordHash(user.getPasswordHash());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setBio(user.getBio());
        userDTO.setProfilePictureUrl(user.getProfilePictureUrl());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setEditedAt(user.getEditedAt());
        userDTO.setIsBlocked(user.getIsBlocked());

        // Перетворення UsersType у DTO
        UsersType userType = user.getUserType();
        if (userType != null) {
            UsersTypeDTO usersTypeDTO = new UsersTypeDTO();
            usersTypeDTO.setId(userType.getId());
            usersTypeDTO.setUsersType(userType.getUsersType());
            usersTypeDTO.setRole(userType.getRole());
            userDTO.setUserType(usersTypeDTO);
        }

        return userDTO;
    }

    private User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setBio(userDTO.getBio());
        user.setProfilePictureUrl(userDTO.getProfilePictureUrl());
        user.setIsBlocked(userDTO.getIsBlocked());
//        user.setUserType(userDTO.getUserType());
        return user;
    }

}
