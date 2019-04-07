package com.summer.graduate.controller;

import com.summer.graduate.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName com.summer.graduate.controller.ImagesController
 * @Description TODO
 * @Author summer
 * @Date 2019/4/4 12:52
 * @Version 1.0
 **/
@Controller
@RequestMapping("images")
public class ImagesController {

	@Autowired
	private FileUtil fileUtil;

	@RequestMapping("upload.do")
	@ResponseBody
	public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
		return fileUtil.fileUpload(request, request.getParameter("username"), file);
	}
}
