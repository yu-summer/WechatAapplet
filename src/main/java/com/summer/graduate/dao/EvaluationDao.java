package com.summer.graduate.dao;

import com.summer.graduate.entities.Evaluation;

import java.util.List;

public interface EvaluationDao {
	//添加商品评论
	void addEvaluation(Evaluation evaluation);

	//获取某一个商品的评论
	List<Evaluation> getAllEvaluateByGoodId(Integer good_id);
}
