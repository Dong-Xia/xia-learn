package com.aspire.core.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aspire.commom.unit.ResponseUtils;
import com.aspire.core.service.FileUploadService;



@Controller
public class FileController {
	
	@Autowired
	private FileUploadService fileUploadService;
	//首页默认查询控制
	@RequestMapping(value="/fileUpload/findMainPage.do")
	public String findMainPage(HttpServletRequest request,HttpServletResponse response,Model model) {
		return "/page/fileUpload/fileList";
	}
	
	//首页默认查询控制
	@RequestMapping(value="/fileUpload/findUpload.do")
	public String findUpload(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		fileUploadService.upload(request,response);
		
		return null;
	}
	
	//首页默认查询控制
	@RequestMapping(value="/fileUpload/generateMD5.do")
	public void generateMD5(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		fileUploadService.upload(request,response);
		
	}
	
}
