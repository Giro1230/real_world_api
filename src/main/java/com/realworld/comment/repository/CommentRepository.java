package com.realworld.comment.repository;

import com.realworld.article.domain.Article;
import com.realworld.comment.domain.Comment;
import com.realworld.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  List<Comment> findByArticle(Article article);

  List<Comment> findByArticleAndUser(Article article, User user);
}
