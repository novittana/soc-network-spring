package com.mycompany.socnetworkspring.service;

import com.mycompany.socnetworkspring.percistence.IDAOPost;
import com.mycompany.socnetworkspring.percistence.IDAOUser;
import com.mycompany.socnetworkspring.percistence.dto.PostDTO;
import com.mycompany.socnetworkspring.percistence.enteties.Post;
import com.mycompany.socnetworkspring.percistence.enteties.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PostService {
    private IDAOPost idaoPost;
    private IDAOUser idaoUser;

    public PostDTO createPost(PostDTO postDTO) {
        Post post = convertToEntity(postDTO);
        post.setCreatedAt(Instant.now());
        Post savedPost = idaoPost.create(post);
        return convertToDTO(savedPost);
    }

    public PostDTO updatePost(Long id, PostDTO postDTO) {
        Optional<Post> optionalPost = idaoPost.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setContent(postDTO.getContent());
            post.setImageUrl(postDTO.getImageUrl());
            idaoPost.update(post);
            return convertToDTO(post);
        } else {
            // handle post not found scenario
            return null;
        }
    }

    public void deletePost(Long id) {
        idaoPost.delete(id);
    }

    public List<PostDTO> findAllPosts() {
        List<Post> posts = idaoPost.findAll();
        return posts.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<PostDTO> findPostsByUserId(Long userId) {
        List<Post> postList = idaoPost.findByUserId(userId);
        return postList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public Optional<PostDTO> findPostById(Long id) {
        return idaoPost.findById(id).map(this::convertToDTO);
    }

    private PostDTO convertToDTO(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setUserId(post.getUser().getId());
        postDTO.setContent(post.getContent());
        postDTO.setImageUrl(post.getImageUrl());
        postDTO.setCreatedAt(post.getCreatedAt());
        return postDTO;
    }

    private Post convertToEntity(PostDTO postDTO) {
        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setImageUrl(postDTO.getImageUrl());
        Optional<User> userOptional = idaoUser.findById(postDTO.getUserId());
        userOptional.ifPresent(post::setUser);
        return post;
    }
}