package com.realworld.comment.domain;

import com.realworld.article.domain.Article;
import com.realworld.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @org.hibernate.annotations.Comment("내용")
    private String body;

    @CreatedDate
    @org.hibernate.annotations.Comment("생성날짜")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @org.hibernate.annotations.Comment("수정날짜")
    private LocalDateTime updatedAt;

    @org.hibernate.annotations.Comment("게시글")
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @org.hibernate.annotations.Comment("글쓴이")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
