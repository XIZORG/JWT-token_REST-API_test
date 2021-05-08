package com.javamaster.springsecurityjwt.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CategorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;
}
