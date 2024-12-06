package com.realworld.tag.domain;

import com.realworld.article.domain.Article;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Tag {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String tagName;

  @Comment("게시글")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "article_id",nullable = false)
  private Article article;

  @CreatedDate
  @Comment("생성날짜")
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Comment("수정날짜")
  @Column
  private LocalDateTime updatedAt;
}
