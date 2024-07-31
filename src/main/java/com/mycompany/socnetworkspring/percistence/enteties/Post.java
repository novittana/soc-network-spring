package com.mycompany.socnetworkspring.percistence.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;


@Getter
@Setter
@Entity
@Table(name = "posts", schema = "social_network")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Lob
    @Column(name = "content")
    private String content;

    //    @Size(max = 45)
    @Column(name = "image_url", length = 45)
    private String imageUrl;

//    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public  Post(){
        this.createdAt = Instant.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post{")
                .append("id=").append(id)
                .append(", content='").append(content).append('\'')
                .append(", imageUrl='").append(imageUrl).append('\'')
                .append(", createdAt=").append(createdAt)
                .append(", user=").append(user)
                .append('}');
        return sb.toString();
    }

}
