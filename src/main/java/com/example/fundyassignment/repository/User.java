package com.example.fundyassignment.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "NICKNAME")
    private String nickname;

    @Builder
    private User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;

    }
}
