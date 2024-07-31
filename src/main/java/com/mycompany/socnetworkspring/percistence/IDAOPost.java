package com.mycompany.socnetworkspring.percistence;

import com.mycompany.socnetworkspring.percistence.enteties.Post;

import java.util.List;

public interface IDAOPost extends IGenericDAO<Post> {
    List<Post> findByUserId(Long userId);
}
