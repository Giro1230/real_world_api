package com.realworld.favorite.domain;

import com.realworld.article.domain.Article;
import com.realworld.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table
public class Favorite {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @org.hibernate.annotations.Comment("유저 정보")
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @org.hibernate.annotations.Comment("게시물 정보")
  @ManyToOne(fetch = FetchType.LAZY)
  private Article article;

  @CreatedDate
  @org.hibernate.annotations.Comment("생정 날짜")
  @Column(nullable = false)
  private LocalDateTime createdAt;
}
