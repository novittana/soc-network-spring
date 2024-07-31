package com.mycompany.socnetworkspring.springdata;

import com.mycompany.socnetworkspring.percistence.IDAOPost;
import com.mycompany.socnetworkspring.percistence.enteties.Post;
import com.mycompany.socnetworkspring.percistence.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class PostImpl implements IDAOPost {

    private PostRepository postRepository;

    @Override
    public Post create(Post obj) {
        return postRepository.save(obj);
    }

    @Override
    public Post update(Post obj) {
        return postRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
