package com.javamaster.springsecurityjwt.service;

import com.javamaster.springsecurityjwt.entity.PostEntity;
import com.javamaster.springsecurityjwt.entity.RoleEntity;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import com.javamaster.springsecurityjwt.repository.PostRepository;
import com.javamaster.springsecurityjwt.repository.RoleEntityRepository;
import com.javamaster.springsecurityjwt.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void createPost(PostEntity post) throws Exception {
        if (postRepository.findByTitle(post.getTitle()) != null) {
            throw new Exception("Already exist title");
        }
        postRepository.save(post);
    }

    public void updatePost(PostEntity post) {
        postRepository.save(post);
    }

    public List<PostEntity> getActivePosts(){
        List<PostEntity> result = postRepository.findAll();
        result = result.stream().filter(postEntity -> postEntity.getStatus().equals("ACTIVE")).collect(Collectors.toList());
        return result;
    }

    public void deletePost(PostEntity post) {
        postRepository.delete(post);
    }

    public PostEntity getByTitle(String title){
        return postRepository.findByTitle(title);
    }

}
