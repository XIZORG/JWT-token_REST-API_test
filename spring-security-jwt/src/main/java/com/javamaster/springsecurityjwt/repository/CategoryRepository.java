package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.CategorEntity;
import com.javamaster.springsecurityjwt.entity.CommentEntity;
import com.javamaster.springsecurityjwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategorEntity, Integer> {
    CategorEntity findByTitle(String title);
}
