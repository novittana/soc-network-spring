package com.mycompany.socnetworkspring.percistence.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "comments", schema = "social_network")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commentator_id")
    private User commentator;

    @Lob
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

public Comment() {
    this.createdAt = Instant.now();
}
}
