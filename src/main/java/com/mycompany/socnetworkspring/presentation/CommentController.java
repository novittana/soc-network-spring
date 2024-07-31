package com.mycompany.socnetworkspring.presentation;


import com.mycompany.socnetworkspring.percistence.enteties.Comment;
import com.mycompany.socnetworkspring.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Optional<Comment> comment = commentService.findById(id);
        return comment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(
            @RequestParam Long userId,
            @RequestParam Long postId,
            @RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(userId, postId, comment);
        URI location = URI.create(String.format("/comments/%d", createdComment.getId()));
        return ResponseEntity.created(location).body(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Comment> existingComment = commentService.findById(id);
        if (existingComment.isPresent()) {
            comment.setId(id);
            Comment updatedComment = commentService.updateComment(comment);
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        Optional<Comment> existingComment = commentService.findById(id);
        if (existingComment.isPresent()) {
            commentService.deleteComment(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
