package com.mycompany.socnetworkspring.percistence.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "friendships", schema = "social_network")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id1")
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id2")
    private User user2;

//    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "status", nullable = false)
    private String status;

    public Friendship() {
        this.createdAt = Instant.now();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Friendship{")
                .append("id=").append(id)
                .append(", user1='").append(user1).append('\'')
                .append(", user2='").append(user2).append('\'')
                .append(", createdAt='").append(createdAt).append('\'')
                .append(", status=").append(status)
                .append('}');
        return sb.toString();
    }
}

