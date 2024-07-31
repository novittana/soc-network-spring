package com.mycompany.socnetworkspring.percistence.dto;

import com.mycompany.socnetworkspring.percistence.enteties.UsersType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UserRegistrationDTO {
        @Getter
        private String userName;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private UsersType usersType;
}