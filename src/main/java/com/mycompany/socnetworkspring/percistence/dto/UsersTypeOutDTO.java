package com.mycompany.socnetworkspring.percistence.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
public class UsersTypeOutDTO {
    private Integer id;
    private String usersType;
    private String role;
}
