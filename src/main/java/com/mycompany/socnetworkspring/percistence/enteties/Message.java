package com.mycompany.socnetworkspring.percistence.enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "messages", schema = "social_network")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User receiver;

    @Lob
    @Column(name = "message_text")
    private String messageText;

    @NotNull
    @Column(name = "created_at", insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @Column(name = "edited_at", insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
//    @Column(name = "edited_at", nullable = false)
    private Instant editedAt;

    public Message() {
        this.createdAt = Instant.now();
        this.editedAt = Instant.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post{")
                .append("id=").append(id)
                .append(", sender='").append(sender).append('\'')
                .append(", receiver='").append(receiver).append('\'')
                .append(", messageText='").append(messageText).append('\'')
                .append(", createdAt='").append(createdAt).append('\'')
                .append(", editedAt=").append(editedAt)
                .append('}');
        return sb.toString();
    }
}
