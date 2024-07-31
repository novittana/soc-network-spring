package com.mycompany.socnetworkspring.percistence.dto;

import com.mycompany.socnetworkspring.percistence.enteties.Post;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Data
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String bio;
    private String profilePictureUrl;
    private Instant createdAt;
    private Instant editedAt;
    private Short isBlocked;
    private UsersTypeDTO userType;

}
