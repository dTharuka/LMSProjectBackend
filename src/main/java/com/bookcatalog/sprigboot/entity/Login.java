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
@Table(name = "login")
public class Login {
    @Id
    private String loginPsd;

    @Column(name = "loginEmail",nullable = false, length = 50)
    private String loginEmail;
}
