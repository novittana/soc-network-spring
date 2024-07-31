package com.mycompany.socnetworkspring.percistence.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "social_network")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //    @Size(max = 255)
    @Column(name = "user_name")
    private String userName;

    //    @Size(max = 255)
    @Column(name = "email")
    private String email;

    //    @Size(max = 255)
    @Column(name = "password_hash")
    private String passwordHash;

    //    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    //    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Lob
    @Column(name = "bio")
    private String bio;

    //    @Size(max = 45)
    @Column(name = "profile_picture_url", length = 45)
    private String profilePictureUrl;

//    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "edited_at")
    private Instant editedAt;

    @Column(name = "is_blocked")
    private Short isBlocked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_type")
    private UsersType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts;

    public User() {
        this.createdAt = Instant.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{")
                .append("id=").append(id)
                .append(", userName='").append(userName).append('\'')
                .append(", email='").append(email).append('\'')
                .append(", passwordHash='").append(passwordHash).append('\'')
                .append(", firstName='").append(firstName).append('\'')
                .append(", lastName='").append(lastName).append('\'')
                .append(", dateOfBirth=").append(dateOfBirth)
                .append(", bio='").append(bio).append('\'')
                .append(", profilePictureUrl='").append(profilePictureUrl).append('\'')
                .append(", createdAt=").append(createdAt)
                .append(", editedAt=").append(editedAt)
                .append(", isBlocked=").append(isBlocked)
                .append(", userType=").append(userType)
                .append('}');
        return sb.toString();
    }
}
