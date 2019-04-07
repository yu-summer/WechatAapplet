package com.summer.graduate.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName com.summer.graduate.util.FileUtil
 * @Description 文件操作工具类，图片上传、文件夹创建以及删除
 * @Author summer
 * @Date 2019/4/4 13:40
 * @Version 1.0
 **/
@Component
public class FileUtil {

	/**
	 * 用户上传头像
	 * @param request
	 * @param username
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(HttpServletRequest request, String username, MultipartFile file) throws IOException {
		System.out.println("image upload start...");
		request.setCharacterEncoding("UTF-8");
		if (!file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				String path = null;
				String type = null;
				type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;

				if (type != null) {
					if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
						// 项目在容器中实际发布运行的根路径
						String realPath = request.getSession().getServletContext().getRealPath("/");

						//判断问价夹是否存在
						File file1 = new File(realPath + "/upload/head");
						if (!file1.exists()) {
							file1.mkdirs();
						}

						// 设置存放图片文件的路径
						path = realPath + "/upload/head/" + username + "." + type;
						file.transferTo(new File(path));
					} else {
						System.out.println("pictures type error");
						return "error";
					}
				} else {
					System.out.println("pictures type is null");
					return "error";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No picture file found");
			return "error";
		}
		return "success";
	}

	/**
	 * 管理员上传商品图片
	 * @param request
	 * @param good_id
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String fileUpload(HttpServletRequest request, Integer good_id, MultipartFile file) throws IOException {
		System.out.println("image upload start...");
		request.setCharacterEncoding("UTF-8");
		if (!file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				String path = null;
				String type = null;
				type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;

				if (type != null) {
					if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
						// 项目在容器中实际发布运行的根路径
						String realPath = request.getSession().getServletContext().getRealPath("/");

						//判断问价夹是否存在
						File file1 = new File(realPath + "/upload/goods" + good_id + "/");
						if (!file1.exists()) {
							file1.mkdirs();
						}

						// 设置存放图片文件的路径
						path = realPath + "/upload/goods" + good_id + "/" + 1 + type;
						file.transferTo(new File(path));
					} else {
						System.out.println("pictures type error");
						return "error";
					}
				} else {
					System.out.println("pictures type is null");
					return "error";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("No picture file found");
			return "error";
		}
		return "success";
	}
}
