package com.mycompany.socnetworkspring.percistence.dto;

import com.mycompany.socnetworkspring.percistence.enteties.UsersType;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class UsersTypeDTO extends UsersType {
    @Column(name = "users_type", length = 45)
    private String usersType;
    @Column(name = "role", length = 45)
    private String role;
}
