package com.bookcatalog.sprigboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "register")
public class Register {
    @Id
    private String registerID;

    @Column(name = "courseID",nullable = false, length = 50)
    private String courseID;

    @Column(name ="userID",nullable = false, length = 50)
    private String userID;

    @Column(name ="name",nullable = false, length = 50)
    private String name;

    @Column(name ="email",nullable = false, length = 50)
    private String email;

}
