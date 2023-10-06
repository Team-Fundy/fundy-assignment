package com.example.fundyassignment.repository;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "TEXT", nullable = false)
    private String text;

    //유저 객체로 연결해야됨
    @Column(name = "NICKNAME", nullable = false)
    private String nickname;

    @Builder
    private Post(String title, String text, String author){
        this.title = title;
        this.text = text;
        this.nickname = author;
    }


}
