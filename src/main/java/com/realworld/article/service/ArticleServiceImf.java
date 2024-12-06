package com.realworld.article.service;

import com.realworld.article.controller.req.CreatedArticleReq;
import com.realworld.article.controller.req.UpdatedArticleReq;
import com.realworld.article.controller.res.*;
import com.realworld.article.service.inf.ArticleInterface;

import java.util.List;

public class ArticleServiceImf implements ArticleInterface {
    @Override
    public List<AllArticlesRes> getAllArticle() {
        return List.of();
    }

    @Override
    public List<AllArticlesByAuthorRes> getArticlesByAuthor(String name) {
        return List.of();
    }

    @Override
    public CreatedArticleRes createdArticle(CreatedArticleReq data, String email) {
        return null;
    }

    @Override
    public List<FeedArticleRes> getFeed(String email) {
        return List.of();
    }

    @Override
    public List<AllArticlesRes> getAllArticlesWithFavoriteStatus(String email) {
        return List.of();
    }

    @Override
    public List<AllArticlesByAuthorRes> getAllArticlesByUser(String email) {
        return List.of();
    }

    @Override
    public List<AllArticlesByAuthorRes> getArticlesByAuthorWithFavoriteStatus(String email, String username) {
        return List.of();
    }

    @Override
    public ArticleBySlugRes getArticleBySlug(String email, String slug) {
        return null;
    }

    @Override
    public UpdatedArticleRes updatedArticle(String email, String slug, UpdatedArticleReq updatedArticle) {
        return null;
    }

    @Override
    public Boolean deleteArticle(String email, String slug) {
        return null;
    }
}
