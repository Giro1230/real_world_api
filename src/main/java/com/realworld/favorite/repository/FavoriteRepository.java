package com.realworld.favorite.repository;

import com.realworld.article.domain.Article;
import com.realworld.favorite.domain.Favorite;
import com.realworld.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
  List<Favorite> findByUserUsername(String username);

  @Query("SELECT f.article.id FROM Favorite f WHERE f.user = :user")
  List<Long> findFavoritedArticleIdsByUser(@Param("user") User user);

  @Query("SELECT f.article FROM Favorite f WHERE f.user = :user")
  List<Article> findArticlesByUser(@Param("user") User user);

  @Query("SELECT f FROM Favorite f WHERE f.user = :user AND f.article = :article")
  Favorite findFavoriteArticleIdsByUserAndArticle(@Param("user") User user, @Param("article") Article article);
}
