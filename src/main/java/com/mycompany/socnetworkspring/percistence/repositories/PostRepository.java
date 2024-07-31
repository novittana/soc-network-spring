package com.mycompany.socnetworkspring.percistence.repositories;

import com.mycompany.socnetworkspring.percistence.enteties.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
