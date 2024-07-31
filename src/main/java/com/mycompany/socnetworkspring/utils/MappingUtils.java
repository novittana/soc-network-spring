package com.mycompany.socnetworkspring.utils;

import com.mycompany.socnetworkspring.percistence.dto.UsersTypeDTO;
import com.mycompany.socnetworkspring.percistence.enteties.UsersType;

public class MappingUtils {
    public UsersTypeDTO convertUserToUsersTypeDTO(UsersType usersType) {
        UsersTypeDTO usersTypeDTO = new UsersTypeDTO();
        usersTypeDTO.setUsersType(usersType.getUsersType());
        usersTypeDTO.setRole(usersType.getRole());
        return usersTypeDTO;
    }

    public UsersType convertUsersTypeDTOToUsersType(UsersTypeDTO usersTypeDTO) {
        UsersType usersType = new UsersType();
        usersType.setUsersType(usersTypeDTO.getUsersType());
        usersType.setRole(usersTypeDTO.getRole());
        return usersType;
    }
}
