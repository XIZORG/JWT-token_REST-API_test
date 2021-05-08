package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.CommentEntity;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
        CommentEntity findByAuthor(UserEntity user);
}
