package com.summer.graduate.service.impl;

import com.summer.graduate.dao.EvaluationDao;
import com.summer.graduate.entities.Evaluation;
import com.summer.graduate.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName com.summer.graduate.service.impl.EvaluationServiceImpl
 * @Description TODO
 * @Author summer
 * @Date 2019/4/5 10:33
 * @Version 1.0
 **/
@Service
public class EvaluationServiceImpl implements EvaluationService {

	@Autowired
	private EvaluationDao evaluationDao;

	@Override
	public void addEvaluation(Evaluation evaluation) {
		evaluationDao.addEvaluation(evaluation);
	}

	@Override
	public List<Evaluation> getAllEvaluateByGoodId(Integer good_id) {
		return evaluationDao.getAllEvaluateByGoodId(good_id);
	}
}
