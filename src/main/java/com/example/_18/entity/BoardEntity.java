package com.example._18.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // 작성자 이름

    @Column(nullable = false,columnDefinition = "TEXT")
    private String content; // 글 내용

    @Column(nullable = false, unique = true)
    private Integer position;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // 작성 시간

}
