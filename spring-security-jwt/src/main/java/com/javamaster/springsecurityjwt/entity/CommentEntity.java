package com.javamaster.springsecurityjwt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date publishDate;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_table")
    private UserEntity author;
}
