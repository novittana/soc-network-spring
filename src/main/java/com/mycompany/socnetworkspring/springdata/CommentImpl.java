package com.mycompany.socnetworkspring.springdata;

import com.mycompany.socnetworkspring.percistence.IDAOComment;
import com.mycompany.socnetworkspring.percistence.enteties.Comment;
import com.mycompany.socnetworkspring.percistence.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CommentImpl implements IDAOComment {

    private CommentRepository commentRepository;
    @Override
    public Comment create(Comment obj) {
        return commentRepository.save(obj);
    }

    @Override
    public Comment update(Comment obj) {
        return commentRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findByPostId(Long postId){
        return commentRepository.findByPostId(postId);
    }
}
