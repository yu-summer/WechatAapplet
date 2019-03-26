package com.summer.graduate.service.impl;

import com.summer.graduate.dao.ArticleDao;
import com.summer.graduate.entities.Article;
import com.summer.graduate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.summer.graduate.service.impl.ArticleServiceImpl
 * @Description TODO
 * @Author summer
 * @Date 2019/3/24 9:41
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	@Override
	public List<Article> showAllArticle() {
		return articleDao.showAllArticle();
	}

	@Override
	public void updateArticle(String title, String text, String id) {
		articleDao.updateArticle(title, text, id);
	}

	@Override
	public void deleteArticle(Integer id) {
		articleDao.deleteArticle(id);
	}

	@Override
	public void addArticle(Article article) {
		articleDao.addArticle(article);
	}

	@Override
	public Article getArticleByTitle(String title) {
		return articleDao.getArticleByTitle(title);
	}
}
