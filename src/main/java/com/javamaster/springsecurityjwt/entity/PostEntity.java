package com.javamaster.springsecurityjwt.entity;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title",unique=true,nullable = false)
    private String title;
    @Column
    private Date publishDate;
    private String status;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_table")
    private UserEntity author;
}
