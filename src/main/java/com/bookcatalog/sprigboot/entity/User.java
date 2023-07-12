package com.bookcatalog.sprigboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name="user")
public class User {

    @Id
    private String userID;

    @Column(name = "name",nullable = false, length = 50)
    private String name;

    @Column(name ="email",nullable = false, length = 50)
    private String email;

    @Column(name ="password",nullable = false, length = 50)
    private String password;

    @Column(name ="image")
    private String image;
}
