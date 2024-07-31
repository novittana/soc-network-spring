package com.mycompany.socnetworkspring.percistence.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.Instant;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private Long userId;
    private String content;
    private String imageUrl;
    private Instant createdAt;
}