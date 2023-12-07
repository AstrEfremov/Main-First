package com.firstProject.firstMain.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private Integer id;

    @Column(name ="name")
    private String name;
}
