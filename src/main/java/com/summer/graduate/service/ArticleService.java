package com.summer.graduate.service;

import com.summer.graduate.entities.Article;

import java.util.List;

public interface ArticleService {
	List<Article> showAllArticle();
	void updateArticle(String title, String text, String id);
	void deleteArticle(Integer id);
	void addArticle(Article article);
	Article getArticleByTitle(String title);
}
