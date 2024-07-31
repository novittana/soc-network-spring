package com.mycompany.socnetworkspring.percistence;

import com.mycompany.socnetworkspring.percistence.enteties.Comment;

import java.util.List;

public interface IDAOComment extends IGenericDAO<Comment> {
    List<Comment> findByPostId(Long postId);
}
