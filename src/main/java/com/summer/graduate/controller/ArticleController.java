package com.summer.graduate.controller;

import com.google.gson.Gson;
import com.summer.graduate.entities.Article;
import com.summer.graduate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName com.summer.graduate.controller.ArticleController
 * @Description TODO
 * @Author summer
 * @Date 2019/3/24 9:43
 * @Version 1.0
 **/
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@ResponseBody
	@RequestMapping(value = "showAllArticle.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String showAllArticle() {
		List<Article> articles = articleService.showAllArticle();
		Gson gson = new Gson();
		String json = gson.toJson(articles);
		System.out.println(json);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "getArticleByTitle.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String getArticleByTitle(String title) {
		Article article = articleService.getArticleByTitle(title);
		String json = new Gson().toJson(article);
		System.out.println(json);
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "updateArticle.do", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String updateArticle(String title, String text, String id) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();
		try {
			articleService.updateArticle(title, text, id);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			String json = new Gson().toJson(result);
			return json;
		}
	}

	@ResponseBody
	@RequestMapping(value = "deleteArticle.do", method = RequestMethod.GET)
	public String deleteArticle(Integer id) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();
		try {
			articleService.deleteArticle(id);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			String json = new Gson().toJson(result);
			return json;
		}
	}

	@ResponseBody
	@RequestMapping(value = "addArticle.do", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String addArticle(String title, String text) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();
		try {
			Article article = new Article();
			article.setTitle(title);
			article.setText(text);
			articleService.addArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			String json = new Gson().toJson(result);
			return json;
		}
	}
}
