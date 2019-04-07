package com.summer.graduate.service;

import com.summer.graduate.entities.Evaluation;

import java.util.List;

public interface EvaluationService {
	void addEvaluation(Evaluation evaluation);

	List<Evaluation> getAllEvaluateByGoodId(Integer good_id);
}
