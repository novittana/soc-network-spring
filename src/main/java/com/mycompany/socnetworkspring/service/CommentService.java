package com.mycompany.socnetworkspring.service;


import com.mycompany.socnetworkspring.percistence.IDAOComment;
import com.mycompany.socnetworkspring.percistence.IDAOPost;
import com.mycompany.socnetworkspring.percistence.IDAOUser;
import com.mycompany.socnetworkspring.percistence.dto.CommentDTO;
import com.mycompany.socnetworkspring.percistence.enteties.Comment;
import com.mycompany.socnetworkspring.percistence.enteties.Post;
import com.mycompany.socnetworkspring.percistence.enteties.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CommentService {
    private final IDAOUser idaoUser;
    private final IDAOPost idaoPost;
    private IDAOComment idaoComment;

    public List<Comment> getAllComments() {
        return idaoComment.findAll();
    }

    public Optional<Comment> findById(Long id) {
        return idaoComment.findById(id);
    }

    public Comment createComment(Long userId, Long postId, Comment comment) {
        Optional<User> user = idaoUser.findById(userId);
        Optional<Post> post = idaoPost.findById(postId);

        if (user.isPresent() && post.isPresent()) {
            comment.setCommentator(user.get());
            comment.setPost(post.get());
            comment.setCreatedAt(Instant.now());
            return idaoComment.create(comment);
        } else {
            throw new RuntimeException("User or Post not found");
        }
    }

    public Comment updateComment(Comment comment) {
        return idaoComment.update(comment);
    }

    public void deleteComment(Long id) {
        idaoComment.delete(id);
    }

    public List<CommentDTO> getCommentsByPostId(Long postId) {
        List<Comment> comments = idaoComment.findByPostId(postId);
        return comments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private CommentDTO convertToDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setCommentatorId(comment.getCommentator() != null ? comment.getCommentator().getId() : null);
        dto.setPostId(comment.getPost() != null ? comment.getPost().getId() : null);
        return dto;
    }

//    public List<Comment> findAll() {
//    }
}
