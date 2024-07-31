package com.mycompany.socnetworkspring.percistence.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String content;
    private Instant createdAt;
    private Long commentatorId;
    private Long postId;
}
