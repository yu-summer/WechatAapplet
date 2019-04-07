package com.summer.graduate.controller;

import com.google.gson.Gson;
import com.summer.graduate.entities.Evaluation;
import com.summer.graduate.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName com.summer.graduate.controller.Evaluation
 * @Description TODO
 * @Author summer
 * @Date 2019/4/5 15:00
 * @Version 1.0
 **/
@Controller
@RequestMapping("evaluation")
public class EvaluationController {

	@Autowired
	private EvaluationService evaluationService;

	@ResponseBody
	@RequestMapping(value = "addEvaluation.do", method = RequestMethod.POST, produces="text/html;charset=UTF-8")
	public String addEvaluation(Integer good_id, String username, String content) {
		String result_mess = "success";
		Map<String, String> result = new HashMap<>();
		try {
			Evaluation evaluation = new Evaluation();
			evaluation.setGood_id(good_id);
			evaluation.setUsername(username);
			evaluation.setContent(content);
			evaluationService.addEvaluation(evaluation);
		} catch (Exception e) {
			e.printStackTrace();
			result_mess = "error";
		} finally {
			result.put("result", result_mess);
			return new Gson().toJson(result);
		}
	}

	@ResponseBody
	@RequestMapping(value = "getAllEvaluateByGoodId.do", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
	public String getAllEvaluateByGoodId(Integer good_id) {
		List<Evaluation> evaluations = evaluationService.getAllEvaluateByGoodId(good_id);
		return new Gson().toJson(evaluations);
	}
}
