package com.mycompany.socnetworkspring.percistence.repositories;

import com.mycompany.socnetworkspring.percistence.enteties.Comment;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
