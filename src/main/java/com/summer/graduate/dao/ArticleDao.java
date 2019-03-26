package com.summer.graduate.dao;

import com.summer.graduate.entities.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName com.summer.graduate.dao.ArticleDao
 * @Description TODO
 * @Author summer
 * @Date 2019/3/24 9:38
 * @Version 1.0
 **/
public interface ArticleDao {
	List<Article> showAllArticle();
	void updateArticle(@Param("title")String title, @Param("text") String text, @Param("id") String id);
	void deleteArticle(Integer id);
	void addArticle(Article article);
	Article getArticleByTitle(String title);
}
