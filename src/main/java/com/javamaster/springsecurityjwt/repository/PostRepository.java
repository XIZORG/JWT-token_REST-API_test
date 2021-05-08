package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.PostEntity;
import com.javamaster.springsecurityjwt.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    PostEntity findByTitle(String title);
}
