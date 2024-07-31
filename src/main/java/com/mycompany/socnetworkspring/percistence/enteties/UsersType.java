package com.mycompany.socnetworkspring.percistence.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "users_type", schema = "social_network")
public class UsersType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "users_type", length = 45)
    private String usersType;
    @Column(name = "role", length = 45)
    private String role;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usertype{")
                .append("id=").append(id)
                .append(", usersType='").append(usersType).append('\'')
                .append(", role='").append(role)
                .append('}');
        return sb.toString();
    }

}