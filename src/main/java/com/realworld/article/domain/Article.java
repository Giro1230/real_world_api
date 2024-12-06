package com.realworld.article.domain;


import com.realworld.favorite.domain.Favorite;
import com.realworld.tag.domain.Tag;
import com.realworld.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("게시물 제목")
    @Column(length = 50)
    private String tile;

    @Comment("게시물 제복 분할")
    @Column(length = 100)
    private String slug;

    @Comment("부제목")
    private String description;

    @Comment("게시글")
    @Column(columnDefinition = "MEDIUMTEXT")
    private String body;

    @Comment("글쓴이")
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Comment("태그")
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Tag> tags = new ArrayList<>();

    @Comment("댓글")
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<com.realworld.comment.domain.Comment> comments = new ArrayList<>();

    @Comment("좋아요")
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Favorite> favorites = new ArrayList<>();

    @Comment("생성날짜")
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Comment("수정날짜")
    private LocalDateTime updatedAt;

    public void update(String body){
        this.body = body;
    }
}
