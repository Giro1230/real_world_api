package com.realworld.article.controller.res;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllArticlesByAuthorRes {
    private String title;
    private String slug;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
    private List<String> tagList;
    private String author;
    private boolean favorited;
    private int favoritesCount;
}
